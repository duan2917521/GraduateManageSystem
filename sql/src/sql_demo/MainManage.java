	package sql_demo;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
//import cn.com.stu.*;
//import cn.com.jw.change.ChangeManage;
//import cn.com.jw.punish.PunishManage;
//import cn.com.jw.reward.RewardManage;
//import cn.com.stu.StudentManage;

public class MainManage extends JFrame implements ActionListener{
	//========面板控件
	  private JLabel queryLab = null;
	  private JTextField queryTxt = null;
	  private JButton queryBtn = null;
	  private JButton allBtn = null;
	  private JTable resultTb = null;
	  private JScrollPane jsp = null;
	  private JButton jibenBtn = null;
	  //private JButton changeBtn = null;
	  //private JButton rewardBtn = null;
	  //private JButton punishBtn = null;
	  private JPanel top = null;
	  private JPanel bottom = null;
	  //========
	 private MainModel sm = null;
	  
	  //构造函数
	  public MainManage()
	  {
	    /***************************初始化面板控件***********************/
	    //========查询栏
	    queryLab = new JLabel("请输入姓名:");
	    queryTxt = new JTextField(10);
	    queryBtn = new JButton("查询");
	    allBtn = new JButton("全部");
	    //......添加查询栏监听
	    queryBtn.addActionListener(this);
	    queryBtn.setActionCommand("query");
	    allBtn.addActionListener(this);
	    allBtn.setActionCommand("all");
	    //========增删改栏
	    jibenBtn = new JButton("基本情况输入与修改");
	    //changeBtn = new JButton("流动情况输入与修改");
	    //rewardBtn = new JButton("奖励情况输入与修改");
	    //punishBtn = new JButton("处罚情况输入与修改");
	    //......添加增删改栏监听
	    jibenBtn.addActionListener(this);
	    jibenBtn.setActionCommand("jiben");
	    //changeBtn.addActionListener(this);
	    //changeBtn.setActionCommand("change");
	    //rewardBtn.addActionListener(this);
	    //rewardBtn.setActionCommand("reward");
	    //punishBtn.addActionListener(this);
	    //punishBtn.setActionCommand("punish");
	    //========创建窗口整体布局
	    //......顶层查询栏
	    top = new JPanel();
	    top.add(queryLab);
	    top.add(queryTxt);
	    top.add(queryBtn);
	    top.add(allBtn);
	    //......底层增删改栏
	    bottom = new JPanel();
	    bottom.add(jibenBtn);
	    //bottom.add(changeBtn);
	    //bottom.add(rewardBtn);
	   // bottom.add(punishBtn);
	    //......中间层显示栏
	    sm = new MainModel();
	    String sql = "select * from 用户信息";
	    sm.queryStu(sql, null);
	    resultTb = new JTable(sm);
	    jsp = new JScrollPane(resultTb);
	    //......构建整体布局
	    this.add(top,BorderLayout.NORTH);
	    this.add(jsp,BorderLayout.CENTER);
	    this.add(bottom,BorderLayout.SOUTH);
	    //========设置窗口属性
	    this.setTitle("学生信息查询");
	    this.setLocation(270, 100);
	    this.setSize(900, 500);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	    this.setResizable(false);
	  }
	  
	  //监听
	  @Override
	  public void actionPerformed(ActionEvent e)
	  {
	    // TODO Auto-generated method stub
	    if(e.getActionCommand().equals("query")) {
	      /*********************查询***********************/
	      //========获取输入学生的姓名
	      String name = queryTxt.getText().trim();
	      if(name.length() != 0) {
	        //========姓名输入有效时，执行查询
	        //......定义参数
	        String sql = "select * from 用户信息 where 用户名=?";
	        String []paras = {name};
	        //......更新模型
	        jtableUpdate(sql, paras);
	      } else {
	        //========姓名为空时，设置提醒
	        JOptionPane.showMessageDialog(this, "姓名输入不能为空");
	      }
	    } else if(e.getActionCommand().equals("jiben")) {
	      /*********************添加***********************/
	      new StudentManage();
	    }
	  else if(e.getActionCommand().equals("all")) {
	      /*********************全部显示***********************/
	      String sql = "select * from 用户信息";
	      jtableUpdate(sql, null);
	    }
	    } 
	    //else if(e.getActionCommand().equals("change")) {
	      /*********************学籍流动***********************/
	      
	      ///new ChangeManage();
	    //} //else if(e.getActionCommand().equals("reward")) {
	      /*********************奖励情况***********************/
	      
	      //new RewardManage();
	    //}//else if(e.getActionCommand().equals("punish")){
	    	//new PunishManage();
	    //}
	  //} 
	  
	  //========更新JTable内数据
	  public void jtableUpdate(String sql, String[] paras)
	  {
	    //......创建模型
	    sm = new MainModel();
	    sm.queryStu(sql, paras);
	    //......更新显示
	    resultTb.setModel(sm);
	  }

}