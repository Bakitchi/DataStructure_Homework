//直接插入排序
public class InsertionSort{
	void sort(int [] array){
		for(int curr = 1; curr < array.length; curr++){
			int temp = array[curr];
			//	较大元素右移
			for(int next = curr; next > 0 && array[next - 1] > array[next]; next--){
			//	交换位置
				array[next] = array[next - 1];
				array[next - 1] = temp;
			}
		}
	}
}