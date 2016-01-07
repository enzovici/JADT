package _appelli;

import java.util.Iterator;

import nodeList.NodePositionList;
import nodeList.PositionList;

import position.Position;
import tree.LinkedTree;
import tree.Tree;
import tree.TreeNode;
import tree.TreePosition;
import exception.EmptyTreeException;

//importare le classi necessarie
	/**
	Scrivere la funzione
public static <E> Iterable <Position<E>> select(Tree<E> T, E x, int k)
nella classe ExTree_17_1_12.
Istruzioni per lo svolgimento dell’esercizio:
• La funzione deve effettuare una visita ricorsiva preorder dell’albero T e restituire una
collezione iterabile dei primi k nodi visitati contenenti x. Se ci sono meno di k nodi
contenenti x, la collezione restituita in output deve comprendere tutti i nodi contenenti x.
• Se T è vuoto la funzione deve lanciare l’eccezione EmptyTreeException.
• La funzione deve interrompere la visita non appena incontra il k-esimo nodo contenente x.
Nel caso in cui non venga soddisfatto questo requisito la funzione sarà valutata al massimo
21 punti.
• La funzione non deve invocare funzioni che restituiscono o utilizzano collezioni/iteratori
di tutti i nodi dell’albero. Nel caso in cui non venga soddisfatto questo requisito la
funzione sarà valutata al massimo 13 punti.
La classe di test ExTree_17_1_13 deve essere inserita nel pacchetto in cui si trova l’interfaccia
Tree. 
	 */

	/*****
	* L'albero usato per il II test e`
	* 
	*                              9
	*                        /    /  \    \
	*                     10    11   12    13   
	*                    / | \           /  / \  \
	*                   2  3  4         8  7   6  10
	*                         |              / | \
	*                         10            11 10  9
	*
	*

    Il programma deve stampare:

    I test
    L'albero e` vuoto.


   II test: T e` l'albero disegnato all'inizio del file.

   I primi 2 nodi contenenti 10 sono: 
   il nodo avente come padre il nodo contenente 9 e come figli i nodi contenenti gli elementi 2, 3, 4,    
   il nodo avente come padre il nodo contenente 4

   I primi 3 nodi contenenti 10 sono: 
   il nodo avente come padre il nodo contenente 9 e come figli i nodi contenenti gli elementi 2, 3, 4, 
   il nodo avente come padre il nodo contenente 4
   il nodo avente come padre il nodo contenente 6

   I primi 4 nodi contenenti 10 sono: 
   il nodo avente come padre il nodo contenente 9 e come figli i nodi contenenti gli elementi 2, 3, 4, 
   il nodo avente come padre il nodo contenente 4  
   il nodo avente come padre il nodo contenente 6
   il nodo avente come padre il nodo contenente 13
   
   I primi 5 nodi contenenti 10 sono: 
   il nodo avente come padre il nodo contenente 9 e come figli i nodi contenenti gli elementi 2, 3, 4,  
   il nodo avente come padre il nodo contenente 4
   il nodo avente come padre il nodo contenente 6
   il nodo avente come padre il nodo contenente 13
	

*/

            public class ExTree_17_1_2013 {
	
		public static void main(String[]args){	

			ExamTree<Integer > T = new ExamTree<Integer>();
			
			
			
			System.out.println("I test");
			try{
				select(T,5,4);
			}
			catch(EmptyTreeException e){
				System.out.println("L'albero e` vuoto.\n");
			}
			
			
			
		   
		    T.examAddRoot(9);
		    for(int i=10;i<=13 ; i++)
		    T.examAddChild(i, T.root());
		    
		    Iterator <Position<Integer>> figliRadice= T.children(T.root()).iterator();
		    Position <Integer> figlioRadice = figliRadice.next();
		    Position<Integer> figlio=null;
		    for(int j=1;j<=3;j++)
		      figlio = T.examAddChild(+(1+j), figlioRadice);
		    T.examAddChild(10, figlio);
		    figliRadice.next();	
		    figliRadice.next();
		    figlioRadice = figliRadice.next();
		    Position<Integer> nipoteRadice=null;
		    for(int j=1;j<=3;j++)
				nipoteRadice=T.examAddChild((9-j), figlioRadice);
		    T.examAddChild(10, figlioRadice);
		    for(int j=11;j>=9;j--)
				 T.examAddChild( j, nipoteRadice);
		    
			
			
			
		
			
			System.out.println("\nII test: T e` l'albero disegnato all'inizio del file.");
			
			for(int k=2;k<6;k++){
		        System.out.print("\nI primi "+ k +" nodi contenenti 10 sono: ");
		   
			  for(Position<Integer> p: select(T,10,k)){
				  if(T.isRoot(p))System.out.print("\nil nodo radice, ");
				  else System.out.print("\nil nodo avente come padre il nodo contenente "+ T.parent(p).element());
				  if(T.isInternal(p)){
					  System.out.print(" e come figli i nodi contenenti gli elementi ");
			        for(Position<Integer> child : T.children(p))
			        		System.out.print(child.element()+", ");
		             
				  
			    }
			   }
			  System.out.println();
			}
		}
		

  	     
               //scrivere qui la funzione
		public static <E> Iterable <Position<E>>  select(Tree<E> T, E x, int k){
			if(T.isEmpty())throw new EmptyTreeException("albero vuoto");
		PositionList<Position<E>> L = new NodePositionList<Position<E>>();	
		int count = 0;
		pre(T,x,k,L,T.root(),count);
		return L;
		}	
		
		
		private static <E> int pre(Tree<E> T,E x, int k,PositionList<Position<E>> L,Position<E> v, int count){
			if(T.isExternal(v)){
				if(v.element().equals(x)){
					L.addLast(v);
					count++;
					if(count == k)return 0;
				}
				return -1;
			}
			
			
			if(v.element().equals(x)){
				L.addLast(v);
				count++;
				if(count == k)return 0;
			}
			
			
			for(Position<E> f: T.children(v)){
				if(pre(T,x,k,L,f,count) == 0)return 0;
			}
			
			
			return -1;
			
			
			
			
		}
		

               //sostituire size con la variabile della vostra classe LinkedTree che tiene traccia della dimensione dell'albero 
		public static class ExamTree<E> extends LinkedTree<E>{
			 
			 public Position<E> examAddRoot(E e){// throws NonEmptyTreeException {
				  //  if(!isEmpty())
				   //   throw new NonEmptyTreeException("L'albero ha gia` una radice");
				    size = 1;
				    root = examCreateNode(e,null,null);
				    return root;
				 }
			 
			 
			  //aggiunge a v un figlio che ha come elemento element
			  public Position <E> examAddChild(E element,Position <E> v){
				  size++;
				  Position<E> newP= examCreateNode(element,(TreePosition <E>) v,null);
				  if(isExternal(v)){
					 PositionList<Position<E>> figli = new NodePositionList<Position<E>>();
				    ((TreePosition<E>) v).setChildren(figli);
				     figli.addLast(newP);}
				  else((PositionList<Position<E>>)children(v)).addLast(newP);
				  return newP;
			  }
			  
			  protected TreePosition<E> examCreateNode(E element, TreePosition<E> parent, 
					  PositionList<Position<E>> children) {
	                      return new TreeNode<E>(element,parent,children); 
	          }

		 }







	}
