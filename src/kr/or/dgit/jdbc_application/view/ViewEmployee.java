package kr.or.dgit.jdbc_application.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListDepartment;
import kr.or.dgit.jdbc_application.list.ListEmployee;
import kr.or.dgit.jdbc_application.list.ListTitle;
import kr.or.dgit.jdbc_application.service.EmployeeService;
import kr.or.dgit.jdbc_application.content.DepartmentContent;
import kr.or.dgit.jdbc_application.content.EmployeeContent;
import kr.or.dgit.jdbc_application.content.TitleContent;

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
	protected JPanel createContent() {
		EmployeeContent pContent = new EmployeeContent(es);
		return pContent;
	}

	@Override
	protected void createService() {
		es = new EmployeeService();
	}

}
