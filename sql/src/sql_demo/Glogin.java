package sql_demo;
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

public class Glogin extends Frame implements ActionListener{
	Label username=new Label("����Ա�˺ţ�");//ʹ���ı�����һ���û�����ǩ     
	TextField t1=new TextField();//����һ���ı������    
	Label password=new Label("����Ա���룺");//����һ�������ǩ   
	JPasswordField t2=new JPasswordField();      
	Button b1=new Button("��½");//������½��ť     
	Button b2=new Button("ȡ��");//����ȡ����ť 
	Button b3=new Button("������һ��") ;
	public Glogin(){           
		this.setTitle("����Ա��½����");//���ô��ڱ���          
		this.setLayout(null);//���ô��ڲ��ֹ�����       
		username.setBounds(50,40,120,40);//����������ǩ�ĳ�ʼλ��          
		this.add(username);// ��������ǩ�����ӵ�����          
		t1.setBounds(250,40,160,40);// �����ı���ĳ�ʼλ��          
		this.add(t1);// ���ı��������ӵ�����  
		
		password.setBounds(50,80,120,40);//�����ǩ�ĳ�ʼλ��          
		this.add(password);//�������ǩ�����ӵ�����           
		t2.setBounds(250,80,160,40);//���������ǩ�ĳ�ʼλ��         
		this.add(t2);//�������ǩ�����ӵ����� 
		
		b1.setBounds(50,150,120,40);//���õ�½��ť�ĳ�ʼλ��         
		this.add(b1);//����½��ť�����ӵ�����    
		
		b2.setBounds(150,150,120,40);//����ȡ����ť�ĳ�ʼλ��          
		this.add(b2);// ��ȡ����ť�����ӵ����� 
		
		b3.setBounds(250, 150, 120, 40);
		this.add(b3);
		
		b1.addActionListener(this);//����½��ť��Ӽ�����          
		b2.addActionListener(this);// ��ȡ����ť��Ӽ�����  
		b3.addActionListener(this);
		this.setLocation(500, 300);
		this.setVisible(true);//���ô��ڵĿɼ���         
		this.setSize(600,400);//���ô��ڵĴ�С          
		addWindowListener(new WindowAdapter(){     
			public void windowClosing(WindowEvent e){                  
				System.exit(0);               
				}              
			});//ͨ���ڲ�����д�رմ���ķ���       
		}
	public void actionPerformed(ActionEvent e) {
			//�����½�¼�
		if(e.getSource()==b1){
			/*String username=t1.getText();
			String password=String.valueOf(t2.getPassword());
			
			if(username.equals("xxk")&&password.equals("xxk")){
				JOptionPane.showMessageDialog(Glogin.this, "��½�ɹ�!���ȷ�ϼ���");
	    		new GloginSelect();//�Ժ��޸ĵ�½��Ľ���  
	    		this.dispose();
	    		}else{
				JOptionPane.showMessageDialog(this, "�˺Ż����������󣬵��ȷ����������");
				t1.setText("");
				t2.setText("");
				}*/
				try {
					fun1();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		else if(e.getSource()==b2){
			System.exit(-1);
		}
		else if(e.getSource()==b3){	
			new Login();
			this.dispose();
			
		}
		
		}
public void fun1() throws ClassNotFoundException, SQLException{
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		String url = "jdbc:sqlserver://localhost:1433; DatabaseName=SMBN";
		String username = "test1";
		String password = "123";
		
		Connection con = (Connection) DriverManager.getConnection(url, username, password);
		System.out.println(con);
		
		Statement stmt = con.createStatement();
		//Xlogin x=new Xlogin();
		ResultSet rs = stmt.executeQuery("select * from ����Ա where �û��� ='"+ t1.getText()+"'");
		//System.out.println(t1.getText());
	
		
		rs.next();
		String inf_username = rs.getString("����");
		//System.out.println(inf_username);
		if (inf_username.equals(t2.getText())){
			System.out.println("Successful");
			JOptionPane.showMessageDialog(Glogin.this, "��½�ɹ�!���ȷ�ϼ���");
    		new GloginSelect();//�Ժ��޸ĵ�½��Ľ���  
    		this.dispose();
		}else {
			JOptionPane.showMessageDialog(this, "�˺Ż����������󣬵��ȷ����������");
			t1.setText("");
			t2.setText("");
		}
}
	
	
	}
	