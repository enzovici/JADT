package _ex;

import position.Position;
import tree.TreePosition;
import exception.EmptyTreeException;
import exception.InvalidPositionException;
import binaryTree.*;


	/*


	 
	 
	L'albero T usato per il II test e` il seguente:               
	  
	    
		                     4
		                               
		                 /      \
		               2         8
		              / \      /    \
		            1    3    4      10    
		                       \    /  \
		                        7  2    11	     
		                   
		    
	L'albero T usato per il III test e` il seguente:               
	  
	    
		                     4
		                               
		                 /      \
		               2         8
		              / \      /    \
		            1    3    4      10    
		                  \    \    /  \
		                   2    7  2    11	     	    


	L'albero T usato per il IV test e` il seguente:                
	  
	    
		                     4
		                               
		                 /        \
		               2           8
		              / \         /   \
		            1    3       4     10    
		                  \     /  \   /  \
		                   8   5    7 2    11	 
		                      /  \             
		                     1   40       
		               
		                      
		                      
		                      
Il programma deve stampare:

    I test: Albero vuoto

    II test: L'albero soddisfa la proprieta`.

    III test: L'albero NON soddisfa la proprieta`.

    IV test: L'albero NON soddisfa la proprieta`.                     
		                                 
	*/

 public class ExBinaryTree_11_2_13 {

	public static void main(String[] args){
		ExamBinaryTree <Integer>T= new ExamBinaryTree<Integer>();

		System.out.print("I test: ");
	
	    try{check(T);}
	    catch(EmptyTreeException e)
	    {System.out.println("Albero vuoto");}
	    
		T.examAddRoot(4);
		T.examExpandExternal(T.root(), 2,  8 );
		T.examExpandExternal(T.left(T.root()), 1 , 3 );
		T.examExpandExternal(T.right(T.root()), 4 , 10 );
		T.examInsertRight(T.left(T.right(T.root())), 7 );
		T.examExpandExternal(T.right(T.right(T.root())), 2 , 11 );

		System.out.print( "\nII test: ");
		if(check(T)) System.out.println("L'albero soddisfa la proprieta`.");
		else System.out.println("L'albero NON soddisfa la proprieta`.");

		T.examInsertRight(T.right(T.left(T.root())), 2);
		System.out.print( "\nIII test: ");
		if(check(T)) System.out.println("L'albero soddisfa la proprieta`.");
		else System.out.println("L'albero NON soddisfa la proprieta`.");

		T.replace(T.right(T.right(T.left(T.root()))), 8);
		T.examInsertLeft(T.left(T.right(T.root())),5);
		T.examExpandExternal(T.left(T.left(T.right(T.root()))), 1, 40);
		
		System.out.print( "\nIV test: ");
		if(check(T)) System.out.println("L'albero soddisfa la proprieta`.");
		else System.out.println("L'albero NON soddisfa la proprieta`.");

		
		}








		
		

               //scrivere qui la funzione
	
	
	public static boolean checkRoot(BTPosition<Integer> r , BinaryTree<Integer> T){
		
		boolean flag;
		Integer elemr= r.element();
		
	if(	T.isExternal(r) ){
			return true;
			
		}
		
		
	if( T.hasLeft(r) && !T.hasRight(r) ){	
		if( T.left(r).element()<elemr )
			return true && checkRoot((BTPosition<Integer>) T.left(r),T);
		else return false;
	}
	
	else if( T.hasRight(r) && !T.hasLeft(r) ){	
		if( T.right(r).element()>elemr )
			return true && checkRoot((BTPosition<Integer>) T.right(r),T);
		else return false;
	}
	
	else if( T.hasRight(r) && T.hasLeft(r) ){	
		if( T.right(r).element()>elemr && T.left(r).element()< elemr )
			return true && checkRoot((BTPosition<Integer>) T.right(r),T) && checkRoot((BTPosition<Integer>) T.left(r),T);
		else return false;
	}
	
	else return false;
//		
//		
//		if (T.isExternal(r));
//			return true ;
//			
//		
//		
//		Integer elemr= r.element();
//		
//		BTPosition<Integer>  sxChild = r.getLeft();
//		BTPosition<Integer>  rxChild = r.getRight();
//
//		if( T.isInternal(r) && T.left(r).element()<elemr && T.right(r).element()>elemr)
//			{
//			 boolean flag=true;
//			
//			 return checkRoot(sxChild,T) && checkRoot(rxChild,T) && flag;
//			}
//		else return false;		
		}

		public static  boolean check(BinaryTree<Integer> T){	
			BTPosition p = (BTPosition) T.root();
			
			return checkRoot(p,T );
					}


        //Sostituire size con in nome della variabile di istanza che tiene 
		//traccia del numero di nodi nella vostra classe LinkedBinaryTree
		public static class ExamBinaryTree <E>extends LinkedBinaryTree <E>implements BinaryTree<E>{


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