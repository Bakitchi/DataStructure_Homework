public class TestCode{
  public static void main(String[] args) {
    Timer timer = new Timer();
    System.out.println("插入排序 正序");
    for (int t = 100; t <= 10000; t += 100) {
      SortFunction s = new InsertionSort(new SequenceGenerator(), t);
      System.out.println(timer.gettime(s, 100) );
    }
    System.out.println("插入排序 逆序");
    for (int t = 100; t <= 10000; t += 100) {
      SortFunction s = new InsertionSort(new ReverseGenerator(), t);
      System.out.println(timer.gettime(s, 100) );
    }
    System.out.println("插入排序 随机序");
    for (int t = 100; t <= 10000; t += 100) {
      SortFunction s = new InsertionSort(new RandomGenerator(), t);
      System.out.println(timer.gettime(s, 100) );
    }
    System.out.println("选择排序 正序");
    for (int t = 100; t <= 10000; t += 100) {
      SortFunction s = new SelectionSort(new SequenceGenerator(), t);
      System.out.println(timer.gettime(s, 100) );
    }
    System.out.println("选择排序 逆序");
    for (int t = 100; t <= 10000; t += 100) {
      SortFunction s = new SelectionSort(new ReverseGenerator(), t);
      System.out.println(timer.gettime(s, 100) );
    }
    System.out.println("选择排序 随机序");
    for (int t = 100; t <= 10000; t += 100) {
      SortFunction s = new SelectionSort(new RandomGenerator(), t);
      System.out.println(timer.gettime(s, 100) );
    }
    System.out.println("Shell排序 正序");
    for (int t = 100; t <= 10000; t += 100) {
      SortFunction s = new ShellSort(new SequenceGenerator(), t);
      System.out.println(timer.gettime(s, 100) );
    }
    System.out.println("Shell排序 逆序");
    for (int t = 100; t <= 10000; t += 100) {
      SortFunction s = new ShellSort(new ReverseGenerator(), t);
      System.out.println(timer.gettime(s, 100) );
    }
    System.out.println("Shell排序 随机序");
    for (int t = 100; t <= 10000; t += 100) {
      SortFunction s = new ShellSort(new RandomGenerator(), t);
      System.out.println(timer.gettime(s, 100) );
    }
    System.out.println("快速排序 正序");
    for (int t = 100; t <= 10000; t += 100) {
      SortFunction s = new QuickSort(new SequenceGenerator(), t);
      System.out.println(timer.gettime(s, 100) );
    }
    System.out.println("快速排序 逆序");
    for (int t = 100; t <= 10000; t += 100) {
      SortFunction s = new QuickSort(new ReverseGenerator(), t);
      System.out.println(timer.gettime(s, 100) );
    }
    System.out.println("快速排序 随机序");
    for (int t = 100; t <= 10000; t += 100) {
      SortFunction s = new QuickSort(new RandomGenerator(), t);
      System.out.println(timer.gettime(s, 100) );
    }
    System.out.println("归并排序 正序");
    for (int t = 100; t <= 10000; t += 100) {
      SortFunction s = new MergeSort(new SequenceGenerator(), t);
      System.out.println(timer.gettime(s, 100) );
    }
    System.out.println("归并排序 逆序");
    for (int t = 100; t <= 10000; t += 100) {
      SortFunction s = new MergeSort(new ReverseGenerator(), t);
      System.out.println(timer.gettime(s, 100) );
    }
    System.out.println("归并排序 随机序");
    for (int t = 100; t <= 10000; t += 100) {
      SortFunction s = new MergeSort(new RandomGenerator(), t);
      System.out.println(timer.gettime(s, 100) );
    }
  }
}
