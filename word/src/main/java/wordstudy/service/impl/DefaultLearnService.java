package wordstudy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wordstudy.dao.LearnDao;
import wordstudy.service.LearnService;
import wordstudy.vo.Learn;

@Service
public class DefaultLearnService implements LearnService {
  @Autowired LearnDao learnDao;


  public List<Learn> selectList(int meno) {
    return learnDao.selectList(meno);
  }
  
  public List<Learn> hintList() {
    return learnDao.hintList();
  }

  public List<Learn> correctMean(int meno) {
    return learnDao.correctMean(meno);
  }

  public List<Learn> otherHint(int meno) {
    return learnDao.otherHint(meno);
  }

  

}