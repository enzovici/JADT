package tree;
import nodeList.*;

import java.util.Iterator;

import exception.InvalidPositionException;
import exception.NonEmptyTreeException;
import exception.BoundaryViolationException;
import position.Position;
import exception.*;


@SuppressWarnings("all")
public class LinkedTree<E> implements Tree<E>{
	
		protected TreePosition<E> root;
		protected int size;
		
	/** Costruttore vuoto con radice impostata a null e ovviamente size a 0 in quanto
	 *  gli non vi sono elemento nell'albero. */	
	public LinkedTree(){
		root=null;
		size=0;
	}
	
	
	/** Se v e` un nodo valido, fa il cast a TreePosition, altrimenti lancia una eccezione.
	 * @param p la posizione da controllare
	 * @return  il TreeNode
	 */
	public TreeNode<E> checkPosition(Position<E> pos)throws InvalidPositionException{
		
		if(pos==null || !(pos instanceof TreeNode)) throw new InvalidPositionException("La posizione è invalida...");
		
			return (TreeNode<E>) pos;
	}
	
	
	/** Aggiunge la radice all'albero e restituisce la posizione di essa 
	 * @param e		l'elemento da inserire come radice
	 * @return		la position della radice
	 * */
	public Position<E> addRoot(E e) throws NonEmptyTreeException {
			if(!isEmpty())throw new NonEmptyTreeException("Esiste già una radice..!!");
		
			root=new TreeNode<E>(e,null,null);
			size=1;	
			
				return root;
	}

	
	/** Ritorna la lista dei figli del nodo di posizione passata come parametro
	 * @param v		la posizione del nodo del quale vogliamo sapere i figli
	 * @return		la lista dei figli
	 */
	public Iterable<Position<E>> children(Position<E> v)throws InvalidPositionException {
		
		TreeNode<E> temp = checkPosition(v);
		
		if(isExternal(v))throw new InvalidPositionException("Errore,una foglia non può avere figli!!");
		
		return temp.getChildren();
	}

	
	/** Inserisce un figlio ad un nodo 
	 *  @param e 		l'elemento da inserire
	 *  @param v 		la posizione del nodo al quale vogliamo aggiungere il figlio
	 *  @return 		la posizione del nuovo figlio
	 */
	public Position<E> addChild(E e , Position<E> v)throws InvalidPositionException {
		
		TreeNode<E> padre = checkPosition(v);
		TreeNode<E> figlio = new TreeNode<E>(e,padre,null);
		
		if(padre.getChildren()!=null)
			
			padre.getChildren().addLast(figlio);
		
		else {
				padre.setChildren(new NodePositionList<Position<E>>());
				padre.getChildren().addLast(figlio);
			  }
		size++;
		
		return figlio;
	}

	
	/** Ritorna true se l'albero è vuoto, false altrimenti
	 * @return 	true o false a seconda dei casi
	 */
	public boolean isEmpty() {
		return (size==0);
	}

	
	/** Controlla se il nodo di posizione passata è una foglia o no
	 * @param	v 	la position del nodo da controllare
	 * @return 		true o false a seconda dei casi
	 */
	public boolean isExternal(Position<E> v) throws InvalidPositionException {
		
		TreeNode<E> temp = checkPosition(v);
		
		return(temp.getChildren()==null || temp.getChildren().isEmpty());
	}

	
	/** Controlla se il nodo di posizione passata è un nodo interno o no
	 * @param	v 	la position del nodo da controllare
	 * @return 		true o false a seconda dei casi
	 */
	public boolean isInternal(Position<E> v) throws InvalidPositionException {

	return (!isExternal(v));
	}

	
	/** Controlla se la position del nodo passato è la radice o no
	 * @param 	v	la position del nodo da controllare
	 * @return		true o false a seconda dei casi
	 */
	public boolean isRoot(Position<E> v) throws InvalidPositionException {
		
		checkPosition(v);
		
		return (v==root());
	}

	
	/** Crea e ritorna un iteratore sugli elementi dei nodi dell'albero
	 * @return elemento Iterator sugli elementi
	 */
	public Iterator<E> iterator() {
		
		Iterable<Position<E>> l = positions();
		NodePositionList<E> listElem = new NodePositionList();
		
		for(Position<E> pos : l)
			listElem.addLast(pos.element());
		
		return listElem.iterator();
	}

	
	/** Ritorna il parent della posizione passata come argomento
	 * @param v 	la posizione sulla quale vogliamo ritornare il padre
	 * @return 		il padre 
	 */
	public Position<E> parent(Position<E> v) throws InvalidPositionException,BoundaryViolationException {
		
		TreeNode<E> n = checkPosition(v);
		
			if(isRoot(v)) throw new BoundaryViolationException("Non posso tornare il parent di un elemento root!!!");
			
		return n.getParent();
	}

	
	/** Ritorna una lista iterabile dei nodi dell'albero
	 * @return lista Iterable cioè la lista iterabile
	 */
	public Iterable<Position<E>> positions() {
		//polimorfismo sull'interfaccia position list che viene poi implementata da nodepositionlist
		NodePositionList<Position<E>> l = new NodePositionList<Position<E>>();
		if(!isEmpty())
			preorderPositions(root,l);
		return l;
	}

	
	/** Rimpiazza il contenuto del nodo passato con il nuovo elemento restituendo
	 * il contenuto prima dell'operazione 
	 * @param v 	la posizione nella quale rimpiazzare
	 * @param e 	il nuovo elemento da inserire
	 * @return 		l'elemento precedente l'operazione di replace
	 */
	public E replace(Position<E> v, E e) throws InvalidPositionException {
		
		TreeNode<E> temp = checkPosition(v);
		E el = temp.element();
		temp.setElement(e);
		
		return el;
	}

	
	/**Ritorna la radice dell'albero 
	 * @return la radice */
	public Position<E> root() throws EmptyTreeException {
		if(isEmpty()) throw new EmptyTreeException("L'albero è vuoto!!");
		return root;
	}

	
	/** Ritorna la dimensione dell'albero 
	 * @return la dimensione
	 */
	public int size() {
			return size;
	}
	
	
	/** Effettua la visita preorder sull'albero radicato nel nodo di posizione passata come argomento, riempiendo 
	 * una lista sempre passata come parametro
	 * @param v		la radice sulla quale operare la visita
	 * @param pos	la lista di posizioni da riempire
	 */
	protected void preorderPositions(Position<E> v,PositionList<Position<E>> pos) throws InvalidPositionException {
		checkPosition(v);
		pos.addLast(v);//lista di tutte le posizioni dell'albero
		if(isInternal(v))
			for (Position<E> w : children(v))
				preorderPositions(w, pos); // ricorsione su ciascun figlio
	}
	
	

