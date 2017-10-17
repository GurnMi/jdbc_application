package kr.or.dgit.jdbc_application.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import kr.or.dgit.jdbc_application.common.TextFieldComponent;
import kr.or.dgit.jdbc_application.dto.Title;

public abstract class AbstractContent<T> extends JPanel {

	
	public abstract T getContent();
	
	public abstract void setContent(T content);
	
	public abstract void isEmptyCheck() throws Exception;
	
	public abstract void clear();
}
