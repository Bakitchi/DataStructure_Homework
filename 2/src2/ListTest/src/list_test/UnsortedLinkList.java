//UnsortedLinkList.java 未排序链表
package list_test;

import java.util.Arrays;

public class UnsortedLinkList implements List {
	public Node first; // 定义一个头结点  
    public Node current = null;
    public int size = 0;
    //错误标记（int类型下界）
    private int ERROR = -2147483648;
	public class Node {  
	     protected Node next; //指针域  
	     protected int data;//数据域  
	       
	     public Node( int data) {  
	           this. data = data;  
	     }
	}
	
	public UnsortedLinkList() {
		first = new Node(0);
		//指向自身
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
	            throw new Error("无元素可以删除！");
	     current.next = current.next.next;
	     size --;
	     return x;

	}

	@Override
	public int successor(int x) {
		search(x);
		 if(current.next == first || current.next.next == first)
			 throw new Error("无直接后继！");
		 return current.next.next.data;
	}

	@Override
	public int predecessor(int x) {
		search(x);
		 if(current.next == first || current.next.data == x)
			 throw new Error("无直接前驱！");
		 return current.data;
	}

	@Override
	public int minimum() {
		int min = -ERROR;
		current = first;
		while (current.next != first) {
			if(current.next.data < min) {
				//最小值变更及current指针后移
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
				//最大值变更及current指针后移
				max = current.next.data;
				current = current.next;
			}
		}
		return max;
	}

	@Override
	public int KthElement(int k) {
		if(k <=0 || k > size)
			throw new Error("无第" + k + "大元素！");
        int[] temp = new int[size];
        int i = 0;
        current = first;
        //拷贝到数组
        while(current.next != first)
        {
            temp[i++] = current.next.data;
            current = current.next;
        }
        //排序并查找
        Arrays.sort(temp);
        return temp[size - k];
    }
}

