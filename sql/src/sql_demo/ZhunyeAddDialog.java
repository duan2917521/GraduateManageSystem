package sql_demo;
import java.awt.BorderLayout;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ZhunyeAddDialog extends JDialog implements ActionListener{
  //=========���ؼ�
  //......��������
  private JLabel idLab;
  //......�Ҳ���Ϣѡ����д��
  private JTextField idTxt;
  //......��Ӻ�ȡ����ť
  private JButton addBtn,cancelBtn;
  //......���ֿؼ�
  private JPanel left,center,bottom;
  
  
  //���캯��
  public ZhunyeAddDialog(Frame owner, String title, boolean modal) 
  {
    //========��д���෽��
    super(owner, title, modal);
    //========����ǩ��
    idLab = new JLabel("רҵ: ");
    idTxt=new JTextField();
    
    
    
    //========��Ӻ�ȡ����ť
    addBtn = new JButton("���");
    cancelBtn = new JButton("ȡ��");
    //......��Ӽ���
    addBtn.addActionListener(this);
    addBtn.setActionCommand("add");
    cancelBtn.addActionListener(this);
    cancelBtn.setActionCommand("cancel");
    //========��������
    //......���������
    left = new JPanel();
    left.setLayout(new GridLayout(7, 1));
    left.add(idLab);     
    
    
    //......�����ұ���
    center = new JPanel();
    center.setLayout(new GridLayout(7, 1));
    center.add(idTxt);      
    
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
  public void actionPerformed(ActionEvent e) 
  {
    // TODO Auto-generated method stub
    if(e.getActionCommand().equals("add")) {
      /***********************���רҵ��Ϣ**************************/
      ZhuanyeModel tmp = new ZhuanyeModel();
      String sql = "insert into רҵ���� values(?)";
      String []paras = {idTxt.getText()};
      if(!tmp.cudStu(sql, paras))
        JOptionPane.showMessageDialog(this, "���רҵʧ��");
      //========�رմ���
      this.dispose();
    } else if(e.getActionCommand().equals("cancel")) {
      //========�رմ���
      this.dispose();
    }
  }
}