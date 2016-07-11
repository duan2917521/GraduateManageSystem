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
public class xxUp extends JDialog implements ActionListener{
  //=========面板控件
  //......左侧标题栏
	  //......左侧标题栏
	  private JLabel idLab;
	  //......右侧信息选择填写栏
	  private JTextField idTxt;
  //......添加和取消按钮
  private JButton addBtn,cancelBtn;
  //......布局控件
  private JPanel left,center,bottom;

  
  //构造函数
  public xxUp(Frame owner, String title, boolean modal, xxModel sm, int  rowNum) 
  {
    //========重写父类方法
    super(owner, title, modal);
    //========左侧标签栏
    idLab = new JLabel("毕业学校: ");
    
 
    //========右侧信息填写栏
    idTxt = new JTextField();    
    idTxt.setText((String)sm.getValueAt(rowNum,0));//获取属性信息
    idTxt.setEditable(false);
   
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
    
    //......创建右边栏
    center = new JPanel();
    center.setLayout(new GridLayout(7, 1));
    center.add(idTxt);  
    
   
   
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
    /***********************修改信息**************************/
      xxModel tmp = new xxModel();
      String sql = "update 学校管理 set 毕业学校=?";
      String []paras = {idTxt.getText()
    		 };
      if(!tmp.cudStu(sql, paras))
        JOptionPane.showMessageDialog(this, "修改信息失败");
      //========关闭窗口
      this.dispose();
    } else if(e.getActionCommand().equals("cancel")) {
      //========关闭窗口
      this.dispose();
    }
  }
}