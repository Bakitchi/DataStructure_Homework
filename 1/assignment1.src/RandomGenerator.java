// RandomGenerator.java 随机数据生成器
import java.util.Random;

public class RandomGenerator extends DataGenerator{
  int[] generate(int size){
    int[] r = new int[size];
    Random ran = new Random();
    ran.setSeed(System.currentTimeMillis());
    for (int i = 0; i < size; i++) {
      r[i] = ran.nextInt();
    }
    return r;
  }
}