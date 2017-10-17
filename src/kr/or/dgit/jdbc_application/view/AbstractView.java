package kr.or.dgit.jdbc_application.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.jdbc_application.list.AbstractList;
import kr.or.dgit.jdbc_application.list.ListDepartment;
import kr.or.dgit.jdbc_application.content.AbstractContent;
import kr.or.dgit.jdbc_application.content.DepartmentContent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public abstract class AbstractView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnOk;
	private JButton btnCancel;
	protected AbstractContent<?> pContent;
	protected AbstractList pList;

	public AbstractView(String title) {
		setTitle(title);
		createService();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new BorderLayout(0, 0));
		
		pContent = createContent();
		pNorth.add(pContent, BorderLayout.NORTH);
		
		JPanel pbtn = new JPanel();
		pNorth.add(pbtn, BorderLayout.SOUTH);
		
		btnOk = new JButton("추가");
		btnOk.addActionListener(this);
		pbtn.add(btnOk);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pbtn.add(btnCancel);
		
		pList = createList();
		pList.setPopupMenu(ceratePopupMenu());
		contentPane.add(pList, BorderLayout.CENTER);
	}
	
	private JPopupMenu ceratePopupMenu(){
		JPopupMenu pupUpMenu = new JPopupMenu();
		
		JMenuItem delItem = new JMenuItem("삭제");
		JMenuItem updateItem = new JMenuItem("수정");		
		JMenuItem searchItem = new JMenuItem("검색");
		
		delItem.addActionListener(this);
		updateItem.addActionListener(this);
		searchItem.addActionListener(this);
		
		pupUpMenu.add(delItem);
		pupUpMenu.add(updateItem);
		pupUpMenu.add(searchItem);
		
		return pupUpMenu;
	}
	
	protected abstract void createService();

	protected abstract AbstractList createList();

	protected abstract AbstractContent<?> createContent();
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			btnCancelActionPerformed(e);
		}
		if (e.getSource() == btnOk) {
			if(e.getActionCommand().equals("추가")){
				btnOkActionPerformed(e);
			}
			if(e.getActionCommand().equals("수정")){
				//실제 수정
				//1.pContent에서 입력된 내용(DTO)을 가져옴
				
				//2.가져온 content를 pContent에 setcontent();
				
				//3.버튼의 글자를"추가"=>"수정"
			}
			if(e.getActionCommand().equals("확인")){
				//1.pContent내용을 clear
				//2.pContent내용을 setEnable()
				//3.btn "확인" -> "추가"
			}
		}
		if(e.getActionCommand().equals("삭제")){
			//1. 리스트에서 선택된 ITem을 가져와서
			Object item = pList.getSelectedItem();
			//2.service에서 delete호출
			deleteContent(item);
			//3.삭제되고 난 후 목록을 다시 load
			pList.loadData();
		}if(e.getActionCommand().equals("수정")){
			//1.리스트에서 선택된content를 가져와서
			Object content = pContent.getContent();
			//2.가져온 content를 pContent에 setcontent();
			setContent(content);
			//3.버튼의 글자를"추가"=>"수정"
			
			
		}if(e.getActionCommand().equals("검색")){
			//1.다이얼로그 상자를 띄워서 사원번호, 부서번호, 직책번호를 가져와서
			//2.해당하는 번호로 service에서 검색한 content를 가져옴
			//3.검색된 content를 pContent.setContent()
			//4.pContent setEnable(false)
			//4.btn ->"확인"
		}
	}
	



	

	protected void btnOkActionPerformed(ActionEvent e) {
		//0.공백체크
		try {
			pContent.isEmptyCheck();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			return;
		}
		//1.pConent에서 입력된 내용을 가져옴
		Object content = pContent.getContent();
		//JOptionPane.showMessageDialog(null, content);
		
		//2.입력된 DTO를 service를 이용해서 DB에 insert
		insertContent(content);
		
		//3.pList에서 목록을 새로 load
		pList.loadData();
	};
	protected abstract void insertContent(Object content) ;
	

	protected void btnCancelActionPerformed(ActionEvent e){
		pContent.clear();
	};
	
	protected abstract void deleteContent(Object item);
	
	protected abstract void setContent(Object content) ;
}
