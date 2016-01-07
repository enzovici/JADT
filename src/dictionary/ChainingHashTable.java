package dictionary;

import java.util.Comparator;
import java.util.Iterator;

import comparator.DefaultComparator;
import nodeList.NodePositionList;
import nodeList.PositionList;
import entry.Entry;
import exception.InvalidEntryException;
import exception.InvalidKeyException;

public class ChainingHashTable<K, V> implements Dictionary<K, V> {
	protected int size=0, capacity;
	protected LogFile<K,V> A[];
	protected Comparator<K> c;

	@SuppressWarnings("unchecked")
	public ChainingHashTable(){ //aggiungere altri costruttori�
		capacity = 500;
		c = new DefaultComparator<K>();
		A = new LogFile[capacity];
		for (int i=0; i<capacity; i++) 
			A[i] = new LogFile<K,V>();
	}
	
	/**Restituisce una collezzione iterabile di tutte le entry del dizionario**/
	public Iterable<Entry<K, V>> entries() {
		PositionList<Entry<K,V>> lista= new NodePositionList<Entry<K,V>>();					//Crea una lista d'appoggio(che sar� la nostra collezione iterabile)
		Iterator<Entry<K,V>> temp;															//crea un iteratore di Entry
		Entry<K,V> x;																		//Crea un Entry d'appoggio
		for (int i=0; i<capacity; i++){														//Per ogni lista contenuta in A[i] 
			temp=A[i].entries().iterator();															//invochiamo su questa lista il meotodo entries(che restituisce una collezione iterabile di entry) e poi iterator(che crea un iteratore di entry) e cio lo assegnamo a temp(iteratore d'appoggio)
			while(temp.hasNext()){																	//finche l'iteratore ha un successivo
				x=temp.next();																			//nell' Entry d'appoggio inseriamo la entry successiva
				if(!x.equals(null))																		//se la entry � diversa da null
					lista.addLast(x);																		//allora nella nostra lista aggiungiamo tale elemento
			}
		}
			return lista;																	//restituiamo lista
	}

	/**Trova la prima Entry con key uguale a quella passata in input**/
	public Entry<K,V> find(K key) throws InvalidKeyException{
		checkKey(key);
		int i = hashValue(key); //funzione di compressione h(k)=i
		return A[i].find(key); //rimando al metodo applicato sul dizionario conservato in A[h(k)]
	}

	private int hashValue(K key) {
		int i=key.hashCode();
		return i%capacity;
	}

	private void checkKey(K key) {
		if(key.equals(null))											//se la key � uguale a nulla allora lancia l'eccezione
			throw new InvalidKeyException("Invalid key");
	}

	@Override
	public Iterable<Entry<K, V>> findAll(K key) throws InvalidKeyException {
		this.checkKey(key);							//controlla la validit� della key
		int x= this.hashValue(key);					//dentro x assegna il valore hash della key passata in input
		return A[x].entries();						//richiama su A[x](cio� la cella in cui ci sono tutte le chiavi aventi funzione hash=alla funzione hash di key) il metodo entrys(cio� restituisce una iterable di Entry)
	}

	/** Inserisce un�entry nel dizionario e restituisce l�entry creata */
	public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
		this.checkKey(key);							//controlla la validit� della key
		if(size==capacity-1)
			this.rehash();
		int x= this.hashValue(key);					//dentro x assegna il valore hash della key passata in input
		Entry<K,V> e= A[x].insert(key, value);		//richiama su A[x](cio� la cella in cui ci sono tutte le chiavi aventi funzione hash=alla funzione hash di key) l'insert con gli stessi parametri passati in input
		return e;									//restituisce la entry restituita dalla funzione insert
	}

	@SuppressWarnings("unchecked")
	private void rehash() {
		PositionList<Entry<K,V>> temp= (PositionList<Entry<K, V>>) this.entries();			
		Iterator<Entry<K,V>> iter= temp.iterator();												
		Entry<K,V> x;
		capacity=capacity*2;
		
		LogFile<K,V> B[];
		B = new LogFile[capacity];
		
		for (int i=0; i<capacity; i++) 
			B[i] = new LogFile<K,V>();
		
		while(iter.hasNext()){
			x=iter.next();
			int h= this.hashValue(x.getKey());
			B[h].insert(x.getKey(), x.getValue());
			}
		A=B;
	}


	/**Restituisce true se la il dizionario � vuoto altrimenti false**/
	public boolean isEmpty() {
		return this.size()==0;
	}

	/** Cancella e restituisce un�entry dal dizionario */
	public Entry<K, V> remove(Entry<K, V> e) throws InvalidEntryException {
		int x=this.hashValue(e.getKey());					//richiama la funzione hash sulla entry passata in input
		Entry<K,V> temp=A[x].remove(e);						//richiama su A[x](cio� la cella in cui ci sono tutte le chiavi aventi funzione hash=alla funzione hash di key) remove e come parametro il parametro passato in input
		return temp;
		
	}

	/**Restituisce la dimensione del dizionario**/
	public int size() {
		return size;
	}
	
	/**modifica tutte le entry di chiave key con la chiave newKey**/
	public void UpdateKey(K key, K newKey){
		this.checkKey(key);																		//controlla la validit� della key
		this.checkKey(newKey);																	//controlla la validit� della key
		
		PositionList<Entry<K,V>> temp= (PositionList<Entry<K, V>>)this.findAll(key);			//crea una PositionList e gli assegna quello che restituisce il metodo findAll che come parametro prende la vecchia key
		Iterator<Entry<K,V>> iter= temp.iterator();												//crea un iteratore e gli assegna cio che restituisce il metodo iterator invocato sulla lista(temp sopra riempita
		Entry<K,V> x;																			//Crea un Entry d'appoggio
		
		while(iter.hasNext()){																	//finche l'iteratore ha un successivo
			x=iter.next();																			//nella Entry d'appoggio gli assegno il successivo
			this.remove(x);																			//rimuovo questa entry
			this.insert(newKey, x.getValue());														//la inserisco passandogli come input la nuova key, e il vecchio valore
		}
			
	}

}
