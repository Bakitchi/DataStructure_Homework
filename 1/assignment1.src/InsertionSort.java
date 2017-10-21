//InsertionSort.java 直接插入排序
public class InsertionSort extends SortFunction{
  InsertionSort(DataGenerator gen, int size){
    super(gen, size);
  }
  void sort(int[] arr){
    for (int cur = 1; cur < arr.length; cur++) {
      // 在当前值之前的元素都已排序
      int t = arr[cur];
      int nxt = cur;
      // 将所有大于当前值的已排序元素右移
      for (; nxt >= 1 && arr[nxt - 1] > t; nxt--) {
        arr[nxt] = arr[nxt - 1];
      }
      // 将当前值归位
      arr[nxt] = t;
    }
  }
}