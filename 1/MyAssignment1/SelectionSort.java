//选择排序
public class SelectionSort{
	SelectionSort(){

	}
		void sort(int [] array){
		for(int i = 0; i < array.length - 1; i++){
			// 记录最小值索引号及其值
			int low_index = i;
			int low_value = array[i];
			// 遍历数组，寻找最小元素	
			for(int j = i + 1; j < array.length; j++){
				if(array[j] < low_value){
					low_value = array[j];
 					low_index = j;
				}
			}
			// 交换最小值与当前元素
			int temp = array[low_index];
			array[low_index] = array[i];
			array[i] = temp;
		}
	}
}