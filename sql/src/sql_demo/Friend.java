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

public class Friend extends JFrame implements ActionListener{
	
	static String username = null;
	JButton yes = new JButton("是");
	JButton no = new JButton("否");
	JButton back = new JButton("返回主菜单");
	
	
	public Friend(String username){
		this.username = username;
		
		this.setLayout(null);
		JLabel title = new JLabel("好友提示");
	    title.setFont(new Font(null, Font.PLAIN, 20));
	    title.setSize(200, 30);   
		title.setLocation(20, 10);
		this.add(title);
		
		JLabel title2 = new JLabel("您的好友");
	    title2.setFont(new Font(null, Font.PLAIN, 20));
	    title2.setSize(200, 30);   
		title2.setLocation(20, 100);
		this.add(title2);
		
		yes.addActionListener(this);
		yes.setSize(50, 30);
		yes.setLocation(450, 50);
	    this.add(yes);
	    no.addActionListener(this);
		no.setSize(50, 30);
		no.setLocation(510, 50);
	    this.add(no);
	    back.addActionListener(this);
		back.setSize(110, 30);
		back.setLocation(450, 10);
	    this.add(back);
		
		this.setTitle("查看好友");
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
	}
	
	public static void main(String[] args){
		Friend frame = new Friend(username);
	}
	
	
	
}