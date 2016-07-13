package wordstudy.vo;


public class MyWord {
  int mno;
  int ano;
  char favorYn;
  public MyWord() {
    super();
    // TODO Auto-generated constructor stub
  }
  public MyWord(int mno, int ano, char favorYn) {
    super();
    this.mno = mno;
    this.ano = ano;
    this.favorYn = favorYn;
  }
  public int getMno() {
    return mno;
  }
  public void setMno(int mno) {
    this.mno = mno;
  }
  public int getAno() {
    return ano;
  }
  public void setAno(int ano) {
    this.ano = ano;
  }
  public char getFavorYn() {
    return favorYn;
  }
  public void setFavorYn(char favorYn) {
    this.favorYn = favorYn;
  }
  @Override
  public String toString() {
    return "MyWord [mno=" + mno + ", ano=" + ano + ", favorYn=" + favorYn + "]";
  }

}