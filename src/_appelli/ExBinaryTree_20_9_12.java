package _appelli;

import nodeList.NodePositionList;
import nodeList.PositionList;
import exception.EmptyTreeException;
import exception.InvalidPositionException;
import position.Position;

import binaryTree.*;
/**
 Scrivere la funzione
public static <E> Iterable <Position<E>> nodesOfHeightLT1(BinaryTree<E> T)
nella classe ExBinaryTree_20_9_12.
Istruzioni per lo svolgimento dell’esercizio:
• La funzione deve effettuare una visita ricorsiva Preorder dell’albero e restituire una
collezione iterabile di tutti i nodi di altezza maggiore di 1 (nodi che hanno almeno un figlio
che è un nodo interno). La funzione non deve calcolare l’altezza dei nodi ma limitarsi a
controllare se abbiano o meno altezza maggiore di 1.
• Se T è vuoto la funzione deve lanciare l’eccezione EmptyTreeException.
• La funzione non deve invocare funzioni che restituiscono o utilizzano collezioni/iteratori di
tutti i nodi o di tutti i nodi interni dell’albero. Nel caso in cui non venga soddisfatto
questo requisito la funzione sarà valutata al massimo 13 punti.
La classe di test ExBinaryTree_20_9_12 deve essere inserita nel pacchetto in cui si trova
l’interfaccia BinaryTree.
 */


//importare le classi necessarie

/*




L'albero T usato per II test e` il seguente:               
  
         
  
    
	                     0
	                               
	                 /      \
	               2         8
	              / \      /    \
	            1    3    4      10    
	                    /  \    /  \
	                   5    7  9    11	 
	                    \             
	                     40       
	                    /
	                   41
	                  /   
	                 42   
	                /
	               43
	                      
	                      
	                      
	                      
	                      
Il programma deve stampare:

I test: Albero vuoto

II test: Gli elementi dei nodi di altezza maggiore di 1 sono:
0 8 4 5 40 41      
	                                 
*/
public class ExBinaryTree_20_9_12 {
	

	public static void main(String[] args){
		ExamBinaryTree <Integer>T= new ExamBinaryTree<Integer>();

		System.out.print("I test: ");
	
	    try{nodesOfHeightLT1(T);}
	    catch(EmptyTreeException e)
	    {System.out.println("Albero vuoto");}
	    
		T.examAddRoot(0);
		T.examExpandExternal(T.root(), 2,  8 );
		T.examExpandExternal(T.left(T.root()), 1 , 3 );
		T.examExpandExternal(T.right(T.root()), 4 , 10 );
		T.examInsertRight(T.left(T.right(T.root())), 7 );
		T.examExpandExternal(T.right(T.right(T.root())), 9 , 11 );
		T.examInsertLeft(T.left(T.right(T.root())),5);
		T.examInsertRight(T.left(T.left(T.right(T.root()))),  40);
		T.examInsertLeft(T.right(T.left(T.left(T.right(T.root())))),41);
		T.examInsertLeft(T.left(T.right(T.left(T.left(T.right(T.root()))))),42);
		T.examInsertLeft(T.left(T.left(T.right(T.left(T.left(T.right(T.root())))))),43);
		System.out.print( "\nII test: ");
		
		System.out.println("Gli elementi dei nodi di altezza maggiore di 1 sono:");
		for(Position<Integer> p: nodesOfHeightLT1(T)){
			System.out.print(p.element()+" ");
		}
		

		
		}





	
      //scrivere qui la funzione	
	public static <E> Iterable <Position<E>> nodesOfHeightLT1(BinaryTree<E> T){
		if(T.isEmpty())throw new EmptyTreeException("albero vuoto");
		
		PositionList<Position<E>> p = new NodePositionList<Position<E>>();
		pre(T,T.root(),p);
		return p;
		
		
		
		
	}
	
	public static <E> void pre(BinaryTree<E> T, Position<E> v, PositionList<Position<E>> p){
		p.addLast(v);
		System.out.println("computo:" + v.element());
		int flag = 0;
				if(T.hasLeft(v)){
						Position<E> FL = T.left(v);	
							if(T.hasLeft(FL)){
								if(T.isInternal(T.left(FL))){
								
									flag = 1;
								}
							}
						
						if(T.hasRight(FL)){
							if(T.isInternal(T.right(FL))){
								flag = 1;
							}
						
							
						}	
						if(flag == 1)pre(T,T.left(v),p);
				}
		
		
				flag = 0;
				if(T.hasRight(v)){
						Position<E> RL = T.right(v);	
						if(T.hasLeft(RL)){
							if(T.isInternal(T.left(RL))){
							
								flag = 1;
							}
						}
						
						if(T.hasRight(RL)){
							if(T.isInternal(T.right(RL))){
								flag = 1;
							}
						
							
						}
						if(flag == 1)pre(T,T.right(v),p);
				}
		
		}
 
		
	
		
		
	//Sostituire size con in nome della variabile di istanza che tiene 
     //traccia del numero di nodi nella vostra classe LinkedBinaryTree
	public static class ExamBinaryTree <E>extends LinkedBinaryTree <E>{


	public Position<E> examAddRoot(E e){// throws NonEmptyTreeException {
	//   if(!isEmpty())
        // throw new NonEmptyTreeException("L'albero ha gia una radice");
	size = 1;
	root = examCreateNode(e,null,null,null);
	return root;
	} 

	protected BTPosition<E> examCreateNode(E element, BTPosition<E> parent, 
	BTPosition<E> left, BTPosition<E> right) {
	return new BTNode<E>(element,parent,left,right); }

	public void examExpandExternal(Position<E> v, E l, E r) 
	throws InvalidPositionException {
	if (!isExternal(v)) 
	throw new InvalidPositionException("Il nodo non e` una foglia");
	examInsertLeft(v, l);
	examInsertRight(v, r);
	}


	public Position<E>  examInsertLeft(Position<E> v, E e)
	throws InvalidPositionException {
	BTPosition<E> vv = checkPosition(v);
	Position<E> leftPos = vv.getLeft();
	if (leftPos != null)
	throw new InvalidPositionException("il nodo ha gia` un figlio sin");
	BTPosition<E> ww = examCreateNode(e, vv, null, null);
	vv.setLeft(ww);
	size++;
	return ww;
	}
	public Position<E>  examInsertRight(Position<E> v, E e)
	throws InvalidPositionException {
	BTPosition<E> vv = checkPosition(v);
	Position<E> rightPos = vv.getRight();
	if (rightPos != null)
	throw new InvalidPositionException("il nodo ha gia` un figlio destro");
	BTPosition<E> w = examCreateNode(e, vv, null, null);
	vv.setRight(w);
	size++;
	return w;
	}




	}

}

