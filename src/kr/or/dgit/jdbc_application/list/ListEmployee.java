package kr.or.dgit.jdbc_application.list;

import java.sql.SQLException;
import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.jdbc_application.dao.DepartmentDao;
import kr.or.dgit.jdbc_application.dao.EmployeeDao;
import kr.or.dgit.jdbc_application.dao.TitleDao;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.service.EmployeeService;

public class ListEmployee extends AbstractList {
	
	private EmployeeService service;
	
	
	public ListEmployee(EmployeeService service) {
		this.service = service;
	}

	@Override
	protected void setAlighWidth() {
		setCellWidth(100,100,100,150,150,100);
		setAlign(SwingConstants.RIGHT, 4);
		setAlign(SwingConstants.CENTER, 0,1,2,3,5);
	}

	@Override
	protected Object[][] getData() {
		/*Object[][] datas ={
				{3427,"최종철","과장","이사장",1500000,"마케팅"},
				{3427,"최종철","과장","이사장",1500000,"마케팅"},
				{3427,"최종철",10,1,1500000,1}
		};
		*/
		/*List<Employee> lists = service.selectEmployeeByAll();
		Object[][] datas = new Object[lists.size()][];
		for(int i=0; i<lists.size();i++){
			datas[i] = lists.get(i).toArray();
		}
		return datas;*/
		
		List<Employee> lists = service.selectEmployeeByAll();
		Object[][] datas = new Object[lists.size()][];
		
		for(int i=0; i<lists.size();i++){
			Employee emp = lists.get(i);
			datas[i] = emp.toArray();
			datas[i][2] = getTitle(emp.getTitle());
			datas[i][3] = getManager(emp.getManager());
			datas[i][4] = String.format("%,d", datas[i][4]);
			datas[i][2] = getDno(emp.getDno());
		}
		return datas;
	}

	private Object getTitle(Title title) {
		return service.selectTitleByNo(title).getTitlename();
	}

	private Object getManager(Employee manager) {
		Employee emp = service.selectEmployeeByNo(manager);
		if(emp ==null){
			return String.format("%s", "");
		}
		return emp;
	}

	private Object getDno(Department dno) {
		return service.selectDepartmentByNo(dno).getDeptName();
		//return null;
	}

	
	
	@Override
	protected String[] getColumnNames() {
		// TODO Auto-generated method stub
		return new String[] {"사원번호","사원명","직책","관리자","급여","부서"};
	}

	@Override
	public Object getSelectedItem() {
		/*//Title title = new Title();
		int selectedIndex = table.getSelectedRow();
		int empNo = (int) table.getValueAt(selectedIndex, 0);
		String empName = (String) table.getValueAt(selectedIndex, 1);
		int titleNo = (int) table.getValueAt(selectedIndex, 2);
		int managerNo = (int) table.getValueAt(selectedIndex, 3);
		int salary = (int) table.getValueAt(selectedIndex, 4);
		int dno = (int) table.getValueAt(selectedIndex, 5);
		
		Employee manager = new Employee();
		Title title = new Title();
		Department DeptNo = new Department();
		
			try {
				if(managerNo != 0){
				manager = EmployeeDao.getInstance().selectItemByNo(new Employee(managerNo));
				}
				title = TitleDao.getInstance().selectItemByNo(new Title(titleNo));
				
				DeptNo = DepartmentDao.getInstance().selectItemByNo(new Department(dno));
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
		return new Employee(empNo, empName, title, manager, salary, DeptNo);
		//return null;
*/	
		int seletedIndex = table.getSelectedRow();
		int empNo = (int) table.getValueAt(seletedIndex, 0);
		return service.selectEmployeeByNo(new Employee(empNo));	
	}

}
