package com.ljy;


import java.sql.*;
import java.util.*;



public class DBconnect {



/**
 * 一个非常标准的连接Oracle数据库的示例代码
 * 
	public static void main(String args[])

	 */
	public List<String> list;
	public List<String> getlist()
	{
		return list;
	}
	public List<RecordData> list2;
	public void outputlist(List<RecordData> l){
		for (int i=0;i<l.size();i++){
			System.out.println(l.get(i).username+"---"+l.get(i).age);
		}
		 
	}

 public void init()
{
	 list= new ArrayList<String>();
	 list2= new ArrayList<RecordData>();
    Connection con = null;// 创建一个数据库连接
    PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
    ResultSet result = null;// 创建一个结果集对象
    try
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
        System.out.println("开始尝试连接数据库！");
        String url = "jdbc:oracle:" + "thin:@132.108.200.19:1521:dbsch";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
        System.out.println(url);
        String user = "test";// 用户名,系统默认的账户名
        String password = "Aa123456";// 你安装时选设置的密码
        con = DriverManager.getConnection(url, user, password);// 获取连接
        System.out.println("连接成功！");
        String sql = "select * from test.tb_users where username=?";// 预编译语句，“？”代表参数
        pre = con.prepareStatement(sql);// 实例化预编译语句
        pre.setString(1, "aba");// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
        result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
        while (result.next())
        {
        	   int a = result.getInt("age");
        	   String username = result.getString("username");
        String ages ="";
        ages = a+"";
            // 当结果集不为空时
            System.out.println("age:" + result.getInt("age") + "姓名:"
                    + result.getString("username"));
        list.add(username);
     
        list.add( ages);
        RecordData ra =new RecordData();
        ra.set(username,a) ;
        list2.add(ra);
       
        }
        
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
    finally
    {
    	   System.out.println("finally------");
    	   System.out.println(list.get(0));
    	   outputlist(list2);
        try
        {
            // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
            // 注意关闭的顺序，最后使用的最先关闭
            if (result != null)
                result.close();
            if (pre != null)
                pre.close();
            if (con != null)
                con.close();
            System.out.println("数据库连接已关闭！");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
}