<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>
<!-- 본문 시작 -->
*비밀번호 입력*
<form method="post"
      action="bbsUpdateForm.jsp"
      onsubmit="return pwCheck(this)">
 <input type="hidden" name="bbsno" value="<%=request.getParameter("bbsno") %>">
 <input type="hidden" name="col" value="<%=col %>">
 <input type="hidden" name="word" value="<%=word %>">
 <input type="hidden" name="nowPage"  value="<%=nowPage%>">
 <table border="1"  id='customers' width='20%'>
 <tr>
       <td>비밀번호</td> 
       <td><input type='password' name='passwd'></td>
 </tr>
 <tr>
       <td colspan='2'>
           <input type='submit' value='확인'>
       </td>    
 </tr>
 </table>
</form>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>