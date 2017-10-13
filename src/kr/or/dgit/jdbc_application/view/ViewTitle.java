package kr.or.dgit.jdbc_application.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListDepartment;
import kr.or.dgit.jdbc_application.list.ListTitle;
import kr.or.dgit.jdbc_application.content.DepartmentContent;
import kr.or.dgit.jdbc_application.content.TitleContent;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class ViewTitle extends AbstractView {

	private JPanel contentPane;

	public ViewTitle(String title){
		super(title);
	}

	@Override
	protected AbstractList createList() {
		ListTitle pList = new ListTitle();
		return pList;
	}
	
	@Override
	protected JPanel createContent() {
		TitleContent pContent = new TitleContent();
		return pContent;
	}

}