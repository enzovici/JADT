package _ex;

import java.util.Iterator;

import nodeList.NodePositionList;
import nodeList.PositionList;
import position.Position;
import tree.*;
import exception.EmptyTreeException;
import _ex.ExamTree;

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
	 * @param <E>
	*/

public class ExTree_prova<E> {
	
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
		NodePositionList<Position<E>> output = new NodePositionList<Position<E>>();
		return (Iterable<Position<E>>) select(T,x,k,T.root(),output);
	}
	
	public static <E>  NodePositionList<Position<E>> select(Tree<E> T, E x, int k,Position<E> r,NodePositionList<Position<E>> output){
		if (r.element()==x && output.size()<k){
			output.addLast(r);
		}
		if(T.isInternal(r)){
			Iterable<Position<E>> children = T.children(r);
			for (Position<E> child : children){				
				select(T,x,k,child,output);
			}
		}
		return output;
	}
}
