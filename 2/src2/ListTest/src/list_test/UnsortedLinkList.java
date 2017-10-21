//UnsortedLinkList.java δ��������
package list_test;

import java.util.Arrays;

public class UnsortedLinkList implements List {
	public Node first; // ����һ��ͷ���  
    public Node current = null;
    public int size = 0;
    //�����ǣ�int�����½磩
    private int ERROR = -2147483648;
	public class Node {  
	     protected Node next; //ָ����  
	     protected int data;//������  
	       
	     public Node( int data) {  
	           this. data = data;  
	     }
	}
	
	public UnsortedLinkList() {
		first = new Node(0);
		//ָ������
		first.next = first;
	}
	
	@Override
	public boolean search(int x) {
		current = first;  
        while (current.next != first) {  
            if (current.next.data == x)  
                 return false;  
           current = current. next;  
        }  
        return true;
	}

	@Override
	public boolean insert(int x) {
		Node node = new Node(x);  
        node.next = first;  
        current.next = node;
        size++;
        return true;
	}
	
	@Override
	public int delete(int x) {
		search(x);
		 if(current.next == first)
	            throw new Error("��Ԫ�ؿ���ɾ����");
	     current.next = current.next.next;
	     size --;
	     return x;

	}

	@Override
	public int successor(int x) {
		search(x);
		 if(current.next == first || current.next.next == first)
			 throw new Error("��ֱ�Ӻ�̣�");
		 return current.next.next.data;
	}

	@Override
	public int predecessor(int x) {
		search(x);
		 if(current.next == first || current.next.data == x)
			 throw new Error("��ֱ��ǰ����");
		 return current.data;
	}

	@Override
	public int minimum() {
		int min = -ERROR;
		current = first;
		while (current.next != first) {
			if(current.next.data < min) {
				//��Сֵ�����currentָ�����
				min = current.next.data;
				current = current.next;
			}
		}
		return min;
	}

	@Override
	public int maximum() {
		int max = ERROR;
		current = first;
		while (current.next != first) {
			if(current.next.data > max) {
				//���ֵ�����currentָ�����
				max = current.next.data;
				current = current.next;
			}
		}
		return max;
	}

	@Override
	public int KthElement(int k) {
		if(k <=0 || k > size)
			throw new Error("�޵�" + k + "��Ԫ�أ�");
        int[] temp = new int[size];
        int i = 0;
        current = first;
        //����������
        while(current.next != first)
        {
            temp[i++] = current.next.data;
            current = current.next;
        }
        //���򲢲���
        Arrays.sort(temp);
        return temp[size - k];
    }
}

