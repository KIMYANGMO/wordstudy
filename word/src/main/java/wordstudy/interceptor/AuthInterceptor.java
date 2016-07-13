package wordstudy.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
  @Override
  public boolean preHandle(
      HttpServletRequest request, 
      HttpServletResponse response,
      Object handler) throws Exception {
    
    HttpSession session = request.getSession();
    if (session.getAttribute("loginUser") == null) {
      PrintWriter writer = response.getWriter();
     /* writer.println("<script type='text/javascript'>");
      writer.println("alert('로그인이 필요합니다.');");
      writer.println("</script>");
      writer.flush();*/
      System.out.println("okok!!");
      response.sendRedirect(request.getContextPath() + "/auth/toMain.do");
      return false;
    }
    
    return true;
  }

}










