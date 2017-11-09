package pl.com.harehounds.harehounds;

import java.io.Serializable;

/**
 * created by klata on 31.10.2017.
 */

class User implements Serializable {
	private Integer idUser;
	private String nickName;
	private String email;

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	@Override
	public String toString() {
		return this.idUser.toString() + this.nickName + this.email;
	}

	User(Integer idUser, String nickName, String email) {
		this.idUser = idUser;
		this.nickName = nickName;
		this.email = email;
	}

	public User() {}
}