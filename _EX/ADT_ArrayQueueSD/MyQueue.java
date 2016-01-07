package ADT_ArrayQueueSD;

import queue.ArrayQueue;

public class MyQueue<E> extends ArrayQueue<E> {
	
	private int index;
	
	public MyQueue(){
		super();
		index=-1;
	}
	
	public int getIndex(){
		return index;
	}
	
	public void setIndex(int i){
		index=i;
	}

}
