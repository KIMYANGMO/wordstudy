package wordstudy.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wordstudy.dao.MemberDao;
import wordstudy.service.MemberService;
import wordstudy.vo.Member;

@Service
public class DefaultMemberService implements MemberService {
  @Autowired MemberDao memberDao;
  
  public void add(Member member) {
    memberDao.insert(member);
  }
  
  public void delete(String email) {
    memberDao.delete(email);
  }
  
  public Member retrieveByNo(int no) {
    Map<String,Object> paramMap = new HashMap<>();
    paramMap.put("no", no);
    
    return memberDao.selectOne(paramMap);
  }
  
  public Member retrieveByEmail(String email) {
    Map<String,Object> paramMap = new HashMap<>();
    paramMap.put("email", email);
    
    return memberDao.selectOne(paramMap);
  }
  
  public Member retrieveByNick(String nick) {
    Map<String,Object> paramMap = new HashMap<>();
    paramMap.put("nick", nick);
    
    return memberDao.selectOne(paramMap);
  }
  
  public void change(Member member) {
    memberDao.update(member);
  }
  
  public void pwdChange(Member member) {
    memberDao.pwdChange(member);
  }
  
  public void photChange(Member member) {
    memberDao.photChange(member);
  }
  
  public boolean exist(String email, String password) {
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("email", email);
    paramMap.put("password", password);
    
    if (memberDao.isMember(paramMap) > 0) {
      return true;
    }
    
    return false;
  }
  
  public int mylikes(Member member) {    
    return memberDao.mylikes(member);
  }
  
  public List<Member> list(Member member) {
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("email", member.getEmail());
    
    return memberDao.selectList(paramMap);
  }
  public int countPage(int pageSize) {
    int count = memberDao.countAll();
    int pages = count / pageSize;
    if ((count % pageSize) > 0)
      pages++;
    return pages;
  }

  
}
