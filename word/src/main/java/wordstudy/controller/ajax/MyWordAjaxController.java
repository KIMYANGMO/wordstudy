package wordstudy.controller.ajax;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import wordstudy.service.MyWordService;
import wordstudy.vo.Member;
import wordstudy.vo.MyWord;
import wordstudy.vo.Paging;
import wordstudy.vo.SearchList;

@Controller
@RequestMapping("/ajax/myWord/")
public class MyWordAjaxController {
  @Autowired MyWordService myWordService;
  
  @RequestMapping(value="add", produces="application/json;charset=UTF-8")
  @ResponseBody
  public String add(HttpSession session, int ano) throws ServletException, IOException {
    
    Member member = (Member)session.getAttribute("loginUser");
    MyWord myWord = new MyWord();
    myWord.setMno(member.getNo());
    myWord.setAno(ano);
    
    HashMap<String,Object> result = new HashMap<>();
    
    try {
      myWordService.add(myWord);
      result.put("status", "success");
    } catch (Exception e) {
      e.printStackTrace();
      result.put("status", "failure");
    }
    
    return new Gson().toJson(result);
  }
  
  @RequestMapping(value="delete", produces="application/json;charset=UTF-8")
  @ResponseBody
  public String delete(HttpSession session, int ano) 
      throws ServletException, IOException {
    
    Member member = (Member)session.getAttribute("loginUser");
    
    MyWord myWord = new MyWord();
    myWord.setMno(member.getNo());
    myWord.setAno(ano);
    
    HashMap<String,Object> result = new HashMap<>();
    try {
      myWordService.delete(myWord);
      result.put("status", "success");
    } catch (Exception e) {
      result.put("status", "failure");
    }
    return new Gson().toJson(result);
  }

  @RequestMapping(value="list", produces="application/json;charset=UTF-8")
  @ResponseBody
  public String list(
      HttpSession session, int pageNo, int pageSize)
      throws ServletException, IOException {
    
    Member member = (Member)session.getAttribute("loginUser");
        
    Paging paging = new Paging();
    paging.setPageNo(pageNo);
    paging.setPageSize(pageSize); // 한 페이지에 나타나는 연상법 갯수
    paging.setTotalCount(myWordService.totalCount(member.getNo()));
    
    List<SearchList> list = myWordService.list(member.getNo(), paging);
    HashMap<String,Object> result = new HashMap<>();
    result.put("paging", paging);
    result.put("list", list);
    
    return new Gson().toJson(result);
  }
  
/*  @RequestMapping(value="update",
      method=RequestMethod.POST,
      produces="application/json;charset=UTF-8")
  @ResponseBody
  public String update(int no, String nick, String password, String photo) throws ServletException, IOException {
    
    MyWord myWord = new MyWord();
    myWord.setNo(no);
    myWord.setNick(nick);
    myWord.setEmail(password);
    myWord.setPhoto(photo);
    
    HashMap<String,Object> result = new HashMap<>();
    try {
      myWordService.change(myWord);
      result.put("status", "success");
    } catch (Exception e) {
      result.put("status", "failure");
    }
    return new Gson().toJson(result);
  }*/
  

  @RequestMapping(value="exist", produces="application/json;charset=UTF-8")
  @ResponseBody
  public String exist(HttpServletRequest request, int ano) 
      throws ServletException, IOException {

    HttpSession session = request.getSession();
    Member member = (Member)session.getAttribute("loginUser");
    
    boolean exist = myWordService.exist(member.getNo(), ano);
    
    HashMap<String,Object> result = new HashMap<>();
    result.put("exist", exist);
    
    System.out.println(result.get("exist"));
    return new Gson().toJson(result);
  }
  
  
}




