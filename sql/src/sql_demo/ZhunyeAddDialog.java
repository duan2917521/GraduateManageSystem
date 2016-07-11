package sql_demo;
import java.awt.BorderLayout;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ZhunyeAddDialog extends JDialog implements ActionListener{
  //=========面板控件
  //......左侧标题栏
  private JLabel idLab;
  //......右侧信息选择填写栏
  private JTextField idTxt;
  //......添加和取消按钮
  private JButton addBtn,cancelBtn;
  //......布局控件
  private JPanel left,center,bottom;
  
  
  //构造函数
  public ZhunyeAddDialog(Frame owner, String title, boolean modal) 
  {
    //========重写父类方法
    super(owner, title, modal);
    //========左侧标签栏
    idLab = new JLabel("专业: ");
    idTxt=new JTextField();
    
    
    
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
    left.setLayout(new GridLayout(7, 1));
    left.add(idLab);     
    
    
    //......创建右边栏
    center = new JPanel();
    center.setLayout(new GridLayout(7, 1));
    center.add(idTxt);      
    
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
      /***********************添加专业信息**************************/
      ZhuanyeModel tmp = new ZhuanyeModel();
      String sql = "insert into 专业管理 values(?)";
      String []paras = {idTxt.getText()};
      if(!tmp.cudStu(sql, paras))
        JOptionPane.showMessageDialog(this, "添加专业失败");
      //========关闭窗口
      this.dispose();
    } else if(e.getActionCommand().equals("cancel")) {
      //========关闭窗口
      this.dispose();
    }
  }
}