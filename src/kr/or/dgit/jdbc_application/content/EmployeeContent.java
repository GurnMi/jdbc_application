package kr.or.dgit.jdbc_application.content;

import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import com.sun.xml.internal.ws.api.ServiceSharedFeatureMarker;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Vector;

import kr.or.dgit.jdbc_application.common.ComboComponent;
import kr.or.dgit.jdbc_application.common.SpinnerComponent;
import kr.or.dgit.jdbc_application.dto.Department;
import kr.or.dgit.jdbc_application.dto.Employee;
import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.service.EmployeeService;
import kr.or.dgit.jdbc_application.common.TextFieldComponent;

@SuppressWarnings("serial")
public class EmployeeContent extends AbstractContent<Employee> implements ActionListener {

	private TextFieldComponent pEmpNo;
	private TextFieldComponent pEmpName;
	private ComboComponent<Department> pDno;
	private ComboComponent<Employee> pManager;
	private SpinnerComponent pSalary;
	private ComboComponent<Title> pTitle;
	private EmployeeService service;
	private Department seldept;
	private Department selD;
	
	public EmployeeContent(EmployeeService service) {
		this.service = service;
		
		setLayout(new GridLayout(0, 1, 0, 10));
		
		pEmpNo = new TextFieldComponent("사원 번호");
		add(pEmpNo);
		
		pEmpName = new TextFieldComponent("사원 이름");
		add(pEmpName);
		
		pDno = new ComboComponent("부서");
		pDno.getCombo().addActionListener(this);
		add(pDno);
		
		
		
	
		pManager = new ComboComponent("매니저");
		add(pManager);
		
		pSalary = new SpinnerComponent("급여");
		pSalary.setDefaultValue(1500000, 1000000, 5000000, 100000);
		add(pSalary);
		
		pTitle = new ComboComponent("직책");
		add(pTitle);
		
		setDepartModel();
		setTitleModel();
		//setManagerModel();
		
	
		
	}
	

	private void setManagerModel(Department selD2) {
		List<Employee> lists = service.selectEmployeeByDno(selD2);
		//System.out.println(lists);
		
		Employee ceo = new Employee(4377);
		if (!lists.contains(ceo)){
			lists.add(service.selectEmployeeByNo(new Employee(4377)));
		}
		
		Vector<Employee> managers = new Vector<>(lists);
		
		pManager.setComboBoxModel(managers);	
		
	}

	
	private void setTitleModel() {
		List<Title> lists = service.selectTitleByAll();
		Vector<Title> titles = new Vector<>(lists);
		pTitle.setComboBoxModel(titles);		
	}

	public void setDepartModel(){
		List<Department> lists = service.selectDepartmentByAll();
		Vector<Department> depts = new Vector<>(lists);
		pDno.setComboBoxModel(depts);
		
		
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
	
	@Override
	public void setContent(Employee employee){
		pEmpNo.setTextValue(employee.getEmpNo()+"");
		pEmpName.setTextValue(employee.getEmpName());
		pDno.setSelectedItem(employee.getDno());
		pManager.setSelectedItem(employee.getManager());
		pSalary.setSpinValue(employee.getSalary());
		pTitle.setSelectedItem(employee.getTitle());
	}
	
	@Override
	public void isEmptyCheck() throws Exception {
		pEmpNo.isEmptyCheck();
		pEmpName.isEmptyCheck();
		pDno.isEmptyCheck();
		pManager.isEmptyCheck();
		pSalary.isEmptyCheck();
		pTitle.isEmptyCheck();
	}

	

	@Override
	public void clear() {
		pEmpNo.setTextValue("");
		pEmpName.setTextValue("");
		pDno.setSelectedIndex(0);
		pManager.setSelectedIndex(0);
		pSalary.setSpinValue(1500000);
		pTitle.setSelectedIndex(0);
		
	}



	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pDno.getCombo()) {
			pDnoComboActionPerformed(e);
		}
	}
	
	protected void pDnoComboActionPerformed(ActionEvent e) {
		selD = pDno.getSelectedItem();
		//System.out.println(selD);
		setManagerModel(selD);
	}
}
