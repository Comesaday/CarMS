package CSMainFrame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import CSFrames.aboutSystem;
import CSFrames.addCar;
import CSFrames.addIn;
import CSFrames.addOut;
import CSFrames.addUser;
import CSFrames.dealIllegal;
import CSFrames.delCar;
import CSFrames.delUser;
import CSFrames.modCar;
import CSFrames.modUser;
import CSFrames.viewIllegal;

public class carMain extends JFrame implements ActionListener,MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final JDesktopPane desktopPane=new JDesktopPane();

	JLabel bg=new JLabel();
	JMenuBar bar;
	JMenu carmg,personmg,cardmg,illegal,about,exit;
	public static JMenuItem cadd,cdel,cmod;
	public static JMenuItem padd,pdel,pmod;
	public static JMenuItem rin,rout;
	public static JMenuItem iview,ideal;
	
	public carMain() {    	
		
    	setTitle("����ϵͳ");
    	setBounds(200,130,800,600);;
        bar=new JMenuBar();
        
        bg.setBounds(0, 0, 0, 0);
		bg.setIcon(null); // ���屳��
        desktopPane.addComponentListener(new ComponentAdapter() {
			public void componentResized(final ComponentEvent e) {
				Dimension size = e.getComponent().getSize();
				bg.setSize(e.getComponent().getSize());
				bg.setText("<html><img width=" + size.width + " height="
						+ size.height + " src='"
						+ this.getClass().getResource("/backImg.jpg")
						+ "'></html>");
			}
		});
        desktopPane.add(bg,new Integer(Integer.MIN_VALUE));
		add( desktopPane);
        
    	carmg=new JMenu("��������");
    	cadd=new JMenuItem("���ӳ���");
    	cdel=new JMenuItem("ɾ������");
    	cmod=new JMenuItem("�޸ĳ���");
    	carmg.add(cadd);
    	carmg.add(cdel);
    	carmg.addSeparator();
    	carmg.add(cmod);
    	
    	personmg=new JMenu("��ʻԱ����");
    	padd=new JMenuItem("���Ӽ�ʻԱ");
    	pdel=new JMenuItem("ɾ����ʻԱ");
    	pmod=new JMenuItem("�޸ļ�ʻԱ");
    	personmg.add(padd);
    	personmg.add(pdel);
    	personmg.addSeparator();
    	personmg.add(pmod);
    	
    	cardmg=new JMenu("��ʻ��¼");
    	rin=new JMenuItem("��վ����");
    	rout=new JMenuItem("��վ����");
      	cardmg.add(rin);
    	cardmg.add(rout);
  
    	illegal=new JMenu("Υ�¼�¼");
    	iview=new JMenuItem("�鿴Υ��");
    	ideal=new JMenuItem("����Υ��");
    	illegal.add(iview);
    	illegal.add(ideal);
    	
    	about=new JMenu("����ϵͳ");
    	
    	exit=new JMenu("�˳�ϵͳ");
  
    	setJMenuBar(bar);
    	bar.add(carmg);
    	bar.add(personmg);
    	bar.add(cardmg);
       	bar.add(illegal);
    	bar.add(about);
    	bar.add(exit);
    	
    	cadd.addActionListener(this);
    	cdel.addActionListener(this);
    	cmod.addActionListener(this);
    	padd.addActionListener(this);
    	pdel.addActionListener(this);
    	pmod.addActionListener(this);
    	rin.addActionListener(this);
    	rout.addActionListener(this);
    	iview.addActionListener(this);
    	ideal.addActionListener(this);
    	about.addMouseListener(this);
    	exit.addMouseListener(this);
  
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cadd) {
			addCar addcar=new addCar();
			desktopPane.add(addcar);
		}
		else if(e.getSource()==cdel) {
			delCar delcar=new delCar();
			desktopPane.add(delcar);
		}
		else if(e.getSource()==cmod) {
			modCar modcar=new modCar();
			desktopPane.add(modcar);
		}
		else if(e.getSource()==padd) {
			addUser adduser=new addUser();
			desktopPane.add(adduser);
		}
		else if(e.getSource()==pdel) {
			delUser deluser=new delUser();
			desktopPane.add(deluser);
		}
		else if(e.getSource()==pmod) {
			modUser moduser=new modUser();
			desktopPane.add(moduser);
		}
		else if(e.getSource()==rin) {
			addIn addin=new addIn();
			desktopPane.add(addin);
		}
		else if(e.getSource()==rout) {
			addOut addout=new addOut();
			desktopPane.add(addout);
		}
		else if(e.getSource()==iview) {
			viewIllegal viewillegal=new viewIllegal();
			desktopPane.add(viewillegal);
		}
		else if(e.getSource()==ideal) {
			dealIllegal dealillegal=new dealIllegal();
			desktopPane.add(dealillegal);
		}
		
	}
	
	 public void mouseClicked(MouseEvent e) { 
		 
		 if(e.getSource()==about) {
			 aboutSystem about=new aboutSystem();
			 desktopPane.add(about);
		 }
		 if(e.getSource()==exit) {
			 System.exit(0);
		 }
	 }

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
