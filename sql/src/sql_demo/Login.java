package sql_demo;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

//import cn.com.main.MainManage;

public class Login extends Frame implements ActionListener{
	
	Label author=new Label("�汾�ţ�xugougou��jingjing");
	Button b1=new Button("����Ա��½");//������½��ť     
	Button b2=new Button("��ͨ�û���¼");//����ȡ����ť  
	
	public Login(){           
		this.setTitle("ѡ���¼����");//���ô��ڱ���          
		this.setLayout(null);//���ô��ڲ��ֹ�����       
		author.setBounds(150, 300, 200,80);
		this.add(author);
		//stuid.setBounds(50, 125, 110, 20);
		//this.add(stuid);
		b1.setBounds(150,175,120,40);//���õ�½��ť�ĳ�ʼλ��         
		this.add(b1);//����½��ť�����ӵ�����           
		b2.setBounds(350,175,120,40);//����ȡ����ť�ĳ�ʼλ�� 
		
		this.add(b2);// ��ȡ����ť�����ӵ�����           
		b1.addActionListener(this);//����½��ť��Ӽ�����          
		b2.addActionListener(this);// ��ȡ����ť��Ӽ�����  
		this.setLocation(500, 300);
		this.setVisible(true);//���ô��ڵĿɼ���         
		this.setSize(600,400);//���ô��ڵĴ�С          
		addWindowListener(new WindowAdapter(){     
			public void windowClosing(WindowEvent e){                  
				System.exit(0);               
				}              });//ͨ���ڲ�����д�رմ���ķ���       
	}
		


     public void actionPerformed(ActionEvent e) {
    	 if(e.getSource()==b1){
    		 //JOptionPane.showMessageDialog(Login.this, "����Ա��½�ɹ�!���ȷ�ϼ���");
	    		new Glogin();//�Ժ��޸ĵ�½��Ľ���  
	    		this.dispose();
    	 }
    	 if(e.getSource()==b2){
    		 //JOptionPane.showMessageDialog(Login.this, "��ͨ�û���½�ɹ�!���ȷ�ϼ���");
    		 	new Xlogin();
      		 	this.dispose();
    		 
    	 }
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 	 
    	 
 }
     

}
