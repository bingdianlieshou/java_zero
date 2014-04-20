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
	 * ����HTML�ĵ���˵������ �ĵ��汾 �����
	 * @param value ���ĵ�˵��
	 */
	public void SetDescription(String value){
		_description = value;	
	}
	/**
	 * ���ãȣԣͣ��ĵ���head���֣� ����head���ڲ�Ԫ���� �Լ�tittle�Ĵ�����һ��������item�����д���
	 * @param value �� ��ӦHTML�ĵ���head����
	 */
	public void Sethead(Item value){
		_head = value;
	}
	/**
	 * Ϊ�ĵ���������һ��
	 * @param e ��  һ����ǩ
	 */
	public void addItem(Item  e){
		_itemArray.add(e);
	}
	/**
	 * ����ĵ����ַ�������
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
