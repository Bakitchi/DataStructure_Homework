// MergeSort.java 归并排序
public class MergeSort extends SortFunction{
  MergeSort(DataGenerator gen, int size){
    super(gen, size);
  }
  void sort(int[] arr){
    // 调用递归的排序方法
    rsort(arr, 0, arr.length);
  }
  // 递归归并排序
  void rsort(int[] arr, int l, int r){
    // 在元素个数小于等于16时调用插入排序
    if(r - l <= 16){
      isort(arr, l, r);
      return;
    }
    // 把数组均分，递归进行排序
    rsort(arr, l, (l + r) / 2);
    rsort(arr, (l + r) / 2, r);

    // 申请临时空间
    int[] arr2 = new int[arr.length];
    int arr2p = 0;

    // 归并两个有序数组
    int ls = l, le = (l + r) / 2, es = (l + r) / 2, ee = r;
    while(ls < le && es < ee){
      if(arr[ls] < arr[es]){
        arr2[arr2p++] = arr[ls++];
      }
      else{
        arr2[arr2p++] = arr[es++];
      }
    }
    while(ls < le){
      arr2[arr2p++] = arr[ls++];
    }
    while(es < ee){
      arr2[arr2p++] = arr[es++];
    }

    // 将临时结构拷贝回原数组
    System.arraycopy(arr2, 0, arr, 0, arr.length);
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