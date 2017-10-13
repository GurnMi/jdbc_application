package kr.or.dgit.jdbc_application.view;

import java.awt.EventQueue;

public class TestView {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//AbstractView frame = new ViewDepartment("부서관리");
					//AbstractView frame = new ViewTitle("직책관리");
					AbstractView frame = new ViewEmployee("사원관리");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
