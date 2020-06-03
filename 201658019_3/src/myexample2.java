import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/my2")
public class myexample2 extends HttpServlet {
	

	  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        System.out.println("service called");
	        super.service(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parsedVar = request.getParameter("parsedVar");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.println("º¯¼ö°¡ ¿·¿¡ ¶ß¸é  ¼º°ø!" + parsedVar);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
