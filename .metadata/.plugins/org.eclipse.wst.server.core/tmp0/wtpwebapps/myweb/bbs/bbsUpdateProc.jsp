<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>
<!-- 본문 시작 -->
*수정결과*
<%
// 사용자 요청한 정보 가져오기
 int bbsno= Integer.parseInt(request.getParameter("bbsno")); //부모글정보 가져와야함
//request : 사용자가 요청한 정보를 관리하는 내부객체
//sungjukinsert페이지 사용자가 입력한걸 갖고온거!
//1) 사용자가 입력 요청한 정보를 가져오기
//2) 아래 Update SQL문실행
//3) 수정한 이후 목록 페이지로 이동
 
 String wname=request.getParameter("wname");
 String subject=request.getParameter("subject");
 String content=request.getParameter("content");
 String passwd=request.getParameter("passwd");
 String ip=request.getRemoteAddr();

 dto.setBbsno(bbsno);
 dto.setWname(wname);
 dto.setSubject(subject);
 dto.setContent(content);
 dto.setPasswd(passwd);
 dto.setIp(ip);
 

int res=dao.updateProc(dto,bbsno);   
if(res==0) {
   out.println("<p>수정 실패</p>");
   out.println("<a href='javascript:history.back()'>[다시시도]</a>");
                            //뒤로가기 history.back() 또는 history.go(-1)
}else {
   out.println("<script>");
   out.println("  alert('작성글이 수정 되었습니다');");
   out.println("  location.href='bbsList.jsp?col="+col+"&word="+word+"&nowPage="+nowPage+"';"); //페이지이동★
   out.println("</script>");
}
    
 %>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>