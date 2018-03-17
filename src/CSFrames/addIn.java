package CSFrames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import CSBean.illeBean;
import CSBean.ioBean;
import CSMainFrame.carMain;

public class addIn  extends JInternalFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Frame addIn = null;
	ioBean bean=new ioBean();
	String[] colName= {"���","��ʻԱ","��վʱ��","���ƺ�","·��","��ϵ��ʽ"};
	String[][] colValue;
	int style=0;
	JPanel centerPanel,downPanel,downPanel1,downPanel2;
	JLabel label1,label2,label3,label4,label5,label6,label7;
	JTextField text2,text3,text4,text5,text6,text7;
	JButton button1,button2,button3;
	JTable table;
	JScrollPane jspane;
	public addIn() {
		super("��վ��Ϣ����",true,true,true);
		setBounds(140,60,480,390);
		setLayout(new BorderLayout());
		setIconifiable(true);//
		setMaximizable(false); //�����ṩ��󻯰�ť
		setClosable(true);  //�ṩ�رհ�ť
		setResizable(false);
		
		centerPanel=new JPanel();
		centerPanel.setPreferredSize(new Dimension(400,200));
		colValue=bean.searchAllIn();
		table=new JTable(colValue,colName);
		table.setPreferredScrollableViewportSize(new Dimension(400,180));
		jspane=new JScrollPane(table);
		centerPanel.add(jspane);
		add(centerPanel);
		
		downPanel=new JPanel();
		downPanel.setPreferredSize(new Dimension(400,130));
		downPanel1=new JPanel();
		downPanel1.setPreferredSize(new Dimension(400,90));
		GridLayout g1=new GridLayout(0,4);
		g1.setHgap(15);
		g1.setVgap(10);
		downPanel1.setLayout(g1);
		
		label2=new JLabel();
		label2.setText("��    �ţ�");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		downPanel1.add(label2);
		String iid=String.valueOf(bean.selInID()+1);
		text2=new JTextField(iid);
		text2.setEnabled(false);
		downPanel1.add(text2);
		
		label3=new JLabel();
		label3.setText("��ʻԱ��");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		downPanel1.add(label3);
		text3=new JTextField();
		downPanel1.add(text3);
		
		label4=new JLabel();
		label4.setText("��վʱ�䣺");
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		downPanel1.add(label4);
		text4=new JTextField();
		text4.setText((new SimpleDateFormat("yyyy-MM-dd HH:MM:ss")).format(new java.util.Date()));
		text4.setEnabled(false);
		downPanel1.add(text4);
		
		label5=new JLabel();
		label5.setText("���ƺţ�");
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		downPanel1.add(label5);
		text5=new JTextField();
		downPanel1.add(text5);
		downPanel.add(downPanel1);
		
		label6=new JLabel();
		label6.setText("·�ߣ�");
		label6.setHorizontalAlignment(SwingConstants.CENTER);
		downPanel1.add(label6);
		text6=new JTextField();
		downPanel1.add(text6);
		
		label7=new JLabel();
		label7.setText("��ϵ��ʽ��");
		label7.setHorizontalAlignment(SwingConstants.CENTER);
		downPanel1.add(label7);
		text7=new JTextField();
		downPanel1.add(text7);
		
		downPanel2=new JPanel();
		downPanel2.setPreferredSize(new Dimension(400,40));
		downPanel2.setBorder(new LineBorder(SystemColor.RED,1, false));
		FlowLayout f1=new FlowLayout();
		f1.setAlignment(FlowLayout.RIGHT);  
		downPanel2.setLayout(f1);
		button2=new JButton();
		button2.setText("���");
		button2.addActionListener(this);
		downPanel2.add(button2);
		
		button1=new JButton();
		button1.setText("����");
		button1.addActionListener(this);
		downPanel2.add(button1);
		
		button3=new JButton();
		button3.setText("�˳�");
		button3.addActionListener(this);
		downPanel2.add(button3);
		downPanel.add(downPanel2);
		add(downPanel,BorderLayout.SOUTH);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1) {
			FileDialog fd=new FileDialog(addIn,"�����¼",FileDialog.SAVE);
			fd.setLocation(400, 250);
			fd.setVisible(true);
			String filePath = fd.getDirectory()+fd.getFile()+".xls";
			illeBean.exportToExcel(table, filePath);
		}
		else if(e.getSource()==button2) {
			int iid=Integer.parseInt(text2.getText());
			bean.addInRecord(iid,text3.getText(),text4.getText(),text5.getText(),text6.getText(),text7.getText());
			this.dispose();
			
			addIn addin=new addIn();
			carMain.desktopPane.add(addin);
		}
		else if(e.getSource()==button3) {
			this.dispose();
		}
	}
}
