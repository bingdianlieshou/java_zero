package zero;
/**
 * ������������ǩ������
 * @author fengjin.wfj
 *
 */
public class Attribute {
		Attribute(){
			_key = null;
			_value = null;
		}
		Attribute(String key, String value){
			_key = key;
			_value = value;
		}
		/**
		 * �������Ե�����
		 * @param key ���Ե�����
		 */
		public void SetKey(String key){
			_key = key;
		}
		/**
		 * �������Ե�ֵ
		 * @param value ���Ե�ֵ
		 */
		public  void SetValue(String value){
			_value = value;
		}
		public String getString(){
			return _value == null ? _key + " = \"" + "\"" :
									_key + " = \"" + _value + "\""; 
		}
		private String _key;
		private String _value;
}
