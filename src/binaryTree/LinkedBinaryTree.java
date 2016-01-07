package binaryTree;

import java.util.Iterator;

import nodeList.NodePositionList;
import nodeList.PositionList;
import exception.BoundaryViolationException;
import exception.InvalidPositionException;
import position.Position;
import exception.EmptyTreeException;
import exception.NonEmptyTreeException;


public class LinkedBinaryTree<E> implements BinaryTree<E> {

	protected BTPosition<E> root;		// radice dell'albero
	public int size;				// dimensione dell'albero
	
	/** Costruttore di un Albero binario */
	public LinkedBinaryTree(){
		root = null;
		size = 0;
	}
	
	/** Ritorna true o false a seconda che il nodo di posizione v ha un figlio sinistro o no
	 * @param v		la posizione da controllare
	 * @return 		true se ha un figlio sinistro, false altrimenti
	 */
	public boolean hasLeft(Position<E> v) throws InvalidPositionException {
		BTPosition<E> l = checkPosition(v);
		if(l.getLeft() == null)
			return false;
		
		return true;
	}
	
	/** Ritorna true o false a seconda che il nodo di posizione v ha un figlio destro o no
	 * @param v		la posizione da controllare
	 * @return 		true se ha un figlio destro, false altrimenti
	 */
	public boolean hasRight(Position<E> v) throws InvalidPositionException {
		BTPosition<E> r = checkPosition(v);
		if(r.getRight() == null)
			return false;
		
		return true;
	}

	/** Ritorna il figlio sinistro del nodo di posizione v
	 *	@param v	la posizione della quale vogliamo sapere il figlio sinistro
	 *	@return 	il figlio sinistro di v 
	 */
	public Position<E> left(Position<E> v) throws InvalidPositionException,	BoundaryViolationException {
		BTPosition<E> l = checkPosition(v);
		if(l.getLeft()==null)
			throw new BoundaryViolationException("Non esiste un figlio sinistro!");
		
		return l.getLeft();
	}

	/** Ritorna il figlio destro del nodo di posizione v
	 *	@param v	la posizione della quale vogliamo sapere il figlio destro
	 *	@return 	il figlio destro di v 
	 */
	public Position<E> right(Position<E> v) throws InvalidPositionException,BoundaryViolationException {
		BTPosition<E> l = checkPosition(v);
		if(l.getRight()==null)
			throw new BoundaryViolationException("Non esiste un figlio destro!");
		
		return l.getRight();
	}
	
	/** Aggiunge la radice all'albero se non c'è già
	 * @param e		l'elemento della radice
	 * @return		posizione della radice
	 */
	public Position<E> addRoot(E e) throws NonEmptyTreeException {
		if(!isEmpty())
			throw new NonEmptyTreeException("La radice esiste già");
		
		root = new BTNode<E>(e,null,null,null);
		size = 1;
		return root;
	}
	
	/** Ritorna una lista iterabile dei due figli del nodo di posizione v
	 * @param v		la posizione del nodo del quale vogliamo conoscere la lista dei figli
	 * @return		la lista iterabile dei figli
	 */
	public Iterable<Position<E>> children(Position<E> v)	throws InvalidPositionException {
		BTPosition<E> n = checkPosition(v);
		PositionList<Position<E>> lista = new NodePositionList<Position<E>>();// lista vuota
		
		if(isInternal(n)){
			if(hasLeft(n))
				lista.addLast(left(n));
			if(hasRight(n))
				lista.addLast(right(n));
			return lista;
		}
		
		return null;
	}
	
	/** Inserisce un figlio di elemento e al nodo di posizione v, se questo ha almeno una posizione libera
	 * @param v		il nodo al quale aggiungere un figlio
	 * @param e		l'elemento del nodo figlio
	 * @return 		la posizione del figlio
	 */
	public Position<E> insertChild(Position<E> v, E e)	throws InvalidPositionException {
		BTPosition<E> n = checkPosition(v);
		if(hasLeft(n)&&hasRight(n)) throw new InvalidPositionException("I figli gia esistono entrambi");
		BTNode<E> nodo = new BTNode<E>(e,null,null,null);
		if(hasLeft(n)){
			n.setRight(nodo);
			nodo.setParent(n);
		}
		else{
			n.setLeft(nodo);
			nodo.setParent(n);
		}
		size++;
		return nodo;
	}

	/** Dice se l'albero è vuoto o no
	 * @return 		true se è vuoto, false altrimenti
	 */
	public boolean isEmpty() {
		return size==0;
	}
	
	/** Dice se il nodo di posizione v è una foglia o no
	 * @param v		la posizione da controllare
	 * @return 		true se è una foglia, false altrimenti
	 */
	public boolean isExternal(Position<E> v) throws InvalidPositionException {
		return !isInternal(v);
	}

