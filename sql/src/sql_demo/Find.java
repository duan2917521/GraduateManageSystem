package sql_demo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Find extends JFrame implements ActionListener{
	
	static String username = null;
	JButton looking = new JButton("搜索");
	JButton looking2 = new JButton("搜索");
	JButton back = new JButton("返回主菜单");
	JButton add1 = new JButton("添加为好友");
	JButton add2 = new JButton("添加为好友");
	JComboBox school = new JComboBox();
	JCheckBox namecheck = new JCheckBox(" 姓名:");
	JTextField name = new JTextField(10);
	JTable JTableView = new JTable();
	DefaultTableModel JTableModel = new DefaultTableModel();
	private void createTableModel(){
		JTableModel.addColumn("姓名");
		JTableModel.addColumn("学校");
		JTableModel.addColumn("班级");
		JTableModel.addColumn("毕业年月");
	}
	
	JTable JTableView1 = new JTable();
	DefaultTableModel JTableModel1 = new DefaultTableModel();
	private void createTableModel1(){
		JTableModel1.addColumn("姓名");
		JTableModel1.addColumn("学校");
		JTableModel1.addColumn("班级");
		JTableModel1.addColumn("毕业年月");
	}
	
	public Find(String username){
		this.username = username;
		
		this.setLayout(null);
		JLabel title = new JLabel("按条件搜索用户吧");
	    title.setFont(new Font(null, Font.PLAIN, 20));
	    title.setSize(200, 30);   
		title.setLocation(20, 10);
		this.add(title);
		back.addActionListener(this);
		back.setSize(100, 30);
		back.setLocation(300, 10);
	    this.add(back);
	    add1.addActionListener(this);
		add1.setSize(100, 30);
		add1.setLocation(20, 300);
	    this.add(add1);
	    add2.addActionListener(this);
		add2.setSize(100, 30);
		add2.setLocation(300, 300);
	    this.add(add2);
	    
	    createTableModel();
		JTableView.setModel(JTableModel);
		JTableView.setBounds(25, 80, 230, 200);
		
		createTableModel1();
		JTableView1.setModel(JTableModel1);
		JTableView1.setBounds(300, 80, 280, 200);
		
		/*try {
			fun2();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		this.add(JTableView);
		this.add(JTableView1);
		
		JPanel search = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		search.setSize(250, 30);
		search.setLocation(20, 50);
		JPanel search2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		search2.setSize(300, 30);
		search2.setLocation(300, 50);
		search.add(new JLabel("姓名:"));
		search.add(name);
		search2.add(new JLabel("毕业学校:"));
		
		try {
			fun3("学校管理", school);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    this.add(school);
	    /*school.addItem("身份证");
	    school.addItem("驾驶证");
	    school.addItem("军官证");*/
	    search2.add(school);
	    looking.addActionListener(this);
	    search.add(looking);
	    looking2.addActionListener(this);
	    search2.add(looking2);
		this.add(search);
		this.add(search2);
		
		this.setTitle("搜索用户");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back)
		{
			new Menu(username);
    		this.dispose();
		}
		
		if (e.getSource() == looking) {
			try {
				fun2();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if (e.getSource() == looking2) {
			try {
				fun4(school);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		Find frame = new Find(username);
	}
	
	public void fun2() throws ClassNotFoundException, SQLException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		String url = "jdbc:sqlserver://localhost:1433; DatabaseName=SMBN";
		String username = "test1";
		String password = "123";
		
		Connection con = (Connection) DriverManager.getConnection(url, username, password);
		System.out.println(con);
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from 用户信息 where 毕业学校 = (select 毕业学校 from 用户信息 where 姓名 ='"+name.getText()+"')");
		
		Vector vcRows = new Vector();
		vcRows.addElement("姓名");
        //System.out.println(rs.getString(4));
        vcRows.addElement("学校");
        vcRows.addElement("班级");
        vcRows.addElement("毕业年月");
        JTableModel.addRow(vcRows);
		while(rs.next()){
			Vector vcRows1 = new Vector();
			vcRows1.addElement(rs.getString(4));
            //System.out.println(rs.getString(4));
            vcRows1.addElement(rs.getString(11));
            vcRows1.addElement(rs.getString(12));
            vcRows1.addElement(rs.getString(14));
            JTableModel.addRow(vcRows1);
		}
	}
	
	public void fun3(String name,JComboBox n) throws ClassNotFoundException, SQLException{
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
	
	public void fun4(JComboBox n) throws ClassNotFoundException, SQLException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		String url = "jdbc:sqlserver://localhost:1433; DatabaseName=SMBN";
		String username = "test1";
		String password = "123";
		
		Connection con = (Connection) DriverManager.getConnection(url, username, password);
		System.out.println(con);
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from 用户信息 where 毕业学校 ='"+n.getSelectedItem().toString()+"'");
		
		Vector vcRows = new Vector();
		vcRows.addElement("姓名");
        //System.out.println(rs.getString(4));
        vcRows.addElement("学校");
        vcRows.addElement("班级");
        vcRows.addElement("毕业年月");
        JTableModel1.addRow(vcRows);
		while(rs.next()){
			Vector vcRows1 = new Vector();
			vcRows1.addElement(rs.getString(4));
            //System.out.println(rs.getString(4));
            vcRows1.addElement(rs.getString(11));
            vcRows1.addElement(rs.getString(12));
            vcRows1.addElement(rs.getString(14));
            JTableModel1.addRow(vcRows1);
		}
	}
}