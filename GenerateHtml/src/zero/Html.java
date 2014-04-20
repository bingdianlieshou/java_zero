package zero;
import java.util.ArrayList;
import java.lang.StringBuilder;
public class Html {
	private String _description ;
	private Item  _head;
	private ArrayList<Item> _itemArray;
	private static String nextline = "\n";
	public Html(){
		_description = new String("<!DOCTYPE html>");
		_head = null;
		_itemArray = new ArrayList<Item>();
	}
	/**
	 * 设置HTML文档的说明部分 文档版本 字体等
	 * @param value ：文档说明
	 */
	public void SetDescription(String value){
		_description = value;	
	}
	/**
	 * 设置ＨＴＭＬ文档的head部分， 关于head的内部元数据 以及tittle的处理当做一个完整的item来进行处理
	 * @param value ： 对应HTML文档的head部分
	 */
	public void Sethead(Item value){
		_head = value;
	}
	/**
	 * 为文档主体增加一项
	 * @param e ：  一个标签
	 */
	public void addItem(Item  e){
		_itemArray.add(e);
	}
	/**
	 * 获得文档的字符串主体
	 * @return
	 */
	public String  getString(){
		StringBuilder res = new StringBuilder();
		res.append(_description + nextline);
		res.append("<html>" + nextline);
		res.append(_head.getString());
		res.append("<body>"+nextline);
		for(int i = 0; i < _itemArray.size(); ++i){
			res.append(_itemArray.get(i).getString() + nextline) ;
		}
		res.append("</body>"+nextline);
		res.append("</html>"+nextline);
		return res.toString();
	}
}
