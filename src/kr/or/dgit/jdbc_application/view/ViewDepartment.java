package kr.or.dgit.jdbc_application.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListDepartment;
import kr.or.dgit.jdbc_application.service.DepartmentService;
import kr.or.dgit.jdbc_application.content.AbstractContent;
import kr.or.dgit.jdbc_application.content.DepartmentContent;
import kr.or.dgit.jdbc_application.dto.Department;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class ViewDepartment extends AbstractView {
	private DepartmentService service;
	//private JPanel contentPane;
	//private DepartmentContent pContent;

	public ViewDepartment(String title){
		super(title);
	}

	@Override
	protected AbstractList createList() {
		pList = new ListDepartment(service);
		pList.loadData();
		return pList;
	}
	
	@Override
	protected AbstractContent<Department> createContent() {
		pContent = new DepartmentContent();
		return (AbstractContent<Department>) pContent;
	}

	@Override
	protected void createService() {
		service = new DepartmentService();
		
	}

	@Override
	protected void btnOkActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	

}
