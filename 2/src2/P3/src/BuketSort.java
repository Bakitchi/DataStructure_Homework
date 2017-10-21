//BucketSort.java »ùÊýÅÅÐò
public class BuketSort {
		public void bucket_sort (Element[] instance, int tag) {
		    int len = instance.length;
		    Queue[] q;
		    int max_q = 0;
		    int MAX_SIZE = 0;
		    if(tag == 0)
		        max_q = 10;
		    else
		        max_q = 26;
		    q = new Queue[max_q];
		    for(int i = 0;i < max_q;i++) q[i] = new Queue();
		    for(int i = 0;i < len;i++) MAX_SIZE = MAX_SIZE > instance[i].length() ? MAX_SIZE : instance[i].length();
		    for(int pos = 0;pos < MAX_SIZE;pos++)
		    {
		        for(int temp = 0;temp < len;temp++)
		            q[instance[temp].numAt(pos)].enqueue(instance[temp]);
		        int cur = 0;
		        for(int index = 0;index < max_q;index++)
		            while(!q[index].isEmpty()) instance[cur++] = q[index].dequeue();
		    }
		}
}
