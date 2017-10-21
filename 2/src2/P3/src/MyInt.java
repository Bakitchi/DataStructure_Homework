//MyInt.java 整型数类
public class MyInt implements Element{
	
	//构造函数
	int num;
    MyInt(int num) {
        this.num = num;
    }
	    
	@Override
	public int numAt(int pos) {
		//临时变量
		int temp = num;
        while(pos > 0) {
            temp /= 10;
            pos--;
        }
        return temp % 10;
	}

	@Override
	public int length() {
		int count = 0;
        int tem = num;
        while(tem > 0) {
            count ++;
            tem /= 10;
        }
        return count;
	}
}
