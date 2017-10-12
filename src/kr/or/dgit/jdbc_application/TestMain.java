package kr.or.dgit.jdbc_application;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.dgit.jdbc_application.dao.DepartmentDao;
import kr.or.dgit.jdbc_application.dao.EmployeeDao;
import kr.or.dgit.jdbc_application.dao.TitleDao;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.jdbc.DBCon;

public class TestMain {

	public static void main(String[] args) {
		//testDBCon();		//db연결 & 만들기
		Department dept = new Department(4, "마케팅",10);
		/*Department dept = new Department(4, "마케팅",10);

		testInsert(dept);
		testListAll();
		
		dept.setDeptName("마케팅2");
		testUpdate(dept);
		testDeptNo(dept);
		
		testDelete(dept);
		testListAll();*/
		
		//testDeptNo(dept);
		
		Title title = new Title(2, "대리");
		Title t = new Title(3);
		Title t1 = new Title(3, "담당");
		/*testInsertTitle(title);
		
		testDeleteTitle(title);
		
		testTitleListAll();*/
		
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
		
		
		/*insertEmp(emp);
		
		DeleteEmp(emp1);*/
		
		employeeUpdate(emp2);
		
		
		employeeAllList();
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
