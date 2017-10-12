package kr.or.dgit.jdbc_application;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.dgit.jdbc_application.dao.EmployeeDao;
import kr.or.dgit.jdbc_application.dao.TitleDao;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;

public class TestMain2 {

	public static void main(String[] args) {
		Title t = new Title(2);
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
