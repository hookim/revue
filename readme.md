## 엔티티

1. Member

   id 필드 추가.

2. MemberSecret

   member_no 대신에 memberId 필드 추가하기

3. Home

   기존 코드 + 위도, 경도 정보 추가하기


## API 명세

1. 회원가입

   POST `/members/regist`

    - 요청예제

        ```json
        // 값 전부 채워넣어야 합니다. 문자열임
        {
            "id" : "ssafy3",
            "name" : "김싸피",
            "email" : "hello@gmail.com",
            "pw" : "ssafy",
            "ssn" : "9999"
        }
        ```

    - 응답

        ```json
        // 성공시
        {
        	"msg" : "회원가입 성공"
        }
        
        // 실패시 
        {
        	"msg" : "회원가입 실패" 
        }
        ```

2. 로그인

   POST `/members/login`

    - 요청예제

        ```json
        {
            "id" : "ssafy",
            "pw" : "ssafy"
        }
        ```

    - 응답

        ```json
        // 성공시
        {
            "msg": "로그인 성공",
            "refresh-token": "c977a69f-3b72-45b3-b560-0f0b05f50af9",
            "access-token": "e7964374-c96e-4d60-b2b2-28d56efacf0c"
        }
        
        // 실패시
        {
            "msg": "로그인 실패"
        }
        ```

3. 로그아웃

   POST `/members/logout`

    - 요청예제

        ```json
        {
            "refresh-token" : "8016cec6-8423-4810-a612-9d4a7fa06782"
        }
        ```

    - 응답

        ```json
        {
            "msg": "로그아웃에 성공했습니다."
        }
        ```

4. 리프레시토큰으로 토큰 재발급받기

   POST `/members/refresh`

    - 요청예제

        ```json
        {
            "refresh-token" : "8016cec6-8423-4810-a612-9d4a7fa06782"
        }
        ```

    - 응답

        ```json
        //성공시
        {
            "access-token": "1ffc133d-0c0b-48ac-a7de-42115585a93e"
        }
        
        //실패시 
        {
            "msg": "리프레시 토큰이 유효하지 않습니다."
        }
        ```

5. 집 목록 구해오기

   GET `/homes`

    - 응답

        ```json
        //성공시
        [
            {
                "price": "1000",
                "constructionYear": "1999",
                "legalDong": "동작구",
                "aptName": "레미안",
                "exclusiveArea": "잘몰라요",
                "addressNumber": "11111",
                "floor": "3rd"
            },
            {
                "price": "1000",
                "constructionYear": "1999",
                "legalDong": "동작구",
                "aptName": "레미안",
                "exclusiveArea": "잘몰라요2",
                "addressNumber": "11112",
                "floor": "3rd"
            },
            {
                "price": "1000",
                "constructionYear": "1999",
                "legalDong": "동작구",
                "aptName": "레미안",
                "exclusiveArea": "잘몰라요3",
                "addressNumber": "1111",
                "floor": "3rd"
            }
        ]
        
        // 실패시
        {
        		"msg" : "유효하지 않은 토큰입니다."
        }
        ```

6. 집 등록하기 (관리자 테스트용 API)

   POST `/homes/regist`

    - 요청예시

        ```json
        //다 채워넣어야 함
        {
            "price" : "1000",
            "constructionYear" : "1999",
            "legalDong" : "동작구",
            "aptName" : "레미안",
            "exclusiveArea" : "잘몰라요",
            "addressNumber" : "1111",
            "floor" : "3rd"
        }
        ```

    - 응답

        ```json
        // 성공시
        success
        ```


## Access Token과 Refresh Token

1. 최초로그인 을 하면 AccessToken과 RefreshToken이 같이 발급됩니다.
2. 이후 AccessToken을 Request `“Authorization”`헤더에 앞에 `“Bearer “` 를 집어넣어서 요청을 보냅니다.
3. AccessToken이 제대로 된 값이 아니거나 유효기간이 지난 경우에 `/homes` 도메인의 모든 기능을 사용할 수 없습니다. AccessToken에러를 받게됩니다.
4. AccessToken이 유효하게 있는경우에 로그아웃을 제외한 /members 도메인의 기능을 사용할 수 없습니다. 왜냐하면 아직 토큰이 유효한 상태이고 이는 로그인 상태이기 때문에 토큰 재발급, 회원가입, 로그인을 하는 것이 로직상 맞지 않기 때문입니다.
5. `/members/logout` 의 경우는 RefreshToken, AccessToken을 메모리 저장소에서 지우는 작업을 담당하게 됩니다.

## 토큰 발급 방식

jwt라이브러리를 써서 구현할 수 있었지만 그냥 UUID를 사용해서 구현했습니다.
```java
try{
   String accessToken = UUID.randomUUID().toString();
   Date accessExpiration = new Date(System.currentTimeMillis() + 60 * 1000);
   accessMemStorage.getStorage().put(accessToken, new TupleStorage(member.getId(), accessExpiration));

   String refreshToken = UUID.randomUUID().toString();
   Date refreshExpire = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
   refreshMemStorage.getStorage().put(refreshToken, new TupleStorage(member.getId(), refreshExpire));

   result.put("msg", "로그인 성공");
   result.put("access-token", accessToken);
   result.put("refresh-token", refreshToken);
   return result;
}
```

## 토큰 저장

토큰의 경우 redis에 저장을 하곤 합니다. 그러나 redis대신에 스프링 서버 memory저장소를 활용했습니다. 
스프링 컨테이너가 빈즈를 싱글톤으로 생성한다는 사실을 활용해 주입된 beans를 메모리 저장소로 활용했습니다.
key값은 토큰 값이고 해당 값을 통해 유저아이디, 토큰 만료 정보를 알 수 있습니다. 리프레시 토큰, 액세스 토큰 저장소를 따로 운영했습니다. 

```java
@Component
public class AccessMemStorage {
    private final Map<String, TupleStorage> storage = new HashMap<>();

    public Map<String, TupleStorage> getStorage() {
        return storage;
    }

    @Override
    public String toString() {
        return "AccessMemStorage{" +
                "storage=" + storage +
                '}';
    }
}
```

## 개선 방향
액세스 토큰에 리프레시 토큰을 알 수 있는 정보를 추가하자. 
그러면 나중에 로그아웃을 할 때 바디 부분에 토큰을 집어넣지 않아도 된다.

## 발생했던 이슈
CORS 이슈. 스프링에서 CORS 설정을 해서 제대로 동작하는 듯 했다. 그러나 액세스 토큰을 받고 클라이언트 부분에서
AUTHORIZATION 헤더를 추가해서 보내자마자 CORS에러가 발생하기 시작했다. AUTHORIZATION과 같은 헤더의 경우 
preflight 요청이 OPTIONS 메소드로 본 요청 직전에 날아간다고 한다. 이 부분에서 오류가 발생한 듯 하다. 


