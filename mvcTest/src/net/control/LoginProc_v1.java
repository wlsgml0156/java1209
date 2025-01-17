package net.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginProc_v1 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //method=get방식 요청
    try {
      //1)한글 인코딩
      req.setCharacterEncoding("UTF-8");
      
      //2)사용자가 요청한 정보를 변수에 옮겨담기
      String uid = req.getParameter("uid").trim();
      String upw = req.getParameter("upw").trim();
      
      //3)요청한 사용자에게 응답
      resp.setContentType("text/html; charset=UTF-8");
      PrintWriter out=resp.getWriter();
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<title>welcome.jsp</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("  아이디 : <strong>" + uid + "</strong>");
      out.println("  <hr>");
      out.println("  비번   : <strong>" + upw + "</strong>");      
      out.println("</body>");
      out.println("</html>");
      out.close();//자원반납
      
      
    }catch (Exception e) {
      System.out.println("요청실패:" + e);
    }//try end
    
  }//doGet() end
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //method=post방식 요청
    try {
      //1)한글 인코딩
      req.setCharacterEncoding("UTF-8");
      
      //2)사용자가 요청한 정보를 변수에 옮겨담기
      String uid = req.getParameter("uid").trim();
      String upw = req.getParameter("upw").trim();
      
      //3)요청한 사용자에게 응답
      resp.setContentType("text/html; charset=UTF-8");
      PrintWriter out=resp.getWriter();
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<title>welcome.jsp</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("  아이디 : <strong>" + uid + "</strong>");
      out.println("  <hr>");
      out.println("  비번   : <strong>" + upw + "</strong>");      
      out.println("</body>");
      out.println("</html>");
      out.close();//자원반납
      
      
    }catch (Exception e) {
      System.out.println("요청실패:" + e);
    }//try end
  }//doPost() end
  
}//class end
