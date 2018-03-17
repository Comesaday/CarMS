package CSFrames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import CSBean.carBean;
import CSBean.illeBean;
import CSMainFrame.carMain;

public class dealIllegal extends JInternalFrame implements ActionListener,ListSelectionListener  {
	
	private static final long serialVersionUID = 1L;
	String[] colName= {"���","ʱ��","���ƺ�","����","��ϵ��ʽ","����","��ʻ��"};
	String[][] colValue=null;
	JPanel upPanel,centerPanel,downPanel,downPanel1,downPanel2;
	JLabel label1,label2,label3,label4,label5;
	JTextField text2,text3,text4,text5;
	JButton button1,button3;
	JTable table;
	JScrollPane jspane;
	ListSelectionModel listmodel=null;
	illeBean bean=new illeBean();
	public dealIllegal() {
		super("����Υ����Ϣ",true,true,true);
		setBounds(140,60,470,375);
		setLayout(new BorderLayout());
		setIconifiable(true);//
		setMaximizable(false); //�����ṩ��󻯰�ť
		setClosable(true);  //�ṩ�رհ�ť
		//setResizable(false);
		
		upPanel=new JPanel();
		upPanel.setPreferredSize(new Dimension(400,35));
		upPanel.setLayout(new FlowLayout());
		label1=new JLabel();
		label1.setText("����Υ����Ϣ");
		upPanel.add(label1);
		add(upPanel,BorderLayout.NORTH);
		
		centerPanel=new JPanel();
		centerPanel.setPreferredSize(new Dimension(400,180));
		colValue=bean.searchAllIG();
		table=new JTable(colValue,colName);
		listmodel=table.getSelectionModel();
		listmodel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listmodel.addListSelectionListener(this);
		table.setPreferredScrollableViewportSize(new Dimension(400,150));
		jspane=new JScrollPane(table);
		centerPanel.add(jspane);
		add(centerPanel);

		downPanel=new JPanel();
		downPanel.setPreferredSize(new Dimension(400,120));
		downPanel1=new JPanel();
		downPanel1.setPreferredSize(new Dimension(400,60));
		GridLayout g1=new GridLayout(0,4);
		g1.setHgap(15);
		g1.setVgap(10);
		downPanel1.setLayout(g1);
		label2=new JLabel();
		label2.setText("��    �ţ�");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		downPanel1.add(label2);
		text2=new JTextField();
		downPanel1.add(text2);
		label3=new JLabel();
		label3.setText("ʱ    �䣺");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		downPanel1.add(label3);
		text3=new JTextField();
		downPanel1.add(text3);
		label4=new JLabel();
		label4.setText("�� �� �ţ�");
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		downPanel1.add(label4);
		text4=new JTextField();
		downPanel1.add(text4);
		label5=new JLabel();
		label5.setText("��ϵ��ʽ��");
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		downPanel1.add(label5);
		text5=new JTextField();
		downPanel1.add(text5);
		downPanel.add(downPanel1);
		
		downPanel2=new JPanel();
		downPanel2.setPreferredSize(new Dimension(400,40));
		downPanel2.setBorder(new LineBorder(SystemColor.RED,1, false));
		FlowLayout f1=new FlowLayout();
		f1.setAlignment(FlowLayout.RIGHT);  
		downPanel2.setLayout(f1);
		
		button1=new JButton();
		button1.setText("ɾ��");
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
		// TODO Auto-generated method stub
		if(e.getSource()==button1) {
			int id=Integer.parseInt(text2.getText());
			bean.dealIll(id);
			this.dispose();
			
			dealIllegal deal=new dealIllegal();
			carMain.desktopPane.add(deal);
		}
		else if(e.getSource()==button3) {
			this.dispose();
		}
	}
	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		int[] selectedRow=table.getSelectedRows();
		int[] selectedCol=table.getSelectedColumns();
		for(int i=0;i<selectedCol.length;i++) {
			for(int j=0;j<selectedRow.length;i++) {
				 text2.setText(colValue[selectedRow[i]][0]);
			     text3.setText(colValue[selectedRow[i]][1]);
			     text4.setText(colValue[selectedRow[i]][2]);
			     text5.setText(colValue[selectedRow[i]][4]);
			}
		}
	}


}
