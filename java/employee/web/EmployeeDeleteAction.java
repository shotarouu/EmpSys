package employee.web;

import employee.common.EmployeeBusinessException;
import employee.common.EmployeeSystemException;
import employee.entity.Employee;
import employee.logic.EmployeeDeleteLogic;
import employee.logic.EmployeeFindLogic;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class EmployeeDeleteAction implements ActionIF {
	public String execute(HttpServletRequest request) {
		//遷移先のページ設定
		String page = "EmployeeDeleteResultView.jsp";

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

			String empId = request.getParameter("empId");

			if (empId == null || empId.equals("")) {
				throw new EmployeeBusinessException("従業員番号が未入力です");
			}

			//業務ロジックの呼び出し
			EmployeeFindLogic logic = new EmployeeFindLogic();
			Employee employee = null;
			try {
				employee = logic.findEmployeeById(Integer.parseInt(empId));
			} catch (NumberFormatException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			if (employee == null) {
				throw new EmployeeBusinessException("従業員情報が存在しません。");
			}

			EmployeeDeleteLogic log = new EmployeeDeleteLogic();
			log.deleteEmployeeById(employee);

			request.setAttribute("employee", employee);

		} catch (EmployeeBusinessException e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.setAttribute("errorMessageList", e.getMessage());
			page = "EmployeeFindView.jsp";

		} catch (EmployeeSystemException e) {
			request.setAttribute("errorMessage", e.getMessage());
			page = "SystemErrorPage.jsp";
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return page;
	}
}
