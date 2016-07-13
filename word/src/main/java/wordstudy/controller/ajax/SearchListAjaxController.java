package wordstudy.controller.ajax;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.gson.Gson;

import wordstudy.service.SearchListService;
import wordstudy.vo.Member;
import wordstudy.vo.SearchList;


@Controller
@RequestMapping("/ajax/searchList/")
public class SearchListAjaxController {
  @Autowired SearchListService searchListService;
  @Autowired ServletContext servletContext;
  
  @RequestMapping(value="likeOrHate", produces="application/json;charset=UTF-8")
  @ResponseBody
  public String likeOrHate(HttpSession session, String asso) throws ServletException, IOException {
    
    Member member = (Member)session.getAttribute("loginUser");
    SearchList searchList = new SearchList();
    searchList.setAsso(asso);
    searchList.setMno(member.getNo());
    
    if (searchListService.assoList(searchList) == null) {
      searchListService.myLOHAdd(searchList);      
    }
      
    HashMap<String,Object> result = new HashMap<>();  
    Integer likes = searchListService.likes(searchList);
    Integer hates = searchListService.hates(searchList);
    
    if(likes == null){
    	likes = 0;
    }
    if(hates == null){
    	hates = 0;
    }
    
    if(likes.intValue() == 0 && hates.intValue() == 0) { 
      searchListService.likesUpdateAdd(searchList);
      
      result.put("status", "success");
    } else {
      System.out.println("이미 좋아/싫어 누름");
      result.put("status", "failure");
    }
    
    return new Gson().toJson(result);
  }
   
  
  @RequestMapping(value="wordList", produces="application/json;charset=UTF-8")
  @ResponseBody
  public String wordList(String word) throws ServletException, IOException {

    SearchList searchList = new SearchList();
    searchList.setWord(word);
   
    
    HashMap<String,Object> result = new HashMap<>();
    if(searchListService.wordList(searchList) != null) {
      result.put("status", "success");
    } else {
      result.put("status", "failure");
    }
    return new Gson().toJson(result);
  }

  
  @RequestMapping(value="wordMeanAdd", produces="application/json;charset=UTF-8")
  @ResponseBody
  public String add(String word, String mean) throws ServletException, IOException {

    SearchList searchList = new SearchList();
    searchList.setWord(word);
    searchList.setMean(mean);
    
    
    HashMap<String,Object> result = new HashMap<>();
    
    try {
      searchListService.wordMeanAdd(searchList);
      result.put("status", "success");
    } catch (Exception e) {
      e.printStackTrace();
      result.put("status", "failure");
    }
    
    return new Gson().toJson(result);
  }
  
