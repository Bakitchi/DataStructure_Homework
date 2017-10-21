//Queue.java 队列类
public class Queue {
	int DEFAULT_SIZE;
    Element[] instance;
    int head = 0;
    int tail = 1;
    
    //构造函数
    Queue()
    {
        DEFAULT_SIZE = 300;
        instance = new Element[DEFAULT_SIZE];
    }
    
    //判断是否空队
    boolean isEmpty() {
        return (head+1) % DEFAULT_SIZE == tail;
    }
    
    //判断是否满队
    boolean isFull() {
        return head == tail;
    }
    
    //入队
    boolean enqueue(Element e) {
        if(isFull()) {
            return false;
        } else{
            instance[tail] = e;
            tail = (tail + 1) % DEFAULT_SIZE;
        }
        return true;
    }
    
    //出队
    Element dequeue() {
        if(isEmpty()) {
            return null;
        }
        else {
            head = (head + 1) % DEFAULT_SIZE;
            return instance[head];
        }
    }
    
    //获得第一个元素
    Element head() {
        if(isEmpty())
            return null;
        else
            return instance[(head + 1) % DEFAULT_SIZE];
    }

}
