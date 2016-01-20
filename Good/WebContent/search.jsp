<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>search.jsp</title>
</head>
<body>
hello logon search.jsp 
<br>

<s:form action="search">
   
    <s:textfield name="username" key="user"/>
    <s:textfield name="password" key="pass"/>
    <s:submit key="login" label = "search"/>
   
    p1----
    <s:property value="p1" /> 
    <br>
    l1-------
  
    <s:property value="l1[1]" />
     l2-------
     
   
     
     <table border="1" width="50%" cellspacing="0" cellpadding="0">  
    <tr>  
      <td>key=value</td>  
      <td>ID</td>  
      <td>num</td>  
      <td>name</td>  
     <td>sex</td>  
      <td>age</td>  
    </tr>  
    <s:iterator value="l3" id="u">  
    <tr>  
     <td><s:property value="#u"/></td>  
     <td><s:property value="#u.username"/></td>  
     <td><s:property value="#u.age"/></td>  
     <td><s:property value="value[2]"/></td>  
     <td><s:property value="value[3]"/></td>  
     <td><s:property value="value[4]"/></td>  
    </tr>  
    </s:iterator>  
  </table>  
  <p>  
      <br>=============================<a></a>
            <s:iterator value="l2" id="column">  
    <tr>  
     <td><s:property value="#column"/></td>  
     <td><s:property value="value[0]"/></td>  
     <td><s:property value="value[1]"/></td> 
    </tr>  
    </s:iterator>  
    
					
			
</s:form>

<br>--------------%%%%%--------------<br>

<!-- 
3：遍历数据栈.简单的List类，
List<Attr> 
class Attr{String attrName;String getAttrName(){return "123";}}
<s:iterator value="label" id="id"> 
    <s:property value="#id.attrName" /> 
</s:iterator> 
当然value 还可以写成 value="%{label}" label可以有.操作
label的属性List 可以写成value="%{label.list}" 相当于：getLabel().getList();
 -->

 <s:form action="listaction" method="post" theme="simple">  
   <table border="1">  
     <tr style="background:gray;">  
       <td>username</td>  
       <td>age</td>    
      
     </tr>  
       
     <s:iterator  value="l111" id="id">  
         <tr>   
           <td><s:textfield name="#id.username'}"/></td>  
           <td><s:textfield name="#id.age'}"/></td>  
           
         </tr>  
    </s:iterator>  
    </table>  
  
    </s:form>    

</body>
</html>
