package ADT_ArrayQueueSD;

import position.PositionList;
import queue.*;

public class ArrayQueueContainerTester {

	public static void main(String[] args) {

		
		ArrayQueueContainer<Integer> array = new ArrayQueueContainer<Integer>();
		
		Queue<Integer> q1 = array.insert(5);
		array.enqueue(q1,1);
		array.enqueue(q1,2);
		array.enqueue(q1,4);
		
		
		Queue<Integer> q2 = array.insert(3);
		array.enqueue(q2,1);
		array.enqueue(q2,2);
		array.enqueue(q2,4);
		array.enqueue(q2,6);
		array.enqueue(q2,7);
		array.enqueue(q2,12);
		
		
		Queue<Integer> q3 = array.insert(1);
		array.enqueue(q3,7);
		array.enqueue(q3,12);
		
		Queue<Integer> q4 = array.insert(5);
		array.enqueue(q4,77);
		
		
		System.out.println("Elementi contenuti nell' array:\n"+array.toString());
		
		
		PositionList<Queue<Integer>> lista=array.searchAll(5);
		
		for(Queue<Integer> q : lista){
			ArrayQueue<Integer> coda = (ArrayQueue<Integer>) q;
			System.out.println("Coda avente front = 5 : "+coda.toString());
		}
		
		array.remove();
		System.out.println("Rimuovo la coda avente front maggiore: "+array.toString());
		
		array.remove2(q3);
		System.out.println("Rimuovo la coda q3: "+array.toString());
		
		array.dequeue(q2);
		System.out.println("Rimuovo la coda q2: "+array.toString());
		
		
	}

}
