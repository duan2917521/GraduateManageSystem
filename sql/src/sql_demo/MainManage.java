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
	//========���ؼ�
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
	  
	  //���캯��
	  public MainManage()
	  {
	    /***************************��ʼ�����ؼ�***********************/
	    //========��ѯ��
	    queryLab = new JLabel("����������:");
	    queryTxt = new JTextField(10);
	    queryBtn = new JButton("��ѯ");
	    allBtn = new JButton("ȫ��");
	    //......��Ӳ�ѯ������
	    queryBtn.addActionListener(this);
	    queryBtn.setActionCommand("query");
	    allBtn.addActionListener(this);
	    allBtn.setActionCommand("all");
	    //========��ɾ����
	    jibenBtn = new JButton("��������������޸�");
	    //changeBtn = new JButton("��������������޸�");
	    //rewardBtn = new JButton("��������������޸�");
	    //punishBtn = new JButton("��������������޸�");
	    //......�����ɾ��������
	    jibenBtn.addActionListener(this);
	    jibenBtn.setActionCommand("jiben");
	    //changeBtn.addActionListener(this);
	    //changeBtn.setActionCommand("change");
	    //rewardBtn.addActionListener(this);
	    //rewardBtn.setActionCommand("reward");
	    //punishBtn.addActionListener(this);
	    //punishBtn.setActionCommand("punish");
	    //========�����������岼��
	    //......�����ѯ��
	    top = new JPanel();
	    top.add(queryLab);
	    top.add(queryTxt);
	    top.add(queryBtn);
	    top.add(allBtn);
	    //......�ײ���ɾ����
	    bottom = new JPanel();
	    bottom.add(jibenBtn);
	    //bottom.add(changeBtn);
	    //bottom.add(rewardBtn);
	   // bottom.add(punishBtn);
	    //......�м����ʾ��
	    sm = new MainModel();
	    String sql = "select * from �û���Ϣ";
	    sm.queryStu(sql, null);
	    resultTb = new JTable(sm);
	    jsp = new JScrollPane(resultTb);
	    //......�������岼��
	    this.add(top,BorderLayout.NORTH);
	    this.add(jsp,BorderLayout.CENTER);
	    this.add(bottom,BorderLayout.SOUTH);
	    //========���ô�������
	    this.setTitle("ѧ����Ϣ��ѯ");
	    this.setLocation(270, 100);
	    this.setSize(900, 500);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	    this.setResizable(false);
	  }
	  
	  //����
	  @Override
	  public void actionPerformed(ActionEvent e)
	  {
	    // TODO Auto-generated method stub
	    if(e.getActionCommand().equals("query")) {
	      /*********************��ѯ***********************/
	      //========��ȡ����ѧ��������
	      String name = queryTxt.getText().trim();
	      if(name.length() != 0) {
	        //========����������Чʱ��ִ�в�ѯ
	        //......�������
	        String sql = "select * from �û���Ϣ where �û���=?";
	        String []paras = {name};
	        //......����ģ��
	        jtableUpdate(sql, paras);
	      } else {
	        //========����Ϊ��ʱ����������
	        JOptionPane.showMessageDialog(this, "�������벻��Ϊ��");
	      }
	    } else if(e.getActionCommand().equals("jiben")) {
	      /*********************���***********************/
	      new StudentManage();
	    }
	  else if(e.getActionCommand().equals("all")) {
	      /*********************ȫ����ʾ***********************/
	      String sql = "select * from �û���Ϣ";
	      jtableUpdate(sql, null);
	    }
	    } 
	    //else if(e.getActionCommand().equals("change")) {
	      /*********************ѧ������***********************/
	      
	      ///new ChangeManage();
	    //} //else if(e.getActionCommand().equals("reward")) {
	      /*********************�������***********************/
	      
	      //new RewardManage();
	    //}//else if(e.getActionCommand().equals("punish")){
	    	//new PunishManage();
	    //}
	  //} 
	  
	  //========����JTable������
	  public void jtableUpdate(String sql, String[] paras)
	  {
	    //......����ģ��
	    sm = new MainModel();
	    sm.queryStu(sql, paras);
	    //......������ʾ
	    resultTb.setModel(sm);
	  }

}