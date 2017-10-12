package kr.or.dgit.jdbc_application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.jdbc.DBCon;

public class EmployeeDao implements SqlDao<Employee> {
	private static final EmployeeDao Instance = new EmployeeDao();
	
	public static EmployeeDao getInstance() {
		return Instance;
	}

	public EmployeeDao() {}
	
	
	

	@Override
	public int insertItem(Employee item) throws SQLException {
		//insert into employee values(3427,	'최종철',	5,	3011,	1500000,	3	);
		String sql  = "insert into employee values(?,?,?,?,?,?)";
		Connection con = DBCon.getInstance().getConnection();
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, item.getEmpNo());
			pstmt.setString(2, item.getEmpName());
			pstmt.setInt(3, item.getTitle().getTitleNo());
			pstmt.setInt(4, item.getManager().getEmpNo());
			pstmt.setInt(5, item.getSalary());
			pstmt.setInt(6, item.getDno().getDeptNo());
			System.out.println(pstmt);
			return pstmt.executeUpdate();
		}
		
		
	}

	@Override
	public void deleteItem(Employee item) throws SQLException {
		//delete from employee where empno =200;
		String sql = "delete from employee where empno =?";
		Connection con = DBCon.getInstance().getConnection();
		
		try (PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, item.getEmpNo());
			pstmt.executeUpdate();
		}	
		
	}

	@Override
	public void updateItem(Employee item) throws SQLException {
		String sql = "update employee set empname = ?, title = ? , manager = ?, salary = ?, dno = ? where empno = ?";
		Connection con = DBCon.getInstance().getConnection();

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, item.getEmpName());
			pstmt.setInt(2, item.getTitle().getTitleNo());
			pstmt.setInt(3, item.getManager().getEmpNo());
			pstmt.setInt(4, item.getSalary());
			pstmt.setInt(5, item.getDno().getDeptNo());
			pstmt.setInt(6, item.getEmpNo());
			pstmt.executeUpdate();
		}
	}

	@Override
	public Employee selectItemByNo(Employee item) throws SQLException {
		Employee emp = null;
		String sql = "select * from employee where empno = ?";
		Connection con = DBCon.getInstance().getConnection();

		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, item.getEmpNo());
			
			try(ResultSet rs = pstmt.executeQuery()){
				if (rs.next()) {
					emp = getEmployee(rs);	
				}
			}
			
		}

		return emp;
	}

	@Override
	public List<Employee> selectItemByAll() throws SQLException {
		// select empno, empname, title, manager, salary, dno from employee;
		List<Employee> lists = new ArrayList<>();
		String sql ="select empno, empname, title, manager, salary, dno from employee";
		
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();){
			while(rs.next()){
				lists.add(getEmployee(rs));		//메소드로 뺌
			}
		}
		return lists;

	}

	private Employee getEmployee(ResultSet rs) throws SQLException {
				
		int empno = rs.getInt(1);
		String empname = rs.getString(2);
		int titleNo = rs.getInt(3);
		
		int managerNo = rs.getInt(4);
		
		int salary = rs.getInt(5);
		int dno = rs.getInt(6);
		
		Employee manager = new Employee();
		
		if(managerNo != 0){
			manager = EmployeeDao.getInstance().selectItemByNo(new Employee(managerNo));
		}	
		Title title = TitleDao.getInstance().selectItemByNo(new Title(titleNo));
		
		Department DeptNo = DepartmentDao.getInstance().selectItemByNo(new Department(dno));
		
		return new Employee(empno, empname, title, manager, salary, DeptNo);

	/*	int empNo = rs.getInt(1);
		String empName = rs.getString(2);
		int titleNo = rs.getInt(3);
		int managerNo = rs.getInt(4);
		int salary = rs.getInt(5);
		int dnoNo = rs.getInt(6);
		
		Employee manager = new Employee();
		Title title = new Title();
		Department dno = new Department();
		
		if(managerNo != 0){
			manager = EmployeeDao.getInstance().selectItemByNo(new Employee(managerNo));
		}	
		//manager = EmployeeDao.getInstance().selectItemByNo(new Employee(managerNo));
		title = TitleDao.getInstance().selectItemByNo(new Title(titleNo));
		dno = DepartmentDao.getInstance().selectItemByNo(new Department(dnoNo));
		
		return new Employee(empNo, empName, title, manager, salary, dno);
		*/
		/*pstmt.setInt(1, item.getEmpNo());
		pstmt.setString(2, item.getEmpName());
		pstmt.setInt(3, item.getTitle().getTitleNo());
		pstmt.setInt(4, item.getManager().getEmpNo());
		pstmt.setInt(5, item.getSalary());
		pstmt.setInt(6, item.getDno().getDeptNo());
		System.out.println(pstmt);*/
	}

	
	
	
	
	
	
	
}
