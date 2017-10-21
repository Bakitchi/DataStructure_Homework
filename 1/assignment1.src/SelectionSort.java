// SelectionSort.java 选择排序
public class SelectionSort extends SortFunction{
  SelectionSort(DataGenerator gen, int size){
    super(gen, size);
  }
  void sort(int[] arr){
    for (int i = 0; i < arr.length; i++) {
      // 初始化当前最小元素及其位置
      int curm = arr[i];
      int curmi = i;
      // 遍历数组，寻找最小元素
      for (int j = i + 1; j < arr.length; j++) {
        if(arr[j] < curm){
          curm = arr[j];
          curmi = j;
        }
      }
      // 将当前元素与最小元素交换
      int t = arr[i];
      arr[i] = arr[curmi];
      arr[curmi] = t;
    }
  }
}