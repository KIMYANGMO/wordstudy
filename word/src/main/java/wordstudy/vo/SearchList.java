package wordstudy.vo;

import java.sql.Date;

public class SearchList {
  int ano;
  int mno;
  int meno;
  String nick;
  Date date;
  String word;
  String mean;
  String asso;
  int likeNo;
  int hateNo;
  String prophotPath;
  String assophotPath;
  String assothumPath;
  String hint;
  int best;
  boolean favor;
  int likes;
  int hates;
  public SearchList() {
    super();
    // TODO Auto-generated constructor stub
  }
  public SearchList(int ano, int mno, int meno, String nick, Date date, String word, String mean, String asso,
      int likeNo, int hateNo, String prophotPath, String assophotPath, String assothumPath, String hint, int best,
      boolean favor, int likes, int hates) {
    super();
    this.ano = ano;
    this.mno = mno;
    this.meno = meno;
    this.nick = nick;
    this.date = date;
    this.word = word;
    this.mean = mean;
    this.asso = asso;
    this.likeNo = likeNo;
    this.hateNo = hateNo;
    this.prophotPath = prophotPath;
    this.assophotPath = assophotPath;
    this.assothumPath = assothumPath;
    this.hint = hint;
    this.best = best;
    this.favor = favor;
    this.likes = likes;
    this.hates = hates;
  }
  public int getAno() {
    return ano;
  }
  public void setAno(int ano) {
    this.ano = ano;
  }
  public int getMno() {
    return mno;
  }
  public void setMno(int mno) {
    this.mno = mno;
  }
  public int getMeno() {
    return meno;
  }
  public void setMeno(int meno) {
    this.meno = meno;
  }
  public String getNick() {
    return nick;
  }
  public void setNick(String nick) {
    this.nick = nick;
  }
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
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
  public String getAsso() {
    return asso;
  }
  public void setAsso(String asso) {
    this.asso = asso;
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
  public String getProphotPath() {
    return prophotPath;
  }
  public void setProphotPath(String prophotPath) {
    this.prophotPath = prophotPath;
  }
  public String getAssophotPath() {
    return assophotPath;
  }
  public void setAssophotPath(String assophotPath) {
    this.assophotPath = assophotPath;
  }
  public String getAssothumPath() {
    return assothumPath;
  }
  public void setAssothumPath(String assothumPath) {
    this.assothumPath = assothumPath;
  }
  public String getHint() {
    return hint;
  }
  public void setHint(String hint) {
    this.hint = hint;
  }
  public int getBest() {
    return best;
  }
  public void setBest(int best) {
    this.best = best;
  }
  public boolean isFavor() {
    return favor;
  }
  public void setFavor(boolean favor) {
    this.favor = favor;
  }
  public int getLikes() {
    return likes;
  }
  public void setLikes(int likes) {
    this.likes = likes;
  }
  public int getHates() {
    return hates;
  }
  public void setHates(int hates) {
    this.hates = hates;
  }
  @Override
  public String toString() {
    return "SearchList [ano=" + ano + ", mno=" + mno + ", meno=" + meno + ", nick=" + nick + ", date=" + date
        + ", word=" + word + ", mean=" + mean + ", asso=" + asso + ", likeNo=" + likeNo + ", hateNo=" + hateNo
        + ", prophotPath=" + prophotPath + ", assophotPath=" + assophotPath + ", assothumPath=" + assothumPath
        + ", hint=" + hint + ", best=" + best + ", favor=" + favor + ", likes=" + likes + ", hates=" + hates + "]";
  }
      
  
}