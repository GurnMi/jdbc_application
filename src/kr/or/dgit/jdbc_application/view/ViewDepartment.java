package kr.or.dgit.jdbc_application.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListDepartment;
import kr.or.dgit.jdbc_application.service.DepartmentService;
import kr.or.dgit.jdbc_application.content.DepartmentContent;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class ViewDepartment extends AbstractView {
	private DepartmentService service;
	//private JPanel contentPane;

	public ViewDepartment(String title){
		super(title);
	}

	@Override
	protected AbstractList createList() {
		ListDepartment pList = new ListDepartment(service);
		pList.loadData();
		return pList;
	}
	
	@Override
	protected JPanel createContent() {
		DepartmentContent pContent = new DepartmentContent();
		return pContent;
	}

	@Override
	protected void createService() {
		service = new DepartmentService();
		
	}

}
