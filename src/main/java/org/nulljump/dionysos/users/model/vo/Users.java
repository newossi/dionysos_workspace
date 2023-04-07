package org.nulljump.dionysos.users.model.vo;

import java.sql.Date;

public class Users implements java.io.Serializable {
	private static final long serialVersionUID = 404901630073494581L;
	private String user_id; // 아이디
	private String password; // 패스워드
	private String name; // 이름
	private java.sql.Date birthday; // 생년월일
	private String phone; // 전화번호
	private String email; // 이메일
	private String admin; // 관리자여부

	public Users() {
		super();
	}

	public Users(String user_id, String password, String name, Date birthday, String phone, String email,
			String admin) {
		super();
		this.user_id = user_id;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.admin = admin;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public java.sql.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.sql.Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", password=" + password + ", name=" + name + ", birthday=" + birthday
				+ ", phone=" + phone + ", email=" + email + ", admin=" + admin + "]";
	}

}
