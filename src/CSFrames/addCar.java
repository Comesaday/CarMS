package CSFrames;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import CSBean.carBean;
import CSMainFrame.carMain;

public class addCar extends JInternalFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String getstyle=null;
	int getid=0;
	String[] carstyle=null;
	String[] carname=null;
	String[] drive= {"ǰ��ǰ����FF��","ǰ�ú�����FR��","ǰ������","���ú�����MR��","��������","���ú�����RR��","��������"};
	String cstyleitem=null;
	String cnameitem=null;
	String cdriveitem=null;
	carBean bean=new carBean();
	protected JPanel upPanel=new JPanel();
	protected JPanel centerPanel=new JPanel();
	protected JPanel downPanel=new JPanel();
	
	protected JLabel lnum=new JLabel();
	protected JLabel lname=new JLabel();
	protected JLabel lstyle=new JLabel();
	protected JLabel lproduce=new JLabel();
	protected JLabel lcdate=new JLabel();
	protected JLabel lbdate=new JLabel();
	protected JLabel lmnum=new JLabel();
	protected JLabel ldrive=new JLabel();
	protected JLabel lother=new JLabel();
	protected JLabel lowner=new JLabel();
	protected JLabel laddress=new JLabel();
	protected JLabel lphone=new JLabel();
	
	protected JTextField tnum=new JTextField(15);
	protected JTextField tproduce=new JTextField(15);
	protected JTextField tmnum=new JTextField(15);
	protected JTextField tcdate=new JTextField(15);
	protected JTextField tbdate=new JTextField(15);
	protected JTextField towner=new JTextField(15);
	protected JTextField taddress=new JTextField(15);
	protected JTextField tother=new JTextField(15);
	protected JTextField tphone=new JTextField(15);
	protected JTextField regdate=new JTextField(15);
	
	protected JComboBox<String> cname=null;
	@SuppressWarnings("rawtypes")
	protected JComboBox cstyle=null;
	@SuppressWarnings("rawtypes")
	protected JComboBox cdrive=null;
	
	protected JButton bsure=new JButton();
	protected JButton bsel=new JButton();
	protected JButton breset=new JButton();
	protected JButton bexit=new JButton();
	protected JButton bmod=new JButton();
	protected JButton badd=new JButton();
	protected JButton bdel=new JButton();
	
	public addCar() {
		super("��ӳ�����Ϣ",true,true,true);
		setBounds(140,60,460,360);
		setLayout(new BorderLayout());
		setIconifiable(true);//
		setMaximizable(false); //�����ṩ��󻯰�ť
		setClosable(true);  //�ṩ�رհ�ť
		setResizable(false);
		
		JLabel label1=new JLabel();
		label1.setBounds(0,0,0,0);
		label1.setIcon(null); 
		Image image = Toolkit.getDefaultToolkit().getImage("res/login.jpg");
        Icon icon = new ImageIcon(image);
        label1.setIcon(icon);
        upPanel.add(label1);
    	upPanel.setBorder(new EmptyBorder(0,0,0,0));
		upPanel.setPreferredSize(new Dimension(500,80));
		add(upPanel,BorderLayout.NORTH);
		
		GridLayout g1=new GridLayout(0,4);
		g1.setHgap(15);
		g1.setVgap(10);
		centerPanel.setBorder(new EmptyBorder(2, 20, 15, 20));
		centerPanel.setPreferredSize(new Dimension(450,200));
		centerPanel.setLayout(g1);
		
		lnum.setText("��    �ţ�");
		lnum.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(lnum);
		tnum=new JTextField();
		String cid= String.valueOf(bean.selCID()+1);
		tnum.setText(cid);
		tnum.setEnabled(false);
		centerPanel.add(tnum);
		
		lstyle.setText("��    �ͣ�");
		lstyle.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(lstyle);
		carstyle=bean.selectStyle();
		cstyle=new JComboBox<Object>(carstyle);
		cstyle.addActionListener(this);
		centerPanel.add(cstyle);
		
		lname.setText("��    �ƣ�");
		lname.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(lname);
		cname=new JComboBox<String>();
		cname.addActionListener(this);
		centerPanel.add(cname);
		
		lproduce.setText("������ҵ��");
		lproduce.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(lproduce);
		tproduce=new JTextField();
		centerPanel.add(tproduce);
		
		lcdate.setText("�������ڣ�");
		lcdate.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(lcdate);
		tcdate=new JTextField();
		centerPanel.add(tcdate);
		
		lbdate.setText("�������ڣ�");
		lbdate.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(lbdate);
		tbdate=new JTextField();
		centerPanel.add(tbdate);
		
		lmnum.setText("�������ţ�");
		lmnum.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(lmnum);
		tmnum=new JTextField();
		centerPanel.add(tmnum);
		
		ldrive.setText("������ʽ��");
		ldrive.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(ldrive);
		cdrive=new JComboBox<Object>(drive);
		cdrive.addActionListener(this);
		centerPanel.add(cdrive);
		
		lother.setText("��¼ʱ�䣺");
		lother.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(lother);
		regdate.setText((new SimpleDateFormat("yyyy-MM-dd HH:MM:ss")).format(new java.util.Date()));
		regdate.setEnabled(false);
		centerPanel.add(regdate);
		
		lowner.setText("�� �� �ţ�");
		lowner.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(lowner);
		towner=new JTextField();
		centerPanel.add(towner);
		
		laddress.setText("��    ַ��");
		laddress.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(laddress);
		taddress=new JTextField();
		centerPanel.add(taddress);
		
		lphone.setText("��ϵ��ʽ��");
		lphone.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(lphone);
		tphone=new JTextField();
		centerPanel.add(tphone);
		add(centerPanel);
		
		downPanel.setPreferredSize(new Dimension(500,40));
		downPanel.setBorder(new LineBorder(SystemColor.activeCaptionBorder,1, false));
		FlowLayout f1=new FlowLayout();
		f1.setAlignment(FlowLayout.RIGHT);  
		downPanel.setLayout(f1);
		badd.setText("��  ��");
		badd.addActionListener(this);
		downPanel.add(badd);
		
		breset.setText("��  ��");
		breset.addActionListener(this);
		downPanel.add(breset);
		
		bexit.setText("��  ��");
		bexit.addActionListener(this);
		downPanel.add(bexit);
		add(downPanel,BorderLayout.SOUTH);
		
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==cstyle) {
			cname.removeAllItems();
			getstyle=String.valueOf(cstyle.getSelectedItem());
			carname=bean.selectNames(getstyle);
			for(int i=0;i<carname.length;i++) {
				cname.addItem(carname[i]);
			}
		}
		else if(e.getSource()==cname) {
			cnameitem=String.valueOf(cname.getSelectedItem());
		}	
		else if(e.getSource()==cdrive) {
			cdriveitem=String.valueOf(cdrive.getSelectedItem());
		}	
		
		else if(e.getSource()==badd) {
			if(tnum.getText().length()==0){
				JOptionPane.showMessageDialog(null, "������Ų���Ϊ��");
				return;
			}
			else if(tproduce.getText().length()==0){
				JOptionPane.showMessageDialog(null, "������ҵ����Ϊ��");
				return;
			}
			else if(tmnum.getText().length()==0){
				JOptionPane.showMessageDialog(null, "�������Ų���Ϊ��");
				return;
			}
			else if(tcdate.getText().isEmpty()||tbdate.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "ʱ���ʽ��ʹ��\"2007-05-10\"��ʽ");
				return;
			}
			else if(towner.getText().length()==0){
				JOptionPane.showMessageDialog(null, "������Ϣ����Ϊ��");
				return;
			}
			else if(taddress.getText().length()==0){
				JOptionPane.showMessageDialog(null, "������ϵ��ַ����Ϊ��");
				return;
			}
			else if(tphone.getText().length()!=11) {
				JOptionPane.showMessageDialog(null, "�绰�����ʽ����");
				return;
			}
			else {
				int cids = Integer.parseInt(tnum.getText());
				bean.addCarInfo(cids,getstyle,cnameitem,tproduce.getText(),tcdate.getText(),tbdate.getText(),tmnum.getText(),cdriveitem,regdate.getText(),towner.getText(),taddress.getText(),tphone.getText());
				String cid= String.valueOf(bean.selCID()+1);
				tnum.setText(cid);
				setNull();
			}
		}
		
		else if(e.getSource()==bexit) {
			this.dispose();
		}
		else if(e.getSource()==breset) {
			setNull();
		}
		
	}	
	public void setNull() {
		tproduce.setText(null);
		tcdate.setText(null);
		tbdate.setText(null);
		tmnum.setText(null);
		tother.setText(null);
		towner.setText(null);
		taddress.setText(null);
		tphone.setText(null);
	}
}
