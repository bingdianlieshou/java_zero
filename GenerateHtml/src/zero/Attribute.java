package zero;
/**
 * 用来对描述标签的属性
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
		 * 设置属性的类型
		 * @param key 属性的类型
		 */
		public void SetKey(String key){
			_key = key;
		}
		/**
		 * 设置属性的值
		 * @param value 属性的值
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
