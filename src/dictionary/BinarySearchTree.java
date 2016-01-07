package dictionary;

import java.util.Comparator;
import java.util.Iterator;

import nodeList.NodePositionList;
import nodeList.PositionList;
import binaryTree.LinkedBinaryTree;
import comparator.DefaultComparator;
import dictionary.Dictionary;
import entry.Entry;
import exception.InvalidEntryException;
import exception.InvalidKeyException;
import position.Position;



public class BinarySearchTree<K, V> extends LinkedBinaryTree<Entry<K,V>> implements Dictionary<K, V> {
	protected Comparator<K> C; 							// comparator
	protected Position<Entry<K,V>> actionPos; 			//mantiene la location (position)
	protected int numEntries = 0; 						// number of entries
	
	
	/** Creates a BinarySearchTree with a default comparator. */
	public BinarySearchTree() {
		C = new DefaultComparator<K>(); 
		addRoot(null); //perchï¿½ non aumento size???
	} 
	
	/**Costruttore parametrico**/
	public BinarySearchTree(Comparator<K> c) {
		C = c; 
		addRoot(null);
	}
	
	/**Della position passata in input restituisce la key**/
	protected K key(Position<Entry<K,V>> position) { 
		return position.element().getKey();    
		} 
   
	
	/** Dalla position passata in input restituisce il valore */
   protected V value(Position<Entry<K,V>> position) { 
		return position.element().getValue();      
		} 
   
   
   /** Data una position ne restituisce la entry */
   protected Entry<K,V> entry(Position<Entry<K,V>> position) { 
 		return position.element();     
 		} 
   
   
   /**Sostituisce la entry con una nuova entry **/
   protected void replaceEntry(Position <Entry<K,V>> pos, Entry<K,V> ent) { 
		((BSTEntry<K,V>) ent).pos = pos;				//cambia il puntatore a position della entry passata in input con quello contenuto nell'albero
		replace(pos, ent);								//nella position pos cambia l'elemento(cioé la nuova entry)
		}
   
   
   /**Controlla se la key ï¿½ valida**/
   protected void checkKey(K key) throws InvalidKeyException {
	   if(key == null)  								// just a simple test for now
	   throw new InvalidKeyException("null key"); 
	   }
   
   /**Controlla se la entry ï¿½ valida**/
   @SuppressWarnings("unchecked")
   protected void checkEntry(Entry<K,V> ent) throws InvalidEntryException {
	   if(ent == null || !(ent instanceof BSTEntry))           //se la entry è nulla o non è istanza della classe BTSEntry
	   throw new InvalidEntryException("invalid entry");			//lancia l'eccezione
   }
	
   
   /** Cerco k nel sottoalbero radicato in pos: se pos è esterna, k non c'è. */
   protected Position<Entry<K,V>> treeSearch(K key, Position<Entry<K,V>> pos) { 
	   if (isExternal(pos)) 												//se è sentinella key non estite nel sottoalbero radicato in pos
		   return pos; 				
	   else { 
		   		K curKey = this.key(pos); 									//alla chiave corrente assegna la key passata in input
		   		int comp = C.compare(key, curKey); 								//ad un intero assegna il risultato del metodo compare tra key,currkey
		   		if (comp < 0) 													//se è minore di 0
		   			return treeSearch(key, left(pos)); 								// cerca nel sottoalbero sinistro
		   		else 
		   			if (comp > 0) 
		   				return treeSearch(key, right(pos)); 							// cerca nel sottoalbero destro
   return pos; 																// ritorna il nodo dove è stato trovato key
   } 
  }
   
   
   /**Aggiunge a L tutte le entry nel sottoalbero di v con chiave uguale a quella di k**/
   protected void addAll(PositionList<Entry<K,V>> L, Position<Entry<K,V>> v, K k) { 
	   if (isExternal(v)) 									//se v è nodo sentinella(vuoto)
		   return; 
	   Position<Entry<K,V>> pos = treeSearch(k, v); 		//salva la prima entry trovata con chiave k
	   if (!isExternal(pos)) { 								// se la entry non è esterna 
	   	addAll(L, left(pos), k); 								//chiama ricorsivamente nel sottoalbero sinistro
	   	L.addLast(pos.element()); 								// aggiunge nella lista alla fine la entry trovata(per la visita inorder)
	   	addAll(L, right(pos), k);								//chiama ricorsivamente nel sottoalbero sinistro
	   	}
   }
   
