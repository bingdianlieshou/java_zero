package zero;

//import java.util.regex.*;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class Html{
	FileWriter myfile;
	static String end = "\n" ;
	static String quote = "\""; 
	Html(FileWriter path){
		myfile = path;
	}
	Html(String name)
	{
		try{
			myfile = new FileWriter(name);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	void generateDiscription(){
		record("<!DOCTYPE html><html>"+end);
	}
	void htmlEnd(){
		record("</html>"+end);
	}
	void generateHead(String style, String title){
		try{
			myfile.write("<head>"+end);
			myfile.write("<style>"+end);
			myfile.write(style+end);
			myfile.write("</style>"+end);
			myfile.write("<title>"+end);
			myfile.write(title+end);
			myfile.write("</title>"+end);
			myfile.write("</head>"+end);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	void  generateHead(String title){
		try{
			myfile.write("<head>"+end);
			myfile.write("<title>"+end);
			myfile.write(title+end);
			myfile.write("</title>"+end);
			myfile.write("</head>"+end);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	void  generateHeadOne(String head){
		try{
			myfile.write("<h1>"+end);
			myfile.write(head+end);
			myfile.write("</h1>"+end);
			myfile.write("<hr/>"+end);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	void bodyBegin(){
		record("<body>"+end);
	}
	void bodyEnd(){
		record("</body>"+end);
	}
	void unorderListBegin(){
		record("<ul>"+end);
	}
	void unorderListEnd(){
		record("</ul>"+end);
	}
	void generateList(String ref, String content){
		try{
			myfile.write("<li>");
			myfile.write("<a href="+quote+ref+quote+" target =\"_blank\""+"</a>");
			myfile.write(content);
			myfile.write("</li>");
			myfile.write("</br>"+end);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
	}
	
	void record(String infro){
		try{
			myfile.write(infro);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	void close(){
		try{
		myfile.write("</html>"+end);
		myfile.close();
		}catch (IOException ioe){
			ioe.printStackTrace();
		}
	}
}
class ScanFile{
	 Map<String, String> myMap;
	 ScanFile(){
		 //myMap = new HashMap<String, String>();
		 myMap = new LinkedHashMap<String, String>();
	 }
	 void scanAllFile(File path,String fatherName){
		Vector<File> vec_file = new Vector<File>();
		for(File item : path.listFiles()){
			if(item.isDirectory()){
				//System.out.println("This is a directory :" + item.getName()); 
				vec_file.add(item);
				//scanAllFile(item, item.getName());
			}else if(item.getName().equals("index.htm")){	
			//	System.out.println(fatherName  + "  "+ item.getAbsolutePath());
				myMap.put(fatherName, item.getAbsolutePath());
			}	
		}// end of for
		
		for(int i = 0; i< vec_file.size(); ++i ){
			File tp = (File)vec_file.get(i);
			scanAllFile(tp, tp.getName());
		}
	}// end of printAllfile
	 void printmymap(){
		 for(Entry<String, String> entry: myMap.entrySet()){
			 System.out.println(entry.getKey()+"\t"+entry.getValue());
		 }
		 
	 }
	 /*
	 static void printAllfile(String path){
		 File file = new File(path);
		 String firsttile = "Course home";
		 printAllfile(file); 
	 }*/
}


public class GenerateHtml {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File path= new File("D:\\learning\\java\\6-092-january-iap-2010\\6-092-january-iap-2010\\contents");
		String father = "Course Home";
		ScanFile myscan = new ScanFile();
		myscan.scanAllFile(path, father);
		Html myhtml = new Html("result.html");
	    myhtml.generateDiscription();
	    myhtml.generateHead("Introduction to Programming in Java!");
	    myhtml.generateHeadOne("Introduction to Programming in Java!");
	    myhtml.unorderListBegin();
	    
	    String key = null;
		 String value = null;
		 Iterator iter = myscan.myMap.keySet().iterator();
		 while(iter.hasNext()){
			 key = (String)iter.next();
			 value = (String)myscan.myMap.get(key);
			 myhtml.generateList(value, key);
		 }
		 myhtml.unorderListEnd();
	    myhtml.close();
		//myscan.printmymap();

	}

}
