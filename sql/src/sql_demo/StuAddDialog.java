package sql_demo;

import java.awt.BorderLayout;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class StuAddDialog extends JDialog implements ActionListener{
  //=========���ؼ�
  //......��������
  private JLabel idLab,idName,passwordLab,nameLab,phoneLab,emailLab,qqLab,workPlaceLab,lineAddLab,youbianLab,schoolLab,
  classLab,zhuanyeLab,biyeLab;
  //......�Ҳ���Ϣѡ����д��
  private JTextField idTxt,idNameTxt,PassTxt,nameTxt,phoneTxt,emailTxt,qqTxt,workPlaceTxt,lineAddTxt,youbianTxt,schoolTXt,
  classTxt,zhuanyeTxt,biyeTxt;
  //......��Ӻ�ȡ����ť
  private JButton addBtn,cancelBtn;
  //......���ֿؼ�
  private JPanel left,center,bottom;
  //private JComboBox jx = new JComboBox();//ѧ���Ա�������
  
  //���캯��
  public StuAddDialog(Frame owner, String title, boolean modal) 
  {
    //========��д���෽��
    super(owner, title, modal);
    //========����ǩ��
    idLab = new JLabel("���: ");
    idName = new JLabel("�û���:");
    passwordLab = new JLabel("����:");
    nameLab = new JLabel("����: ");
    phoneLab=new JLabel("��ϵ�绰��");
    emailLab=new JLabel("�����ʼ���");
    qqLab=new JLabel("QQ��");
    workPlaceLab=new JLabel("������λ��");
    lineAddLab=new JLabel("ͨ�ŵ�ַ��");
    youbianLab=new JLabel("�ʱࣺ");
    schoolLab=new JLabel("��ҵѧУ ��");
    classLab=new JLabel("�༶��");
    zhuanyeLab=new JLabel("רҵ��");
    biyeLab=new JLabel("��ҵ���£�");
    //========�Ҳ���Ϣ��д��
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
    
    //......�����ұ���
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
      /***********************���ѧ����Ϣ**************************/
      StudentModel tmp = new StudentModel();
      String sql = "insert into �û���Ϣ values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      String []paras = {idTxt.getText(),
    		  idNameTxt.getText(),PassTxt.getText(),nameTxt.getText(),
    		  phoneTxt.getText(),emailTxt.getText(),qqTxt.getText(),workPlaceTxt.getText(),lineAddTxt.getText(),
    		  youbianTxt.getText(),schoolTXt.getText(),classTxt.getText(),zhuanyeTxt.getText(),biyeTxt.getText()};
      if(!tmp.cudStu(sql, paras))
        JOptionPane.showMessageDialog(this, "���ѧ����Ϣʧ��");
      //========�رմ���
      this.dispose();
    } else if(e.getActionCommand().equals("cancel")) {
      //========�رմ���
      this.dispose();
    }
  }
}