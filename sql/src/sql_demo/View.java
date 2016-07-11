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

public class View extends JFrame implements ActionListener{
	static String username = null;
	JButton write = new JButton("Œ““™¡Ù—‘");
	JButton back = new JButton("∑µªÿ÷˜≤Àµ•");
	//String[] columnNames = {"±‡∫≈"," –’√˚","»’∆⁄","¡Ù—‘ƒ⁄»›"};
	//Object[][]data = {{"1","1","1","1"},{"1","1","1","1"}};
	//JTable table = new JTable(data,columnNames);
	JTable JTableView = new JTable();
	DefaultTableModel JTableModel = new DefaultTableModel();
	private void createTableModel(){
		JTableModel.addColumn("±‡∫≈");
		JTableModel.addColumn("–’√˚");
		JTableModel.addColumn("»’∆⁄");
		JTableModel.addColumn("¡Ù—‘");
	}
	
	public View(String username){
		//JPanel p = new JPanel();
		//p.setLayout(new GridLayout(14, 1, 1, 5));
		this.username = username;
		this.setLayout(null);
		JLabel title = new JLabel("¡Ù—‘∞Â");
	    title.setFont(new Font(null, Font.PLAIN, 20));
	    title.setSize(100, 30);   
		title.setLocation(20, 10);
		this.add(title);
		
		//table.setPreferredScrollableViewportSize(new Dimension(100, 30));
		//table.setLocation(20,20);
		createTableModel();
		JTableView.setModel(JTableModel);
		JTableView.setBounds(20, 40, 340, 310);
		this.add(JTableView);
		try {
			fun2();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//add table to JScrollPane
		
		JTableView.getAutoResizeMode();
		
		write.setSize(190, 60);
        write.setFont(new Font(null, Font.PLAIN , 15));
        write.setLocation(380, 50);

		back.setSize(190, 60);
        back.setFont(new Font(null, Font.PLAIN , 15));
        back.setLocation(380, 130);
        
        write.addActionListener(this);
		back.addActionListener(this);
		this.add(write);
		this.add(back);
		
		this.setTitle("¡Ù—‘∞Â");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == write)
		{
			new Write(username);
    		this.dispose();
		}
		if (e.getSource() == back)
		{
			new Menu(username);
    		this.dispose();
		}
	}
	
	public static void main(String[] args){
		View frame = new View(username);
	}
	
	public void fun2() throws ClassNotFoundException, SQLException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		String url = "jdbc:sqlserver://localhost:1433; DatabaseName=SMBN";
		String username = "test1";
		String password = "123";
		
		Connection con = (Connection) DriverManager.getConnection(url, username, password);
		System.out.println(con);
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from ¡Ù—‘");
		while(rs.next()){
			Vector vcRows = new Vector();
            vcRows.addElement(rs.getString(1));
            //System.out.println(rs.getString(4));
            vcRows.addElement(rs.getString(3));
            vcRows.addElement(rs.getString(4));
            vcRows.addElement(rs.getString(7));
            JTableModel.addRow(vcRows);
		}
	}
}