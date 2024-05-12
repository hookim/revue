# 구해줘 홈즈 (WhereIsMyHome)

> Java 전공반 - 스프링 관통 PJT

## 1. 소개

### Project Summary

구해줘 홈즈(WhereIsMyHome) - 이전 관통 rest api 버전으로 변경   

### Team

- 서울 19반 조윤정
- 서울 19반 조현아

### Skill & Tool

- html
- css
- javascript
- bootstrap
- spring boot
- java
<br><br>

## 2. 구조
### 데이터베이스
- 테이블 정보
    - member 테이블
        - 회원 정보
    - member_secret 테이블
        - salt
        - ssn 암호화 대칭키
    - board 테이블
        - 게시글 정보

- sql문
    ```SQL
    use ssafyweb;

    CREATE TABLE IF NOT EXISTS `ssafyweb`.`member`(
    `no` int NOT NULL auto_increment,
    `name` VARCHAR(20) NOT NULL,
    `email` VARCHAR(30) UNIQUE NOT NULL,
    `user_enc_password` VARCHAR(256) NOT NULL,
    `ssn` VARCHAR(1000) NOT NULL,
    PRIMARY KEY (`no`));

    create TABLE IF NOT EXISTS `ssafyweb`.`member_secret`(
        `no` int NOT NULL auto_increment,
        `member_no` int NOT NULL,
        `salt` VARCHAR(1000) NOT NULL,
        `ssn_key` VARCHAR(128) NOT NULL,
        primary key(`no`),
        foreign key(`member_no`) references member (`no`));

    CREATE TABLE IF NOT EXISTS `ssafyweb`.`board`(
    `no` int NOT NULL auto_increment,
    `title` VARCHAR(100) NOT NULL,
    `content` VARCHAR(2000) UNIQUE NOT NULL,
    `email` VARCHAR(30) NOT NULL,
    `created_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`no`),
    CONSTRAINT FOREIGN KEY(email) REFERENCES member(email)
    );
    ```

## 3. 기능
### 3-1) 회원가입
- 초기화면<br>
  <img src="/uploads/4498772b3782e0daaeba2ec4e39e5eef/signup_init.png" width="300px">
- 회원가입 성공
    - 회원가입 전 데이터베이스
        - member 테이블<br>
            <img src="/uploads/0eddca33efca457e8e4875af15960300/signup_success_init_member_db.png" width="500px">
        - member_secret 테이블<br>
            <img src="/uploads/b739375c18b2666ab9bee6b3ed253c09/signup_success_init_member_secret_db.png" width="500px">
    - 회원가입 성공<br>
        <img src="/uploads/6679b4af8e17b4904ed0a84d3f2710b6/signup_success.png" width="300px">
    - 회원가입 후 데이터베이스
        - member 테이블<br>
            <img src="/uploads/4203916cbd824ec827a42896c2281705/signup_success_member_db.png" width="500px">
        - member_secret 테이블<br>
            <img src="/uploads/ac744aa893b28c2822aaba913ccce016/signup_success_member_secret_db.png" width="500px">
- 회원가입 실패<br>
    | 빈 칸 존재하는 경우
  <br><img src="/uploads/8de0caafae4ddb95a798ab0f0b2c5fc9/signup_blank.png" width="300px">


### 3-2) 로그인
- 초기화면
    - 메인 상단바<br>
        <img src="/uploads/241e609c1a51c7f65d5ab94efe1e42cb/login_init_main.png" width="200px">
    - 로그인 화면<br>
        <img src="/uploads/8950a7305c7967c7766375065ff3c1bf/login_init.png" width="300px">
        
- 로그인 성공<br>
    - 로그인 화면<br>
        <img src="/uploads/6d97f8531e8bb2dbbc9440eab566bdb3/login_success.png" width="300px">
    - 메인 상단바<br>
        <img src="/uploads/bef09c6eed4f5e632a00aff5f65b61e5/login_success_main.png" width="200px">
- 로그인 실패<br>
    <img src="/uploads/1e0378d9ef6e35218b6aeb4c5693834c/login_fail.png" width="300px">


### 3-3) 게시글
- 게시글 조회
    - 전체 목록<br>
        <img src="/uploads/a08d55f9386defc1c6923a3dff6468d4/board_list.png" width="600px">
    - 개별 게시글<br>
        <img src="/uploads/5328e268a5116dbcfdd514197484baea/board.png" width="600px">
  
- 게시글 등록
    - 초기화면 <br>
        <img src="/uploads/c04cc8a24f58f77dcf4623be3590f4c3/board_regist_init.png" width="600px">
    - 게시글 등록 전 데이터베이스 <br>
        <img src="/uploads/7121ab14e616a27e325b71ad464a3826/board_regist_before_db.png" width="400px">
    - 게시글 등록 <br>
        <img src="/uploads/58812a3c100d009ce214794ae1acac0d/board_regist_ing.png" width="600px"><br>
        <img src="/uploads/56b6cf5e6c8a7feaec5641758b1fe383/board_regist_success.png" width="600px"><br>
        <img src="/uploads/acaacba83abd58861f2dbd3b0e052670/board_regist_after_list.png" width="600px">
    - 게시글 등록 후 데이터베이스 <br>
        <img src="/uploads/0e185dea538622ac0b4741d795439803/board_regist_after_db.png" width="400px">

## 4. 소감

- 조윤정

  ```
    백엔드가 REST api로 바꾸는것에 맞춰 프론트의 코드를 바꿀..필요가 딱히 없었다... 코드를 최대한 보기 편하게 바꾸는 노력을 기울여보았다..
    먼저, my.min.js를 board관련과 member 관련으로 나누었다. 또한, 리스트를 클릭해야 볼 수 있는 것이 아니라 사이트에 들어가자마자 window.onload로 보이도록 수정했다. 로그인 유저가 아니라면 게시글을 추가하지 못하도록 프론트단에서의 처리를 추가하고, 약간의 UI를 수정했다.
    Form data로 서버에 요청을 보내는 방법은 써본적이 없었는데 이번 기회에 해보게 되어 좋았다. 백엔드에 요청을 보낼때, 이 요청이 어떻게 처리되는지를 알 수 있었고,, 프론트-백 연결할때 여러 방법과 그 차이를 알 수 있어 뜻깊은 시간이었다.
  ```

- 조현아

  ```
  이전에 했던 코드들을 REST api를 사용하도록 변경하는 과정에서 월평 대비도 할 수 있어서 좋았습니다. 비밀번호와 ssn을 암호화 하는 과정에서
  클래스 분리를 제대로 하지 못한 것 같아 아쉬워 다음에 다시 공부를 해보고 싶습니다. 또한, 윤정이와 페어를 하면서 front와 back을 분리하여
  개발하고 오류가 난 부분을 서로 봐주는 방식으로 프로젝트를 진행하면서 back뿐만 아니라 front도 많이 배울 수 있었습니다. 
  ```
