package wordstudy.service;

import java.util.List;

import wordstudy.vo.Learn;

public interface LearnService {
  List<Learn> selectList(int meno);
  List<Learn> hintList();
  List<Learn> correctMean(int meno);
  List<Learn> otherHint(int meno);
}
