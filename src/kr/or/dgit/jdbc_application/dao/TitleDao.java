package kr.or.dgit.jdbc_application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.jdbc.DBCon;

public class TitleDao implements SqlDao<Title> {
	private static final TitleDao Instance = new TitleDao();
	
	

	public static TitleDao getInstance() {
		return Instance;
	}


	public TitleDao() {}

	
	@Override
	public int insertItem(Title item) throws SQLException {
		String sql ="INSERT INTO title VALUES(?,?)";
		Connection con = DBCon.getInstance().getConnection();
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, item.getTitleNo());
			pstmt.setString(2, item.getTitlename());
			System.out.println(pstmt);
			return pstmt.executeUpdate();
			
		}
		
	}

	@Override
	public void deleteItem(Title item) throws SQLException {
		String sql ="delete from title where titleno=?";
		Connection con = DBCon.getInstance().getConnection();
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, item.getTitleNo());
			pstmt.executeUpdate();
		}
		
	}

	@Override
	public void updateItem(Title item) throws SQLException {
		String sql = "update title set titlename=? where titleno=?";
		Connection con = DBCon.getInstance().getConnection();
		
		try (PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, item.getTitlename());
			pstmt.setInt(2, item.getTitleNo());
			pstmt.executeUpdate();
		}
	}

	@Override
	public Title selectItemByNo(Title item) throws SQLException {
		String sql = "select titleno, titlename from title where titleno =?";
		Title title = null;
		
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);){
			pstmt.setInt(1, item.getTitleNo());
			
			try(ResultSet rs = pstmt.executeQuery();){
				if(rs.next()){
					title = getTilte(rs);
				}
			}
		}
	
		return title;
	}

	@Override
	public List<Title> selectItemByAll() throws SQLException {
		List<Title> lists = new ArrayList<>();
		
		String sql ="select titleno, titlename from title ";
		
		try(PreparedStatement pstmt = DBCon.getInstance().getConnection().prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();){
			while(rs.next()){
				lists.add(getTilte(rs));		
			}
		}
		return lists;
		
	}


	private Title getTilte(ResultSet rs) throws SQLException {
		int titleNo = rs.getInt(1);
		String titlename = rs.getString(2);
		
		return new Title(titleNo, titlename);
		
				
	}

}
