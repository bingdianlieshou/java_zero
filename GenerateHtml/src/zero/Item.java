package zero;
import java.util.ArrayList;

/**
 * 对html标签进行抽象建模
 * @author fengjin.wfj
 *
 */
public class Item {
	 
	Item(){
		_itemType = null;
		_itemValue = null;
		_attributeArray = new ArrayList<Attribute>();
	}
	/**
	 * 
	 * @param type 标签的类型
	 * @param value 标签的值
	 */
	Item(String type, String value){
		_itemType = type;
		_itemValue = value;
		_attributeArray = new ArrayList<Attribute>();
	}
	/**
	 * 
	 * @param type 设置html 标签类型
	 */
	public void SetType(String type){
		_itemType = type;
	}
	/**
	 * 设置标签的值
	 * @param value 标签的值
	 */
	public void SetValue(String value){
		_itemValue = value;
	}
	public void AddAttrubte(Attribute value){
		_attributeArray.add(value);
	}
	/**
	 *  * 获得完整标签的字符串
	 */
	public String getString(){	
		return  _itemValue == null ? GetItemStart()  + GetItemEnd():
									GetItemStart() + _itemValue + GetItemEnd();
	}
	
	/**
	 * 获得标签开始字符串
	 * @return
	 */
	public String GetItemStart(){
		String attribute = " " ;
		for(int i = 0; i< _attributeArray.size();++i){
			attribute +=((Attribute)_attributeArray.get(i)).getString()+" " ;		 
		}
		return _beforeAngleBrackets + _itemType + attribute +_afterAngleBrackets ;
	}
	/**
	 * 获得标签的结束字符串
	 * @return
	 */
	public String GetItemEnd(){
		return  _beforeAngleBrackets + _slash +_itemType + _afterAngleBrackets ;
	}
	
	private static String _beforeAngleBrackets =  "<";
	private static String _afterAngleBrackets = ">";
	private static String _slash = "/";
	private String _itemType;
	private String  _itemValue;
	private ArrayList<Attribute> _attributeArray;
	
}
