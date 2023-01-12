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

#### 5. DAO 작성방법 (getTime , insert, selectAll )
기존에 내가 사용하던 방식(회사코드나 자바로 하던 프로젝트들)은 따로 xml파일을 생성해서 그안에서 쿼리문을 적는 방식이었다면
여기서 배우는 방식은 스프링 프레임워크를 이용하는 방식이다. 
처음에는 익숙하지 않겠지만 반복을 통해서 공부하다보면 익숙해질듯 (오히려 편할수도) 
   

-- 기회가 된다면 vo 와 dto의 차이 공부
`https://www.youtube.com/watch?v=z5fUkck_RZM`
`https://www.notion.so/DTO-VO-bf8b7f903ce547bb82662de486016d68`

2023.01.03 
#### 1. DAO > select one , delete, update
PreparedStatement 클래스 
; SQL 구문을 실행하는 역할, 스스로는 sql 구문을 이해못한다 > 전달해주는 역할
sql 관리 o + 연결정보 x 

#### 2. MVC 와 JDBC의 결합 
@AllArgsConstructor //여기에 필드에 쓴 모든생성자만 만들어줌
@NoArgsConstructor //기본 생성자를 만들어줌



2023.01.12 
1. 어제 CRUD 중 다른건 다 정상적으로 처리 되었는데 update가 안되었다. 
해결하고 집에가고 싶었는데 빨리 가고싶은마음이 더 컸던듯
다 되는걸 보니 연결 문제 아니고, 쿼리 문제 아닐까 싶어서 다시한번 보기로.. 
아 지금은 또 된다..
바꾼것도 없는데 왜 되는걸까...
하 ... 찝찝
*해결*  
해당 문제 데이트포메터 떄문이었던것 같다. 
오타를 발견하지는 못했으나
TodoRegisterController에 있는 
`private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");`
코드로 변경해줬더니 바로 실행됨
해당 오류를 찾을 수 있던 이유는 레지스터에서도 데이트포메터로 오류가 났던 이유때문인데. 그때는 `yyyy-mm-dd`로 적어서 난 오류였음
아니근데 진짜로 이해안가는게 오타가 있나 싶어서 붙여놓고 확인했는데도 모르겠다.
어쨌든 단순한 휴먼에러였던걸로 

2. todo-list 간단한 CRUD를 완성했다.
책에서 말하는 코드의 개선사항들은
- 여러개의 컨트롤러를 작성해야하는 번거로움
- 동일한 로직읜 반복적인 사용
- 예외처리의 부재
- 반복적인 메소드 호출
이렇게 네가지를 꼽았다. 
해당부분은 공부하다보면 해결될 내용이겠지. 

내가 CRUD 작업을 하면서 힘들었던것은 일단 회사코드랑 사용도가 좀 다른것 같다. 회사코드는 로직을 서비스에다가 적는반면 이 프로젝트에서는 컨트롤러에 작성했기때문, 
사실이런건 개발자 맘대로기는 한데, 아직 구조이해도가 미숙한 나로써는 너무 헷갈려서 소스한번 찾아보려면이파일갔다가 저파일갔다가 요런 애로사항이 있었음.
이건 그냥 다른 방법없이 계속 작성하면서 익숙해지는 방법밖에는 없다고 생각한다. 
그래도...
나름 뿌듯! 잘했다 잘했어! 
