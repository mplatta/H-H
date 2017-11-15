package pl.com.harehounds.harehounds;

/**
 * created by klata on 31.10.2017.
 */
class UserSingletone {
	private Integer idUser;
	private String nickName;
	private String email;
	private static UserSingletone instance = null;

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

	public static UserSingletone getInstance(Integer idUser, String nickName, String email) {
		if (instance == null) {
			instance = new UserSingletone(idUser, nickName, email);
		}

		return instance;
	}

	public static UserSingletone getInstance() {
		return instance;
	}

	private UserSingletone(Integer idUser, String nickName, String email) {
		this.idUser = idUser;
		this.nickName = nickName;
		this.email = email;
	}

	private UserSingletone() {}
}