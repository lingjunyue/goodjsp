package com.ljy;


import java.sql.*;
import java.util.*;



public class DBconnect {



/**
 * һ���ǳ���׼������Oracle���ݿ��ʾ������
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
    Connection con = null;// ����һ�����ݿ�����
    PreparedStatement pre = null;// ����Ԥ����������һ�㶼�������������Statement
    ResultSet result = null;// ����һ�����������
    try
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");// ����Oracle��������
        System.out.println("��ʼ�����������ݿ⣡");
        String url = "jdbc:oracle:" + "thin:@132.108.200.19:1521:dbsch";// 127.0.0.1�Ǳ�����ַ��XE�Ǿ����Oracle��Ĭ�����ݿ���
        System.out.println(url);
        String user = "test";// �û���,ϵͳĬ�ϵ��˻���
        String password = "Aa123456";// �㰲װʱѡ���õ�����
        con = DriverManager.getConnection(url, user, password);// ��ȡ����
        System.out.println("���ӳɹ���");
        String sql = "select * from test.tb_users where username=?";// Ԥ������䣬�������������
        pre = con.prepareStatement(sql);// ʵ����Ԥ�������
        pre.setString(1, "aba");// ���ò�����ǰ���1��ʾ�����������������Ǳ�������������
        result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
        while (result.next())
        {
        	   int a = result.getInt("age");
        	   String username = result.getString("username");
        String ages ="";
        ages = a+"";
            // ���������Ϊ��ʱ
            System.out.println("age:" + result.getInt("age") + "����:"
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
            // ��һ������ļ�������رգ���Ϊ���رյĻ���Ӱ�����ܡ�����ռ����Դ
            // ע��رյ�˳�����ʹ�õ����ȹر�
            if (result != null)
                result.close();
            if (pre != null)
                pre.close();
            if (con != null)
                con.close();
            System.out.println("���ݿ������ѹرգ�");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
}