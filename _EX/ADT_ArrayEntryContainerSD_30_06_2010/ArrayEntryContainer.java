package ADT_ArrayEntryContainerSD_30_06_2010;

import java.util.Comparator;
import priorityQueue.Entry;

/*
 * NOME: FRANCESCO
 * COGNOME: ISERNIA
 * MATRICOLA: 0510201785
 */

@SuppressWarnings("all")
public class ArrayEntryContainer<K, V> implements EntryContainer<K,V>{
	
	private Comparator<K> comp;
	private Entry<K,V>[] listaEntry;
	private int size;
	
	public ArrayEntryContainer(Comparator<K> c) { 
			comp = c;
			listaEntry = (Entry<K,V>[])new Entry[1024];
			size=0;
		  }
	
	
	public int ricercaBinaria(K key,int low,int high){
		
		//caso base dove fermarsi,CHIAVE NON TROVATA
		if(low>high)
			return -1;
		
		if(high==0){
			if(comp.compare(key,listaEntry[high].getKey())== 0)
				return high;
			//non trova niente
			else return -1;
		}
		int media =(low+high)/2;
		
//salvo in una variabile il risultato della comparazione tra la chiave del valore medio e la chiave passata in input 
//al metodo.
		int c= comp.compare(key,listaEntry[media].getKey());
		
//se la chiave della media è uguale alla chiave passata in input al metodo me la restituisce
		if(c == 0)
			return media;
		
//altrimenti se la chiave passata in input al metodo è maggiore della chiave 'media' effettuiamo la ricorsione cambiando 
//i parametri di ricerca: il min da dove iniziare la ricerca è 'media+1' mentre il max è 'high' .
		else if (c == -1)
			return ricercaBinaria(key,media+1,high);
		
//altrimenti se la chiave passata in input al metodo è minore della chiave 'media' effettuiamo la ricorsione cambiando 
//i parametri di ricerca: il min da dove iniziare la ricerca è 'low' mentre il max è 'media-1' .
		else 
			return ricercaBinaria(key,low,media-1);
	}
	
	
	public Entry<K, V> add(K k, V v) {
		
		MyEntry<K,V> en= new MyEntry<K, V>(k, v);
		
		if(size==0){
			listaEntry[0]=en;
			size++;
			return en;
		}
		
		//controlla se la chiave inserita è già presente nell'array,se è presente non l'aggiunge(nn fa niente)
		//evitando di includere chiavi doppie
		if(ricercaBinaria(k,0,size)!=-1)
			return null;
		
		for(int i=0;i<size();i++){
			
			if(comp.compare(k,listaEntry[i].getKey())>=0){
				
				for(int j = size; j>i ;j--)
					listaEntry[j]=listaEntry[j-1];
			
			listaEntry[i]=en;
			size++;
			return en;
			}
		}
		
		listaEntry[size]=en;
		size++;
		return en;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public V remove() {
		V valore = listaEntry[size-1].getValue();
		size--;
		return valore;
	}
	
	public V search(K k) {
		
		int varRicerca = ricercaBinaria(k,0,size);
		if(varRicerca==-1)
			return null;
		
		return listaEntry[varRicerca].getValue();
	}
	
	public int size() {
		return size;
	}
	
	public String toString(){
		String stampa="";
		for(int i=0;i<size();i++){
			stampa+=listaEntry[i].getKey()+"-"+listaEntry[i].getValue()+" ";
		}
		return stampa;
	}


}
