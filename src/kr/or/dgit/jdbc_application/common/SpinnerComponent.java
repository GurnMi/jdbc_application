package kr.or.dgit.jdbc_application.common;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class SpinnerComponent extends JPanel {

	
	private JSpinner spinner;

	public SpinnerComponent(String string) {
		setLayout(new GridLayout(1, 0, 10, 0));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNewLabel);
		
		spinner = new JSpinner();
		add(spinner);

	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public void isEmptyCheck() throws Exception {
		if (spinner.getValue().toString().equals("")) {
			spinner.requestFocus();
			throw new Exception("공백 존재");
		}
	}

	public void setSpinValue(int value){
		spinner.setValue(value);
	}
	
	public int getSpinValue(){
		Number n = (Number) spinner.getValue();
		return  n.intValue();
	}
	
	public void setDefaultValue(double value, double minimum, double maximum, double stepSize){
		SpinnerModel model = new SpinnerNumberModel(value, minimum, maximum, stepSize);
		spinner.setModel(model);
	}

	public void setEnable(boolean isEnable) {
		spinner.setEnabled(isEnable);		
	}
	
}
