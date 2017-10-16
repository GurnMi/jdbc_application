package kr.or.dgit.jdbc_application;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import kr.or.dgit.jdbc_application.common.TextFieldComponent;
import kr.or.dgit.jdbc_application.content.DepartmentContent;
import kr.or.dgit.jdbc_application.content.EmployeeContent;
import kr.or.dgit.jdbc_application.content.TitleContent;
import kr.or.dgit.jdbc_application.dao.DepartmentDao;
import kr.or.dgit.jdbc_application.dao.EmployeeDao;
import kr.or.dgit.jdbc_application.dao.TitleDao;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.jdbc.DBCon;
import kr.or.dgit.jdbc_application.service.EmployeeService;

public class TestMain {

	public static void main(String[] args) {
		/*//testDBCon();		//db연결 & 만들기
		Department dept = new Department(4, "마케팅",10);
		Department dept = new Department(4, "마케팅",10);

		testInsert(dept);
		testListAll();
		
		dept.setDeptName("마케팅2");
		testUpdate(dept);
		testDeptNo(dept);
		
		testDelete(dept);
		testListAll();
		
		//testDeptNo(dept);
		
		Title title = new Title(2, "대리");
		Title t = new Title(3);
		Title t1 = new Title(3, "담당");
		testInsertTitle(title);
		
		testDeleteTitle(title);
		
		testTitleListAll();
		
		//testTitleNo(t);
		testTitleListAll();
		
		testTitleUpdate(t1);
		testTitleListAll();
		
		Employee e1 = new Employee(1004);
		Department d = new Department(3);
		
		Employee emp = new Employee(200, "최종철", t, e1, 1500000, d);
		Employee emp2 = new Employee(3427, "김종철3", t, e1, 1500000, d);
		Employee emp1 = new Employee(200);
		//Employee employee = new Employee(3427,"최종철",5,3011,1500000,3);
		
		
		insertEmp(emp);
		
		DeleteEmp(emp1);
		
		employeeUpdate(emp2);
		
		
		employeeAllList();*/
		

		//testTextFieldComponent();
		
		//testDepartmentContent();
		
		
		//testTitleContent();
		
		testEmployeeContent();
		
		
		
		
	}





	private static void testEmployeeContent() {
		EmployeeContent tfc = new EmployeeContent(new EmployeeService());
		tfc.setContent(new Employee(1, "홍길동", new Title(1), new Employee(2), 1000000, new Department(1)));
		
		JButton btn = new JButton("테스트");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					tfc.isEmptyCheck();
					Employee dept = tfc.getContent();
					StringBuilder sb = new StringBuilder();
					sb.append(dept.getEmpNo());
					sb.append(dept.getEmpName());
					sb.append(dept.getDno());
					sb.append(dept.getTitle());
					sb.append(dept.getSalary());
					sb.append(dept.getManager());
					JOptionPane.showMessageDialog(null, sb);
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		testContnet(tfc, btn);
	}
		
	



	private static void testTitleContent() {
		TitleContent tfc = new TitleContent();	
		
		
		tfc.setContent(new Title(1, "사장"));
		
		JButton btn = new JButton("테스트");	
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					tfc.isEmptyCheck();
					Title title =  tfc.getConten();
					
					JOptionPane.showMessageDialog(null, title);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		
		testContnet(tfc, btn);
	}



	private static void testDepartmentContent() {
		DepartmentContent tfc = new DepartmentContent();	
		
		Department dept = new Department(1, "개발",10);
		tfc.setContent(dept);
		
		JButton btn = new JButton("테스트");	
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					tfc.isEmptyCheck();
					Department dept1 = tfc.getConten();
					
					JOptionPane.showMessageDialog(null, dept1);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		
		testContnet(tfc, btn);
	}



	private static void testTextFieldComponent() {
		TextFieldComponent tfc = new TextFieldComponent("테스트");	
		tfc.setTextValue("재진");
		
		JButton btn = new JButton("테스트");	
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					tfc.isEmptyCheck();
					JOptionPane.showMessageDialog(null, tfc.getTextValue());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		
		testContnet(tfc, btn);
	}



