package kr.or.dgit.jdbc_application.list;

import javax.swing.SwingConstants;

import kr.or.dgit.jdbc_application.dto.Title;

public class ListTitle extends AbstractList {
	
	
	@Override
	protected void setAlighWidth() {
		setAlign(SwingConstants.CENTER, 0,1);
		setCellWidth(100,150);

	}

	@Override
	protected Object[][] getData() {
		Object[][] datas ={
				{1, "사장"},
				{2, "부장"},
				{3, "사원"}
		};
		
		return datas;
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] {"직책번호","직책명"};
	}

	@Override
	public Object getSelectedItem() {
		int selectedIndex = table.getSelectedRow();		
		int titleNo =(int) table.getValueAt(selectedIndex, 0);
		String titlename = (String) table.getValueAt(selectedIndex, 1);
		return new Title(titleNo, titlename);
	}

}
