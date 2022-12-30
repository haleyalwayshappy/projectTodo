## 2022_11~ 
### 맥북에어m2에서 추가한 웹프로젝트 (자바웹개발 워크북으로 공부중)


### 2022-11-29 현재 인텔리제이에서 깃허브 업로드 테스트 중 



### 2022-12-29 todo web 
1. 목록화면(get)
   TodoListController / todo/list.jsp
2. 등록화면(get)
   TodoRegisterController / todo/register.jsp 
3. 등록화면(post)
   TodoRegisterController 
4. 조회화면(get)
   TodoReadController / todo/read.jsp
5. 수정/삭제 화면(get)
   TodoModifyController / todo/modify.jsp
6. 수정(post)
   TodoModifyController 
7. 삭제(post)
   TodoRemoveController 


### 2022-12-29 
현재 page 91p 까지 끝냄 
jdbc + db준비해야함 하... 

### 2022-12-30
#### 1. github이슈
커밋은 정상적으로 됐다는데 깃허브에서는 보이지 않는 현상이 있었다. 
찾아보니 그냥 홍은.. push 안한것,, 아니 분명 커밋 앤 푸쉬 눌렀는디.. 
다음부터는 터미널로 확실하게 푸쉬하고 확인하는것으로! !

#### 2. database 추가
mariadb를 사용해서 webdb database를 만들고 연결해주는데 성공했다.
(테스트 코드 연결 확인 및 테이블 생성 후 insert/select/update/delete 실행해봄)

#### 3. Lombok 설치
   `https://projectlombok.org/setup/gradle`
사이트에 접속해서 build.gradle > dependencies에다가 롬복생성해주면 된다. (간단!)

#### 4. HikariCP 설치
 공식사이트(깃허브)에 들어가면 maven설치법 밖에없는데, 그냥 구글링으로 간단하게 검색하면 현재버전보다 아래버전인
`implementation group: 'com.zaxxer', name: 'HikariCP', version: '2.3.2'`
나옴 이거 build.gradle > dependencies에다가 생성해주면 된다.
(전에 해당부분에서 막혔어서... 이클립스에서 인텔리제이로 갈아탐)

#### 5. DAO 작성방법 
기존에 내가 사용하던 방식(회사코드나 자바로 하던 프로젝트들)은 따로 xml파일을 생성해서 그안에서 쿼리문을 적는 방식이었다면
여기서 배우는 방식은 스프링 프레임워크를 이용하는 방식이다. 
처음에는 익숙하지 않겠지만 반복을 통해서 공부하다보면 익숙해질듯 (오히려 편할수도) 
   

-- 기회가 된다면 vo 와 dto의 차이 공부 


131p 까지 진행함 