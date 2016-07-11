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
	JButton confirm = new JButton("ȷ���޸�");
	JButton cancel = new JButton("ȡ��");
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
		
		add(new JLabel("   ���:"));
		
		num.setEditable(false);
		add(num);
		add(new JLabel("   �û���:"));
		
		user.setEditable(false);
		add(user);
		add(new JLabel("   ����:"));
		
		add(password);
		add(new JLabel("   ����:"));
		
		add(name);
		add(new JLabel("   ��ϵ�绰:"));
		
		add(telephone);
		add(new JLabel("   �����ʼ�:"));
		
		add(email);
		add(new JLabel("   QQ:"));
		
		add(QQ);
		add(new JLabel("   ������λ:"));
		
		add(workplace);
		add(new JLabel("   ͨ�ŵ�ַ:"));
		
		add(addr);
		add(new JLabel("   �ʱ�:"));
		
		add(place_num);
		
		add(new JLabel("   ��ҵѧУ:"));
		JComboBox school = new JComboBox();
	    /*school.addItem("���֤");
	    school.addItem("��ʻ֤");
	    school.addItem("����֤");*/
		try {
			fun2("ѧУ����", school);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    this.add(school);
	    
		add(new JLabel("   רҵ:"));
		JComboBox major = new JComboBox();
		try {
			fun2("רҵ����", major);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.add(major);
		
		add(new JLabel("   �༶:"));
		JComboBox classroom = new JComboBox();
		try {
			fun2("�༶����", classroom);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.add(classroom);
		
		add(new JLabel("   ��ҵ����:"));
		JComboBox g_date = new JComboBox();
		try {
			fun2("��ҵ���¹���", g_date);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.add(g_date);
		
		
		
		confirm.addActionListener(this);
		cancel.addActionListener(this);
		this.add(confirm);
		this.add(cancel);
		
		this.setTitle("��Ϣ�༭");
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
		ResultSet rs = stmt.executeQuery("select * from �û���Ϣ where �û���  ='"+a+"'");
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
		//stmt.executeUpdate("insert into �û���Ϣ  values('"+con1+"','"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+i+"','"+j+"','"+k+"','"+l+"','"+m+"')");
		//System.out.println("successful");
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
		ResultSet rs = stmt.executeQuery("select * from �û���Ϣ");
		int count = 1;
		while(rs.next()){
			count++;
		}
		
		String con1 = String.valueOf(count);
		//Xlogin x=new Xlogin();
		System.out.println(a);
		System.out.println(this.username);
		stmt.executeUpdate("update �û���Ϣ set ���� = '"+b+"',���� = '"+c+"',��ϵ�绰 = '"+d+"',�����ʼ� = '"+e+"',QQ = '"+f+"',������λ = '"+g+"',ͨ�ŵ�ַ = '"+h+"',�ʱ� = '"+i+"',��ҵѧУ = '"+j+"',�༶ = '"+l+"',רҵ = '"+k+"',���� = '"+m+" where �û��� ='"+this.username+"'");
		System.out.println("successful");
		//System.out.println(t1.getText());
	
		
		/*rs.next();
		String inf_username = rs.getString("����");
		//System.out.println(inf_username);
		if (inf_username.equals(t2.getText())){
			System.out.println("Successful");
		}*/
	}
}