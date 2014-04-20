package zero;
import java.util.ArrayList;

/**
 * ��html��ǩ���г���ģ
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
	 * @param type ��ǩ������
	 * @param value ��ǩ��ֵ
	 */
	Item(String type, String value){
		_itemType = type;
		_itemValue = value;
		_attributeArray = new ArrayList<Attribute>();
	}
	/**
	 * 
	 * @param type ����html ��ǩ����
	 */
	public void SetType(String type){
		_itemType = type;
	}
	/**
	 * ���ñ�ǩ��ֵ
	 * @param value ��ǩ��ֵ
	 */
	public void SetValue(String value){
		_itemValue = value;
	}
	public void AddAttrubte(Attribute value){
		_attributeArray.add(value);
	}
	/**
	 *  * ���������ǩ���ַ���
	 */
	public String getString(){	
		return  _itemValue == null ? GetItemStart()  + GetItemEnd():
									GetItemStart() + _itemValue + GetItemEnd();
	}
	
	/**
	 * ��ñ�ǩ��ʼ�ַ���
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
	 * ��ñ�ǩ�Ľ����ַ���
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
