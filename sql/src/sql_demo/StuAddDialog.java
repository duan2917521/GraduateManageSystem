package sql_demo;

import java.awt.BorderLayout;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StuAddDialog extends JDialog implements ActionListener{
  //=========面板控件
  //......左侧标题栏
  private JLabel idLab,idName,passwordLab,nameLab,phoneLab,emailLab,qqLab,workPlaceLab,lineAddLab,youbianLab,schoolLab,
  classLab,zhuanyeLab,biyeLab;
  //......右侧信息选择填写栏
  private JTextField idTxt,idNameTxt,PassTxt,nameTxt,phoneTxt,emailTxt,qqTxt,workPlaceTxt,lineAddTxt,youbianTxt,schoolTXt,
  classTxt,zhuanyeTxt,biyeTxt;
  //......添加和取消按钮
  private JButton addBtn,cancelBtn;
  //......布局控件
  private JPanel left,center,bottom;
  //private JComboBox jx = new JComboBox();//学生性别下拉框
  
  //构造函数
  public StuAddDialog(Frame owner, String title, boolean modal) 
  {
    //========重写父类方法
    super(owner, title, modal);
    //========左侧标签栏
    idLab = new JLabel("编号: ");
    idName = new JLabel("用户名:");
    passwordLab = new JLabel("密码:");
    nameLab = new JLabel("姓名: ");
    phoneLab=new JLabel("联系电话：");
    emailLab=new JLabel("电子邮件：");
    qqLab=new JLabel("QQ：");
    workPlaceLab=new JLabel("工作单位：");
    lineAddLab=new JLabel("通信地址：");
    youbianLab=new JLabel("邮编：");
    schoolLab=new JLabel("毕业学校 ：");
    classLab=new JLabel("班级：");
    zhuanyeLab=new JLabel("专业：");
    biyeLab=new JLabel("毕业年月：");
    //========右侧信息填写栏
    idTxt = new JTextField();
    idNameTxt = new JTextField();
    PassTxt = new JTextField();
    nameTxt = new JTextField();
    phoneTxt = new JTextField();
    emailTxt = new JTextField();
    qqTxt = new JTextField();
    workPlaceTxt = new JTextField();
    lineAddTxt = new JTextField();
    youbianTxt = new JTextField();
    schoolTXt = new JTextField();
    classTxt = new JTextField();
    zhuanyeTxt = new JTextField();
    biyeTxt = new JTextField();
    
    
    //========添加和取消按钮
    addBtn = new JButton("添加");
    cancelBtn = new JButton("取消");
    //......添加监听
    addBtn.addActionListener(this);
    addBtn.setActionCommand("add");
    cancelBtn.addActionListener(this);
    cancelBtn.setActionCommand("cancel");
    //========创建布局
    //......创建左边栏
    left = new JPanel();
    left.setLayout(new GridLayout(14, 1));
    left.add(idLab);     
    left.add(idName);
    left.add(passwordLab); 
    left.add(nameLab); 
    left.add(phoneLab);
    left.add(emailLab);
    left.add(qqLab);
    left.add(workPlaceLab);
    left.add(lineAddLab);
    left.add(youbianLab);
    left.add(schoolLab);
    left.add(classLab);
    left.add(zhuanyeLab);
    left.add(biyeLab);
    
    //......创建右边栏
    center = new JPanel();
    center.setLayout(new GridLayout(14, 1));
    center.add(idTxt);      
    center.add(idNameTxt);
    center.add(PassTxt);  
    center.add(nameTxt);
    center.add(phoneTxt);
    center.add(emailTxt);
    center.add(qqTxt);
    center.add(workPlaceTxt);
    center.add(lineAddTxt);
    center.add(youbianTxt);
    center.add(schoolTXt);
    center.add(classTxt);
    center.add(zhuanyeTxt);
    center.add(biyeTxt);
    //========底层添加和取消按钮
    bottom = new JPanel();
    bottom.add(addBtn);
    bottom.add(cancelBtn);
    //========整体布局
    this.add(left,BorderLayout.WEST);
    this.add(center,BorderLayout.CENTER);
    this.add(bottom,BorderLayout.SOUTH);
    //========设置窗口属性
    this.setLocation(450, 300);
    this.setSize(300, 250);
    this.setResizable(false);
    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) 
  {
    // TODO Auto-generated method stub
    if(e.getActionCommand().equals("add")) {
      /***********************添加学生信息**************************/
      StudentModel tmp = new StudentModel();
      String sql = "insert into 用户信息 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      String []paras = {idTxt.getText(),
    		  idNameTxt.getText(),PassTxt.getText(),nameTxt.getText(),
    		  phoneTxt.getText(),emailTxt.getText(),qqTxt.getText(),workPlaceTxt.getText(),lineAddTxt.getText(),
    		  youbianTxt.getText(),schoolTXt.getText(),classTxt.getText(),zhuanyeTxt.getText(),biyeTxt.getText()};
      if(!tmp.cudStu(sql, paras))
        JOptionPane.showMessageDialog(this, "添加学生信息失败");
      //========关闭窗口
      this.dispose();
    } else if(e.getActionCommand().equals("cancel")) {
      //========关闭窗口
      this.dispose();
    }
  }
}