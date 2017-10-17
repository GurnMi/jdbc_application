package kr.or.dgit.jdbc_application.dto;

public class Employee {
	private int empNo;
	private String empName;
	private Title title;
	private Employee manager;
	private int salary;
	private Department dno;
	

	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Employee(int empNo) {
		this.empNo = empNo;
	}






	public Employee(int empNo, String empName, Title title, Employee manager, int salary, Department dno) {
		this.empNo = empNo;
		this.empName = empName;
		this.title = title;
		this.manager = manager;
		this.salary = salary;
		this.dno = dno;
	}

	/*public Employee(int empNo2, String empName2, int title2, int manager2, int salary2, int dno2) {
		// TODO Auto-generated constructor stub
		
		this.empNo = empNo2;
		this.empName = empName2;
		this.title = title;
		this.manager1 = manager2;
		this.salary = salary2;
		this.dno1= dno2;
	}*/




	public int getTitle1() {
		return title.getTitleNo();
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Title getTitle() {
		return title;
	}
	
	

	public void setTitle(Title title) {
		this.title = title;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Department getDno() {
		return dno;
	}

	public void setDno(Department dno) {
		this.dno = dno;
	}

	
	/*public String toString() {
		return String.format("%s %s %s %s %s %s",
				empNo, empName,	title.getTitlename(), manager.getEmpName(), salary, dno.getDeptName());
	}*/
	
	/*public String toString() {
		return String.format("%s %s %s %s %s %s",
				empNo, empName,	title.getTitlename(), manager.getEmpName(), salary, dno.getDeptName());
	}*/

	/*public Object[] ToArray(){
		return new Object[]{empNo, empName,	title, manager, salary, dno};
	}*/

	@Override
	public String toString() {
		return String.format("%s(%s)", empName, empNo);
	}

	public Object[] toArray() {
		// TODO Auto-generated method stub
	return new Object[]{empNo, empName,	title.getTitlename(), manager.getEmpName(), salary, dno.getDeptName()};
	}




	
}
