// SortFunction.java 抽象的排序函数
abstract public class SortFunction implements Timeable {
  DataGenerator gen;
  int[] arr;
  SortFunction(DataGenerator g, int size){
    gen = g;
    arr = gen.generate(size);
  }
  public void reset(){
    validate();
    arr = gen.generate(arr.length);
  }
  public void run(){
    sort(arr);
  }
  public void validate(){
    for (int i = 0; i < arr.length - 1; i++) {
      if(arr[i] > arr[i + 1]){
        for (int j = 0; j < arr.length; j++) {
          System.out.print(arr[j]+" ");
          System.out.println();
        }
        System.out.println(i + " " + arr[i] + " " + arr[i + 1]);
        assert(false);
      }
    }
  }
  abstract void sort(int[] arr);
}