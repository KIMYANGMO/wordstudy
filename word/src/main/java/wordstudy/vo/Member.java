package wordstudy.vo;

public class Member {
  protected int    no;
  protected String nick;
  protected String email;
  protected String password;
  protected String photo;
  
  public Member() {}

  public Member(int no, String nick, String email, String password) {
    this.no = no;
    this.nick = nick;
    this.email = email;
    this.password = password;
  }

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	

	@Override
	public String toString() {
		return "Member [no=" + no + ", nick=" + nick + ", email=" + email + ", password=" + password + ", photo=" + photo
				+ "]";
	}



}