   /**Restituisce la dimensione dell BST**/
   public int size() { 
	   return numEntries; 
	   } 
   
   /**Restituisce true se ï¿½ vuota altrimenti false**/
   public boolean isEmpty() { 
	   return size() == 0; 
	 } 
   
   /**Cerca la prima entry con chiave key**/
   public Entry<K,V> find(K key) throws InvalidKeyException { 
	   checkKey(key); 												//Controlla la validita della key passata in input
	   Position<Entry<K,V>> curPos = treeSearch(key, root()); 		//Nella position di Entry assegna la prima occorenza di key (trovata con il metodo treesearch partendo da root)
	   actionPos = curPos; 											// position che contiene la Entry trovata
	   if (isInternal(curPos)) 										//se questo position è interno
		   return entry(curPos); 										//restituisce la entry contenuta nella position
   return null; 													//la ricercaè finita su una foglia
   } 
   
   /**Restituisce la collezione iterabile di tutte le Entry con chave key**/
   public Iterable<Entry<K,V>> findAll(K key) throws InvalidKeyException { 
   checkKey(key); 													// Controlla la validità della key passatan in input
   PositionList<Entry<K,V>> L = new NodePositionList<Entry<K,V>>(); // Crea una Position list'appoggio 
   addAll(L, root(), key);											//si invoca il metodo addAll passando la lista d'appoggio, inziando da root con chiave key
   return L;														//restituisce la lista creata
   }
		
	/**Crea una collezione iterabile di tutte le Entry**/
	public Iterable<Entry<K, V>> entries() {
		PositionList<Position<Entry<K,V>>> temp=new NodePositionList<Position<Entry<K,V>>>();					//Crea una PositionList D'appoggio
		this.postOrderPositions(root, temp);																		//richiama il metodo inorderPosition partendo dalla root
		Iterator<Position<Entry<K,V>>> iter=temp.iterator();													//Ad un iteratore assegna l'iteratore di quella lista
		NodePositionList<Entry<K,V>> lista= new NodePositionList<Entry<K,V>>();									//Crea una lista d'appoggio che poi sarà quella che ritorneremo
		while(iter.hasNext()){																					//finche l'iteratore ha un nuovo elemento
			actionPos=iter.next();																					//nella nostra posizion su cui lavoriamo assegnamo il prossimo elemento
			if(actionPos.element()!=null)																			//se tale elemento è diverso da null(lo facciamo per cancellare i nodi sentinella)
				lista.addLast(actionPos.element());																			//nella lista aggiungiamo l'elemento
		}
		return lista;																							//restituiamo tale lista
		
	}


	/**Inserisce l'Entry e nel nodo sentinella v, e espande con i due figli sentinella**/
	protected Entry<K,V> insertAtExternal(Position<Entry<K,V>> v, Entry<K,V> e) {
		expandExternal(v,null,null); 		//ATTENZIONE: CREO EFFETTIVAMENTE DUE NODI CON INFORMAZIONE null(metodo creato per estendere con due figli un dato nodo)
		replace(v, e); 						//sostituisce il nodo sentinella(null) con la entry
		numEntries++;						//incrementa il numero degli elementi
		return e;							//e ritorna questa entry
	}
	
	/**Inserisce(rispettando struttura) del BST**/
	public Entry<K,V> insert(K k, V x) throws InvalidKeyException { 
		checkKey(k); 														// Controlla la validità della key
		Position<Entry<K,V>> insPos = treeSearch(k, root()); 				//Nella position di entry inseriamo la prima occorrenza trovata con treesearch invocata su k e dal nodo(o null)
		while (!isExternal(insPos)) 										//finche la position d'appoggio non è esterna 
			insPos = treeSearch(k, left(insPos)); 								//continua a cercare entry con chiave k sul sottoalbero sinistro del nodo trovato precedentemente
		actionPos = insPos; 												// Position dove si ferma la ricerca(cioé la sentinella che si trova nella posizione giusta per il nuovo elemento, perché a sinistra ci sono i minori uguali)
		return insertAtExternal(insPos, new BSTEntry<K,V>(k, x, insPos)); 	//Aggiunge la entry creata nella posizione dell'ex nodo sentinella
	}
	
	

