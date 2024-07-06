package employee.common;

import java.util.ArrayList;

public class EmployeeBusinessException extends Exception{
	private ArrayList<String> messageList = new ArrayList<>();
	
	public ArrayList<String> getMessageList() {
		return messageList;
	}

	public void setMessageList(ArrayList<String> messageList) {
		this.messageList = messageList;
	}

	public EmployeeBusinessException(String message) {
		super(message);
	}
	
	public EmployeeBusinessException(ArrayList<String> messageList) {
		this.messageList = messageList;
	}
	
	
}
