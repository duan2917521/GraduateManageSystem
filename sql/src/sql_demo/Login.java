package sql_demo;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

//import cn.com.main.MainManage;

public class Login extends Frame implements ActionListener{
	
	Label author=new Label("版本号：xugougou爱jingjing");
	Button b1=new Button("管理员登陆");//创建登陆按钮     
	Button b2=new Button("普通用户登录");//创建取消按钮  
	
	public Login(){           
		this.setTitle("选择登录窗口");//设置窗口标题          
		this.setLayout(null);//设置窗口布局管理器       
		author.setBounds(150, 300, 200,80);
		this.add(author);
		//stuid.setBounds(50, 125, 110, 20);
		//this.add(stuid);
		b1.setBounds(150,175,120,40);//设置登陆按钮的初始位置         
		this.add(b1);//将登陆按钮组件添加到容器           
		b2.setBounds(350,175,120,40);//设置取消按钮的初始位置 
		
		this.add(b2);// 将取消按钮组件添加到容器           
		b1.addActionListener(this);//给登陆按钮添加监听器          
		b2.addActionListener(this);// 给取消按钮添加监听器  
		this.setLocation(500, 300);
		this.setVisible(true);//设置窗口的可见性         
		this.setSize(600,400);//设置窗口的大小          
		addWindowListener(new WindowAdapter(){     
			public void windowClosing(WindowEvent e){                  
				System.exit(0);               
				}              });//通过内部类重写关闭窗体的方法       
	}
		


     public void actionPerformed(ActionEvent e) {
    	 if(e.getSource()==b1){
    		 //JOptionPane.showMessageDialog(Login.this, "管理员登陆成功!点击确认继续");
	    		new Glogin();//以后修改登陆后的界面  
	    		this.dispose();
    	 }
    	 if(e.getSource()==b2){
    		 //JOptionPane.showMessageDialog(Login.this, "普通用户登陆成功!点击确认继续");
    		 	new Xlogin();
      		 	this.dispose();
    		 
    	 }
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 	 
    	 
 }
     

}
