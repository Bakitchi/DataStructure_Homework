////MyInt.java �ַ�����
public class MyStr implements Element {
	
	//���캯��
	String str;
    MyStr(String str) {
        this.str = str;
    }

	@Override
	public int numAt(int pos) {
		int len = str.length();
        if(pos >= len)
            return 0;
        else
            return str.charAt(len-1-pos) - 'a';
	}

	@Override
	public int length() {
		return str.length();
	}

}
