//SequenceArray.java ����������
package list_test;

public class SequenceArray implements List {
	//Ĭ�������С200
	private int DEFAULT_SIZE = 200;
	private static int size = 0;
	public int[] elementData;
	private static int index = 0;
    //��@param firstElement ָ��˳�����Ա��е�һ��Ԫ�ش���һ��Ĭ�ϴ�С��˳������
	SequenceArray(int firstElement){
		elementData = new int[DEFAULT_SIZE];
			for(; size < DEFAULT_SIZE - 20; size++) {
				elementData[size] = firstElement;
				firstElement++;
			}
	}
	
	@Override
	//���ַ�����
	public boolean search(int x) {
		boolean flag = true;
		int start = 0;
		int end = size;
		while(x < elementData[size - 1] && x > elementData[0] && start < end) {
			int mid = (start + end) / 2;
			if(x < elementData[mid]) {
				end = mid - 1;
			} else if(x > elementData[mid]){
				start  = mid + 1;
			} else{
				flag = true;
				//��¼�±�
				index = mid;
				return flag;
			}
		}
		if(x == elementData[0]){
			flag = true;
			index = 0;
			return flag;
		} else{
			flag = false;
			System.out.println(x + "Ԫ�ز�����");
			return flag;
		}
	}

	@Override
	public boolean insert(int x) {
		if(size == DEFAULT_SIZE) {
			return false;
		}
		if(size == 0) {
			elementData[size++] = x;
			return true;
		}
		//��x���뵽����������ĺ���λ��
		for(int i = size-1; i >= 0; i--) {
			if(elementData[i] > x) {
				elementData[i + 1] = elementData[i];
			} else{
				elementData[i + 1] = x;
				break;
			}
		}
		size++;
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
		while(size != 0) {
			System.out.println("��СԪ����" +  this.elementData[0]);
			return  this.elementData[0];
		}
		throw new Error("����Ϊ�գ�");
	}

	@Override
	public int maximum() {
		while(size != 0) {
			System.out.println("���Ԫ����" +  this.elementData[size - 1]);
			return this.elementData[size - 1];
		}
		throw new Error("����Ϊ�գ�");
	}

	@Override
	public int KthElement(int k) {
		if(k > size || k <= 0) {
			throw new Error("�޵�" + k + "��Ԫ�أ�");
		} else{
			return elementData[size - k];
		}
	}
}
