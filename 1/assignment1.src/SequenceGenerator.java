
// SequenceGenerator.java 正序数据生成器
public class SequenceGenerator extends DataGenerator{
  int[] generate(int size){
    int[] r = new int[size];
    for (int i = 0; i < size; i++) {
      r[i] = i;
    }
    return r;
  }