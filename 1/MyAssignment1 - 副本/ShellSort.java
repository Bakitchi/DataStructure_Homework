//希尔排序
public class ShellSort{
	ShellSort(){

	}
	void sort(int [] array){
		// 选用已知最好的Marcin Ciura步长
		int [] interval = {1750, 701, 301, 132, 57, 23, 10, 4, 1};
		// 从大至小选用间隔
		for(int i = 0; i < interval.length; i++){
		// 对每个间隔进行直接插入排序
			for (int j = interval[i]; j < array.length; j++ ) {
				int temp = array[j];
				for(int k = j; k >= interval[i] && array[k] > temp; k -= interval[i]){
					array[k] = array[k - interval[i]];
					array[k  - interval[i]] = temp;
				}
			}
		}
	}
}