//Queue.java ������
public class Queue {
	int DEFAULT_SIZE;
    Element[] instance;
    int head = 0;
    int tail = 1;
    
    //���캯��
    Queue()
    {
        DEFAULT_SIZE = 300;
        instance = new Element[DEFAULT_SIZE];
    }
    
    //�ж��Ƿ�ն�
    boolean isEmpty() {
        return (head+1) % DEFAULT_SIZE == tail;
    }
    
    //�ж��Ƿ�����
    boolean isFull() {
        return head == tail;
    }
    
    //���
    boolean enqueue(Element e) {
        if(isFull()) {
            return false;
        } else{
            instance[tail] = e;
            tail = (tail + 1) % DEFAULT_SIZE;
        }
        return true;
    }
    
    //����
    Element dequeue() {
        if(isEmpty()) {
            return null;
        }
        else {
            head = (head + 1) % DEFAULT_SIZE;
            return instance[head];
        }
    }
    
    //��õ�һ��Ԫ��
    Element head() {
        if(isEmpty())
            return null;
        else
            return instance[(head + 1) % DEFAULT_SIZE];
    }

}
