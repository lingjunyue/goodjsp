package com.ljy;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by IntelliJ IDEA.
 * User: ��ͬ
 * Date: 2010-10-14
 * Time: 15:31:38
 * To change this template use File | Settings | File Templates.
 */
public class OutputExcelAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{
	protected HttpServletRequest request = null;
	protected HttpServletResponse response = null;
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}
    //��ȡ�����
    public InputStream getInputExcel()
    {
        return (InputStream)request.getAttribute("excelStream");
    }
    @Override
    public String execute() throws Exception {
            List<String> list = new ArrayList<String>();
            list.add("����");
            list.add("������");
            if(list != null){
                 int rows=0;
                 HSSFWorkbook wk = new HSSFWorkbook();
                 HSSFSheet sheet = wk.createSheet("FollowAgentStats");
                 HSSFRow row = sheet.createRow(rows++);
                 int column=0;
                 HSSFCell cell = row.createCell(column++,HSSFCell.CELL_TYPE_STRING);
                 cell.setCellValue("���");
                 cell = row.createCell(column++,HSSFCell.CELL_TYPE_STRING);
                 cell.setCellValue("����");
                 for(String ls:list){
                     row = sheet.createRow(rows++);
                     column=0;
                     cell = row.createCell(column++,HSSFCell.CELL_TYPE_NUMERIC);
                     cell.setCellValue(rows - 1);
                     cell = row.createCell(column++,HSSFCell.CELL_TYPE_STRING);
                     cell.setCellValue(ls);
                 }
                 try{
                     ByteArrayOutputStream out=new ByteArrayOutputStream();
                     wk.write(out);
                     request.setAttribute("excelStream",new ByteArrayInputStream(out.toByteArray()));
                     request.setAttribute("filename", "myexcel.xls");//�����ļ���
                     return SUCCESS;
                 }catch(Throwable th){
                     th.printStackTrace();
                     System.out.println("�޷����Excel�ļ�");
                     return ERROR;
                 }
            }else{
                System.out.println("ͳ�����ݲ�����");
                return ERROR;
            }
    }
}
