package sql_demo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;

import javax.swing.*;

import com.sun.xml.internal.fastinfoset.algorithm.BuiltInEncodingAlgorithm.WordListener;

public class Write extends JFrame implements ActionListener{
	private static final java.util.Date Time = null;

	static String username = null;
	
    JButton send = new JButton("����");
	JButton cancel = new JButton("ȡ��");
	JButton check = new JButton("�鿴��������");
    JTextArea word = new JTextArea(30, 20);

	private java.util.Date Date;
	
    public Write(String username){
		this.username = username;
		this.setLayout(null);
		JLabel title = new JLabel("д��һЩ���Ը���Ұ�");
	    title.setFont(new Font(null, Font.PLAIN, 20));
	    title.setSize(200, 30);   
		title.setLocation(20, 10);
		this.add(title);
		
		
		word.setFont(new Font(null, Font.PLAIN , 15));
		word.setSize(350, 290);
		word.setLocation(20, 50);
		word.setTabSize(4);
		word.setLineWrap(true); 
        word.setWrapStyleWord(true); 
        word.setBackground(Color.pink);
        JScrollPane scroll = new JScrollPane(word);
        scroll.setSize(350, 290);
        scroll.setLocation(20, 50);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scroll);
        
        send.setSize(90, 60);
        send.setFont(new Font(null, Font.PLAIN , 15));
        send.setLocation(380, 50);

		cancel.setSize(90, 60);
        cancel.setFont(new Font(null, Font.PLAIN , 15));
        cancel.setLocation(480, 50);

		check.setSize(190, 60);
        check.setFont(new Font(null, Font.PLAIN , 15));
        check.setLocation(380, 130);
        
		send.addActionListener(this);
		cancel.addActionListener(this);
		check.addActionListener(this);
		this.add(send);
		this.add(cancel);
		this.add(check);
		
		this.setTitle("����");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancel)
		{
			new Menu(username);
    		this.dispose();
		}
		else if (e.getSource() == send) {
			try {
				fun1();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == check) {
			new View(username);
    		this.dispose();
		}
	}
	
	public static void main(String[] args){
		Write frame = new Write(username);
	}
	
public void fun1() throws ClassNotFoundException, SQLException{
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		String url = "jdbc:sqlserver://localhost:1433; DatabaseName=SMBN";
		String username = "test1";
		String password = "123";
		
		Connection con = (Connection) DriverManager.getConnection(url, username, password);
		System.out.println(con);
		
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from ����");
		int count = 1;
		while(rs.next()){
			count++;
		}
		String con1 = String.valueOf(count);
		
		Statement stmt1 = con.createStatement();
		System.out.println(username);
		ResultSet c = stmt1.executeQuery("select ��ҵѧУ from �û���Ϣ where �û���='"+this.username+"'");
		c.next();
		String c1 = c.getString(1);

		Statement stmt2 = con.createStatement();
		ResultSet d = stmt2.executeQuery("select �༶ from �û���Ϣ where �û���='"+this.username+"'");
		d.next();
		String d1 = d.getString(1);
	
		
		Statement stmt3 = con.createStatement();
		ResultSet f = stmt3.executeQuery("select ���� from �û���Ϣ where �û���='"+this.username+"'");
		f.next();
		String f1 = f.getString(1);
		
		String e = word.getText();
	
		java.util.Date a = new java.util.Date();
		java.sql.Date b = new java.sql.Date(a.getTime());
		System.out.println(b);
		stmt.executeUpdate("insert into ����  values('"+con1+"','"+this.username+"','"+f1+"','"+b+"','"+c1+"','"+d1+"','"+e+"')");
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