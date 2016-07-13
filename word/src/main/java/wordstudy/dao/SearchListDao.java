package wordstudy.dao;

import java.util.List;
import java.util.Map;

import wordstudy.vo.SearchList;



public interface SearchListDao {
  List<SearchList> selectList(Map<String,Object> paramMap);
  SearchList selectOne(Map<String, Object> paramMap);
  int insert(SearchList searchList);  
  int update(SearchList searchList);
  int delete(int no);
  int isSearchList(Map<String,Object> paramMap);
  int countAll();
  SearchList wordList(SearchList searchList);
  void wordMeanAdd(SearchList searchList);
  void wordAdd(SearchList searchList);
  void likesUpdate(SearchList searchList);
  int likes(SearchList searchList);
  int hates(SearchList searchList);
  SearchList assoList(SearchList searchList);
  void myLOHAdd(SearchList searchList);
  void likesUpdateAdd(SearchList searchList);
  void hatesUpdate(SearchList searchList);
  void hatesUpdateAdd(SearchList searchList);
}










