package queue;

public class TestQueue {
	
	public static void main(String[] args){
	int i;
	ArrayQueue<Integer> a = new ArrayQueue<Integer>();
	ArrayQueue<Integer> b = new ArrayQueue<Integer>();
	ArrayQueue<Integer> c = new ArrayQueue<Integer>();
	
	for(i=1;i<=30;i++){
		a.enqueue(i);
	}
	System.out.println("A: " + a.toString());
	System.out.println("l'ultimo inserito di A è " + a.Last());
	
	//faccio un clone
	b = (ArrayQueue<Integer>) a.clone();
	System.out.println("B: " + b.toString());
	System.out.println("A dopo il clone: " + a.toString());
	
	//proviamo l'equal del clone
	System.out.println("A == B? " + a.equal(b));
	System.out.println("A dopo l'equal: " + a.toString());
	c = (ArrayQueue<Integer>) a.clone();
	c.dequeue();
	System.out.println("C: " + c.size());
	
	System.out.println("A == C con una dequeue()? " + a.equal(c));
	
	System.out.println("Elemento posizione 5 di A: " + a.extract(5));
	System.out.println("A dopo l'extract: " + a.toString());
	
	ArrayQueue<Character> d = new ArrayQueue<Character>();
	d.enqueue('A');
	d.enqueue('B');
	System.out.println("D Normale: " + d.toString());
	d.Reverse();
	System.out.println("D invertito: " + d.toString());
	
	}
}
