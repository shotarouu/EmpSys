//package employee.web;
//
//import java.io.IOException;
//
//import employee.common.EmployeeBusinessException;
//import employee.common.EmployeeSystemException;
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//@WebServlet(urlPatterns = {"/loginMVC"})
//public class LoginServletMVC extends HttpServlet{
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
//		//転送先の設定
//		String page = "/WEB-INF/jsp/Menu.jsp";
//		 try {
//	            request.setCharacterEncoding("UTF-8");
//	            String empId = request.getParameter("empId");
//	            String password = request.getParameter("password");
//	            
//	            String errorMessage = "";
//	           
//	            if(empId == null || empId.equals("")) {
//	            	errorMessage += "従業員番号が未入力です。<br>";
//	            }
//	            
//	            if(password == null || password.equals("")) {
//	            	errorMessage += "パスワードが未入力です。<br>";
//	            }
//	            
//	            
//	            //エラー確認時は、例外を投げる
//	            if(!errorMessage.equals("")) {
//	            	throw new EmployeeBusinessException(errorMessage);
//	            }
//	            
//	            
//	            //業務ロジックの呼び出し
//	            LoginLogic logic = new LoginLogic();
//	            Employee employee = logic.login(Integer.parseInt(empId),password);
//	            
//	            
//	            //セッションの生成
//	            HttpSession session = request.getSession(true);
//	            
//	            
//	            //ログイン情報の格納
//	            session.setAttribute("logionEmployee",employee);
//	            
//	        } catch (EmployeeBusinessException e) {
//	            request.setAttribute("errorMessage", e.getMessage());
//	            page = "/jsp/Logionpage.jsp";
//	        } catch (EmployeeSystemException e) {
//	            request.setAttribute("errorMessage", e.getMessage());
//	            page = "/jsp/SystemErrorPage.jsp";
//	        }
//	        
//	        // JSPへのフォワード
//	        RequestDispatcher rd = request.getRequestDispatcher(page);
//	        rd.forward(request, response);
//	}
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request, response);
//    }
//}
