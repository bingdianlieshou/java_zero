package zero;

import java.io.File;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
//import java.util.*;
import java.util.Map.Entry;
//import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import java.lang.StringBuilder;

public class GenerateHtml {
	public static Logger log = Logger.getLogger(GenerateHtml.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File path= new File("D:\\learning\\java\\6-092-january-iap-2010\\6-092-january-iap-2010\\contents");
		String father = "Course Home";
		ScanFile myscan = new ScanFile();
		myscan.ScanAllFile(path, father);
		myscan.PrintResult();
		Html myhtml = new Html();
	
		
		// generate the html head
		Item head = new Item();
		head.SetType("head");
		Item title = new Item();
		title.SetType("title");
		title.SetValue("Introduciton to learn java!");
		head.SetValue(title.getString());
		myhtml.Sethead(head);
		
		//generate the h1
		Item h1 = new Item();
		h1.SetType("h1");
		h1.SetValue("Introduciton to learn java!");
		myhtml.addItem(h1);
		
		//产生分割线
		Item fengexian  = new Item();
		fengexian.SetType("hr");
		myhtml.addItem(fengexian);

		//generate the table 
		Item mytable = new Item();
		mytable.SetType("ul");
		StringBuilder str_tp = new StringBuilder();
	    for(Entry<String, String> entry : myscan.getResult()){
	    	Item tp = new Item();
	    	tp.SetType("li");
	    	
	    	Item a = new Item();
	    	a.SetType("a");
	    	Attribute ref = new Attribute();
	    	ref.SetKey("href");
	    	ref.SetValue(entry.getValue());
	    	Attribute target = new Attribute();
	    	target.SetKey("target");
	    	target.SetValue("_blank");
	    	a.AddAttrubte(ref);
	    	a.AddAttrubte(target);
	    	a.SetValue(entry.getKey());
	    	tp.SetValue(a.getString());
	    	str_tp.append(tp.getString()+"\n");
	    }
	    mytable.SetValue(str_tp.toString());
	    myhtml.addItem(mytable);
	  
	    try{
	    	File htmlFile = new File("result.html");
	    	OutputStream out  = new BufferedOutputStream(
	    							new FileOutputStream(htmlFile));
	    	out.write(myhtml.getString().getBytes());
	    	out.write('\n');
	    	out.close();
	    }catch(FileNotFoundException e){
	    	
	    }catch(IOException e){
	    	
	    }catch(SecurityException e){
	    	
	    }finally{
	    	//out.close();
	    }
		

	}

}
