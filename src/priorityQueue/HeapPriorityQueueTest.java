package priorityQueue;

import java.util.Comparator;
import entry.Entry;
import comparator.DefaultComparator;
import position.Position;

public class HeapPriorityQueueTest {

	public static void main(String[] args) {
	
		@SuppressWarnings("unchecked")
		Comparator c = (Comparator)new DefaultComparator();

		
		HeapPriorityQueue <Integer , String> hpq = new HeapPriorityQueue(c);
		
		hpq.insert(2, "b");
		hpq.insert(3, "c");
		hpq.insert(6, "f");
		hpq.insert(7, "g");
		hpq.insert(4, "d");
		hpq.insert(5, "e");
		hpq.insert(1, "a");
		hpq.insert(3, "c");
		hpq.insert(8, "h");
	
		
		Entry aaa= hpq.min();
		System.out.println(aaa);
		
		Entry bbb= hpq.removeMin();
	//	Entry bbb= hpq.downHeap(2,"bbb");
		System.out.println(bbb);
		
		Entry ccc= hpq.min();
		System.out.println(ccc);
	}

}
