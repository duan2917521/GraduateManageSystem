package sql_demo;
import sql_demo.*;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

//import cn.com.main.MainManage;

public class Xlogin extends Frame implements ActionListener{
	 Label username=new Label("�˺ţ�");//ʹ���ı�����һ���û�����ǩ     
	TextField t1=new TextField();//����һ���ı������    
	 Label password=new Label("���룺");//����һ�������ǩ   
	JPasswordField t2=new JPasswordField();      
	Button b1=new Button("��½");//������½��ť     
	Button b2=new Button("ȡ��");//����ȡ����ť 
	Button b3=new Button("������һ��") ;
	Button b4=new Button("��ͨ�û�ע��") ;
	public Xlogin(){           
		this.setTitle("����Ա��½����");//���ô��ڱ���          
		this.setLayout(null);//���ô��ڲ��ֹ�����       
	
		username.setBounds(50,40,60,20);//����������ǩ�ĳ�ʼλ��          
		this.add(username);// ��������ǩ�����ӵ�����          
		t1.setBounds(120,40,80,20);// �����ı���ĳ�ʼλ��          
		this.add(t1);// ���ı��������ӵ�����   
      
		password.setBounds(50,80,60,20);//�����ǩ�ĳ�ʼλ��          
		this.add(password);//�������ǩ�����ӵ�����           
		t2.setBounds(120,80,80,20);//���������ǩ�ĳ�ʼλ��         
		this.add(t2);//�������ǩ�����ӵ�����    
		
		b1.setBounds(50,150,60,20);//���õ�½��ť�ĳ�ʼλ��         
		this.add(b1);//����½��ť�����ӵ�����   
		
		b2.setBounds(120,150,60,20);//����ȡ����ť�ĳ�ʼλ��          
		this.add(b2);// ��ȡ����ť�����ӵ�����           
		
		b3.setBounds(50, 200, 60, 20);
		this.add(b3);
		
		b4.setBounds(120, 200, 60, 20);
		this.add(b4);
		
		b1.addActionListener(this);//����½��ť��Ӽ�����          
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		this.setLocation(500, 300);
		this.setVisible(true);//���ô��ڵĿɼ���         
		this.setSize(600,400);//���ô��ڵĴ�С          
		addWindowListener(new WindowAdapter(){     
			public void windowClosing(WindowEvent e){                  
				System.exit(0);               
				}              
			});//ͨ���ڲ�����д�رմ���ķ���       
		}
	
	//one a = new one();
	public void actionPerformed(ActionEvent e) {
			//����ť�¼�
		//System.out.println(t1.getText());
		
		if (e.getSource() == b1) {
			try {
			fun1();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}	
		else if(e.getSource() == b4){
			try {
				new Signin();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//this.dispose();
		}
		
		/*try {
			a.fun1();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
	}
	
	
	
public void fun1() throws ClassNotFoundException, SQLException{
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		String url = "jdbc:sqlserver://localhost:1433; DatabaseName=SMBN";
		String username = "test1";
		String password = "123";
		
		Connection con = (Connection) DriverManager.getConnection(url, username, password);
		System.out.println(con);
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from �û���Ϣ where �û��� ='"+ t1.getText()+"'");
		
		rs.next();
		String inf_username = rs.getString("����");
		if (inf_username.equals(t2.getText())){
			System.out.println("Successful");
			new Menu(t1.getText());
		}
}


}
	