	/** Dice se il nodo di posizione v è un nodo interno o no 
	 * @param v		la posizione da controllare
	 * @return 		true se è un nodo interno, false altrimenti
	 */
	public boolean isInternal(Position<E> v) throws InvalidPositionException {
		BTPosition<E> n = checkPosition(v);
		return (hasLeft(n)||hasRight(n));
	}

	/** Controlla se il nodo di poszione passata è la radice
	 * @param v		la posizione da controllare
	 * @return 		true se è la radice, false altrimenti
	 */
	public boolean isRoot(Position<E> v) throws InvalidPositionException {
		BTPosition<E> n = checkPosition(v);
		return n == root;
	}

	/**	Ritorna il parent del nodo di posizione passata
	 * @param v		la posizione della quale vogliamo sapere il padre
	 * @return 		il parent
	 */
	public Position<E> parent(Position<E> v) throws InvalidPositionException,BoundaryViolationException {
		BTPosition<E> n = checkPosition(v);
		if(isRoot(v))
			throw new BoundaryViolationException("La radice non ha padre!");
		return n.getParent();
	}
	
	/** Ritorna un iteratore sugli elementi dell'albero
	 * @return 		l'iteratore sugli elementi
	 */
	public Iterator<E> iterator() {
		PositionList<E> lista = new NodePositionList<E>();
		for(Position<E> p : positions() )
			lista.addLast(p.element());
		return lista.iterator();
	}
	
	/** Ritorna una lista di posizioni iterabile
	 * @return 		la lista di posizioni iterabile
	 */
	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> lista = new NodePositionList<Position<E>>();
		inOrder(root(),lista);
		return lista;
	}
	
	/** Effettua ricorsivamente la visita inOrder sull'albero radicato in v
	 * @param v		la radice dell'albero
	 * @param 		la lista di posizioni	
	 */
	public void inOrder(Position<E> v,PositionList<Position<E>> lista){
		if(hasLeft(v))
			inOrder(left(v),lista);
		lista.addLast(v);
		if(hasRight(v))
			inOrder(right(v),lista);
	}
	
	/** Effettua la visita preorder sull'albero radicato nel nodo di posizione passata come argomento, riempiendo 
	 * una lista sempre passata come parametro
	 * @param v		la radice sulla quale operare la visita
	 * @param pos	la lista di posizioni da riempire
	 */
	public void preorderPositions(Position<E> v,PositionList<Position<E>> pos) throws InvalidPositionException {
		checkPosition(v);
		pos.addLast(v);
		if(isInternal(v))
			for (Position<E> w : children(v))
				preorderPositions(w, pos); 
	}
	/** Effettua la visita postOrder sull'albero radicato nel nodo di posizione passata come argomento, riempiendo 
	 * una lista sempre passata come parametro
	 * @param v		la radice dell'albero sul quale operare la visita
	 * @param pos	la lista di posizioni da riempire
	 */
	public void postOrderPositions(Position<E> v,PositionList<Position<E>> pos) throws InvalidPositionException {
		checkPosition(v);
		if(isInternal(v))
			for (Position<E> w : children(v))
				postOrderPositions(w, pos); 
		pos.addLast(v);
	}
	 
	/** Rimpiazza il contenuto del nodo di poszione v con e, ritorna il vecchio contenuto
	 * @param v		la posizione dove vogliamo rimpiazzare il contenuto
	 * @param v		il nuovo contenuto
	 * @return 		il vecchio contenuto
	 */
	public E replace(Position<E> v, E e) throws InvalidPositionException {
		BTPosition<E> n = checkPosition(v);
		E element = n.element();
		n.setElement(e);
		return element;
	}

	/** Ritorna la radice dell'albero
	 * @return		la posizione della radice dell'albero
	 */
	public Position<E> root() throws EmptyTreeException {
		if(isEmpty())
			throw new EmptyTreeException("L'albero è vuoto");
		return root;
	}

	/** Ritorna la dimensione dell'albero
	 * @return		la dimensione dell'albero
	 */
	public int size() {
		return size;
	}

	/** Controlla se la posizione p è valida o meno
	 * @param p		la posizione da controllare
	 * @return		la BTPosition della posizione
	 */
	@SuppressWarnings("unchecked")
	public BTPosition<E> checkPosition(Position<E> p) throws InvalidPositionException{
		if(p == null||!(p instanceof BTNode))
			throw new InvalidPositionException("La posizione è invalida");
		return (BTPosition<E>) p;
	}
	
	public E remove(Position<E> v) throws InvalidPositionException{
		BTPosition<E> n = checkPosition(v);
		
		if(hasLeft(n)&&hasRight(n)) throw new InvalidPositionException("Non posso rimuovere un nodo con due figli!");
		E element = n.element();
		
		if(root()==n){
			if(hasLeft(n)){
				n.getLeft().setParent(null);
				root = n.getLeft();
			}
			else if(hasRight(n)){
				n.getRight().setParent(null);
				root = n.getRight();
			}
			else
				root = null;
		}
		else{
			BTPosition<E> parent = n.getParent();
			if(parent.getLeft()==n){
				if(hasLeft(n)){
					n.getLeft().setParent(parent);
					parent.setLeft(n.getLeft());
				}
				else if(hasRight(n)){
					n.getRight().setParent(parent);
					parent.setLeft(n.getRight());
				}
				else
					parent.setLeft(null);
			}
			else{
				if(hasLeft(n)){
					n.getLeft().setParent(parent);
					parent.setRight(n.getLeft());
				}
				else if(hasRight(n)){
					n.getRight().setParent(parent);
					parent.setRight(n.getRight());
				}
				else
					parent.setRight(null);
			}
		}
		n.setElement(null);
		size--;
		return element;
	}
	
	
	
	
