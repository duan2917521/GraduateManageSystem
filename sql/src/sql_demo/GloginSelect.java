package sql_demo;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


public class GloginSelect extends Frame implements ActionListener{
	Button b1=new Button("ѧ��������Ϣ����");//������½��ť     
	Button b2=new Button("רҵѡ�����");//����ȡ����ť 
	Button b3=new Button("�༶����") ;
	Button b4=new Button("ѧУ����") ;
	Button b5=new Button("��ҵ���¹���");
	Button b6=new Button("���Թ���");
	Button b7=new Button("ȡ��");
	Button b8=new Button("���ص�½ѡ�����");
	
	public GloginSelect(){           
		this.setTitle("����Աѡ�񴰿�");//���ô��ڱ���          
		this.setLayout(null);//���ô��ڲ��ֹ�����        
		
		b1.setBounds(100,50,200,50);//���õ�½��ť�ĳ�ʼλ��         
		this.add(b1);//����½��ť�����ӵ�����   
		
		b2.setBounds(350,50,200,50);//����ȡ����ť�ĳ�ʼλ��          
		this.add(b2);// ��ȡ����ť�����ӵ�����           
		
		b3.setBounds(100, 150, 200, 50);
		this.add(b3);
		
		b4.setBounds(350, 150, 200, 50);
		this.add(b4);
		
		b5.setBounds(100, 250, 200, 50);
		this.add(b5);
		
		b6.setBounds(350, 250, 200, 50);
		this.add(b6);
		
		b7.setBounds(100, 350, 200, 50);
		this.add(b7);
		
		b8.setBounds(350, 350, 200, 50);
		this.add(b8);
		
		
		
		b1.addActionListener(this);//����½��ť��Ӽ�����          
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		this.setLocation(500, 300);
		this.setVisible(true);//���ô��ڵĿɼ���         
		this.setSize(800,600);//���ô��ڵĴ�С          
		addWindowListener(new WindowAdapter(){     
			public void windowClosing(WindowEvent e){                  
				System.exit(0);               
				}              
			});//ͨ���ڲ�����д�رմ���ķ���       
		}
	public void actionPerformed(ActionEvent e) {
		//�����½�¼�new banjiManage();
	if(e.getSource()==b1){
		new MainManage();
	}
	 if(e.getSource()==b2){
		 new ZhuanYeManage();
	}
	 if(e.getSource()==b3){	
		 new banjiManage();
		
	}
	 if(e.getSource()==b4){	
			
		 new xxManage();
		}
	 if(e.getSource()==b5){	
			
		 new timeManage();
		}
	 if(e.getSource()==b6){	
			
		 new liuYanManage();
		}
	 if(e.getSource()==b7){	
		 this.dispose();	
			
		}
	 if(e.getSource()==b8){	
		new Login();
		this.dispose();
			
		}
	
	}
}