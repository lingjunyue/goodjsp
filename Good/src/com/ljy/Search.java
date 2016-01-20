package com.ljy;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Search extends ActionSupport {
    private String username;
    private String password;
    private String p1;
    private List<String> l1;
    private List<RecordData> l2;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getp1() {
        return p1;
    }

    public void setp1(String p1) {
        this.p1 = p1;
    }
    public List<String> getl1() {
        return l1;
    }

    public void setl1(List<String> l1) {
        this.l1 = l1;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String init() throws Exception {
    	
    	System.out.println("init.................");
    	return "goood";
    }
    public String execute() throws Exception {
        // (getUsername().equals("ljy") && getPassword().equals("123"))
    	if (true){
            //ActionContext.getContext().getSession().put("p1", "last input true");
        	ActionContext.getContext().put("p1", "last input true");  
        	l1 = new ArrayList<String>(5);
        	 l1.add("Earth");
        	 l1.add("Earth1");
        	 System.out.println("search................."+l1.get(0));
        	 DBconnect testdb =new DBconnect();
        	 testdb.init();
        	 l1 = testdb.list;       	 
        	 System.out.println("search................."+l1.get(0));
        	 ActionContext.getContext().put("l2", l1);  
        	 
        	 l2 = new ArrayList<RecordData>();
        	 l2 = testdb.list2;
        	 ActionContext.getContext().put("l3", l2);  
            return SUCCESS;
        }else{
        	ActionContext.getContext().put("p1", "last input false");
            return LOGIN;
        }
    }
}