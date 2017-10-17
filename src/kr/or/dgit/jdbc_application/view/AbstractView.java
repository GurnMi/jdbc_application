package kr.or.dgit.jdbc_application.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListDepartment;
import kr.or.dgit.jdbc_application.content.AbstractContent;
import kr.or.dgit.jdbc_application.content.DepartmentContent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public abstract class AbstractView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnOk;
	private JButton btnCancel;
	protected AbstractContent<?> pContent;
	protected AbstractList pList;

	public AbstractView(String title) {
		setTitle(title);
		createService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new BorderLayout(0, 0));
		
		pContent = createContent();
		pNorth.add(pContent, BorderLayout.NORTH);
		
		JPanel pbtn = new JPanel();
		pNorth.add(pbtn, BorderLayout.SOUTH);
		
		btnOk = new JButton("추가");
		btnOk.addActionListener(this);
		pbtn.add(btnOk);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pbtn.add(btnCancel);
		
		pList = createList();
		contentPane.add(pList, BorderLayout.CENTER);
	}

	protected abstract void createService();

	protected abstract AbstractList createList();

	protected abstract AbstractContent<?> createContent();
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getSource() == btnOk) {
			btnOkActionPerformed(e);
		}
	}
	
	protected abstract void btnOkActionPerformed(ActionEvent e) ;
	protected void btnCancelActionPerformed(ActionEvent e){
		pContent.clear();
	};
}
