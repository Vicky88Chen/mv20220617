package model;
import java.util.*;
public class MyBean {
	 ArrayList<String> v = new ArrayList<String>();
	    String submit = null;
	    String item = null;
	    
	    private void addItem(String name) {
		       v.add(name);
	    }

	    private void removeItem(String name) {
		     v.remove(name);
	    }

	    public void setItem(String name) {
		      item = name;
	    }
	    
	    public void setSubmit(String s) {
		     submit = s;
	    }    
	    public String[] getItems()
	    {
	    	     String[] temp=null;
	    	     temp=new String[v.size()];
	    	     for(int i=0;i<temp.length; i++)
	    	    	      temp[i]=v.get(i);
	    	     
	    	     return temp;
	    }
	    public void processRequest() {	
		if (submit == null) 
		    addItem(item);

		if (submit.equals("add"))
		    addItem(item);
		else if (submit.equals("remove")) 
		    removeItem(item);
		
		// reset at the end of the request
		reset();
	    }
	    // reset
	    private void reset() {
		submit = null;
		item = null;
	    }
	}
