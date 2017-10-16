package kr.or.dgit.jdbc_application.service;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.dgit.jdbc_application.dao.SqlDao;
import kr.or.dgit.jdbc_application.dao.TitleDao;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Title;

public class TitleService {
	private SqlDao<Title> titleDao;

	public TitleService() {
		titleDao = TitleDao.getInstance();
	}
	
	public void insertTitle(Title title){
		try {
			titleDao.insertItem(title);
			showMessage("추가완료");
		} catch (SQLException e) {
			e.printStackTrace();
			showMessage(e.getMessage());
		}
	}

	private void showMessage(String string) {
		JOptionPane.showMessageDialog(null, string);
	}
	
	public void deleteTitle(Title title){
		try {
			titleDao.deleteItem(title);
			showMessage("삭제완료");
		} catch (SQLException e) {
			e.printStackTrace();
			showMessage(e.getMessage());
		}
	}
	
	public void updateTitle(Title title){
		try {
			titleDao.updateItem(title);
			showMessage("수정완료");
		} catch (SQLException e) {
			e.printStackTrace();
			showMessage(e.getMessage());
		}
	}
	
	public Title selectTitleBuNo (Title title){
		try {
			return titleDao.selectItemByNo(title);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Title> selectTitleByAll(){
		try {
			return titleDao.selectItemByAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
