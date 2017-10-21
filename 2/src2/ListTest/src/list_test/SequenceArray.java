//SequenceArray.java 已排序数组
package list_test;

public class SequenceArray implements List {
	//默认数组大小200
	private int DEFAULT_SIZE = 200;
	private static int size = 0;
	public int[] elementData;
	private static int index = 0;
    //以@param firstElement 指定顺序线性表中第一个元素创建一个默认大小的顺序数组
	SequenceArray(int firstElement){
		elementData = new int[DEFAULT_SIZE];
			for(; size < DEFAULT_SIZE - 20; size++) {
				elementData[size] = firstElement;
				firstElement++;
			}
	}
	
	@Override
	//二分法查找
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
				//记录下标
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
			System.out.println(x + "元素不存在");
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
		//将x插入到已排序数组的合适位置
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
		//仅当此元素存在表中时执行删除
		while(search(x) && size != 0) {
			int temp = x;
			for(int i = index; i < size; i++) {
				elementData[i - 1] = elementData[i];
			}
			size--;
			return temp;
		}
		if(!search(x)) {
			throw new Error("要删除的变量不存在！");
		} else{
			throw new Error("数组中已无元素！");
		}
		
	}

	@Override
	public int successor(int x) {
		//寻找x元素
		search(x);
		if(index == size - 1) {
			throw new Error("该元素无直接后继!");
		} else{
			return elementData[index + 1];
		}
	}

	@Override
	public int predecessor(int x) {
		//寻找x元素
		search(x);
		if(index == size - 1) {
			throw new Error("该元素无直接前驱！");
		} else{
			return elementData[index - 1];
		}
	}


	@Override
	public int minimum() {
		while(size != 0) {
			System.out.println("最小元素是" +  this.elementData[0]);
			return  this.elementData[0];
		}
		throw new Error("数组为空！");
	}

	@Override
	public int maximum() {
		while(size != 0) {
			System.out.println("最大元素是" +  this.elementData[size - 1]);
			return this.elementData[size - 1];
		}
		throw new Error("数组为空！");
	}

	@Override
	public int KthElement(int k) {
		if(k > size || k <= 0) {
			throw new Error("无第" + k + "大元素！");
		} else{
			return elementData[size - k];
		}
	}
}
