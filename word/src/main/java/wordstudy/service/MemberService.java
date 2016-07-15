package wordstudy.service;

import java.util.List;

import wordstudy.vo.Member;

public interface MemberService {
  void add(Member member);
  void delete(String email);
  Member retrieveByNo(int no);
  Member retrieveByEmail(String email);
  Member retrieveByNick(String nick);
  void change(Member member);
  void pwdChange(Member member);
  void photChange(Member member);
  boolean exist(String email, String password);
  List<Member> list(Member member);
  int mylikes(Member member); 
  int countPage(int pageSize);
}

