package CSMainFrame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import CSBean.MnaBean;

public class loginFrame extends JFrame implements ActionListener,FocusListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int userrow=0;//��ȡ���ݿ����û���Ϣ
	int managerrow=0;//��ȡ���ݿ��й���Ա��Ϣ
	MnaBean ubean=new MnaBean();
	
	
	JButton bsure,breset;
	JLabel laccount,lpassword;
	public static JTextField taccount;
	JTextField tpassword;
	
	public loginFrame(){  
        super();  
        this.setTitle("���ܵ�¼");  
        this.setBounds(100,80,385,260);       
        //setResizable(false);
        Container p = getContentPane();  
        p.setLayout(null);  
        
        laccount = new JLabel("��    �ţ�");  
        laccount.setBounds(60,75,80,20);  
        p.add(laccount);  
          
        taccount= new JTextField("�˺ŵ�¼"); 
        taccount.setBounds(130,75,150,22);
        taccount.addActionListener(this);
        taccount.addFocusListener(this);
        p.add(taccount);  
          
        lpassword= new JLabel("��    �룺"); 
        lpassword.setBounds(60,120,80,22);  
        p.add(lpassword); 
        
        tpassword= new JPasswordField(8);  
        tpassword.setBounds(130,120,150,22);
        tpassword.setFocusable(true);
        p.add(tpassword); 
              
        breset = new JButton("����"); 
        breset.setBounds(225,180,60,27); 
        breset.addActionListener(this);
        p.add(breset);
        
        bsure = new JButton("��¼");  
        bsure.setBounds(105,180,60,27);  
        bsure.addActionListener(this); 
        p.add(bsure);
           
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setVisible(true);
    }
	
	public void actionPerformed(ActionEvent e) {
	     
	     if(e.getSource()==breset){
	       		taccount.setText(null);
	    	   	tpassword.setText(null);
	     }  
	
	     if(e.getSource()==bsure){
	    	 
	    	if(taccount.getText().length()==0||tpassword.getText().length()==0) {
	    		JOptionPane.showMessageDialog(null,"�˺Ż����벻��Ϊ�գ�","����",JOptionPane.ERROR_MESSAGE);
	    	}
	    	else{
	    		managerrow=ubean.ManagerLogin(taccount.getText(), tpassword.getText());
	    		if(managerrow>0) {
	    			loginFrame.this.setVisible(false);
		    		carMain mframe=new carMain();
		    		mframe.setVisible(true);
	    		}	
	    		else {
	    			JOptionPane.showMessageDialog(null,"�˺Ż��������","����",JOptionPane.ERROR_MESSAGE);
	    			taccount.setText(null);
	    			tpassword.setText(null);
	    		}
	    	 }
	     }  
	}
	 public void focusGained(FocusEvent e){   
		 
		 if(e.getSource()==taccount){
			 taccount.setText(null); 			
	   	}
		 
		 if(e.getSource()==tpassword){
			 tpassword.setText(null); 			
	   	}
		 
	}
	 
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
}
