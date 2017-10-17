package kr.or.dgit.jdbc_application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_application.view.AbstractView;
import kr.or.dgit.jdbc_application.view.ViewDepartment;
import kr.or.dgit.jdbc_application.view.ViewEmployee;
import kr.or.dgit.jdbc_application.view.ViewTitle;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ErpApplication extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnEmployee;
	private JButton btnDepartment;
	private JButton btnTitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErpApplication frame = new ErpApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ErpApplication() {
		setTitle("회사Erp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnEmployee = new JButton("사원관리");
		btnEmployee.addActionListener(this);
		contentPane.add(btnEmployee);
		
		btnDepartment = new JButton("부서관리");
		btnDepartment.addActionListener(this);
		contentPane.add(btnDepartment);
		
		btnTitle = new JButton("직책관리");
		btnTitle.addActionListener(this);
		contentPane.add(btnTitle);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnTitle) {
			btnTitleActionPerformed(e);
		}
		if (e.getSource() == btnDepartment) {
			btnDepartmentActionPerformed(e);
		}
		if (e.getSource() == btnEmployee) {
			btnEmployeeActionPerformed(e);
		}
	}


	private AbstractView empFr;
	private AbstractView deptFr;
	private AbstractView titleFr;

	protected void btnEmployeeActionPerformed(ActionEvent e) {
		if(empFr == null){
			empFr = new ViewEmployee("사원관리");
		}
		
		empFr.setVisible(true);
	}
	protected void btnDepartmentActionPerformed(ActionEvent e) {
		if(deptFr==null){
			deptFr = new ViewDepartment("부서관리");
		}
		 
		deptFr.setVisible(true);
		
	}
	protected void btnTitleActionPerformed(ActionEvent e) {
		if(titleFr ==null){
			 titleFr = new ViewTitle("직책관리");
		}
		
		titleFr.setVisible(true);
	}
}
