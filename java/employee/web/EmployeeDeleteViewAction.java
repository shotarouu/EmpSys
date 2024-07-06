package employee.web;

import employee.common.EmployeeBusinessException;
import employee.common.EmployeeSystemException;
import employee.entity.Employee;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class EmployeeDeleteViewAction implements ActionIF {
	public String execute(HttpServletRequest request) {

		//遷移先のページ設定
		String page = "EmployeeDeleteView.jsp";

		try {
			HttpSession session = request.getSession(false);
			if (session == null) {
				throw new EmployeeBusinessException("セッションが無効です");
			} else {
				Employee loginEmployee = (Employee) session.getAttribute("loginEmployee");
				if (loginEmployee == null) {
					throw new EmployeeSystemException("ログイン情報が存在しません");
				}
			}

		} catch (EmployeeBusinessException e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.setAttribute("errorMessageList", e.getMessageList());
			page = "EmployeeFindView.jsp";
		} catch (EmployeeSystemException e) {
			request.setAttribute("errorMessage", e.getMessage());
			page = "SystemErrorPage.jsp";
		} catch (NumberFormatException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return page;
	}
}
