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

public class People extends JFrame implements ActionListener{
	
	static String username = null;
	JButton back = new JButton("返回主菜单");
	
	//String[] columnNames = {"姓名","学校","班级","专业"};
	//Object[][]data = {{"1","1","1","1"},{"1","1","1","1"}};
	//JTable table = new JTable(data,columnNames);
	JTable JTableView = new JTable();
	DefaultTableModel JTableModel = new DefaultTableModel();
	private void createTableModel(){
		JTableModel.addColumn("姓名");
		JTableModel.addColumn("学校");
		JTableModel.addColumn("班级");
		JTableModel.addColumn("专业");
	}
	
	
	
	
	public People(String username){
		this.username = username;
		
		this.setLayout(null);
		JLabel title = new JLabel("你可能认识的人");
	    title.setFont(new Font(null, Font.PLAIN, 20));
	    title.setSize(200, 30);   
		title.setLocation(20, 10);
		this.add(title);
		
		
		createTableModel();
		JTableView.setModel(JTableModel);
		JTableView.setBounds(20, 40, 400, 310);
		
		try {
			fun2();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.add(JTableView);
		
		back.addActionListener(this);
		back.setSize(110, 30);
		back.setLocation(450, 10);
	    this.add(back);
		
		this.setTitle("你可能认识的人");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void fun2() throws ClassNotFoundException, SQLException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		String url = "jdbc:sqlserver://localhost:1433; DatabaseName=SMBN";
		String username = "test1";
		String password = "123";
		
		Connection con = (Connection) DriverManager.getConnection(url, username, password);
		System.out.println(con);
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from 用户信息 where 毕业学校 = (select 毕业学校 from 用户信息 where 用户名 ='"+this.username+"')");
		
		Vector vcRows = new Vector();
		vcRows.addElement("姓名");
        //System.out.println(rs.getString(4));
        vcRows.addElement("学校");
        vcRows.addElement("班级");
        vcRows.addElement("专业");
        JTableModel.addRow(vcRows);
		while(rs.next()){
			Vector vcRows1 = new Vector();
			vcRows1.addElement(rs.getString(4));
            //System.out.println(rs.getString(4));
            vcRows1.addElement(rs.getString(11));
            vcRows1.addElement(rs.getString(12));
            vcRows1.addElement(rs.getString(13));
            JTableModel.addRow(vcRows1);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		new Menu(username);
		this.dispose();
	}
	
	public static void main(String[] args){
		People frame = new People(username);
	}
}