package wordstudy.controller.ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import wordstudy.service.LearnService;
import wordstudy.vo.Learn;


@Controller
@RequestMapping("/ajax/learn/")
public class LearnAjaxController {
  @Autowired LearnService learnService;
  @Autowired ServletContext servletContext;
  
  
  @RequestMapping(value="list", produces="application/json;charset=UTF-8")
  @ResponseBody
  public String list()
      throws ServletException, IOException {
    
    List<Learn> hintList = learnService.hintList();
    List<Learn> randExam = null;
    List<Learn> otherHint = null;
    List<Learn> correct = null;
    ArrayList<String> otherHintList = null;
    ArrayList<String> otherAtPaths = null;
    ArrayList<String> examples = null;
    ArrayList<String> resultExamples = null;
    HashMap<String,Object> result = new HashMap<>();
    List<Learn> list = new ArrayList<>();
    Learn learn = null;
    
    for (int i = 0; i < 10; i++) {
      examples = new ArrayList<>();
      learn = new Learn();
      resultExamples = new ArrayList<>();
      otherHintList = new ArrayList<>();
      otherAtPaths = new ArrayList<>();
      
      learn.setAssothumPath(hintList.get(i).getAssothumPath());
      
      otherHint = learnService.otherHint(hintList.get(i).getMeno());
      for (int l = 0; l < otherHint.size(); l++) {
        otherHintList.add(otherHint.get(l).getHint());
        otherAtPaths.add(otherHint.get(l).getAssothumPath());
      }
      learn.setOtherhints((String[])otherHintList.toArray(new String[otherHintList.size()]));
      learn.setOtherAtPath((String[])otherAtPaths.toArray(new String[otherAtPaths.size()]));
      
      randExam = learnService.selectList(hintList.get(i).getMeno());
      for (int j= 0; j < 3; j++) {
        examples.add(randExam.get(j).getMean());
      }
      
      correct = learnService.correctMean(hintList.get(i).getMeno());
      examples.add(correct.get(0).getMean());
      
      Random ra = new Random();
      int mainSize= examples.size();
      for (int k = 0; k < mainSize ;k++){
        int rv = ra.nextInt(examples.size());
        resultExamples.add(examples.get(rv));
        examples.remove(rv);
      }
      learn.setExamples((String[])resultExamples.toArray(new String[resultExamples.size()]));
      learn.setHint(hintList.get(i).getHint());
      learn.setWord(correct.get(0).getWord());
      
      list.add(learn);
      
    }
    
    result.put("list", list);
    return new Gson().toJson(result);
  }
 
}




