package wordstudy.service;

import java.util.List;

import wordstudy.vo.SearchList;

public interface SearchListService {
  void add(SearchList searchList);
  SearchList wordList(SearchList searchList);
  void delete(int no);
  
  List<SearchList> list(String word);
  void change(SearchList searchList);
  int countPage(int pageSize);
  void wordMeanAdd(SearchList searchList);
  void wordAdd(SearchList searchList);
  void likesUpdate(SearchList searchList);
  Integer likes(SearchList searchList);
  Integer hates(SearchList searchList);
  SearchList assoList(SearchList searchList);
  void myLOHAdd(SearchList searchList);
  void likesUpdateAdd(SearchList searchList);
  SearchList retrieve(int no);
  SearchList retrieveWord(String word);
  void hatesUpdate(SearchList searchList);
  void hatesUpdateAdd(SearchList searchList);
}
