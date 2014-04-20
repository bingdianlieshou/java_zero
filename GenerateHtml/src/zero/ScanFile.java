package zero;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import org.apache.log4j.Logger;

/**
 * 该类主要用于解析文件，从文件中取出我们需要的文件
 * @author fengjin.wfj
 *
 */
public class ScanFile {
	
	public ScanFile(){
		_fileNameToUrl = new LinkedHashMap<String, String>(); 
	}
	/**
	 * 该函数主要用来解析出文件夹里我们需要的index.html文件 以及该文件所在的目录名
	 * 并将其以<文件夹名，URL>的形式存储在_fileNameToUrl
	 * @param path  所要解析的文件夹
	 * @param fatherName    所要解析的文件夹的名字
	 */
	public void ScanAllFile(File path, String fatherName){
		 ArrayList<File> myArray = new ArrayList<File>();
		 
		 for(File item : path.listFiles()){
				if(item.isDirectory()){
					//System.out.println("This is a directory :" + item.getName()); 
					myArray.add(item);
					//scanAllFile(item, item.getName());
				}else if(item.getName().equals("index.htm")){	
				//	System.out.println(fatherName  + "  "+ item.getAbsolutePath());
					_fileNameToUrl.put(fatherName, item.getAbsolutePath());
				}	
			}// end of for
			
		for(int i = 0; i<myArray.size(); ++i ){
			File tp = (File)myArray.get(i);
			ScanAllFile(tp, tp.getName());
		}
	}
	/**
	 *用于打印出解析的结果,同时打印的结果卫衣日志文件message.log中
	 */
	public void PrintResult(){
		for(Entry<String,String> entry: _fileNameToUrl.entrySet()){
			log.info(entry.getKey()+"\t"+ entry.getValue());
		}
	}
	/**
	 * 返回解析的结果
	 */
	public  Set<Entry<String, String>> getResult(){
		return _fileNameToUrl.entrySet();
	}
	/**
	 * 主要用于测试ScanFile类
	 * @param args
	 */
	public static void main(String[] args) {
		File path= new File("D:\\learning\\java\\6-092-january-iap-2010\\6-092-january-iap-2010\\contents");
		String father = "Course Home";
		
		ScanFile myscan = new ScanFile();
		myscan.ScanAllFile(path, father);
		myscan.PrintResult(); 
		
		// TODO Auto-generated method stub

	}
	private Map<String, String> _fileNameToUrl; 
	private static Logger log =  Logger.getLogger(ScanFile.class);
	
}
