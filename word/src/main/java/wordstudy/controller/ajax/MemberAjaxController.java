package wordstudy.controller.ajax;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.gson.Gson;

import wordstudy.service.MemberService;
import wordstudy.vo.Member;

@Controller
@RequestMapping("/ajax/member/")
public class MemberAjaxController {
  @Autowired MemberService memberService;
  @Autowired ServletContext servletContext;
  
  @RequestMapping(value="add", produces="application/json;charset=UTF-8")
  @ResponseBody
  public String add(String nick, String email, String password) throws ServletException, IOException {

    Member member = new Member();
    member.setNick(nick);
    member.setEmail(email);
    member.setPassword(password);
    
    HashMap<String,Object> result = new HashMap<>();
    
    try {
      memberService.add(member);
      result.put("status", "success");
    } catch (Exception e) {
      e.printStackTrace();
      result.put("status", "failure");
    }
    
    return new Gson().toJson(result);
  }
  
  @RequestMapping(value="delete", produces="application/json;charset=UTF-8")
  @ResponseBody
  public String delete(String email, String password) 
      throws ServletException, IOException {
    HashMap<String,Object> result = new HashMap<>();
    try {
		      Member resultMember = memberService.retrieveByEmail(email);
		      	//기존 비밀번호 체크 후 진행
		      	if(resultMember.getPassword().equals(password)){
		      		 memberService.delete(email);
		      		 result.put("status", "success");
		      	}else{
		      		result.put("status", "failure");
		       }    
    }catch (Exception e) {
    	result.put("status", "failure");
    }
    return new Gson().toJson(result);
  }
  
  @RequestMapping(value="detail", produces="application/json;charset=UTF-8")
  @ResponseBody
  public String detail(int no) throws ServletException, IOException {
    Member member = memberService.retrieveByNo(no);
    return new Gson().toJson(member);
  }
  
  @RequestMapping(value="detailByEmail", method=RequestMethod.POST, produces="application/json;charset=UTF-8")
  @ResponseBody
  public String detailByEmail(String email) throws ServletException, IOException {
    Member member = memberService.retrieveByEmail(email);
    return new Gson().toJson(member);
  }
  
  @RequestMapping(value="detailByNick", method=RequestMethod.POST, produces="application/json;charset=UTF-8")
  @ResponseBody
  public String detailByNick(String nick) throws ServletException, IOException {
    Member member = memberService.retrieveByNick(nick);
    System.out.println(member.getNick());
    return new Gson().toJson(member);
  }

  @RequestMapping(value="nickupdate",
      method=RequestMethod.POST,
      produces="application/json;charset=UTF-8")
  @ResponseBody
  public String nickupdate(HttpSession session, String nick, String email ) throws ServletException, IOException {
    
  	//결과 반환 result
    HashMap<String,Object> result = new HashMap<>();
    try {

			    	 Member member = new Member();
			     	 member.setEmail(email);
			       member.setNick(nick);
		       
			       Member resultMember = memberService.retrieveByEmail(email);
			      
			      //닉네임변경
			      if(!resultMember.getNick().equals(nick)){
			      
					     //닉네임 변경
				    	 memberService.change(member);
				    	 session.setAttribute("loginUser", member);
				    	 result.put("nick", member.getNick());
			  	  	 result.put("status", "success");
			  	  	 
			      }else{
			      	 result.put("nick", resultMember.getNick());
			  	  	 result.put("status", "failure");
			      }
    	
    } catch (Exception e) {
      result.put("status", "failure");
    }
    return new Gson().toJson(result);
  }
  

  
  @RequestMapping(value="pwdupdate",
      method=RequestMethod.POST,
      produces="application/json;charset=UTF-8")
  @ResponseBody
  public String pwdupdate(String email, String localpassword, String newPass) throws ServletException, IOException {
    
  	//결과 반환 result
    HashMap<String,Object> result = new HashMap<>();
    try {
			    	 Member member = new Member();
			     	 member.setEmail(email);
			       
			       Member resultMember = memberService.retrieveByEmail(email);
			      			      
			       	//기존 비밀번호 체크 후 진행
			       	if(resultMember.getPassword().equals(localpassword)){
			       	   //비밀번호 변경
			       		 member.setPassword(newPass);
			       		 memberService.pwdChange(member);
			       		 result.put("status", "success");
			       	}else{
			       		result.put("status", "failure");
			       
			        }    
    } catch (Exception e) {
      result.put("status", "failure");
    }
    return new Gson().toJson(result);
  }
  
  @RequestMapping(value="photupdate",
      method=RequestMethod.POST,
      produces="application/json;charset=UTF-8")
  @ResponseBody
  public String photupdate(MultipartHttpServletRequest request, String email) throws ServletException, IOException {
    HashMap<String,Object> result = new HashMap<>();
    System.out.println(email);
    Member member = new Member();
    member.setEmail(email);
    Map<String, MultipartFile> files = request.getFileMap();
    CommonsMultipartFile cmf = (CommonsMultipartFile) files.get("photo");
    System.out.println(cmf.getOriginalFilename());
    
    if (cmf.getSize() == 0) {
      result.put("status", "noChange");
      return new Gson().toJson(result);
    }
    
    int extPoint = cmf.getOriginalFilename().lastIndexOf(".");
    if (extPoint > 0) {
      String filename = System.currentTimeMillis() + "-" + "p" + count()
                         + cmf.getOriginalFilename().substring(extPoint);
      System.out.printf("새파일명=%s\n", filename);
      String realPath = "C:/Users/Administrator/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp4/wtpwebapps/word/upload/" + filename;
      System.out.printf("새 파일을 저장할 실제 경로=%s\n", realPath);
      try {
        cmf.transferTo(new File(realPath));
        member.setPhoto("../upload/" + filename);
        memberService.photChange(member);
        result.put("status", "success");
      } catch (Exception e) {
        result.put("status", "failure");
      }
    }
    return new Gson().toJson(result);
  }
  
  int no = 0;
  synchronized private int count() {
    if (++no == 100) no = 1;
    return no;
  }
  
  @RequestMapping(value="list", produces="application/json;charset=UTF-8")
  @ResponseBody
  public String list(HttpSession session) 
      throws ServletException, IOException {
    Member member = (Member)session.getAttribute("loginUser");
    List<Member> list = memberService.list(member);
    
    HashMap<String,Object> result = new HashMap<>();
    result.put("list", list);
    
    return new Gson().toJson(result);
  }
  
  
}




