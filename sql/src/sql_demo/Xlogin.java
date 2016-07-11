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
	 Label username=new Label("账号：");//使用文本创建一个用户名标签     
	TextField t1=new TextField();//创建一个文本框对象    
	 Label password=new Label("密码：");//创建一个密码标签   
	JPasswordField t2=new JPasswordField();      
	Button b1=new Button("登陆");//创建登陆按钮     
	Button b2=new Button("取消");//创建取消按钮 
	Button b3=new Button("返回上一层") ;
	Button b4=new Button("普通用户注册") ;
	public Xlogin(){           
		this.setTitle("管理员登陆窗口");//设置窗口标题          
		this.setLayout(null);//设置窗口布局管理器       
	
		username.setBounds(50,40,60,20);//设置姓名标签的初始位置          
		this.add(username);// 将姓名标签组件添加到容器          
		t1.setBounds(120,40,80,20);// 设置文本框的初始位置          
		this.add(t1);// 将文本框组件添加到容器   
      
		password.setBounds(50,80,60,20);//密码标签的初始位置          
		this.add(password);//将密码标签组件添加到容器           
		t2.setBounds(120,80,80,20);//设置密码标签的初始位置         
		this.add(t2);//将密码标签组件添加到容器    
		
		b1.setBounds(50,150,60,20);//设置登陆按钮的初始位置         
		this.add(b1);//将登陆按钮组件添加到容器   
		
		b2.setBounds(120,150,60,20);//设置取消按钮的初始位置          
		this.add(b2);// 将取消按钮组件添加到容器           
		
		b3.setBounds(50, 200, 60, 20);
		this.add(b3);
		
		b4.setBounds(120, 200, 60, 20);
		this.add(b4);
		
		b1.addActionListener(this);//给登陆按钮添加监听器          
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		this.setLocation(500, 300);
		this.setVisible(true);//设置窗口的可见性         
		this.setSize(600,400);//设置窗口的大小          
		addWindowListener(new WindowAdapter(){     
			public void windowClosing(WindowEvent e){                  
				System.exit(0);               
				}              
			});//通过内部类重写关闭窗体的方法       
		}
	
	//one a = new one();
	public void actionPerformed(ActionEvent e) {
			//处理按钮事件
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
		ResultSet rs = stmt.executeQuery("select * from 用户信息 where 用户名 ='"+ t1.getText()+"'");
		
		rs.next();
		String inf_username = rs.getString("密码");
		if (inf_username.equals(t2.getText())){
			System.out.println("Successful");
			new Menu(t1.getText());
		}
}


}
	