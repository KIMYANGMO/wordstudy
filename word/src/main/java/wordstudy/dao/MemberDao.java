package wordstudy.dao;

import java.util.List;
import java.util.Map;

import wordstudy.vo.Member;


public interface MemberDao {
	 List<Member> selectList(Map<String,Object> paramMap);
  Member selectOne(Map<String,Object> paramMap);
  int insert(Member member);
  int update(Member member);
  int pwdChange(Member member);
  int photChange(Member member);
  int delete(String email);
  int isMember(Map<String,Object> paramMap);
  int countAll();
  int mylikes(Member member);
}