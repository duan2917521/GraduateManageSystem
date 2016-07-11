package sql_demo;
//import cn.com.*;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class timeModel extends AbstractTableModel{
  @SuppressWarnings("rawtypes")
private Vector columnNames;
  @SuppressWarnings("rawtypes")
private Vector rowDates;
  
  //
  @SuppressWarnings("unused")
public timeModel()
  {
    String sql = "select * from 毕业年月管理";
    String []paras = {};
    
  }
  
  //========增删
  public boolean cudStu(String sql, String []paras)
  {
    return new SqlHelper().cudExecute(sql, paras);
  }
  
  //========查询
  public void queryStu(String sql, String []paras)
  {
    SqlHelper sqlHelper = null;
    //========初始化JTable信息
    columnNames = new Vector();
    rowDates = new Vector();
    columnNames = new Vector();
    rowDates = new Vector();
    columnNames.add("毕业年月"); 
    
    
    try {
      sqlHelper = new SqlHelper();
      ResultSet rs = sqlHelper.queryExecute(sql, paras);
      while(rs.next()) {
        Vector row = new Vector();
        row.add(rs.getString(1));
        
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