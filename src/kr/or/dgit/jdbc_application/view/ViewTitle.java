package kr.or.dgit.jdbc_application.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListDepartment;
import kr.or.dgit.jdbc_application.list.ListTitle;
import kr.or.dgit.jdbc_application.service.EmployeeService;
import kr.or.dgit.jdbc_application.service.TitleService;
import kr.or.dgit.jdbc_application.content.AbstractContent;
import kr.or.dgit.jdbc_application.content.DepartmentContent;
import kr.or.dgit.jdbc_application.content.TitleContent;
import kr.or.dgit.jdbc_application.dto.Title;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class ViewTitle extends AbstractView {

	private JPanel contentPane;
	private TitleService service;
	private TitleContent pContent;
	
	
	public ViewTitle(String title){
		super(title);
	}

	@Override
	protected AbstractList createList() {
		ListTitle pList = new ListTitle(service);
		pList.loadData();
		return pList;
	}
	
	@Override
	protected AbstractContent<Title> createContent() {
		pContent = new TitleContent();
		return pContent;
	}
	
	@Override
	protected void createService() {
		service = new TitleService();
	}

	@Override
	protected void btnOkActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
