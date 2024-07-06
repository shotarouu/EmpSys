package employee.web;

import java.util.ArrayList;

import employee.common.EmployeeBusinessException;
import employee.common.EmployeeSystemException;
import employee.entity.Employee;
import employee.logic.EmployeeFindLogic;
import employee.logic.EmployeeRegistLogic;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class EmployeeRegistAction implements ActionIF {
	public String execute(HttpServletRequest request) {
		String page = "EmployeeRegistResulttView.jsp";
		ArrayList<String> errorList = new ArrayList<>();

		try {
			HttpSession session = request.getSession(false);
			if (session == null) {
				throw new EmployeeBusinessException("セッションが無効です");
			} else {
				Employee loginEmployee = (Employee) session.getAttribute("loginEmployee");
				if (loginEmployee == null) {
					errorList.add("ログイン情報が存在しません");
				}
			}

			String empId = request.getParameter("empId");
			String empName = request.getParameter("empName");
			String departmentId = request.getParameter("departmentId");
			String phone = request.getParameter("phone");

			if (empId == null || empId.equals("")) {
				errorList.add("従業員IDが未入力です");
			}

			if (empName == null || empName.equals("")) {
				errorList.add("従業員名が未入力です");
			}

			if (departmentId == null || departmentId.equals("")) {
				errorList.add("部門番号が未入力です");
			}

			if (phone == null || phone.equals("")) {
				errorList.add("電話番号が未入力です");
			}

			if (errorList.size() != 0 || !(errorList.isEmpty())) {
				throw new EmployeeBusinessException(errorList);
			}

			//業務ロジックの呼び出し
			EmployeeFindLogic logic = new EmployeeFindLogic();
			Employee employee = null;
			
			employee = logic.findEmployeeById(Integer.parseInt(empId));

			if (employee != null) {
				throw new EmployeeBusinessException("従業員情報は既に登録されています");
			}

			employee = new Employee(Integer.parseInt(empId), empName, Integer.parseInt(departmentId), phone);

			//登録用のロジック呼び出し
			EmployeeRegistLogic log = new EmployeeRegistLogic();

			boolean result = log.registEmployee(employee);

			if (result) {
				request.setAttribute("employee", employee);
			}

		} catch (EmployeeBusinessException e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.setAttribute("errorMessageList", e.getMessage());
			page = "EmployeeRegistView.jsp";

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