  @RequestMapping(value="wordAdd", produces="application/json;charset=UTF-8")
  @ResponseBody
  public String wordAdd(String word) throws ServletException, IOException {

    SearchList searchList = new SearchList();
    searchList.setWord(word);    
    
    
    HashMap<String,Object> result = new HashMap<>();
    
    try {
      searchListService.wordAdd(searchList);
      result.put("status", "success");
    } catch (Exception e) {
      e.printStackTrace();
      result.put("status", "failure");
    }
    
    return new Gson().toJson(result);
  }
  @RequestMapping(value="add", method=RequestMethod.POST)
  @ResponseBody
  public String add(HttpSession session, MultipartHttpServletRequest request, String word, String mean, String asso, String assophotPath, String hint, HttpServletResponse response) throws ServletException, IOException {
    Member member = (Member)session.getAttribute("loginUser");
    System.out.println("member:" + member.getNo());
    System.out.println("member:" + member.getEmail());
    //asso 태그 변환하여 DB저장
    String outputAssos = "";
    asso = asso.replaceAll("id=\"text\\d{1,4}\" onclick=\"changeValue\\d{1,4}\\(\\d{1,4}\\)\"","")
    .replaceAll("data-index=\"\\d{1,4}\"","")
    .replaceAll("span  class=\"assohint\" ","red")
    .replaceAll("span  class=\"assomean\" ","blue")
    .replaceAll("<span  class=\"assotext\" >","");
    String assos[] = asso.split("</span>");
    for (String assoList : assos) {
      if(assoList.startsWith("<red>")) {
        assoList += "</red>";
      } else if (assoList.startsWith("<blue>")) {
        assoList += "</blue>";
      }
      outputAssos += assoList;
    }
    System.out.println(outputAssos);
    //hint 변환하여 DB로 저장
    hint = hint.replaceAll("id=\"text\\d{1,4}\" onclick=\"changeValue\\d{1,4}\\(\\d{1,4}\\)\"","")
    .replaceAll("data-index=\"\\d{1,4}\"","")
    .replaceAll("</span>","")
    .replaceAll("<span  class=\"assohint\" >","")
    .replaceAll("<span  class=\"assomean\" >.","__")
    .replaceAll("<span  class=\"assotext\" >","");
    SearchList searchList = new SearchList();
    searchList.setWord(word);
    searchList.setMean(mean);
    searchList.setAsso(outputAssos);
    searchList.setHint(hint);
    searchList.setMno(member.getNo());
    
    Map<String, MultipartFile> files = request.getFileMap();
    CommonsMultipartFile cmf = (CommonsMultipartFile) files.get("photo");
    System.out.println(cmf.getOriginalFilename());
    
    int extPoint = cmf.getOriginalFilename().lastIndexOf(".");
    if (extPoint > 0) {
      String filename = System.currentTimeMillis() + "-" + count()
                         + cmf.getOriginalFilename().substring(extPoint);
      System.out.printf("새파일명=%s\n", filename);
      String realPath = "C:/bitcamp/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/word2/upload/" + filename;
      /* 양모 upload 경로 C:/bitcamp/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/word2/upload/ */
      /* /Users/Administrator/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp4/wtpwebapps/word/upload/ */
      System.out.printf("새 파일을 저장할 실제 경로=%s\n", realPath);
      try {
        File realFile = new File(realPath);
        cmf.transferTo(realFile);
        String subs = filename.substring(filename.lastIndexOf("."));
        String thumbnailFileNm = filename.replace(subs, "") + "-" + "t" + subs;
        String realThumbnailPath = "C:/bitcamp/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/word2/upload/" + thumbnailFileNm;
        File thumbnailFile = new File(realThumbnailPath);
   
        int width = 160;
        int height = 110;
        // 썸네일 이미지 생성
        BufferedImage originalImg = ImageIO.read(realFile);
        BufferedImage thumbnailImg = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        // 썸네일 그리기 
        Graphics2D g = thumbnailImg.createGraphics();
        g.drawImage(originalImg, 0, 0, width, height, null);
        // 파일생성
        ImageIO.write(thumbnailImg, "jpg", thumbnailFile);  
        
        searchList.setAssophotPath("../upload/" + filename);
        searchList.setAssothumPath("../upload/" + thumbnailFileNm);
        
        searchListService.add(searchList);
        
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
    return "redirect:../list/list.html?word=" + word;
  }
  
  int no = 0;
  synchronized private int count() {
    if (++no == 100) no = 1;
    return no;
  }
  
  @RequestMapping(value="delete", produces="application/json;charset=UTF-8")
  @ResponseBody
  public String delete(int no) 
      throws ServletException, IOException {
    HashMap<String,Object> result = new HashMap<>();
    try {
      searchListService.delete(no);
      result.put("status", "success");
    } catch (Exception e) {
      result.put("status", "failure");
    }
    return new Gson().toJson(result);
  }
  
  @RequestMapping(value="detail", produces="application/json;charset=UTF-8")
  @ResponseBody
  public String detail(int no) throws ServletException, IOException {
    SearchList searchList = searchListService.retrieve(no);
    return new Gson().toJson(searchList);
  }
  
  @RequestMapping(value="word", produces="application/json;charset=UTF-8")
  @ResponseBody
  public String retrieveWord(String word) throws ServletException, IOException {
    SearchList searchList = searchListService.retrieveWord(word);
    return new Gson().toJson(searchList);
  }
  
  
  
  @RequestMapping(value="list", produces="application/json;charset=UTF-8")
  @ResponseBody
  public String list(HttpSession session,
      @RequestParam String word)
      throws ServletException, IOException {
    
    List<SearchList> list = searchListService.list(word);
    HashMap<String,Object> result = new HashMap<>();
    result.put("list", list);
    return new Gson().toJson(result);
  }
  
 @RequestMapping(value="likesUpdate",    
      produces="application/json;charset=UTF-8")
  @ResponseBody
  public String likesUpdate(HttpSession session, String asso) throws ServletException, IOException {
   Member member = (Member)session.getAttribute("loginUser");
   
    SearchList searchList = new SearchList();    
    searchList.setAsso(asso);    
    searchList.setMno(member.getNo());
    
    HashMap<String,Object> result = new HashMap<>();
    try {
      searchListService.likesUpdate(searchList);
      result.put("status", "success");
    } catch (Exception e) {
      e.printStackTrace();
      result.put("status", "failure");
    }
    return new Gson().toJson(result);
  }
 
 @RequestMapping(value="hatesUpdate",    
     produces="application/json;charset=UTF-8")
 @ResponseBody
 public String hatesUpdate(HttpSession session, String asso) throws ServletException, IOException {
  Member member = (Member)session.getAttribute("loginUser");
  
   SearchList searchList = new SearchList();    
   searchList.setAsso(asso);    
   searchList.setMno(member.getNo());
   
   HashMap<String,Object> result = new HashMap<>();
   try {
     searchListService.hatesUpdate(searchList);
     result.put("status", "success");
   } catch (Exception e) {
     e.printStackTrace();
     result.put("status", "failure");
   }
   return new Gson().toJson(result);
 }
  /*@RequestMapping(value="update",
      method=RequestMethod.POST,
      produces="application/json;charset=UTF-8")
  @ResponseBody
  public String update(int no, String title, String content) throws ServletException, IOException {
    
    SearchList searchList = new SearchList();
    searchList.setNo(no);
    searchList.setTitle(title);
    searchList.setContent(content);
    
    HashMap<String,Object> result = new HashMap<>();
    try {
      searchListService.change(searchList);
      result.put("status", "success");
    } catch (Exception e) {
      result.put("status", "failure");
    }
    return new Gson().toJson(result);
  }*/
}




