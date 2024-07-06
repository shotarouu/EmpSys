package employee.web;

import java.util.ArrayList;

import employee.common.EmployeeBusinessException;
import employee.common.EmployeeSystemException;
import employee.entity.Employee;
import employee.logic.EmployeeFindAllLogic;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class EmployeeFindAllAction implements ActionIF{
	public String execute(HttpServletRequest request) {
		
		//遷移先のページ設定
		String page = "EmployeeFindAllResultView.jsp";
		
		try {
			HttpSession session = request.getSession(false);
			if(session == null) {
				throw new EmployeeBusinessException("セッションが無効です");
			} else {
				Employee loginEmployee = (Employee)session.getAttribute("loginEmployee");
				if(loginEmployee == null) {
					throw new EmployeeSystemException("ログイン情報が存在しません");
				}
			}
			
			//業務ロジックの呼び出し
			EmployeeFindAllLogic logic = new EmployeeFindAllLogic();
			ArrayList<Employee>empList = new ArrayList<>();
			
			try {
				empList = logic.findAllEmployee();
			} catch (NumberFormatException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			
			request.setAttribute("empList",empList);
			
		} catch(EmployeeBusinessException e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.setAttribute("errorMessageList", e.getMessage());
			page = "EmployeeFindAllResultView.jsp";
			
		} catch(EmployeeSystemException e) {
			request.setAttribute("errorMessage", e.getMessage());
			page = "SystemErrorPage.jsp"; 
		}
		
		return page;
		
	}
}
