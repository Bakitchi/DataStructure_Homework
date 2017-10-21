//���Ա�ӿ�����List.java
package list_test;

public interface List {
	boolean search(int x);
	boolean insert(int x);
	int delete(int x);
	int successor(int x);//��ø����Ա��� x Ԫ�ص�ֱ�Ӻ��Ԫ��
	int predecessor(int x);//��ø����Ա��� x Ԫ�ص�ֱ��ǰ��Ԫ��
	int minimum();//��ø����Ա����СԪ��
	int maximum();//��ø����Ա�����Ԫ��
	int KthElement(int k);//������Ա��е� k ��Ԫ�أ�����Ϊָ���� k ֵ�Ĵ�С
}