	/** Metodo per cancellare un nodo esterno e suo padre */
	protected void removeExternal(Position<Entry<K,V>> v) {
	removeAboveExternal(v); 
	numEntries--;
	}

	/**Rimuove la entry passata in input, e la restituisce**/
	public Entry<K,V> remove(Entry<K,V> ent) throws InvalidEntryException { 
		checkEntry(ent); 													//controlla la validità dell'entry
		Position<Entry<K,V>> remPos = ((BSTEntry<K,V>) ent).position();		//dentro una Position d'appoggio inserisce la position di se stessa 
		Entry<K,V> toReturn = this.entry(remPos); 							//entry da eliminare
		
		if (isExternal(left(remPos))) 										//controlla se il figlio sinistro é esterno
			remPos = left(remPos); 												//dentro una position inserisce la sentinella da rimuovere con il padre(cioé il nodo valido)
			else 
				if (isExternal(right(remPos))) 									// controlla se il figlio destro é esterno
					remPos = right(remPos); 										//dentro una position inserisce la sentinella da rimuovere con il padre(cioé il nodo valido)
		else { 														// se arriva a questo punto la nostra entry passata in input ha un figlio interno
			Position<Entry<K,V>> swapPos = remPos; 							// in un nodo d'appoggio salva la entry passata in input da eliminare
			remPos = right(swapPos); 										//nella posizione da eliminare inserisce il figlio destro della swap position(cioïé verso quelli maggiori di lui)
			do 
				remPos = left(remPos); 							//scendo a sinistra finché posso(cerca il più piccolo nel sottoalbero destro cioé il suo successore)(
			while (isInternal(remPos)); 						//per questo while mi fermo nella sentinella sinistra del nodo passato in input
		
			replaceEntry(swapPos, (Entry<K,V>) parent(remPos).element()); 		//scambia la entry dentro swapost(cioé da eliminare) con il successore (cioé il padre del nodo trovato dal while precdente)
		} 
		
		removeExternal(remPos); 								//elemina la sentinella e il suo padre(cioé il duplicato salvato in swappost(il successore di quello da eliminare))
		return toReturn; 
		}


	/**Restituisce il primo elemento dell'albero(quello con la key piï¿½ piccola)**/
	public Entry<K, V> first() {
		actionPos=this.root();													//Ad actionpos(Entry d'appoggio) assegnamo la root
		while(!this.isExternal(actionPos))										//finche anctionpos non è esterno
			actionPos=this.left(actionPos);										//Ad action pos assegnamo il suo figlio sinistro(seguendo la struttra de BST, a sinistra ci sarà il più piccolo)
		return this.parent(actionPos).element();								//Appena usciti dal while ci troveremo nel nodo sentinella figlio dell'entry con key più piccolo quindi restituiremo il padre
	}