	/** Effettua la visita postorder sull'albero radicato nel nodo di posizione passata come argomento, riempiendo 
	 * una lista sempre passata come parametro scorre fino all'albero ed aggiunge dall'ultimo nodo senza figli fino ai figli
	 * della radice su cui è invocato il metodo.
	 * 
	 * @param v		la radice sulla quale operare la visita
	 * @param pos	la lista di posizioni da riempire
	 */
	protected void postorderPositions(Position<E> v,PositionList<Position<E>> pos) throws InvalidPositionException {
		checkPosition(v);
		if(isInternal(v))
			for (Position<E> w : children(v))
				postorderPositions(w, pos); // ricorsione su ciascun figlio
		
		pos.addLast(v);//lista di tutte le posizioni dell'albero
		
	}
	
	
	/** Conta ricorsivamente la profondità nell'albero del nodo passato come parametro 
	 * @param 	v 	il nodo
	 * @return 		la profondità  */
	public int depth(Position<E> pos)throws InvalidPositionException{
		TreeNode<E> temp = checkPosition(pos);
		
		if(pos==root())
			return 0;
		
		return 1+depth(temp.getParent());
	}
		
	/** Esercizio prof. in classe n°2 
	 *  
	 * Prende in input due nodi, v e w, ritorna true se v è antenato di w, false altrimenti
	 * @param 	c 	il primo nodo
	 * @param 	p 	il secondo nodo (ultimo nodo su cui verificare se c è antenato di p)
	 * @return 		true o false a seconda dei casi */
	public boolean ancestor(Position<E> c,Position<E>p)throws InvalidPositionException{
		
		TreeNode<E> e1 = checkPosition(c);
		TreeNode<E> e2 = checkPosition(p);
		
		if(c==p)
			return true;
		if(p==root())
			return false;
		
		else 
			return ancestor(e1,e2.getParent());
	}
	
	
	/**Prenda in input due nodi v e w dell'albero e restituisca il più basso antenato comune fra v e w.
	 * lca = lowest common ancestor
	 * @param v prima posizione
	 * @param w seconda posizione
	 * @return Position<E> posizione del minimo antenato
	 */
	public Position<E> lca(Position<E> v,Position<E> w)throws InvalidPositionException{
		
		TreePosition<E> vv = checkPosition(v);
		TreePosition<E> ww = checkPosition(w);
		
		while(vv!=ww){
			if(depth(vv) > depth(ww))
				vv = vv.getParent();
			else
				ww = ww.getParent();
		}
		
		return vv;
	}
	
	/**(Soluzione Ricorsiva)
	 * Prenda in input due nodi v e w dell'albero e restituisca il più basso antenato comune fra v e w.
	 * lca = lowest common ancestor
	 * @param v prima posizione
	 * @param w seconda posizione
	 * @return Position<E> posizione del minimo antenato
	 */
	public Position<E> lcaRic(Position<E> v,Position<E> w)throws InvalidPositionException{
		
		TreePosition<E> vv = checkPosition(v);
		TreePosition<E> ww = checkPosition(w);
		
		if(vv == ww)
			return vv;
		else if(vv == root() || ww == root())
			return root();
		else{
			if(depth(vv) > depth(ww))
				return lca(vv.getParent(),ww);
			else if (depth(vv) < depth(ww))
				return lca(vv,ww.getParent());
			else
				return lca(vv.getParent(),ww.getParent());
		
		}
	}
	
