package ADT_ArrayEntryContainer_SD_12_07_2010;

import java.util.Comparator;
import nodeList.NodePositionList;
import nodeList.PositionList;
import comparator.DefaultComparator;
import entry.Entry;
@SuppressWarnings("all")

public class ArrayEntryContainer<K, V> implements EntryContainer<K,V>{
	
	private Comparator<K> comp;
	private Entry<K,V>[] A;
	private int size;
	private int capacity=100;
	
	public ArrayEntryContainer(Comparator<K> c) { 
		    A = (Entry<K,V>[]) new Entry[capacity];
		    comp =  new DefaultComparator<K>();
		    size = 0;
		  }
	
	public Entry<K, V> add(K k, V v) {
		
		MyEntry<K,V> entry = new MyEntry<K, V>(k, v);
		if(size==0){
			A[size] = entry;
			size++;
			return entry;
		}
		
		for(int i = 0;i<size; i++){
			if(comp.compare(k,A[i].getKey())<=0){
				for(int j =size ; j>i ;j--)
					A[j] = A[j-1];
			
				A[i] = entry;
				size++;
				return entry;
		    }
		}
		
		A[size] = entry;
		size++;
		return entry;
	}
	
	public PositionList<Entry<K, V>> searchAll(K k){
	
		PositionList<Entry<K,V>> lista = new NodePositionList<Entry<K,V>>();
		ricercaBinaria(k,0,size,lista);
		return lista;
	}
	
	public PositionList<V> remove() {
		
		PositionList<V> lista = new NodePositionList<V>();
		
		lista.addLast(A[size-1].getValue());
		int i = 1;
		
		while(comp.compare(A[size-1].getKey(), A[size-i-1].getKey())==0){
			lista.addLast(A[size-i-1].getValue());
			i++;
			//System.out.println("primo incremento: "+i);
		}
		//i++;
		//System.out.println("secondo incremento: "+i);
		//size=size-i;
		size=size-i-1;
		return lista;
	}
	
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size==0;
	}
	
	public String toString(){
		String stampa="";
		
		for(int i=0;i<=size;i++)
			if(A[i]!= null){
				MyEntry<K,V> e = (MyEntry<K, V>) A[i];
				stampa+= e.getKey()+"-"+e.getValue()+" ";
			}	
		
		return stampa;
	}
	
	
	private void ricercaBinaria(K k,int low,int high,PositionList<Entry<K,V>> lista){
		
		if(low>high)
			return;
		
		if(high==0){
			if(comp.compare(k,A[high].getKey())==0){
				lista.addLast(A[high]);
				return;
			}
			else 
				return;
		}
		
		int middle = (low+high)/2;
		int comparazione = comp.compare(k,A[middle].getKey());
		
		// trovo l'elemento, lo aggiungo e continuo a cercare altre entrate
		if(comparazione == 0){
			lista.addLast(A[middle]);
			
			ricercaBinaria(k,middle+1, high,lista);
			ricercaBinaria(k,low,middle-1,lista);
		}
		else 
			if(comparazione > 0)
				ricercaBinaria(k,middle+1,high,lista);
		else 
			ricercaBinaria(k,low,middle-1,lista);		
	}

}