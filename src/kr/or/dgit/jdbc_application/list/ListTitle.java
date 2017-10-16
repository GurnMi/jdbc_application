package kr.or.dgit.jdbc_application.list;

import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.jdbc_application.dto.Title;
import kr.or.dgit.jdbc_application.service.TitleService;

public class ListTitle extends AbstractList {
	
	private TitleService service;
	

	public ListTitle(TitleService service) {
		this.service = service;
	}

	
	@Override
	protected void setAlighWidth() {
		setAlign(SwingConstants.CENTER, 0,1);
		setCellWidth(100,150);

	}

	@Override
	protected Object[][] getData() {
		List<Title> lists = service.selectTitleByAll();
		Object[][] datas = new Object[lists.size()][];
		for(int i=0; i<lists.size();i++){
			datas[i] = lists.get(i).toArray();
		}
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
		return service.selectTitleBuNo(new Title(titleNo));
	}

}
