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
public class liuYanUpdateDialog extends JDialog implements ActionListener{
  //=========���ؼ�
  //......��������
	  //......��������
	  private JLabel idLab,idName,nameLab,dataLab,schoolLab,classLab,liuYanLab;
	  //......�Ҳ���Ϣѡ����д��
	  private JTextField idTxt,idNameTxt,nameTxt,dataTxt,schoolTxt,classTxt,liuYanTxt;
  //......��Ӻ�ȡ����ť
  private JButton addBtn,cancelBtn;
  //......���ֿؼ�
  private JPanel left,center,bottom;
 
  
  //���캯��
  public liuYanUpdateDialog(Frame owner, String title, boolean modal, liuYanModel sm, int  rowNum) 
  {
    //========��д���෽��
    super(owner, title, modal);
    //========����ǩ��
    idLab = new JLabel("���: ");
    idName = new JLabel("�û���:");
    nameLab = new JLabel("����:");
    dataLab = new JLabel("����: ");
    schoolLab = new JLabel("��ҵѧУ: ");
    classLab = new JLabel("�༶: ");
    liuYanLab = new JLabel("��������: ");
    
  
    //========�Ҳ���Ϣ��д��
    idTxt = new JTextField();	
    idTxt.setText((String)sm.getValueAt(rowNum, 0));//��ȡ������Ϣ
    idTxt.setEditable(false);
    idNameTxt = new JTextField();
    idNameTxt.setText((String)sm.getValueAt(rowNum, 1));
    nameTxt = new JTextField();
    nameTxt.setText((String)sm.getValueAt(rowNum, 2));
    dataTxt = new JTextField();
    dataTxt.setText((String)sm.getValueAt(rowNum, 3));
    schoolTxt = new JTextField();
    schoolTxt.setText((String)sm.getValueAt(rowNum, 4));
    classTxt = new JTextField();
    classTxt.setText((String)sm.getValueAt(rowNum, 5));
    liuYanTxt = new JTextField();
    liuYanTxt.setText((String)sm.getValueAt(rowNum, 6));
    
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
    left.add(nameLab);
    left.add(dataLab); 
    left.add(schoolLab);
    left.add(classLab); 
    left.add(liuYanLab); 
    
    //......�����ұ���
    center = new JPanel();
    center.setLayout(new GridLayout(7, 1));
    center.add(idTxt);  
    center.add(idNameTxt);    
    center.add(nameTxt);  
    center.add(dataTxt);
    center.add(schoolTxt);
    center.add(classTxt);
    center.add(liuYanTxt);
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
      liuYanModel tmp = new liuYanModel();
      String sql = "update ���� set ���=?,�û���=?,����=?,����=?,��ҵѧУ=?,�༶=?,��������=?";
      String []paras = {idTxt.getText(),
    		  idNameTxt.getText(),nameTxt.getText(),dataTxt.getText(),
    		  schoolTxt.getText(),classTxt.getText(),liuYanTxt.getText()};
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
