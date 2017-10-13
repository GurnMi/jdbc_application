package kr.or.dgit.jdbc_application.list;

import javax.swing.SwingConstants;

import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;

public class ListEmployee extends AbstractList {

	@Override
	protected void setAlighWidth() {
		setCellWidth(100,100,100,150,150,100);
		setAlign(SwingConstants.RIGHT, 4);
		setAlign(SwingConstants.CENTER, 0,1,2,3,5);
	}

	@Override
	protected Object[][] getData() {
		Object[][] datas ={
				{3427,"최종철","과장","이사장",1500000,"마케팅"},
				{3427,"최종철","과장","이사장",1500000,"마케팅"},
				{3427,"최종철","과장","이사장",1500000,"마케팅"}
		};
		
		return datas;
	}

	@Override
	protected String[] getColumnNames() {
		// TODO Auto-generated method stub
		return new String[] {"사원번호","사원명","직책","관리자","급여","부서"};
	}

	@Override
	public Object getSelectedItem() {
		//Title title = new Title();
		int selectedIndex = table.getSelectedRow();
		int empNo = (int) table.getValueAt(selectedIndex, 0);
		String empName = (String) table.getValueAt(selectedIndex, 1);
		String title = (String) table.getValueAt(selectedIndex, 1);
		String manager = (String) table.getValueAt(selectedIndex, 1);
		int salary = (int) table.getValueAt(selectedIndex, 0);
		String dno = (String) table.getValueAt(selectedIndex, 1);
		return new Employee(empNo, empName, title, manager, salary, dno);
	}

}
