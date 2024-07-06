package employee.web;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/employeeFC"})
public class FrontController extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
		String path = "/WEB-INF/jsp/";
		String page = null;
		ActionIF action = null;
		
		
		request.setCharacterEncoding("UTF-8");
		String buttonId = request.getParameter("buttonId");
		
		if(buttonId == null || buttonId.equals("")) {
			buttonId = "e000"; 
		}
		
		//リクエスト種別の判定
		switch(buttonId) {
			case "e000":
				page = "LoginPage.jsp";
				break;
			
			case "e001":
				action = new LoginAction();
				page = action.execute(request);
				break;
			
			case "e002":
				action = new EmployeeMenuAction();
				page = action.execute(request);
				break;
			
			case "e100":
				action = new EmployeeFindViewAction();
				page =action.execute(request);
				break;
				
				
			case "e101":
				action = new EmployeeFindAction();
				page =action.execute(request);
				break;
				
			case "e102":
				action = new EmployeeRegistFindAction();
				page =action.execute(request);
				break;
				
			case "e200":
				page ="EmployeeRegistView.jsp";
				break;
			
				
			case "e201":
				action = new EmployeeRegistAction();
				page =action.execute(request);
				break;
			
			case "e300":
				page = "EmployeeUpdateView.jsp";
				break;
				
			case "e301":
				action = new EmployeeUpdateAction();
				page = action.execute(request);;
				break;	
		
			case "e400":
				action = new EmployeeDeleteViewAction();
				page =action.execute(request);
				break;
			
			case "e401":
				action = new EmployeeDeleteAction();
				page =action.execute(request);
				break;
				
			case "e500":
				action = new EmployeeFindAllAction();
				page =action.execute(request);
				break;	
				
			default:
				page = "LoginPage.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(path + page);
		rd.forward(request, response);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
    }
}
