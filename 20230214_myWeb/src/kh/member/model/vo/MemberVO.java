package kh.member.model.vo;


/**
 * 
 * @author user1
 * 0. 첫 화면("/")  header 로그인(login - get)/로그아웃 버튼(logout - get),  
 * 로그인 화면에서 로그인 버튼을 누르면 post - > login  /회원가입 버튼을 누르면 get -> enroll
 * 1. 회원가입("/enroll") - 로그인 화면 하단에 회원가입버튼 get enroll.jsp// post 회원가입 DB다녀와서 -> 메인으로
 * 회원가입 화면 - > 회원가입버튼 -> post -enroll
 * 2. 로그인("/login") - get - login.jsp 로 forward post 로그인 다녀와서 DB session 등록 (이름 ,email, id)
 * 3. 로그아웃("/logout") - get 세션 만료 후 - main 으로
 * 4. 내정보보기("/myinfo")
 * 내정보 보기 화면에서 하단에 수정  , 탈퇴버튼 
 * 5. 내정보수정("/infoupdate")
 * 내정보 보기 수정 화면에서 수정 post 한다.
 * 
 *
 */

public class MemberVO {
	
	private String id;
	private String passwd;
	private String name;
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", passwd=" + passwd + ", name=" + name + ", email=" + email + "]";
	}


}
