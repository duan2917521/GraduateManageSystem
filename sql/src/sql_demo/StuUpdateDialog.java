package sql_demo;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
//import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class StuUpdateDialog extends JDialog implements ActionListener{
  //=========面板控件
  //......左侧标题栏
	  //......左侧标题栏
	  private JLabel idLab,idName,passwordLab,nameLab;
	  //......右侧信息选择填写栏
	  private JTextField idTxt,idNameTxt,PassTxt,nameTxt;
  //......添加和取消按钮
  private JButton addBtn,cancelBtn;
  //......布局控件
  private JPanel left,center,bottom;
  //private JComboBox jx = new JComboBox();
  
  //构造函数
  public StuUpdateDialog(Frame owner, String title, boolean modal, StudentModel sm, int  rowNum) 
  {
    //========重写父类方法
    super(owner, title, modal);
    //========左侧标签栏
    idLab = new JLabel("编号: ");
    idName = new JLabel("用户名:");
    passwordLab = new JLabel("密码:");
    nameLab = new JLabel("姓名: ");
    /*sexLab = new JLabel("性别: ");
    classidLab = new JLabel("班级");
    departmentidLab = new JLabel("学院: ");
    birthLab = new JLabel("生日: ");
    nativeplaceLab = new JLabel("籍贯: ");*/
    //========右侧信息填写栏
    idTxt = new JTextField();	
    idTxt.setText((String)sm.getValueAt(rowNum, 0));//获取属性信息
    idTxt.setEditable(false);
    idNameTxt = new JTextField();
    idNameTxt.setText((String)sm.getValueAt(rowNum, 1));
    PassTxt = new JTextField();
    PassTxt.setText((String)sm.getValueAt(rowNum, 2));
    nameTxt = new JTextField();
    nameTxt.setText((String)sm.getValueAt(rowNum, 3));
    /*sexTxt = new JTextField();
    sexTxt.setText((String)sm.getValueAt(rowNum, 2));
    classidTxt = new JTextField();
    classidTxt.setText((String)sm.getValueAt(rowNum, 3));
    departmentidTxt = new JTextField();
    departmentidTxt.setText((String)sm.getValueAt(rowNum, 4));
    birthTxt = new JTextField();
    birthTxt.setText((String)sm.getValueAt(rowNum, 5));
    nativeplaceTxt = new JTextField();
    nativeplaceTxt.setText((String)sm.getValueAt(rowNum, 6));*/
    //========添加和取消按钮
    addBtn = new JButton("修改");
    cancelBtn = new JButton("取消");
    //......添加监听
    addBtn.addActionListener(this);
    addBtn.setActionCommand("update");
    cancelBtn.addActionListener(this);
    cancelBtn.setActionCommand("cancel");
    //========创建布局
    //......创建左边栏
    left = new JPanel();
    left.setLayout(new GridLayout(7, 1));
    left.add(idLab); 
    left.add(idName);
    left.add(passwordLab);
    
    left.add(nameLab); 
    /*left.add(sexLab);
    left.add(classidLab); 
    left.add(departmentidLab); 
    left.add(birthLab); 
    left.add(nativeplaceLab); */
    //......创建右边栏
    center = new JPanel();
    center.setLayout(new GridLayout(7, 1));
    center.add(idTxt);  
    center.add(idNameTxt);
    //center.add(sexTxt); 
    /*center.add(jx);
    jx.addItem("M");jx.addItem("F");*/
    center.add(PassTxt);  
    center.add(nameTxt);
    //center.add(birthTxt);
    //center.add(nativeplaceTxt);
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
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    if(e.getActionCommand().equals("update")) {
    /***********************修改学生信息**************************/
      StudentModel tmp = new StudentModel();
      String sql = "update 用户信息 set 编号=?,用户名=?,密码=?,姓名=?";
      String []paras = {idTxt.getText(),
    		  idNameTxt.getText(),PassTxt.getText(),nameTxt.getText()};
      if(!tmp.cudStu(sql, paras))
        JOptionPane.showMessageDialog(this, "修改学生信息失败");
      //========关闭窗口
      this.dispose();
    } else if(e.getActionCommand().equals("cancel")) {
      //========关闭窗口
      this.dispose();
    }
  }
}