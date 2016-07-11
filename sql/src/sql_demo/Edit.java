package sql_demo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class Edit extends JFrame implements ActionListener{
	static String username = null;
	JButton confirm = new JButton("确认修改");
	JButton cancel = new JButton("取消");
	JTextField num = new JTextField(10);
	JTextField user = new JTextField(10);
	JPasswordField password = new JPasswordField(10);
	JTextField name = new JTextField(10);
	JTextField telephone = new JTextField(10);
	JTextField email = new JTextField(10);
	JTextField QQ = new JTextField(10);
	JTextField workplace = new JTextField(10);
	JTextField addr = new JTextField(10);
	JTextField place_num = new JTextField(10);
	String a = null;
	String b = null;
	String c = null;
	String d = null;
	String e = null;
	String f = null;
	String g = null;
	String h = null;
	String i = null;
	String j = null;
	String k = null;
	String l = null;
	String m = null;
	
	public Edit(String username){
		this.username = username;
		
		setLayout(new GridLayout(15, 2, 1, 5));
		
		add(new JLabel("   编号:"));
		
		num.setEditable(false);
		add(num);
		add(new JLabel("   用户名:"));
		
		user.setEditable(false);
		add(user);
		add(new JLabel("   密码:"));
		
		add(password);
		add(new JLabel("   姓名:"));
		
		add(name);
		add(new JLabel("   联系电话:"));
		
		add(telephone);
		add(new JLabel("   电子邮件:"));
		
		add(email);
		add(new JLabel("   QQ:"));
		
		add(QQ);
		add(new JLabel("   工作单位:"));
		
		add(workplace);
		add(new JLabel("   通信地址:"));
		
		add(addr);
		add(new JLabel("   邮编:"));
		
		add(place_num);
		
		add(new JLabel("   毕业学校:"));
		JComboBox school = new JComboBox();
	    /*school.addItem("身份证");
	    school.addItem("驾驶证");
	    school.addItem("军官证");*/
		try {
			fun2("学校管理", school);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    this.add(school);
	    
		add(new JLabel("   专业:"));
		JComboBox major = new JComboBox();
		try {
			fun2("专业管理", major);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.add(major);
		
		add(new JLabel("   班级:"));
		JComboBox classroom = new JComboBox();
		try {
			fun2("班级管理", classroom);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.add(classroom);
		
		add(new JLabel("   毕业年月:"));
		JComboBox g_date = new JComboBox();
		try {
			fun2("毕业年月管理", g_date);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.add(g_date);
		
		
		
		confirm.addActionListener(this);
		cancel.addActionListener(this);
		this.add(confirm);
		this.add(cancel);
		
		this.setTitle("信息编辑");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		try {
			fun1();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				a = user.getText();
				b = password.getText();
				c = name.getText();
				d = telephone.getText();
				e = email.getText();
				f = QQ.getText();
				g = workplace.getText();
				h = addr.getText();
				i = place_num.getText();
				j = school.getSelectedItem().toString();
				k = major.getSelectedItem().toString();
				l = classroom.getSelectedItem().toString();
				m = g_date.getSelectedItem().toString();
				try {
					fun3();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
// TODO Auto-generated method stub
				
			}
		});
		
		
	}

    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == confirm)
		{
			new Menu(username);
    		this.dispose();
		}
		if (e.getSource() == cancel)
		{
			new Menu(username);
    		this.dispose();
		}
    }

    public static void main(String[] args){
    	Edit frame = new Edit(username);
    }
    
public void fun1() throws ClassNotFoundException, SQLException{
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		String url = "jdbc:sqlserver://localhost:1433; DatabaseName=SMBN";
		String username = "test1";
		String password = "123";
		
		Connection con = (Connection) DriverManager.getConnection(url, username, password);
		System.out.println(con);
		
		Statement stmt = con.createStatement();
		//Statement stmt1 = con.createStatement();
		System.out.println(this.username);
		String a = this.username;
		ResultSet rs = stmt.executeQuery("select * from 用户信息 where 用户名  ='"+a+"'");
		rs.next();
		System.out.println(rs.getString(1));
		num.setText(rs.getString(1));
		user.setText(rs.getString(2));
		this.password.setText(rs.getString(3));
		name.setText(rs.getString(4));
		telephone.setText(rs.getString(5));
		email.setText(rs.getString(6));
		QQ.setText(rs.getString(7));
		workplace.setText(rs.getString(8));
		addr.setText(rs.getString(9));
		place_num.setText(rs.getString(10));
		
		/*int count = 1;
		while(rs.next()){
			count++;
		}
		String con1 = String.valueOf(count);*/
		//Xlogin x=new Xlogin();
		//System.out.println(a);
		//stmt.executeUpdate("insert into 用户信息  values('"+con1+"','"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+i+"','"+j+"','"+k+"','"+l+"','"+m+"')");
		//System.out.println("successful");
		//System.out.println(t1.getText());
	
		
		/*rs.next();
		String inf_username = rs.getString("密码");
		//System.out.println(inf_username);
		if (inf_username.equals(t2.getText())){
			System.out.println("Successful");
		}*/
	}
    
    
    public void fun2(String name,JComboBox n) throws ClassNotFoundException, SQLException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		String url = "jdbc:sqlserver://localhost:1433; DatabaseName=SMBN";
		String username = "test1";
		String password = "123";
		
		Connection con = (Connection) DriverManager.getConnection(url, username, password);
		//System.out.println(con);
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from "+name);
		while(rs.next()){
			String item = rs.getString(1);
			n.addItem(item);
			//System.out.println(item);
		}
	}
    
public void fun3() throws ClassNotFoundException, SQLException{
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		String url = "jdbc:sqlserver://localhost:1433; DatabaseName=SMBN";
		String username = "test1";
		String password = "123";
		
		Connection con = (Connection) DriverManager.getConnection(url, username, password);
		System.out.println(con);
		
		Statement stmt = con.createStatement();
		Statement stmt1 = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from 用户信息");
		int count = 1;
		while(rs.next()){
			count++;
		}
		
		String con1 = String.valueOf(count);
		//Xlogin x=new Xlogin();
		System.out.println(a);
		System.out.println(this.username);
		stmt.executeUpdate("update 用户信息 set 密码 = '"+b+"',姓名 = '"+c+"',联系电话 = '"+d+"',电子邮件 = '"+e+"',QQ = '"+f+"',工作单位 = '"+g+"',通信地址 = '"+h+"',邮编 = '"+i+"',毕业学校 = '"+j+"',班级 = '"+l+"',专业 = '"+k+"',密码 = '"+m+" where 用户名 ='"+this.username+"'");
		System.out.println("successful");
		//System.out.println(t1.getText());
	
		
		/*rs.next();
		String inf_username = rs.getString("密码");
		//System.out.println(inf_username);
		if (inf_username.equals(t2.getText())){
			System.out.println("Successful");
		}*/
	}
}