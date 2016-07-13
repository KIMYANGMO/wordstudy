package wordstudy.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wordstudy.dao.MyWordDao;
import wordstudy.service.MyWordService;
import wordstudy.vo.MyWord;
import wordstudy.vo.Paging;
import wordstudy.vo.SearchList;

@Service
public class DefaultMyWordService implements MyWordService {
  @Autowired MyWordDao myWordDao;
  
  public void add(MyWord myWord) {
    myWordDao.insert(myWord);
  }
  
  public void delete(MyWord myWord) {
    myWordDao.delete(myWord);
  }
  
  public void change(MyWord myWord) {
    myWordDao.update(myWord);
  }
  
 /* public List<SearchList> list(int mno) {
    return myWordDao.selectList(mno);
  }*/
  public List<SearchList> list(int mno, Paging paging) {
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("mno", mno);
    paramMap.put("startIndex", (paging.getPageNo() - 1) * paging.getPageSize());
    paramMap.put("length", paging.getPageSize());
    
    return myWordDao.selectList(paramMap);
  }

  public boolean exist(int mno, int ano) {
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("mno", mno);
    paramMap.put("ano", ano);
    
    if (myWordDao.isMyWord(paramMap) > 0) {
      return true;
    }
    
    return false;
  }
  
  public int totalCount(int mno) {
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("mno", mno);
    
    if (myWordDao.itIsMyWord(paramMap) > 0) {
      return myWordDao.itIsMyWord(paramMap);
    }
    
    return 0;
  }
 
}
