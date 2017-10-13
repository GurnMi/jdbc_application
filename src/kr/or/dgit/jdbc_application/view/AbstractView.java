package kr.or.dgit.jdbc_application.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListDepartment;
import kr.or.dgit.jdbc_application.content.DepartmentContent;
import javax.swing.JButton;

public abstract class AbstractView extends JFrame {

	private JPanel contentPane;

	public AbstractView(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new BorderLayout(0, 0));
		
		JPanel pContent = createContent();
		pNorth.add(pContent, BorderLayout.NORTH);
		
		JPanel pbtn = new JPanel();
		pNorth.add(pbtn, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("추가");
		pbtn.add(btnOk);
		
		JButton btnCancel = new JButton("취소");
		pbtn.add(btnCancel);
		
		AbstractList pList = createList();
		contentPane.add(pList, BorderLayout.CENTER);
	}

	protected abstract AbstractList createList();

	protected abstract JPanel createContent();
}
