## 엔티티

1. Member

   id 필드 추가.

2. MemberSecret

   member_no 대신에 memberId 필드 추가하기

3. Home

   기존 상필이 코드 + 위도, 경도 정보 추가하기


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