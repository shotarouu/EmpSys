package employee.web;

import jakarta.servlet.http.HttpServletRequest;

public class EmployeeMenuAction implements ActionIF{
	public String execute(HttpServletRequest request) {
		
		String page = "EmployeeMenu.jsp";
		return page;
		
	}
}
