package employee.web;

import java.util.ArrayList;

import employee.common.EmployeeBusinessException;
import employee.common.EmployeeSystemException;
import employee.entity.Employee;
import employee.logic.LoginLogic;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginAction implements ActionIF {
	public String execute(HttpServletRequest request) {

		//遷移先ページの設定
		String page = "EmployeeMenu.jsp";
		//エラーメッセージリストの作成
		ArrayList<String> errorMessageList = new ArrayList<>();

		try {
			String empId = request.getParameter("empId");
			String password = request.getParameter("password");

			if (empId == null || empId.equals("")) {
				errorMessageList.add("従業員番号が未入力です。");
			}

			if (password == null || password.equals("")) {
				errorMessageList.add("パスワードが未入力です。");
			}

			if (!errorMessageList.isEmpty()) {
				throw new EmployeeBusinessException(errorMessageList);
			}

			//業務ロジックの呼び出し
			LoginLogic logic = new LoginLogic();
			Employee employee = null;
			try {
				employee = logic.login(Integer.parseInt(empId), password);
				if (employee == null) {
					errorMessageList.add("従業員番号またはパスワードが間違っています。");
				}
			} catch (NumberFormatException e) {
				// TODO 自動生成された catch ブロック
				errorMessageList.add("従業員番号またはパスワードが間違っています。");
			} catch (ClassNotFoundException e) {
				// TODO 自動生成された catch ブ	ロック
				errorMessageList.add("従業員番号またはパスワードが間違っています。");
			}
			//セッションの生成
			HttpSession session = request.getSession(true);

			session.setAttribute("loginEmployee", employee);

		} catch (EmployeeBusinessException e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.setAttribute("errorMessageList", errorMessageList);
			page = "LoginPage.jsp";
		} catch (EmployeeSystemException e) {
			request.setAttribute("errorMessage", e.getMessage());
			page = "SystemErrorPage.jsp";
		}

		return page;

	}
}
