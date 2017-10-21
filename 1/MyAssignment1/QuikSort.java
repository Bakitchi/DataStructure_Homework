//快速排序（递归实现）
import java.util.Random;

public class QuickSort{
	QuickSort(){

	}
	void sort(int [] array){
		// 调用递归
		subSort(array, 0, array.length - 1);
	}
	void subSort(int [] array, int start, int end){
		// 随机选取轴值索引pivot
		Random r = new Random();
		// 利用Random类的nextInt()函数生成超出数组下标的随机正整数
		int pivot = r.nextInt(end);
		// 交换轴值与最后一个元素
		int temp = array[end];
		array[end] = array[start + pivot];
		array[start + pivot] = temp;
		// 将大于轴值的元素放在数组的右半边
		int curr = end;
		for (int i = end - 1; i > start; i--) {
      if(array[i] > arr[end]){
        curr--;
        temp = array[curr];
        array[curr] = array[i];
        array[i] = temp;
      }
    }
    // 将轴值居中
    temp = array[end];
    array[end] = array[curr];
    array[curr] = temp;
    // 递归调用对左右两部分排序
    subSort(array, start, curr);
    subSort(array, curr + 1, end);
	}
}