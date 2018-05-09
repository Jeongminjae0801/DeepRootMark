비밀번호 암호화

1.

Root  Context 
<bean id="bCryptPasswordEncoder" 
 class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder">
		
</bean>


2.
Servlet Context 
<security:password-encoder ref="bCryptPasswordEncoder"/>


3. Memeber Table 
password :     PWD        VARCHAR2(50)
암호:             PWD        VARCHAR2(2000)    
alter table member
modify (pwd varchar2(200));


4. MemberDAO 인터페이스
              //회원가입
	public int insertMember(Member member);
             
              //회원수정
	public int updateMember(Member member);

                 
5. @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

   생성 주입
   member.setPwd(this.bCryptPasswordEncoder.encode(member.getPwd()));

   기존 패스워드 비교
   boolean result = bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
   사용자 입력 : rawPassword >  1111
   DB 비번     : encodedPassword > $2a$10$wz7BhLkBKPV164JGmtEf4.9e9dn1ji6ABDC7cw9PxghN4o6BVaXhy


6. 회원 가입시 
    roll 테이블에  기본 권한을 가지고 있어야 한다
   insert into roll
   values('park','ROLE_ADMIN');

http://scw0531.blog.me/221002903898