	private static void testContnet(JPanel panel, JButton btn) {
		JFrame jf = new JFrame();
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setBounds(10, 10, 200, 150);
		jf.add(panel);
		jf.add(btn, BorderLayout.SOUTH);
		jf.setVisible(true);
		
	}



	private static void testTitleUpdate(Title t1) {
		try {
			TitleDao.getInstance().updateItem(t1);
			System.out.println(t1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	private static void testTitleNo(Title t) {
		try {
			Title searchT = TitleDao.getInstance().selectItemByNo(t);
			System.out.println(searchT);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	private static void testTitleListAll() {
		try {
			List<Title> lists = TitleDao.getInstance().selectItemByAll();
			for(Title t :lists){
				System.out.println(t);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	private static void testDeleteTitle(Title title) {
		try {
			TitleDao.getInstance().deleteItem(title);
			JOptionPane.showMessageDialog(null, "직책이 삭제 되었습니다");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			JOptionPane.showMessageDialog(null, "직책 번호가 없습니다");
		}
	}

	private static void testInsertTitle(Title title) {
		try {
			TitleDao.getInstance().insertItem(title);
			//TitleDao.getInstance().insertItem(title);
			JOptionPane.showMessageDialog(null, "직책이 추가 되었습니다");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			if(e.getErrorCode()==1062){
				JOptionPane.showMessageDialog(null, "직책번호가 중복");
			}
		}
	}

	private static void testUpdate(Department dept) {
		try {
			DepartmentDao.getInstance().updateItem(dept);
			System.out.println(dept);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void testDeptNo(Department dept) {
		try {
			Department searchDept = DepartmentDao.getInstance().selectItemByNo(dept);
			System.out.println(searchDept);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void testListAll() {
		try {
			List<Department> lists = DepartmentDao.getInstance().selectItemByAll();
			for(Department d :lists){
				System.out.println(d);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void testDelete(Department dept) {
		try {
			DepartmentDao.getInstance().deleteItem(dept);
			JOptionPane.showMessageDialog(null, "부서가 삭제 되었습니다");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			JOptionPane.showMessageDialog(null, "부서번호가 없습니다");
		}
	}

	private static void testInsert(Department dept) {
		try {
			DepartmentDao.getInstance().insertItem(dept);
			JOptionPane.showMessageDialog(null, "부서가 추가 되었습니다");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			if(e.getErrorCode()==1062){
				JOptionPane.showMessageDialog(null, "부서번호가 중복");
			}
		}
	}

	private static void testDBCon() {
		DBCon dbCon =DBCon.getInstance();
		Connection connection = dbCon.getConnection();
		System.out.println(connection);
		
		//jdbcUtill.close(connection);
	}
	
	private static void employeeAllList() {
		try {
			List<Employee> lists = EmployeeDao.getInstance().selectItemByAll();
			for(Employee e2 :lists){
				System.out.println(e2);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void employeeUpdate(Employee emp2) {
		try {
			EmployeeDao.getInstance().updateItem(emp2);
			JOptionPane.showMessageDialog(null, "사원이 수정되었습니다.");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n",e.getErrorCode(),e.getMessage());
			if(e.getErrorCode() == 1062){
				JOptionPane.showMessageDialog(null, "수정 실패");
			}
			e.printStackTrace();
		}
	}

	private static void DeleteEmp(Employee emp1) {
		try {
			EmployeeDao.getInstance().deleteItem(emp1);
			JOptionPane.showMessageDialog(null, "직원이 삭제 되었습니다");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			JOptionPane.showMessageDialog(null, "직원 번호가 없습니다");
		}
	}

	private static void insertEmp(Employee emp) {
		try {
			EmployeeDao.getInstance().insertItem(emp);
			JOptionPane.showMessageDialog(null, "사원이 추가 되었습니다");
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			if(e.getErrorCode()==1062){
				JOptionPane.showMessageDialog(null, "사원번호가 중복");
			}
		}
	}

}