// trasforma le foglie 
//	dell’albero in nodi interni aventi come figli due foglie. Gli elementi delle 
//	nuove foglie devono essere prelevati dalla lista L (in base all’ordine in 
//	cui sono disposti in L). Si assuma che L contenga un numero di 
//	elementi pari a due volte il numero di foglie iniziale dell’albero
//	
	public void attachLeaves(PositionList<E>L){
		
		
	}
	
	
	
	
	
	
	public void attach(Position<E> v,LinkedBinaryTree<E> T1,LinkedBinaryTree<E> T2)throws InvalidPositionException{
		BTPosition<E> n = checkPosition(v);
		if(isInternal(n)) throw new InvalidPositionException("Non posso attaccare due alberi ad un nodo interno!");
		n.setLeft(T1.root);
		n.setRight(T2.root);
		T1.root.setParent(n);
		T2.root.setParent(n);
		size+=T1.size()+T2.size();
	}
	
	/** Inserisce il figlio sinistro di elemento e al nodo di posizione v
	 * @param v		il nodo al quale aggiungere il figlio
	 * @param e		l'elemento del nodo figlio
	 * @return 		la posizione del figlio
	 */
	public Position<E> insertLeft(Position<E> v, E e)	throws InvalidPositionException {
		BTPosition<E> n = checkPosition(v);
		if(n.getLeft() != null) throw new InvalidPositionException("Il nodo ha gia un figlio sinistro");
		BTNode<E> nodo = new BTNode<E>(e,n,null,null);
		n.setLeft(nodo);
		size++;
		return nodo;
	}
	
	/** Inserisce il figlio destro di elemento e al nodo di posizione v
	 * @param v		il nodo al quale aggiungere il figlio
	 * @param e		l'elemento del nodo figlio
	 * @return 		la posizione del figlio
	 */
	public Position<E> insertRight(Position<E> v, E e)	throws InvalidPositionException {
		BTPosition<E> n = checkPosition(v);
		if(n.getRight() != null) throw new InvalidPositionException("Il nodo ha gia un figlio destro");
		BTNode<E> nodo = new BTNode<E>(e,n,null,null);
		n.setRight(nodo);
		size++;
		return nodo;
	}
	
	/** Preso in input un nodo v, resituisce il fratello
	 * @param v		il nodo del quale vogliamo conoscere il fratello
	 * @return 		la posizione del fratello
	 */
	public Position<E> sibling(Position<E> v)	throws BoundaryViolationException {
		BTPosition<E> n = checkPosition(v);
		
		if (n.getParent().getLeft() == n){
			if(n.getParent().getRight()!=null)
				return n.getParent().getRight();
			else
				throw new BoundaryViolationException("Il nodo non ha un fratello!");
		}
		else{
			if(n.getParent().getLeft()!=null)
				return n.getParent().getLeft();
			else
				throw new BoundaryViolationException("Il nodo non ha un fratello!");
		}
		
	}
	
	public boolean equals(Position<E> p,BinaryTree<E> w,Position<E> q){
		
		if(!isRoot(p)) throw new IllegalArgumentException("La posizione passata "+p.element()+" non corrisponde alla radice dell'albero!");
		if(!w.isRoot(q)) throw new IllegalArgumentException("La posizione passata "+q.element()+" non corrisponde alla radice dell'albero!");
		
		NodePositionList<Position<E>> l1 = new NodePositionList<Position<E>>();
		inOrder(p, l1);
		NodePositionList<Position<E>> l2 = new NodePositionList<Position<E>>();
		inOrder(q,l2);
		
		if(l1.size()!=l2.size())
			return false;
		
		Iterator<Position<E>> iter1=l1.iterator();
		Iterator<Position<E>> iter2=l2.iterator();
		
		while(iter1.hasNext()){
			if(iter1.next().element()!=iter2.next().element())
				return false;
			
			iter1.next();
			iter2.next();
		  }
	
		return true;
	}

	
	/*** Espande una foglia in un nodo interno con due foglie come figli.
	 * 
	 */
	public void expandExternal(Position<E> v,E left,E right)throws InvalidPositionException{
		
		if(!isExternal(v)) throw new InvalidPositionException("In nodo passato non è una foglia!!");
		
		insertLeft(v, left);
		insertRight(v, right);
		
	}
	
	
	/** Rimuove una foglia v e rimpiazza suo padre con i fratelli di v
	 * 
	 */
	public void removeAboveExternal(Position<E> v)throws InvalidPositionException{
		
		if(!isExternal(v)) throw new InvalidPositionException("In nodo passato non è una foglia!!"); 
		
		
		if(isRoot(v))
			remove(v);
		
		else{
			Position<E> padre = parent(v);
			remove(v);
			remove(padre);
		}
	}
	
	
	/*** Utilizziamo il metodo atDepth simile ai quello per i tree in modo da scorrere
	 *   la profondità dell'albero. Il metodo restituisce una collezione iterabile di tutti
	 *   i nodi a profondità i passato in input al metodo( conto da root che vale 0 fino alla fino=i)
	 * 
	 * @param i
	 * @return lista
	 * @throws InvalidPositionException
	 */
	public PositionList<Position<E>> atDepth(int i)throws InvalidPositionException{
		
		PositionList<Position<E>> lista = new NodePositionList<Position<E>>();// lista vuota
		PositionList<Position<E>> temp;											  // lista iterabile
		
		if(i == 0){
			lista.addLast(root());
		}else{
			temp = atDepth(i-1);
			for(Position<E> v : temp){
				PositionList<Position<E>> child = (PositionList<Position<E>>) children(v);
				for(Position<E> ww : child)
					lista.addLast(ww);
			}
		}
		return lista;
	}
	
	
	/** Metodo che restituisce l'altezza dell'albero passandogli in input al metodo 
	 *  una posizione dove iniziare la ricerca.
	 * 
	 * @param pos
	 * @return altezza
	 */
	public int altezzaAlbero(Position<E> pos){
		
		if(isExternal(pos))
			return 0;
		
		int sinistro=0;
		int destro=0;
		if(hasLeft(pos))
			sinistro = altezzaAlbero(left(pos));
	
		if(hasRight(pos))
			destro=altezzaAlbero(right(pos));
		
		return 1+Math.max(sinistro,destro);
	}
	
	
	/**  Esame 01 - 02 - 2010
	  *  Il metodo consente di stabilire (ricorsivamente) se l'albero ha tutte le foglie alla stessa profondità
	  *  Ci siamo serviti di metodi quali atDepth per restituire una lista iterabile dei nodi a profondità i, e 
	  *  del metodo altezza albero che mi restituiva l'altezza dell'albero a partire da una data posizione.
	  *  	
	  * @return true || false
	  */
	public boolean someLevelLeaves(){
		for(int i = 1 ; i <= altezzaAlbero(root()) ; i++)
			for(Position<E> pos : atDepth(i))
				//se il nodo è una foglia e se l'indice dove ci troviamo(che scorre volta per volta fino all'altezza 
				//dell'albero) è più piccolo dell'altezza dell'albero stessa,calcolata con il metodo altezzaAlbero
				//(passandogli la radice), allora significa che abbiamo una foglia che non si trova a profondità pari
				//all'altezza dell'albero.
				if(isExternal(pos) && i < altezzaAlbero(root))
					return false;
		
		return true;
	}
		
	 
	
	public int profRel(Position<E> p, Position<E> q) throws InvalidPositionException{
		
		if(p==q)
			return 0;
		
		if(isRoot(q))
			throw new InvalidPositionException("I nodi non sono in relazione tra loro!!"); 
		
		return 1+profRel(p,parent(q));
	}
		
	/** Effettua la copia speculare dell'albero
	 * @param v la radice del sottoalbero sul quale effettuare la copia
	 */
	public void mirror(Position<E> v)throws InvalidPositionException{
		if(isExternal(v))
			return;
		else{
			BTPosition<E> vv = checkPosition(v);
			vv.setLeft(vv.getRight());
			vv.setRight(vv.getLeft());
			for(Position<E> x : children(v))
				mirror(x);
		}
	} 
}
