//UnsortedArray.java δ��������
package list_test;

import java.util.Arrays;
import java.util.Random;

public class UnsortedArray implements List {
	//Ĭ�������С200
	private int DEFAULT_SIZE = 200;
	private static int size = 0;
	public int[] elementData;
	private static int index = 0;
	//�����ǣ�int�����½磩
    private int ERROR = -2147483648;
    
	//���캯��
	public UnsortedArray() {
		elementData = new int[DEFAULT_SIZE];
		Random ra = new Random();
		for(; size < DEFAULT_SIZE - 20; size++) {
			elementData[size] = ra.nextInt(200);
		}
	}
	
	@Override
	public boolean search(int x) {
		for(int i = 0; i < size; i++) {
			if(elementData[i] == x) {
				index = i;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean insert(int x) {
		if(size == DEFAULT_SIZE) {
			return false;
		}
		elementData[size++] = x;
		return true;
	}

	@Override
	public int delete(int x) {
		//������Ԫ�ش��ڱ���ʱִ��ɾ��
		while(search(x) && size != 0) {
			int temp = x;
			for(int i = index; i < size; i++) {
				elementData[i - 1] = elementData[i];
			}
			size--;
			return temp;
		}
		if(!search(x)) {
			throw new Error("Ҫɾ���ı��������ڣ�");
		} else{
			throw new Error("����������Ԫ�أ�");
		}
	}

	@Override
	public int successor(int x) {
		//Ѱ��xԪ��
		search(x);
		if(index == size - 1) {
			throw new Error("��Ԫ����ֱ�Ӻ��!");
		} else{
			return elementData[index + 1];
		}
	}

	@Override
	public int predecessor(int x) {
		//Ѱ��xԪ��
		search(x);
		if(index == size - 1) {
			throw new Error("��Ԫ����ֱ��ǰ����");
		} else{
			return elementData[index - 1];
		}
	}

	@Override
	public int minimum() {
		int min = -ERROR;
		for(int i = 0 ; i < size; i++) 
			min = min < elementData[i] ? min : elementData[i];
        return min;
	}

	@Override
	public int maximum() {
		int max = ERROR;
		for(int i = 0 ; i < size; i++) 
			max = max > elementData[i] ? max : elementData[i];
        return max;
	}

	@Override
	public int KthElement(int k) {
		if(k <=0 || k > size)
        	throw new Error("�޵�" + k + "��Ԫ�أ�");
		//��������ʱ����
		int[] temp = elementData.clone();
		//����ʱ��������
		Arrays.sort(temp, 0, size);
		return elementData[size - k];
	}

}
