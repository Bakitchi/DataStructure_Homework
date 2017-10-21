// QuickSort.java 快速排序
import java.util.Random;

public class QuickSort extends SortFunction{
  QuickSort(DataGenerator gen, int size){
    super(gen, size);
  }
  void sort(int[] arr){
    // 调用递归的排序方法
    rsort(arr, 0, arr.length);
  }
  // 递归快速排序
  void rsort(int[] arr, int l, int r){
    // 在元素个数小于等于16时调用插入排序
    if(r - l <= 16){
      isort(arr, l, r);
      return;
    }
    // 随机选取轴值并与第一个元素交换
    Random ran = new Random();
    int pivot = ran.nextInt(r - l);
    int t = arr[l + pivot];
    arr[l + pivot] = arr[l];
    arr[l] = t;
    int cur = l;
    // 选取所有小于轴值的元素放到数组左半部分
    for (int i = l + 1; i < r; i++) {
      if(arr[i] < arr[l]){
        cur++;
        t = arr[cur];
        arr[cur] = arr[i];
        arr[i] = t;
      }
    }
    // 将轴值放到数组中间
    t = arr[cur];
    arr[cur] = arr[l];
    arr[l] = t;
    // 递归对左右两部分进行排序
    rsort(arr, l, cur);
    rsort(arr, cur + 1, r);
  }
  // 插入排序
  void isort(int[] arr, int l, int r){
    for (int cur = l + 1; cur < r; cur++) {
      int t = arr[cur];
      int nxt = cur;
      for (; nxt >= l + 1 && arr[nxt - 1] > t; nxt--) {
        arr[nxt] = arr[nxt - 1];
      }
      arr[nxt] = t;
    }
  }
}