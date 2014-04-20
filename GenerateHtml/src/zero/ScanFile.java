package zero;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import org.apache.log4j.Logger;

/**
 * ������Ҫ���ڽ����ļ������ļ���ȡ��������Ҫ���ļ�
 * @author fengjin.wfj
 *
 */
public class ScanFile {
	
	public ScanFile(){
		_fileNameToUrl = new LinkedHashMap<String, String>(); 
	}
	/**
	 * �ú�����Ҫ�����������ļ�����������Ҫ��index.html�ļ� �Լ����ļ����ڵ�Ŀ¼��
	 * ��������<�ļ�������URL>����ʽ�洢��_fileNameToUrl
	 * @param path  ��Ҫ�������ļ���
	 * @param fatherName    ��Ҫ�������ļ��е�����
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
	 *���ڴ�ӡ�������Ľ��,ͬʱ��ӡ�Ľ��������־�ļ�message.log��
	 */
	public void PrintResult(){
		for(Entry<String,String> entry: _fileNameToUrl.entrySet()){
			log.info(entry.getKey()+"\t"+ entry.getValue());
		}
	}
	/**
	 * ���ؽ����Ľ��
	 */
	public  Set<Entry<String, String>> getResult(){
		return _fileNameToUrl.entrySet();
	}
	/**
	 * ��Ҫ���ڲ���ScanFile��
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
