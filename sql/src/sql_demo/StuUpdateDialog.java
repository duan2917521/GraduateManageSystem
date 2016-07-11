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
  //=========���ؼ�
  //......��������
	  //......��������
	  private JLabel idLab,idName,passwordLab,nameLab;
	  //......�Ҳ���Ϣѡ����д��
	  private JTextField idTxt,idNameTxt,PassTxt,nameTxt;
  //......��Ӻ�ȡ����ť
  private JButton addBtn,cancelBtn;
  //......���ֿؼ�
  private JPanel left,center,bottom;
  //private JComboBox jx = new JComboBox();
  
  //���캯��
  public StuUpdateDialog(Frame owner, String title, boolean modal, StudentModel sm, int  rowNum) 
  {
    //========��д���෽��
    super(owner, title, modal);
    //========����ǩ��
    idLab = new JLabel("���: ");
    idName = new JLabel("�û���:");
    passwordLab = new JLabel("����:");
    nameLab = new JLabel("����: ");
    /*sexLab = new JLabel("�Ա�: ");
    classidLab = new JLabel("�༶");
    departmentidLab = new JLabel("ѧԺ: ");
    birthLab = new JLabel("����: ");
    nativeplaceLab = new JLabel("����: ");*/
    //========�Ҳ���Ϣ��д��
    idTxt = new JTextField();	
    idTxt.setText((String)sm.getValueAt(rowNum, 0));//��ȡ������Ϣ
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
    //========��Ӻ�ȡ����ť
    addBtn = new JButton("�޸�");
    cancelBtn = new JButton("ȡ��");
    //......��Ӽ���
    addBtn.addActionListener(this);
    addBtn.setActionCommand("update");
    cancelBtn.addActionListener(this);
    cancelBtn.setActionCommand("cancel");
    //========��������
    //......���������
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
    //......�����ұ���
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
    //========�ײ���Ӻ�ȡ����ť
    bottom = new JPanel();
    bottom.add(addBtn);
    bottom.add(cancelBtn);
    //========���岼��
    this.add(left,BorderLayout.WEST);
    this.add(center,BorderLayout.CENTER);
    this.add(bottom,BorderLayout.SOUTH);
    //========���ô�������
    this.setLocation(450, 300);
    this.setSize(300, 250);
    this.setResizable(false);
    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    if(e.getActionCommand().equals("update")) {
    /***********************�޸�ѧ����Ϣ**************************/
      StudentModel tmp = new StudentModel();
      String sql = "update �û���Ϣ set ���=?,�û���=?,����=?,����=?";
      String []paras = {idTxt.getText(),
    		  idNameTxt.getText(),PassTxt.getText(),nameTxt.getText()};
      if(!tmp.cudStu(sql, paras))
        JOptionPane.showMessageDialog(this, "�޸�ѧ����Ϣʧ��");
      //========�رմ���
      this.dispose();
    } else if(e.getActionCommand().equals("cancel")) {
      //========�رմ���
      this.dispose();
    }
  }
}