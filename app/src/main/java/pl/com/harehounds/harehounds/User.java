package pl.com.harehounds.harehounds;

/**
 * Created by Michał on 31.10.2017.
 */

public class User {
	private int idUser;
	private String nickName;
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public User(int idUser, String nickName, String email) {
		this.idUser = idUser;
		this.nickName = nickName;
		this.email = email;
	}

	public User() {}
}
