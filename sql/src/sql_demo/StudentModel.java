package sql_demo;
//import cn.com.*;

import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class StudentModel extends AbstractTableModel{
  @SuppressWarnings("rawtypes")
private Vector columnNames;
  @SuppressWarnings("rawtypes")
private Vector rowDates;
  
  //
  @SuppressWarnings("unused")
public StudentModel()
  {
    String sql = "select * from 用户信息";
    String []paras = {};
    
  }
  
  //========增删改学生
  public boolean cudStu(String sql, String []paras)
  {
    return new SqlHelper().cudExecute(sql, paras);
  }
  
  //========查询学生
  public void queryStu(String sql, String []paras)
  {
    SqlHelper sqlHelper = null;
    //========初始化JTable信息
    columnNames = new Vector();
    rowDates = new Vector();
    columnNames = new Vector();
    rowDates = new Vector();
    columnNames.add("编号"); 
    columnNames.add("用户名");
    columnNames.add("密码");
    columnNames.add("姓名");
    columnNames.add("联系电话");
    columnNames.add("电子邮件");
    columnNames.add("QQ");
    columnNames.add("工作单位");
    columnNames.add("通信地址");
    columnNames.add("邮编");
    columnNames.add("毕业学校");
    columnNames.add("班级") ;
    columnNames.add("专业");
    columnNames.add("毕业年月");
    
    try {
      sqlHelper = new SqlHelper();
      ResultSet rs = sqlHelper.queryExecute(sql, paras);
      while(rs.next()) {
        Vector row = new Vector();
        row.add(rs.getString(1));
        row.add(rs.getString(2));
        row.add(rs.getString(3));
        row.add(rs.getString(4));
        row.add(rs.getString(5));
        row.add(rs.getString(6));
        row.add(rs.getString(7));
        row.add(rs.getString(8));
        row.add(rs.getString(9));
        row.add(rs.getString(10));
        row.add(rs.getString(11));
        row.add(rs.getString(12));
        row.add(rs.getString(13));
        row.add(rs.getString(14));
        rowDates.add(row);
      }
    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      sqlHelper.close();
    }
    
  }

  @Override
  public int getColumnCount() {
    // TODO Auto-generated method stub
    return this.columnNames.size();
  }

  @Override
  public int getRowCount() {
    // TODO Auto-generated method stub
    return this.rowDates.size();
  }

  @Override
  public Object getValueAt(int row, int col) {
    // TODO Auto-generated method stub
    if(!rowDates.isEmpty())
      return ((Vector<?>)this.rowDates.get(row)).get(col);
    else
      return null;
  }

  
  @Override
  public String getColumnName(int column) {
    // TODO Auto-generated method stub
    return (String)this.columnNames.get(column);
  }

  
}