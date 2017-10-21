// ShellSort.java 希尔排序
public class ShellSort extends SortFunction{
  ShellSort(DataGenerator gen, int size){
    super(gen, size);
  }
  void sort(int[] arr){
    // 使用Marcin间隔序列
    int[] gaps = new int[]{701, 301, 132, 57, 23, 10, 4, 1};
    for(int i = 0; i < gaps.length; i++){
      // 对每个间隔进行一次插入排序
      for(int j = gaps[i]; j < arr.length; j++){
        int t = arr[j];
        int k = j;
        for( ; k >= gaps[i] && arr[k - gaps[i]] > t; k -= gaps[i]){
          arr[k] = arr[k - gaps[i]];
        }
        arr[k] = t;
      }
    }
  }
}