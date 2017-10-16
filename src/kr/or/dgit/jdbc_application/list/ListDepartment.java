package kr.or.dgit.jdbc_application.list;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.service.DepartmentService;

public class ListDepartment extends AbstractList {
	
	private DepartmentService service;
	
	public ListDepartment(DepartmentService service) {
		super();
		this.service = service;
	}

	protected void setAlighWidth() {
		setCellWidth(100,150,50);
		setAlign(SwingConstants.CENTER, 0 , 2);		//정렬메소드
		setAlign(SwingConstants.RIGHT, 1);
		
	}

	protected Object[][] getData() {
		List<Department> lists = service.selectDepartmentByAll();
		Object[][] datas = new Object[lists.size()][];
		for(int i=0; i<lists.size();i++){
			datas[i] = lists.get(i).toArray();
		}
		return datas;
	}

	protected String[] getColumnNames() {
		return new String[]{"부서번호","부서명","위치"};
	}

	@Override
	public Object getSelectedItem() {
		int selectedIndex = table.getSelectedRow();
		int deptNo = (int) table.getValueAt(selectedIndex, 0);
		
		return service.selectDepartmentByNo(new Department(deptNo));
	}


	

}
