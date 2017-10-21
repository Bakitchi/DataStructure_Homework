// ReverseGenerator.java 逆序数据生成器
public class ReverseGenerator extends DataGenerator{
  int[] generate(int size){
    int[] r = new int[size];
    for (int i = 0; i < size; i++) {
      r[i] = size - i;
    }
    return r;
  }
}
