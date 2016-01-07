package _appelli;

import java.util.Iterator;

import exception.EmptyTreeException;

import nodeList.NodePositionList;
import nodeList.PositionList;
import position.Position;
import tree.LinkedTree;
import tree.Tree;
import tree.TreeNode;
import tree.TreePosition;

//importare le classi necessarie

/**
 Scrivere la funzione
public static <E> Iterable<Position<E>> select(Tree<E> T, int k)
nella classe ExTree_25_6_12.
Istruzioni per lo svolgimento dell’esercizio:
• La funzione deve effettuare una visita ricorsiva postorder dell’albero e restituire una
collezione iterabile dei nodi interni che hanno almeno k figli.
• Se T è vuoto la funzione deve lanciare l’eccezione EmptyTreeException.
• La funzione non deve invocare funzioni che restituiscono o utilizzano collezioni/iteratori di
tutti i nodi o di tutti i nodi interni dell’albero. Nel caso in cui non venga soddisfatto
questo requisito la funzione sarà valutata al massimo 13 punti.
La classe di test ExTree_25_6_12 deve essere inserita nel pacchetto in cui si trova l’interfaccia
Tree.
 */



/*****
* L'albero usato per il II test e`
* 
*                              9
*                        /    /  \    \
*                     11    12   13    14   
*                    / | \           /  / \  \
*                   2  3  4         8  7   6  5
*                         |              / | \
*                         10            5  4  3
*
*

Il programma deve stampare:

II test
L'albero e` vuoto.


II test: T e` l'albero disegnato all'inizio del file.

Gli elementi dei nodi interni con un numero di figli maggiore o uguale di 1 sono: 
4 11 6 14 9 
Gli elementi dei nodi interni con un numero di figli maggiore o uguale di 2 sono: 
11 6 14 9 
Gli elementi dei nodi interni con un numero di figli maggiore o uguale di 3 sono: 
11 6 14 9 
Gli elementi dei nodi interni con un numero di figli maggiore o uguale di 4 sono: 
14 9 
Gli elementi dei nodi interni con un numero di figli maggiore o uguale di 5 sono: 

*/
public class ExTree_25_6_12{
	public static void main(String[]args){	

		ExamTree<Integer > T = new ExamTree<Integer>();
		
		
		
		System.out.println("I test");
		try{
			select(T,5);
		}
		catch(EmptyTreeException e){
			System.out.println("L'albero e` vuoto.\n");
		}
		
		
		
	   
	    T.examAddRoot(9);
	    for(int i=11;i<=14 ; i++)
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
	    T.examAddChild(5, figlioRadice);
	    for(int j=5;j>=3;j--)
			 T.examAddChild( j, nipoteRadice);
	    
		
		
		
	
		
		System.out.println("\nII test: T e` l'albero disegnato all'inizio del file.");
		
		for(int k=1;k<6;k++){
	        System.out.println("\nGli elementi dei nodi interni con un numero di figli maggiore o uguale di "+ k + " sono: ");
	   
		  for(Position<Integer> p: select(T,k))
			System.out.print(p.element()+" ");
	      
		   }
		
		}

   
       //scrivere qui la funzione	
	public static <E> Iterable<Position<E>> select(Tree<E> T, int k){
		NodePositionList<Position<E>> output = new NodePositionList<Position<E>>();
		
		Position <E> r = T.root();
		
		return select(T,k,r,output);
	}

	
	public static <E> Iterable<Position<E>> select(Tree<E> T, int k, Position<E> r,NodePositionList<Position<E>> output){
		if(T.isInternal(r)){
			NodePositionList<Position<E>> figli=(NodePositionList<Position<E>>)T.children(r);
			for(Position<E>p:figli){
				select(T,k,p,output);
			}
			if(figli.size()>=k){
				output.addLast(r);
			}
		}
		return output;
	}
	
	
//	  //scrivere qui la funzione	
//		public static <E> Iterable<Position<E>> select(Tree<E> T, int k){
//			if(T.isEmpty())throw new EmptyTreeException("albero vuoto");
//			PositionList<Position<E>> l = new NodePositionList<Position<E>>();
//			
//			PositionList<Position<E>> f = (PositionList<Position<E>>) T.children(T.root());
//			if(f.size() >= k){
//			post(T,T.root(),k,l);
//			}
//			return l;
//			
//			}
//			  
//			
//			private static <E> void post(Tree<E> T, Position<E> v, int k,PositionList<Position<E>> L){
//				if(T.isInternal(v)){
//				for(Position<E> p : T.children(v)){
//					if(T.isInternal(p)){
//					PositionList<Position<E>> f = (PositionList<Position<E>>) T.children(p);
//						if(f.size() >= k){
//							post(T,p,k,L);
//						}
//					}
//				}
//				}
//				L.addLast(v);	
//				
//				
//			}
//		
//		}
	
	
       //Sosituire size con la variabile che tiene traccia del numero di nodi nella vostra classe LinkedTree
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
