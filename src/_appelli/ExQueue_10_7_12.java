package _appelli;


import arrayList.ArrayIndexList;
import nodeList.NodePositionList;
import nodeList.PositionList;
import queue.Queue;

public class ExQueue_10_7_12 {
	
	public static <E> Iterable<E> lastElts(Queue<E> Q, int i){
		int num;
		int cur = 0;
		
		ArrayIndexList<E> coll = new ArrayIndexList<E>();
		
		if(i > Q.size()){
			i = Q.size();
			num = 0;
		}else{
			num = Q.size() - i;
		}
		
		
		while(cur < Q.size()){
			E tmp = Q.dequeue();
			if(num == 0){
				//prendo gli elementi dalla coda e li metto nell'ArrayIndexList
				coll.add(0,tmp);
				
			}else{
				num--;
			
			}
			Q.enqueue(tmp);
			
			cur++;
			
		}
		
		return (Iterable<E>) coll;
	}
}
