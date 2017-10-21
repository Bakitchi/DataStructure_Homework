
public class Test3 {

	public static void main(String[] args) {
		MyInt a = new MyInt(10);
		MyStr b = new MyStr("abc");
		
		BuketSort .bucket_sort(a, 0);
		BuketSort .bucket_sort(b, 1);
	}

}
