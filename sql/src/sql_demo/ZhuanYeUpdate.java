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
public class ZhuanYeUpdate extends JDialog implements ActionListener{
  //=========���ؼ�
  //......��������
	  //......��������
	  private JLabel idLab;
	  //......�Ҳ���Ϣѡ����д��
	  private JTextField idTxt;
  //......��Ӻ�ȡ����ť
  private JButton addBtn,cancelBtn;
  //......���ֿؼ�
  private JPanel left,center,bottom;
  //private JComboBox jx = new JComboBox();
  
  //���캯��
  public ZhuanYeUpdate(Frame owner, String title, boolean modal, ZhuanyeModel sm, int  rowNum) 
  {
    //========��д���෽��
    super(owner, title, modal);
    //========����ǩ��
    idLab = new JLabel("רҵ: ");
   
    /*sexLab = new JLabel("�Ա�: ");
    classidLab = new JLabel("�༶");
    departmentidLab = new JLabel("ѧԺ: ");
    birthLab = new JLabel("����: ");
    nativeplaceLab = new JLabel("����: ");*/
    //========�Ҳ���Ϣ��д��
    idTxt = new JTextField();	
    idTxt.setText((String)sm.getValueAt(rowNum, 0));//��ȡ������Ϣ
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
    
    
    /*left.add(sexLab);
    left.add(classidLab); 
    left.add(departmentidLab); 
    left.add(birthLab); 
    left.add(nativeplaceLab); */
    //......�����ұ���
    center = new JPanel();
    center.setLayout(new GridLayout(7, 1));
    center.add(idTxt);  
    
    //center.add(sexTxt); 
    /*center.add(jx);
    jx.addItem("M");jx.addItem("F");*/
   
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
      ZhuanyeModel tmp = new ZhuanyeModel();
      String sql = "update רҵ���� set רҵ=?";
      String []paras = {idTxt.getText(),
    		 };
      if(!tmp.cudStu(sql, paras))
        JOptionPane.showMessageDialog(this, "�޸�רҵ��Ϣʧ��");
      //========�رմ���
      this.dispose();
    } else if(e.getActionCommand().equals("cancel")) {
      //========�رմ���
      this.dispose();
    }
  }
}