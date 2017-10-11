package kr.or.dgit.jdbc_application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.jdbc.DBCon;

public class DepartmentDao implements SqlDao<Department> {
	private static final DepartmentDao Instance = new DepartmentDao();

	public static DepartmentDao getInstance() {
		return Instance;
	}

	public DepartmentDao() {}

	@Override
	public int insertItem(Department item) throws SQLException{
		
		String sql ="INSERT INTO department VALUES(?,?,?)";
		Connection con = DBCon.getInstance().getConnection();
		
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, item.getDeptNo());
			pstmt.setString(2, item.getDeptName());
			pstmt.setInt(3, item.getFloor());
			//System.out.println(pstmt);
			return pstmt.executeUpdate();
			
		} /*catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());		->TestMain에서 처리
			e.printStackTrace();
		}*/
	}

	@Override
	public void deleteItem(Department item) throws SQLException{
		String sql ="delete from department where deptno=?";		//중복 사용하지만 필드로 빼면 메모리에 남아서 용량 먹음. 안에서만 사용되게 계속 적줌
		Connection con = DBCon.getInstance().getConnection();
		
		//try (PreparedStatement pstmt = con.prepareStatement(sql)로 안하고
		/*try{(PreparedStatement pstmt = con.prepareStatement(sql)}로 처리하면 finally가 필요함*/
		
		try (PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, item.getDeptNo());
			//System.out.println(pstmt);
			pstmt.executeUpdate();
		} /*catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			e.printStackTrace();
		}*/
		
		
	}

	@Override
	public void updateItem(Department item) throws SQLException {
		String sql ="update department set deptname=?, floor=? where deptno=?";	
		Connection con = DBCon.getInstance().getConnection();
		
		try (PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, item.getDeptName());
			pstmt.setInt(2, item.getFloor());
			pstmt.setInt(3, item.getDeptNo());
			pstmt.executeUpdate();
		}
	}

	
	
	
	@Override
	public Department selectItemByNo(Department item) throws SQLException {
		String sql ="select deptno, deptname, floor from department where deptno=?";
		Department dept = null;
		
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);){
			pstmt.setInt(1, item.getDeptNo());
			
			try(ResultSet rs = pstmt.executeQuery();){
				if(rs.next()){
					dept =getDeparment(rs);		//메소드로 뺌
				}
			}			
		}	
		return dept;
	}

	@Override
	public List<Department> selectItemByAll() throws SQLException{
		List<Department> lists = new ArrayList<>();
		String sql ="select deptno, deptname, floor from department";
		
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();){
			while(rs.next()){
				lists.add(getDeparment(rs));		//메소드로 뺌
			}
		}
		return lists;
	}

	private Department getDeparment(ResultSet rs) throws SQLException {
		int deptNo = rs.getInt(1);
		String deptName = rs.getString(2);
		int floor = rs.getInt(3);
		return new Department(deptNo, deptName, floor);
	}

}
