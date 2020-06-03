

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/my3")
public class myexample3 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Cookie[] allValues = request.getCookies();
		ServletContext ctx = getServletContext();
		HttpSession session = request.getSession();
		String sesOp = (String) session.getAttribute("session");;
		String ctxValue = (String) ctx.getAttribute("context");;
		String reqOp = request.getParameter("operator");
		String reqValue = request.getParameter("value");
		int resultValue = 0;
		if(reqOp.equals("+")) {
			sesOp = "+";
			ctxValue = reqValue;
		 session.setAttribute("session", sesOp);
		 ctx.setAttribute("context", ctxValue);
		 Cookie c= new Cookie("cookie", URLEncoder.encode(sesOp,"utf-8"));
		 response.addCookie(c);
		 response.sendRedirect("/201658019_3/calculator2.html");
		} 
		if (reqOp.equals("-")) {	
			sesOp = "-";
			ctxValue = reqValue;
		 session.setAttribute("session", sesOp);
		 ctx.setAttribute("context", ctxValue);
		 Cookie c= new Cookie("cookie", URLEncoder.encode(sesOp,"utf-8"));
		 response.addCookie(c);
		 response.sendRedirect("/201658019_3/calculator2.html");
		}
		if (reqOp.equals("=")) {
			if(sesOp.equals("+")) {
				
				resultValue = Integer.parseInt(ctxValue)+Integer.parseInt(reqValue);
			}else if(sesOp.equals("-")) {
				resultValue = Integer.parseInt(ctxValue)-Integer.parseInt(reqValue);
	
			}
			for(int i=0; i<allValues.length; i++) {
				if(allValues[i].getName().equals("cookie")) {
					System.out.println("cookie에 저장된 연산자의 종류: " + URLDecoder.decode(allValues[i].getValue(),"utf-8"));
				}
			}
			
			out.println("결과값 :" + resultValue);
			out.print("<a href=\"/201658019_3/calculator2.html\">계산기로 이동 </a>");
		}
		
		 

				
	}

}
