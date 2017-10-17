package kr.or.dgit.jdbc_application.content;

import javax.swing.JPanel;
import java.awt.GridLayout;
import kr.or.dgit.jdbc_application.common.TextFieldComponent;
import kr.or.dgit.jdbc_application.dto.Title;

public class TitleContent extends AbstractContent<Title> {

	private TextFieldComponent pTitleno;
	private TextFieldComponent pTitlename;

	/**
	 * Create the panel.
	 */
	public TitleContent() {
		setLayout(new GridLayout(0, 1, 0, 10));
		
		pTitleno = new TextFieldComponent("직책번호");
		add(pTitleno);
		
		pTitlename = new TextFieldComponent("직책");
		add(pTitlename);

	}

	@Override
	public Title getContent(){
		int titleNo = Integer.parseInt(pTitleno.getTextValue());
		String titlename = pTitlename.getTextValue();
		return new Title(titleNo, titlename);
	}
	
	@Override
	public void setContent(Title title){
		pTitleno.setTextValue(title.getTitleNo()+"");
		pTitlename.setTextValue(title.getTitlename());
	}
	
	@Override
	public void isEmptyCheck() throws Exception{
		pTitleno.isEmptyCheck();
		pTitlename.isEmptyCheck();
	}
	
	@Override
	public void clear(){
		pTitleno.setTextValue("");
		pTitlename.setTextValue("");
	}
}
