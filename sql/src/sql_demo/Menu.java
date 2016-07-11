package sql_demo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener{
	
	static String username = null;
	
	JButton write = new JButton("���Թ���");
    JButton view = new JButton("�鿴���԰�");
    JButton friend = new JButton("�鿴����");
    JButton people = new JButton("�������ʶ����");
    JButton find = new JButton("�����û�");
    JButton edit = new JButton("��Ϣ�༭");
	public Menu(String username){
		//setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
		this.username = username ;
		
		setLayout(null);
		
		JLabel title = new JLabel(username + ",��ӭ������У��¼����ϵͳ");
	    title.setFont(new Font(null, Font.PLAIN, 20));
	    title.setSize(400, 30);   
		title.setLocation(20, 20);
		this.add(title);
		
        write.setSize(200, 60);
        write.setFont(new Font(null, Font.PLAIN , 15));
        write.setLocation(20, 70);
        write.addActionListener(this);
        this.add(write);

        view.setSize(200, 60);
        view.setFont(new Font(null, Font.PLAIN , 15));
        view.setLocation(250, 70);
        view.addActionListener(this);
        this.add(view);

        friend.setSize(200, 60);
        friend.setFont(new Font(null, Font.PLAIN , 15));
        friend.setLocation(20, 150);
        friend.addActionListener(this);
        this.add(friend);

        people.setSize(200, 60);
        people.setFont(new Font(null, Font.PLAIN , 15));
        people.setLocation(250, 150);
        people.addActionListener(this);
        this.add(people);

        find.setSize(200, 60);
        find.setFont(new Font(null, Font.PLAIN , 15));
        find.setLocation(20, 230);
        find.addActionListener(this);
        this.add(find);

        edit.setSize(200, 60);
        edit.setFont(new Font(null, Font.PLAIN , 15));
        edit.setLocation(250, 230);
        edit.addActionListener(this);
        this.add(edit);
		
		this.setTitle("�˵�");
		this.setSize(490, 390);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == write)
		{
			new Write(username);
    		this.dispose();
		}
		if (e.getSource() == view)
		{
			new View(username);
    		this.dispose();
		}
		if (e.getSource() == edit)
		{
			new Edit(username);
    		this.dispose();
		}
		if (e.getSource() == find)
		{
			new Find(username);
    		this.dispose();
		}
		if (e.getSource() == friend)
		{
			new Friend(username);
    		this.dispose();
		}
		if (e.getSource() == people)
		{
			new People(username);
    		this.dispose();
		}
	}
	
	public static void main(String[] args){
		Menu frame = new Menu(username);
	}
}