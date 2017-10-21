//SortedLinkList.java ����������
package list_test;

public class SortedLinkList extends UnsortedLinkList{
	public boolean insert(int x)
    {
        size++;
        current = first;
        while(current.next != first && current.next.data < x)
            current = current.next;
        Node ins = new Node(0);
        ins.data = x;
        ins.next = current.next;
        current.next = ins;
        return true;
    }
    public int KthNode(int k)
    {
        if(k <=0 || k > size)
        	throw new Error("�޵�" + k + "��Ԫ�أ�");
        Node current = first;
        for(int pos = 0;pos <= size - k;pos++)
            current = current.next;
        return current.data;
    }

}

