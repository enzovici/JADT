package _appelli;

import queue.ArrayQueue;

public class TestExQueue_10_7_12 {
	public static void main(String[] args){
		ArrayQueue<String> coda = new ArrayQueue<String>();
		
		for(int j = 0;j < 10; j++){
			coda.enqueue("" + j);
		}
		/*coda.enqueue("a");
		coda.enqueue("b");
		coda.enqueue("c");
		coda.enqueue("d");
		coda.enqueue("e");
		coda.enqueue("f");
		coda.enqueue("g");
		*/
		System.out.println("Elementi nella coda a partire dal front:\n" + coda);
		
		
		for(String e :ExQueue_10_7_12.lastElts(coda, 4)){
			System.out.print(e + " ");
		}
		
	}
}
