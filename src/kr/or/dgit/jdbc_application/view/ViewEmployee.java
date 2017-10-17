package kr.or.dgit.jdbc_application.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListDepartment;
import kr.or.dgit.jdbc_application.list.ListEmployee;
import kr.or.dgit.jdbc_application.list.ListTitle;
import kr.or.dgit.jdbc_application.service.EmployeeService;
import kr.or.dgit.jdbc_application.content.AbstractContent;
import kr.or.dgit.jdbc_application.content.DepartmentContent;
import kr.or.dgit.jdbc_application.content.EmployeeContent;
import kr.or.dgit.jdbc_application.content.TitleContent;
import kr.or.dgit.jdbc_application.dto.Employee;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class ViewEmployee extends AbstractView {

	//private JPanel contentPane;
	private EmployeeService es;

	public ViewEmployee(String title){
		super(title);
	}

	@Override
	protected AbstractList createList() {	
		ListEmployee pList = new ListEmployee(es);
		pList.loadData();
		return pList;
	}
	
	@Override
	protected AbstractContent<Employee> createContent() {
		pContent = new EmployeeContent(es);
		return (AbstractContent<Employee>) pContent;
	}

	@Override
	protected void createService() {
		es = new EmployeeService();
	}

	@Override
	protected void btnOkActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