	/**Restituisce il primo elemento dell'albero(quello con la key piï¿½ grande)**/
	public Entry<K, V> last() {
		actionPos=this.root();													//Ad actionpos(Entry d'appoggio) assegnamo la root
		while(!this.isExternal(actionPos))										//finche anctionpos non è esterno
			actionPos=this.right(actionPos);									//Ad action pos assegnamo il suo figlio destro(seguendo la struttra de BST, a destra ci sarà il più grande)
		return this.parent(actionPos).element();								//Appena usciti dal while ci troveremo nel nodo sentinella figlio dell'entry con key più½ grande quindi restituiremo il padre
	}

//	/**Restituisce un iterable contenente tutti i predecessori della Entry avente chiave key**/
//	public Iterable<Entry<K, V>> predecessors(K key) {
//		Entry<K,V> min=this.find(key);																//Dentro una entry d'appoggio inseriamo la entry con key passata in input
//		PositionList<Position<Entry<K,V>>> temp=new NodePositionList<Position<Entry<K,V>>>();		//Creaiamo una PositionList di Position di entry d'appoggio
//		this.inorderPositions(this.root(), temp);													//invochaimo il meotodo in order sulla root(cosi avremmo una lista ordinata di tutti gli elementi)
//		NodePositionList<Entry<K,V>> lista= new NodePositionList<Entry<K,V>>();						//Creiamo una PositionList di Entry
//		Iterator<Position<Entry<K,V>>> iter=temp.iterator();										//Creiamo e inizializziamo un iteratore della lista contentente tutti i predecessori
//		while(iter.hasNext()){																		//finchè l'iteratore ha un successivo
//			actionPos=iter.next();																		//ad actionpos assegnamo l'elemento successivo
//			if(actionPos!=null && (C.compare(actionPos.element().getKey(), min.getKey())<=0))				//se tale elemento è diverso da null(per evitare i nodi sentinella) ed è minore/uguale della entry min(quella trovata con il metodo key) allora è un predecessore
//				lista.addLast(actionPos.element());																//inseriamo nella lista actionPos.element() cioè la entry contenuta nella position
//		}
//		return lista;																				//restituisce la lista
//		
//	}
//
//	/**Restituisce un iterable contenente tutti i sucessori della Entry avente chiave key**/
//	public Iterable<Entry<K, V>> successors(K key) {
//		Entry<K,V> min=this.find(key);																//Dentro la nostra variabile di lavoro inseriamo il figlio destro della Entry trovata con la key passata in input
//		PositionList<Position<Entry<K,V>>> temp=new NodePositionList<Position<Entry<K,V>>>();		//Creaiamo una PositionList di Position di entry d'appoggio
//		this.inorderPositions(this.root(), temp);													//invochaimo il meotodo in order su actionPos(cioé il figlio destro, in questo modo avremo una lista contentente le Position di entry con chiave piï¿½ grande di quella passsata in input cioï¿½ i successori)
//		NodePositionList<Entry<K,V>> lista= new NodePositionList<Entry<K,V>>();						//Creiamo una PositionList di Entry
//		Iterator<Position<Entry<K,V>>> iter=temp.iterator();										//Creiamo e inizializziamo un iteratore della lista contentente tutti i successori
//		while(iter.hasNext()){																		//finché l'iteratore ha un successivo
//			actionPos=iter.next();																		//ad actionpos assegnamo l'elemento successivo
//			if(actionPos!=null && (C.compare(actionPos.element().getKey(), min.getKey())>0))				//se tale elemento é diverso da null(per evitare i nodi sentinella)  ed è maggire della entry min(quella trovata con il metodo key) allora è un successore
//				lista.addLast(actionPos.element());															//inseriamo nella lista actionPos.element() cioé la entry contenuta nella position
//		}
//		return lista;																				//restituisce la lista
//		}
//	
//	/**Restituisce il precesessore della Entry avente chiave key**/
//	public Entry<K,V> predecessor(K key){
//		PositionList<Entry<K,V>> lista=(PositionList<Entry<K, V>>) this.predecessors(key);			//invochiamo predecessors per ricavare la lista dei predecessori dell'entry di chiave key
//		return lista.last().element();																//per come è fatto l'output di predecessors() l'ultimo elemento è il predecessore più grande
//	}
//	
//	/**Restituisce il succesessore della Entry avente chiave key**/
//	public Entry<K,V> successor(K key){
//		PositionList<Entry<K,V>> lista=(PositionList<Entry<K, V>>) this.successors(key);			//invochiamo successors per ricavare la lista dei successori dell'entry di chiave key
//		return lista.last().element();																//per come è fatto l'output di successors() l'ultimo elemento è il successore più grande
//	}
//	
	public int conta_nodi_interni(Position<Entry<K,V>> p){
		int contadestra=0;
		int contasinistra=0;
		if(this.isExternal(p))
			return 0;
		if(this.hasLeft(p))
			contasinistra=1+conta_nodi_interni(this.left(p));
		if(this.hasRight(p))
			contadestra=1+conta_nodi_interni(this.right(p));
		return contadestra+contasinistra-1;
	}
	
	
	public Position<Entry<K,V>> seleziona(Position<Entry<K,V>> p, int k){
		int t=0;
		Position<Entry<K,V>> pos = null;
		
		if(this.isExternal(p))
			return null;
		
		if(this.hasLeft(p))
			t=conta_nodi_interni(this.left(p));
		
		if(k==t)
			return p;
		
		if(k<t)
			pos= seleziona(this.left(p),k);
		else
			if(k>t)
				pos= seleziona(this.right(p),k-t-1);
		return pos;
		
	}
	
	
	
}