	/** Restituisce la collezione iterabile dei nodi sul cammino che va da u a v
	 * @param u		primo nodo
	 * @param v		secondo nodo
	 * @return		la lista iterabile
	 */
	public PositionList<Position<E>> path(Position<E> u, Position<E> v){
		PositionList<Position<E>> lista = new NodePositionList<Position<E>>();
		
		Position<E> ant = lca(u,v);
		if(u==ant)
			lista.addLast(u);
		else{
			lista.addLast(u);
			while(u!=ant){
				u = parent(u);
				lista.addLast(u);
			}
		}
		if(ant==v)
			return lista;
		else
			while(ant != v)
				for(Position<E> pos : children(ant))
					if(isDiscendent(v, pos)){
						lista.addLast(pos);
						ant=pos;
					}
		return lista;
	}
	
	
	public int contaFoglie(Position<E> pos){
		
		if(isExternal(pos))
			return 1;
		
		int x=0;
		for(Position p: children(pos))
			x+=contaFoglie(p);
		
		return x;
		
	}
	
	/**
	 * Restituisce true se p è discendente di q
	 * @param p il nodo discendente
	 * @param q il nodo antenato
	 * @return true se p è discendente, false altrimenti
	 */
	public boolean	isDiscendent(Position<E> p, Position<E> q){
		checkPosition(p);
		checkPosition(q);
		if(p == q) 								
			return true;						
		else if(isExternal(q))					
			return false;
		else
			for(Position<E> pos : children(q))
				if(isDiscendent(p,pos)==true)
					return true;
		return false;
	}
	
	
	/**  Esame del 23-11-09
	  *  che prende in input due nodi u e v e modifica l’albero nel modo seguente: 
	  *  il nodo u viene rimosso e i figli di u diventano fratelli di v.
	  *  @param u il primo nodo
	  *  @param v il primo nodo
	  */
	 public void remove(Position<E> u, Position<E> v){
	  TreePosition<E> uu = checkPosition(u);
	  TreePosition<E> vv = checkPosition(v);
	  
	  if(isRoot(uu))
	   throw new InvalidPositionException("Non posso rimuovere la radice!");
	  if(isRoot(vv))
	   throw new InvalidPositionException("Non posso aggiungere fratelli alla radice!");
	  
	  /*** Elimino u dalla lista dei figli del padre di uu, e per ogni figlio cerco e rimuovo il riferimento ad u 
	   *   che ha il padre di u */
	  for(Position<Position<E>> pos : uu.getParent().getChildren().positions())
	   if(pos.element().element() == u.element())
	    uu.getParent().getChildren().remove(pos);
	 
	  /** Assegno il padre ad ogni figlio di u, e memorizzo ogni figlio di u come figlio 
	   *  del padre di v*/
	  for(Position<E> p : children(uu)){
	   ((TreePosition<E>) p).setParent(vv.getParent());
	   vv.getParent().getChildren().addLast(p);
	  }
    }
	
	 /*** Traccia d'esame 14/01/2009 B  
	  *   Esercizio n°2: 
	  *   Si consideri la classe LinkedTree<E> che implementa l’ADT albero mediante lista concatenata. Si aggiunga un
	  *   metodo remove (Position<E> v) che riceve in input un nodo v e lo rimuove dall’albero. Gli eventuali figli di
	  *   v dovranno diventare figli di uno dei fratelli di v. Il metodo deve lanciare opportune eccezioni in tutti i 
	  *   casi in cui si verifichino condizioni di errore (ad esempio v non ha fratelli).
      *	  
      *   Esempio:
													T T.remove(g)
				r 										r	
			   / \									   / \
			  a   b    								  a   b
				/ | \ 									/ |
			   e  f  g 								   e  f 
				    / \									 / \
				   h   i 								h   i
	  
	  */
	 public void remove (Position<E> v){
		 
		 TreePosition<E> vv = checkPosition(v);
		 
		 if(isRoot(vv))
			 throw new InvalidPositionException("Non è possibile rimuovere la radice!!!");
	 
		 
		 
		 PositionList<Position<E>> listaChild = new NodePositionList<Position<E>>();
		 for(Position<Position<E>> pos : vv.getParent().getChildren().positions()){
			 if(pos.element().element()== vv.element())
				 vv.getParent().getChildren().remove(pos);
		 }
		
		 for(Position<E> pos : children(vv)){
			 for(Position<E> posi : vv.getParent().getChildren()){
				 ((TreePosition<E>)pos).setParent((TreePosition<E>) posi);
				 ((TreePosition<E>) posi).getParent().getChildren().addLast(pos);
				 break;
			} 	
		 }
	 }
}
