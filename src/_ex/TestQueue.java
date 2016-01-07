package _ex;

import queue.NodeQueue;

public class TestQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NodeQueue<String> coda = new NodeQueue<String>();
		coda.enqueue("a");
		coda.enqueue("b");
		coda.enqueue("c");
		coda.enqueue("d");
		
		while(!(coda.isEmpty())){
			System.out.println(coda.dequeue());
		}
		
	}

}
