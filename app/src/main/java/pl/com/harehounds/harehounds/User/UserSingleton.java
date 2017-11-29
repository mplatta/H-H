package pl.com.harehounds.harehounds.User;

/**
 * created by klata on 31.10.2017.
 */
public class UserSingleton {
	private Integer idUser;
	private String nickName;
	private String email;
	private static UserSingleton instance = null;

	public String getEmail() {
		return this.email;
	}

	public String getNickName() {
		return this.nickName;
	}

	public Integer getIdUser() {
		return this.idUser;
	}

	@Override
	public String toString() {
		return this.idUser.toString() + this.nickName + this.email;
	}

	public static UserSingleton getInstance(Integer idUser, String nickName, String email) {
		if (instance == null) {
			instance = new UserSingleton(idUser, nickName, email);
		}

		return instance;
	}

	public static UserSingleton getInstance() {
		return instance;
	}

	private UserSingleton(Integer idUser, String nickName, String email) {
		this.idUser = idUser;
		this.nickName = nickName;
		this.email = email;
	}

	private UserSingleton() {}
}