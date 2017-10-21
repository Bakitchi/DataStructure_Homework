//UnsortedArray.java 未排序数组
package list_test;

import java.util.Arrays;
import java.util.Random;

public class UnsortedArray implements List {
	//默认数组大小200
	private int DEFAULT_SIZE = 200;
	private static int size = 0;
	public int[] elementData;
	private static int index = 0;
	//错误标记（int类型下界）
    private int ERROR = -2147483648;
    
	//构造函数
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
        	throw new Error("无第" + k + "大元素！");
		//保存至临时数组
		int[] temp = elementData.clone();
		//对临时数组排序
		Arrays.sort(temp, 0, size);
		return elementData[size - k];
	}

}
