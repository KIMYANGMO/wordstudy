package wordstudy.vo;

public class TestData {
  String nick;
  String date;
  String word;
  String mean;
  String weeks;
  int likeNo;
  int hateNo;
  public TestData() {
    super();
    // TODO Auto-generated constructor stub
  }
  public TestData(String nick, String date, String word, String mean, String weeks,
      int likeNo, int hateNo) {
    super();
    
    this.nick = nick;
    this.date = date;
    this.word = word;
    this.mean = mean;
    this.weeks = weeks;
    this.likeNo = likeNo;
    this.hateNo = hateNo;
  }
  
  public String getNick() {
    return nick;
  }
  public void setNick(String nick) {
    this.nick = nick;
  }
  public String getDate() {
    return date;
  }
  public void setDate(String date) {
    this.date = date;
  }
  public String getWord() {
    return word;
  }
  public void setWord(String word) {
    this.word = word;
  }
  public String getMean() {
    return mean;
  }
  public void setMean(String mean) {
    this.mean = mean;
  }
  public String getWeeks() {
    return weeks;
  }
  public void setWeeks(String weeks) {
    this.weeks = weeks;
  }
  public int getLikeNo() {
    return likeNo;
  }
  public void setLikeNo(int likeNo) {
    this.likeNo = likeNo;
  }
  public int getHateNo() {
    return hateNo;
  }
  public void setHateNo(int hateNo) {
    this.hateNo = hateNo;
  }
  
  
}
