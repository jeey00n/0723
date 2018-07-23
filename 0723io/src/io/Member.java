//파일에 객체 단위로 기록하고 읽기
//1. 기록할 객체의 클래스 생성 - Serializable 인터페이스를 implements
//2. 1번에서 만든 클래스의 객체를 파일이 기록하는 작업을 만들어주기 위해, main메소드를 소유한 클래스를 생성
//3. 메인을 변경해서 읽기

package io;

import java.io.Serializable;

public class Member implements Serializable{
	private String email;
	//transient를 붙이면, 이 변수에는 저장하지 않는다.
	private transient String pw;
	private String phone;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Member [email=" + email + ", pw=" + pw + ", phone=" + phone + "]";
	}
}
