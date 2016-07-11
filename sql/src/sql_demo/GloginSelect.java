package sql_demo;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


public class GloginSelect extends Frame implements ActionListener{
	Button b1=new Button("学生基本信息管理");//创建登陆按钮     
	Button b2=new Button("专业选择管理");//创建取消按钮 
	Button b3=new Button("班级管理") ;
	Button b4=new Button("学校管理") ;
	Button b5=new Button("毕业年月管理");
	Button b6=new Button("留言管理");
	Button b7=new Button("取消");
	Button b8=new Button("返回登陆选择界面");
	
	public GloginSelect(){           
		this.setTitle("管理员选择窗口");//设置窗口标题          
		this.setLayout(null);//设置窗口布局管理器        
		
		b1.setBounds(100,50,200,50);//设置登陆按钮的初始位置         
		this.add(b1);//将登陆按钮组件添加到容器   
		
		b2.setBounds(350,50,200,50);//设置取消按钮的初始位置          
		this.add(b2);// 将取消按钮组件添加到容器           
		
		b3.setBounds(100, 150, 200, 50);
		this.add(b3);
		
		b4.setBounds(350, 150, 200, 50);
		this.add(b4);
		
		b5.setBounds(100, 250, 200, 50);
		this.add(b5);
		
		b6.setBounds(350, 250, 200, 50);
		this.add(b6);
		
		b7.setBounds(100, 350, 200, 50);
		this.add(b7);
		
		b8.setBounds(350, 350, 200, 50);
		this.add(b8);
		
		
		
		b1.addActionListener(this);//给登陆按钮添加监听器          
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		this.setLocation(500, 300);
		this.setVisible(true);//设置窗口的可见性         
		this.setSize(800,600);//设置窗口的大小          
		addWindowListener(new WindowAdapter(){     
			public void windowClosing(WindowEvent e){                  
				System.exit(0);               
				}              
			});//通过内部类重写关闭窗体的方法       
		}
	public void actionPerformed(ActionEvent e) {
		//处理登陆事件new banjiManage();
	if(e.getSource()==b1){
		new MainManage();
	}
	 if(e.getSource()==b2){
		 new ZhuanYeManage();
	}
	 if(e.getSource()==b3){	
		 new banjiManage();
		
	}
	 if(e.getSource()==b4){	
			
		 new xxManage();
		}
	 if(e.getSource()==b5){	
			
		 new timeManage();
		}
	 if(e.getSource()==b6){	
			
		 new liuYanManage();
		}
	 if(e.getSource()==b7){	
		 this.dispose();	
			
		}
	 if(e.getSource()==b8){	
		new Login();
		this.dispose();
			
		}
	
	}
}