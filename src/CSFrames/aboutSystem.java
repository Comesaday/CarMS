package CSFrames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class aboutSystem extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public aboutSystem() {
		super("����ϵͳ",true,true,true);
		setBounds(140,60,470,240);
		setLayout(new BorderLayout());
		setIconifiable(true);//
		setMaximizable(false); //�����ṩ��󻯰�ť
		setClosable(true);  //�ṩ�رհ�ť
		//setResizable(false);
		JPanel panel=new JPanel();
		panel.setPreferredSize(new Dimension(300,150));
		JLabel label2=new JLabel("��ϵͳӦ����С����������վ����CHEN��������Ȩ����@CHEN");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label2);
		add(panel);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
