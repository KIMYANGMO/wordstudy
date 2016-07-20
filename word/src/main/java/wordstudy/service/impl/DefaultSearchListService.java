package wordstudy.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wordstudy.dao.SearchListDao;
import wordstudy.service.SearchListService;
import wordstudy.vo.SearchList;

@Service
public class DefaultSearchListService implements SearchListService {
  @Autowired SearchListDao searchListDao;
  
  public void add(SearchList searchList) {
    searchListDao.insert(searchList);
  }
  
  public void assoUpdate(SearchList searchList) {
    searchListDao.assoUpdate(searchList);
  }
  
  public void hatesUpdate(SearchList searchList) {
    searchListDao.hatesUpdate(searchList);
  }
  
  public void hatesUpdateAdd(SearchList searchList) {
    searchListDao.hatesUpdateAdd(searchList);
  }
  
  public void assoListDelete(SearchList searchList) {
    searchListDao.assoListDelete(searchList);
  }
  
  public void assoDelete(SearchList searchList) {
    searchListDao.assoDelete(searchList);
  }
  
  public void likesUpdate(SearchList searchList) {
    searchListDao.likesUpdate(searchList);
  }
  
  public void likesUpdateAdd(SearchList searchList) {
    searchListDao.likesUpdateAdd(searchList);
  }
  
  public void wordAdd(SearchList searchList) {
    searchListDao.wordAdd(searchList);
  }
  public void myLOHAdd(SearchList searchList) {
    searchListDao.myLOHAdd(searchList);
  }
  
  public void wordMeanAdd(SearchList searchList) {
    searchListDao.wordMeanAdd(searchList);
  }
  /*
  public void delete(int no) {
    searchListDao.delete(no);
  } */
  
  public int findAsso(SearchList searchList) {    
    return searchListDao.findAsso(searchList);
  }
  
  public Integer likes(SearchList searchList) {    
    return searchListDao.likes(searchList);
  }
  
  public Integer hates(SearchList searchList) {    
    return searchListDao.hates(searchList);
  }
  
  public SearchList wordList(SearchList searchList) {    
    return searchListDao.wordList(searchList);
  }
  

  public SearchList assoList(SearchList searchList) {  
    return searchListDao.assoList(searchList);
  }
  

  public List<SearchList> list(String word) {
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("word", word);
    return searchListDao.selectList(paramMap);
  }


  @Override
  public void delete(int no) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public SearchList retrieve(int no) {
    
    return null;
  }

  @Override
  public void change(SearchList searchList) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public int countPage(int pageSize) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public SearchList retrieveWord(String word) {
    Map<String,Object> paramMap = new HashMap<>();
    paramMap.put("word", word);
    return null;
  }
  
  /*public void change(SearchList searchList) {
    searchListDao.update(searchList);
  }

  public int countPage(int pageSize) {
    int count = searchListDao.countAll();
    int pages = count / pageSize;
    if ((count % pageSize) > 0)
      pages++;
    return pages;
  }*/
}

/*
# Service 객체
- 비즈니스 로직을 수행한다.
- 트랜잭션을 제어한다.
- 메서드의 이름은 업무 용어에 가깝게 정의하라!
- 업무 처리에 필요하다면 여러 개의 DAO를 사용할 수 있다.
*/