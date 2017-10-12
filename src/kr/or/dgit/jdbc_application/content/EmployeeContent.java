package kr.or.dgit.jdbc_application.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.Vector;

import kr.or.dgit.jdbc_application.common.ComboComponent;
import kr.or.dgit.jdbc_application.common.SpinnerComponent;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.common.TextFieldComponent;

public class EmployeeContent extends JPanel {

	
	/*private ComboBoxComponent pTitle;
	private SpinnerComponent pSalary;
	private TextFieldComponent pEmpNo;
	private TextFieldComponent pEmpName;*/
	
	private TextFieldComponent pEmpNo;
	private TextFieldComponent pEmpName;
	private ComboComponent<Department> pDno;
	private ComboComponent<Employee> pManager;
	private SpinnerComponent pSalary;
	private ComboComponent<Title> pTitle;
	
	public EmployeeContent() {
		setLayout(new GridLayout(0, 1, 0, 10));
		
		pEmpNo = new TextFieldComponent("사원 번호");
		add(pEmpNo);
		
		pEmpName = new TextFieldComponent("사원 이름");
		add(pEmpName);
		
		pDno = new ComboComponent("부서");
		add(pDno);
		
	
		pManager = new ComboComponent("매니저");
		add(pManager);
		
		pSalary = new SpinnerComponent("급여");
		pSalary.setDefaultValue(1500000, 1000000, 5000000, 100000);
		add(pSalary);
		
		pTitle = new ComboComponent("직책");
		add(pTitle);
		
		
		

	}
	
	private void setManagerModel() {
		Vector<Employee> lists = new Vector<>();
		lists.add(new Employee(1, "서현진",new Title(1, "사장"),new Employee(1), 100000, new Department(1)));
		lists.add(new Employee(1));
		lists.add(new Employee(1));
		pManager.setComboBoxModel(lists);				
	}

	private void setTitleMOdel() {
		Vector<Title> lists = new Vector<>();
		lists.add(new Title(1, "사장"));
		lists.add(new Title(2, "부장"));
		lists.add(new Title(3, "사원"));
		pTitle.setComboBoxModel(lists);		
	}

	public void setDepartModel(){
		Vector<Department> lists = new Vector<>();
		lists.add(new Department(1, "개발1", 11));
		lists.add(new Department(2, "개발2", 12));
		lists.add(new Department(3, "개발3", 13));
		pDno.setComboBoxModel(lists);
	}
	public Employee getContent(){
		int empNo = Integer.parseInt(pEmpNo.getTextValue());
		String empName = pEmpName.getTextValue();
		Title title = pTitle.getSelectedItem();
		Employee manager = new Employee(empNo);
		int salary = pSalary.getSpinValue();
		Department dno = pDno.getSelectedItem();
		return new Employee(empNo, empName, title, manager, salary, dno);
	}
	
	public void setContent(Employee employee){
		pEmpNo.setTextValue(employee.getEmpNo()+"");
		pEmpName.setTextValue(employee.getEmpName());
		pDno.setSelectedItem(employee.getDno());
		pManager.setSelectedItem(employee.getManager());
		pSalary.setSpinValue(employee.getSalary());
		pTitle.setSelectedItem(employee.getTitle());
	}
	
	public void isEmptyCheck() throws Exception {
		pEmpNo.isEmptyCheck();
		pEmpName.isEmptyCheck();
		pDno.isEmptyCheck();
		pManager.isEmptyCheck();
		pSalary.isEmptyCheck();
		pTitle.isEmptyCheck();
	}
	
	
	
}
