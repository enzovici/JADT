package partition;

import position.Position;
import comparator.DefaultComparator;
import map.HashTableMap;
import map.Map;
import nodeList.NodePositionList;
import nodeList.PositionList;
import set.OrderedListSet;
import set.Set;


public class ListPartition<E> implements Partition <E>{

	protected PositionList<Set <E>> partizione;		//lista di insiemi
	protected Map<E,Set<E>> elementi;
	
	public ListPartition(){
		partizione = new NodePositionList<Set<E>>();
		elementi = new HashTableMap<E,Set<E>>();
	}

	public int size() {
		return partizione.size();
	}

	public boolean isEmpty() {
		return partizione.isEmpty();
	}

	public Set<E> makeSet(E x) {
		OrderedListSet<E> newSet = new OrderedListSet<E>(x,
						new DefaultComparator<E>());
		elementi.put(x, newSet);
		partizione.addLast(newSet);
		/* se abbiamo la variabili location*/
		newSet.setLocation(partizione.last());		//setLocation aggiunge una variabile al nodo che fa riferimento alla posizione dell'insieme nella partizione
		return newSet;
	}

	public Set<E> find(E x) {
		return elementi.get(x);
	}

	public Set<E> union(Set<E> A, Set<E> B) {
		OrderedListSet<E> toAdd = new OrderedListSet<E>();	//Insieme più piccolo
		OrderedListSet<E> AUB = new OrderedListSet<E>();
		
		if(A.size() > B.size()){
			toAdd = (OrderedListSet<E>) B;
			AUB = (OrderedListSet<E>) A;
		}else{
			toAdd = (OrderedListSet<E>)A;
			AUB = (OrderedListSet<E>)B;
		}
		
		Position<Set<E>> toRemove;
		
		//se abbiamo la variabli location
		toRemove = toAdd.location();
		
		/* altrimenti cerchiamo la posizione dell'insime più piccolo */
		PositionList<E> lToAdd = toAdd.getSet(); // aggiorno la mappa  METODO getSet da aggiungere in Orderder che ritorna il set
		for(E element: lToAdd)	//Per ogni elemento della lista lToAdd, lo inserisco nella mappa mediante il metodo put
			elementi.put(element, AUB);
		
		AUB.fastUnion(toAdd);  //toAdd viene svuotato
		partizione.remove(toRemove);	//rimuove l'insieme toAdd dalla partizione 
		return AUB;
	}
	
	
	


}
