// Timer.java 计时器
public class Timer{
  long gettime(Timeable c, int testtime){
    long cnt = 0;
    for (int i = 0; i < testtime; i++) {
      long st = System.nanoTime();
      c.run();
      long ed = System.nanoTime();
      cnt += ed - st;
      c.reset();
    }
    return cnt / testtime;
  }
}