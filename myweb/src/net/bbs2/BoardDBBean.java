package net.bbs2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import net.utility.DBClose;
import net.utility.DBOpen;

public class BoardDBBean {

  private DBOpen  dbopen  = null;  
  private Connection con = null;
  private PreparedStatement pstmt = null;
  private ResultSet rs = null;
  private StringBuilder sql = null;
  
  public BoardDBBean() {
    dbopen  = new DBOpen();
  }

  //DBCP방식의 오라클 연결--------------------------------------------------
  /*
  private Connection getConnection() throws Exception{
    Context initCtx=new InitialContext();
    DataSource ds  =(DataSource)initCtx.lookup("java:comp/env/jdbc/oracle");
    return ds.getConnection();
  }
  -------------------------------------------------------------------------*/

  //여기에 비지니스 로직 작성
  public void insertArticle(BoardDataBean article) throws Exception{
    
    int num=article.getNum();
    int ref=article.getRef();
    int re_step=article.getRe_step();
    int re_level=article.getRe_level();
    int number=0;
    
    try{
        con=dbopen.getConnection();
        sql=new StringBuilder();
        pstmt=con.prepareStatement("SELECT max(num) FROM board");
        rs=pstmt.executeQuery();
      
        if(rs.next()) {
            number=rs.getInt(1)+1;
        } else {
            number=1;
        }

        //글순서 재조정
        if(num!=0){
            //부모글이 존재하면
            sql.delete(0, sql.length());
            sql.append("UPDATE board SET re_step=re_step+1 WHERE ref=? AND re_step>?");
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setInt(1, ref);
            pstmt.setInt(2, re_step);
            pstmt.executeUpdate();
            re_step=re_step+1;
            re_level=re_level+1;

        } else{

            ref=number;
            re_step=0;
            re_level=0;
        }
        
        sql.delete(0, sql.length());
        sql.append(" INSERT INTO board(num,writer,email,subject,passwd,reg_date,ref,re_step,re_level,content,ip) ");
        sql.append(" VALUES ((select nvl(max(num),0)+1 from board),?,?,?,?,?,?,?,?,?,?) ");
        
        pstmt=con.prepareStatement(sql.toString());
        pstmt.setString(1, article.getWriter());
        pstmt.setString(2, article.getEmail());
        pstmt.setString(3, article.getSubject());
        pstmt.setString(4, article.getPasswd());
        pstmt.setTimestamp(5, article.getReg_date());
        pstmt.setInt(6, ref);
        pstmt.setInt(7, re_step);
        pstmt.setInt(8, re_level);
        pstmt.setString(9, article.getContent());
        pstmt.setString(10, article.getIp());
        pstmt.executeUpdate();          
        
    }catch(Exception e){
        e.printStackTrace();
    }
    
  }//insertArticle() end  

}//class end