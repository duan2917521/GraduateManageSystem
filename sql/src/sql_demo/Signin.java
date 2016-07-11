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

public class Signin extends JFrame implements ActionListener{
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
	public Signin() throws ClassNotFoundException, SQLException{
		setLayout(new GridLayout(14, 2, 1, 5));
		add(new JLabel("   *�û���:"));
		JTextField user = new JTextField(10);
		add(user);
		
		
		add(new JLabel("   *����:"));
		JPasswordField password = new JPasswordField(10);
		add(password);
		
		
		add(new JLabel("   ����:"));
		JTextField name = new JTextField(10);
		add(name);
		
        
		add(new JLabel("   ��ϵ�绰:"));
		JTextField telephone = new JTextField(10);
		add(telephone);
		
		
		add(new JLabel("   �����ʼ�:"));
		JTextField email = new JTextField(10);
		add(email);
		
		
		add(new JLabel("   QQ:"));
		JTextField QQ = new JTextField(10);
		add(QQ);
		
		
		add(new JLabel("   ������λ:"));
		JTextField workplace = new JTextField(10);
		add(workplace);
		g = workplace.getText();
		
		
		add(new JLabel("   ͨ�ŵ�ַ:"));
		JTextField addr = new JTextField(10);
		add(addr);
		
		
		add(new JLabel("   �ʱ�:"));
		JTextField place_num = new JTextField(10);
		add(place_num);
		
		
		add(new JLabel("   *��ҵѧУ:"));
		JComboBox school = new JComboBox();
	    /*school.addItem("���֤");
	    school.addItem("��ʻ֤");
	    school.addItem("����֤");*/
		fun2("ѧУ����", school);
	    this.add(school);
	    
	   
	    
		add(new JLabel("   *רҵ:"));
		JComboBox major = new JComboBox();
		fun2("רҵ����", major);
		this.add(major);
		
		
		add(new JLabel("   *�༶:"));
		JComboBox classroom = new JComboBox();
		fun2("�༶����", classroom);
		this.add(classroom);
		
		
		add(new JLabel("   *��ҵ����:"));
		JComboBox g_date = new JComboBox();
		fun2("��ҵ���¹���", g_date);
		this.add(g_date);
		
		
		Button signin = new Button("ע��");
		Button cancel = new Button("ȡ��");
		
		signin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
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
					fun1();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}// TODO Auto-generated method stub
				
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Xlogin();
				// TODO Auto-generated method stub
				
			}
		});
		cancel.addActionListener(this);
		this.add(signin);
		this.add(cancel);
		
		this.setTitle("SIGNIN");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent event) {
		//�����½�¼�
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Signin frame = new Signin();
	}
	
	/*String a = null;
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
	String m = null;*/
	//String s_1 = "";
	
	public void fun1() throws ClassNotFoundException, SQLException{
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		String url = "jdbc:sqlserver://localhost:1433; DatabaseName=SMBN";
		String username = "test1";
		String password = "123";
		
		Connection con = (Connection) DriverManager.getConnection(url, username, password);
		System.out.println(con);
		
		Statement stmt = con.createStatement();
		Statement stmt1 = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from �û���Ϣ");
		int count = 1;
		while(rs.next()){
			count++;
		}
		String con1 = String.valueOf(count);
		//Xlogin x=new Xlogin();
		System.out.println(a);
		stmt.executeUpdate("insert into �û���Ϣ  values('"+con1+"','"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+i+"','"+j+"','"+k+"','"+l+"','"+m+"')");
		System.out.println("successful");
		//System.out.println(t1.getText());
	
		
		/*rs.next();
		String inf_username = rs.getString("����");
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
		System.out.println(con);
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from "+name);
		while(rs.next()){
			String item = rs.getString(1);
			n.addItem(item);
			System.out.println(item);
		}
	}
	
	
}