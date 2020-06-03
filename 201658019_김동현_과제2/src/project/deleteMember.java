package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deleteMember")
public class deleteMember extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request,HttpServletResponse response)  throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      response.setContentType("text/html;charset=utf-8");
      MemberDAO dao=new MemberDAO();
      PrintWriter out=response.getWriter();

		 String _id=request.getParameter("id"); // ȸ������â���� ���۵� ������ ��� �� MemberVO��ü�� ������ �� sql���� �̿��� �����մϴ�. 
		 String _pwd=request.getParameter("pwd");
		 String _name=request.getParameter("name");

		 
		 MemberVO vo=new MemberVO();
		 vo.setId(_id);
	     dao.delMember(_id);
	     
	     List list=dao.listMembers();
	     out.print("<html><body>");
	     out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
	     out.print("<td>���̵�</td><td>��й�ȣ</td><td>�̸�</td></tr>");
	    
	     for (int i=0; i<list.size();i++){
	 		MemberVO memberVO=(MemberVO) list.get(i);
	 		String id=memberVO.getId();
	 		String pwd = memberVO.getPwd();
	 		String name = memberVO.getName();

	 		out.print("<tr><td>"+id+"</td><td>"
	 			                +pwd+"</td><td>"
	 			                +name+"</td><td>"
	 		                    );

	 	 }
	 	 out.print("</table></body></html>");
      }
       

   }

