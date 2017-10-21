//≤‚ ‘¥˙¬ÎListTest.java
package list_test;

public class ListTest {

	public static void main(String[] args) {
		SequenceArray a = new SequenceArray(50);
		a.search(52);
		a.minimum();
		a.maximum();
		a.delete(52);
		a.search(52);
		a.insert(52);
		a.successor(100);
		a.predecessor(100);
		a.KthElement(10);
		
		UnsortedArray b = new UnsortedArray();
		b.search(52);
		b.minimum();
		b.maximum();
		b.delete(52);
		b.search(52);
		b.insert(52);
		b.successor(100);
		b.predecessor(100);
		b.KthElement(10);
		
		SortedLinkList c = new SortedLinkList();
		c.insert(100);
		c.insert(300);
		c.insert(400);
		c.search(100);
		c.delete(100);
		c.insert(100);
		c.successor(300);
		c.predecessor(300);
		c.KthElement(2);
		c.maximum();
		c.minimum();
		
		UnsortedArray d = new UnsortedArray();
		d.insert(300);
		d.insert(100);
		d.insert(400);
		d.search(100);
		d.delete(100);
		d.insert(100);
		d.successor(300);
		d.predecessor(300);
		d.KthElement(2);
		d.maximum();
		d.minimum();
		
	}

}
