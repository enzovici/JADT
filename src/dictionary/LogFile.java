 package dictionary;

import nodeList.NodePositionList;
import nodeList.PositionList;
import entry.Entry;
import exception.InvalidEntryException;
import exception.InvalidKeyException;
import position.Position;
import map.HashEntry;


public class LogFile<K, V> implements Dictionary<K, V> {
	private PositionList<Entry<K,V>> lista;
	
	
	public LogFile(){
		lista=new NodePositionList<Entry<K,V>>();
	}
	
	/**Restituisce il numero di elementi contenuti nella PriorityQueue**/
	public int size() {
		return lista.size();				//Come contantore di elementi utilizzo il metodo .size della PositionList
	}

	/**Restituisce true se la PQ � vuota altrimenti false**/
	public boolean isEmpty() {
		if(this.size()!=0)
			return false;
		else
			return true;
	}
	
	/**Controlla se la key � valida **/
	private void checkKey(K key)throws InvalidKeyException{
	if(key.equals(null))											//se la key � uguale a nulla allora lancia l'eccezione
		throw new InvalidKeyException("Invalid key");
	}
	
	/** Restituisce un�entry con chiave k; se non c�� restituisce null **/
	public Entry<K, V> find(K key) throws InvalidKeyException {
		this.checkKey(key);						//controlla se la chiave � valida
		for(Entry<K,V> x: lista){				//per ogni Entry contenuta nella lista
			if(x.getKey().equals(key))					//chiede se la chiave dell'Entry corrente � uguale alla chiave dell'Entry passata in input
				return x;									//se � uguale return quella Entry
		}
		return null;							//Se � uscito dal for vuol dire che non ne ha trovata nessuna quindi, ritorna null
	}

	/** Restituisce una collez. it. di tutte le entry di chiave key (se non c��, vuota) */
	public Iterable<Entry<K, V>> findAll(K key) throws InvalidKeyException {
		this.checkKey(key);						//controlla se la chiave � valida
		PositionList<Entry<K,V>> toreturn= new NodePositionList<Entry<K,V>>();				//Creo una PositionList(cio� una lista iterabile di Entry) 
		for(Entry<K,V> x: lista){				//per ogni Entry contenuta nella lista
			if(x.getKey().equals(key))					//chiede se la chiave dell'Entry corrente � uguale alla chiave dell'Entry passata in input
				toreturn.addLast(x);						//se � uguale alla lista(iterabile) assegnamo la chiave corrente
		}
		return toreturn;							//restituisce la lista cosi creata;
	}

	/** Inserisce un�entry nel dizionario e restituisce l�entry creata */
	public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
		HashEntry<K,V> temp= new HashEntry<K,V>(key,value);					//Creo una Entry con i parametri passati in input
		lista.addLast(temp);											//la aggiungo alla lista
		return temp;													//e la restituisco
	}

	/** Cancella e restituisce un�entry dal dizionario */
	@SuppressWarnings("unchecked")
	public Entry<K, V> remove(Entry<K, V> e) throws InvalidEntryException {
		for(Entry<K,V> x: lista){				//per ogni Entry contenuta nella lista
			if(x.equals(e)){						//chiede la Entry passata � uguale alle Entry corrente
				lista.remove((Position<Entry<K, V>>)x);				//la rimuove per� castandola(perch� la NodePositionList contiene Position di Entry)
				return e;
			}
		}
		return null;	
	}

	/** Restituisce una collezione iterabile di tutte le entry del dizionario */
	public Iterable<Entry<K, V>> entries() {
		return lista;
	}

}
