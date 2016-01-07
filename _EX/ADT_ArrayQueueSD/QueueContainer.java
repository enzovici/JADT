package ADT_ArrayQueueSD;

import position.PositionList;
import queue.Queue;

public interface QueueContainer<E> {


	/** inserisce una nuova coda vuota nel contenitore restituendola in output.*/
	public Queue<E> insert(E elem);
	
	/** fa un enqueue dell’elemento e sulla coda Q.*/
	public Queue<E> enqueue(Queue<E> Q, E e);
	
	/** fa un dequeue sulla coda Q e restituisce l’elemento rimosso. */
	public E dequeue(Queue<E> Q);
	
	/** rimuove dal contenitore la coda il cui front `e il pi`u piccolo fra tutti i front delle
	  * code presenti nel contenitore. In caso di pi`u code con lo stesso front minimo, se ne rimuova 
	  * una qualsiasi fra queste. Il confronto fra i front delle code dovr`a essere eseguito usando il comparatore
	  */
	public void remove();
	
	public void remove2(Queue<E> q);
	
	public PositionList<Queue<E>> searchAll(E elem);
	
	public int size();
	
	public boolean isEmpty();
	
}
