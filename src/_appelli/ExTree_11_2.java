package _appelli;

import java.util.Iterator;

import position.Position;
import nodeList.NodePositionList;
import nodeList.PositionList;
import tree.LinkedTree;
import tree.Tree;
import tree.TreeNode;
import tree.TreePosition;




/**
 *Scrivere la funzione
public static <E> int depthOf(Tree<E> T, E x)
nella classe ExTree_11_2 fornita sul dischetto. 
Istruzioni per lo svolgimento dell’esercizio: 
• La funzione deve effettuare una visita (ricorsiva) postorder dell’albero T e restituire la 
profondità del primo nodo incontrato che ha il campo element uguale ad x. Se non c’è 
alcun nodo con il campo element uguale ad x allora la funzione restituisce -1. 
• La funzione NON deve invocare funzioni che calcolano la profondità di un nodo. Nel caso 
in cui non venga soddisfatto questo requisito la funzione sarà valutata al massimo 18 punti. 
• Ad eccezione di children, la funzione depthOf NON deve invocare funzioni che 
restituiscono o utilizzano collezioni/iteratori di nodi dell’albero. Nel caso in cui non venga 
soddisfatto questo requisito la funzione sarà valutata al massimo 12 punti. 
La classe di test ExTree_11_2 deve essere inserita nel pacchetto in cui si trova l’interfaccia Tree
 */
/****
 * L'albero usato per il II test e`
 * 
 *                             0
 *                        /   /  \    \
 *                       1   2   3     4    
 *                     / | \        / / \  \
 *                    1  2  3      6  5  4  3
 *                          |          / | \
 *                          10        4  3  2
 *
 *
I test
T e` vuoto
La profondita` del primo nodo contenente 2 e`: -1

II test
T e` l'albero disegnato all'inizio del file
La profondita` del primo nodo contenente 0 e`: 0
La profondita` del primo nodo contenente 1 e`: 2
La profondita` del primo nodo contenente 2 e`: 2
La profondita` del primo nodo contenente 3 e`: 2
La profondita` del primo nodo contenente 4 e`: 3
La profondita` del primo nodo contenente 5 e`: 2
La profondita` del primo nodo contenente 6 e`: 2
La profondita` del primo nodo contenente 7 e`: -1
La profondita` del primo nodo contenente 8 e`: -1
La profondita` del primo nodo contenente 9 e`: -1
La profondita` del primo nodo contenente 10 e`: 3

 * 
 */

public class ExTree_11_2 {
	
 public static void main(String[]args){	

	ExamTree<String > T = new ExamTree<String>();
	System.out.println("I test");
	System.out.println("T e` vuoto");
	System.out.println("La profondita` del primo nodo contenente 2"+ " e`: " +depthOf(T,""+2));
	
	T.examAddRoot("0");
	for(int i=1;i<=4 ; i++)
	 T.examAddChild(""+i, T.root());
	    
	Iterator <Position<String>> figliRadice= T.children(T.root()).iterator();
	Position <String> figlioRadice = figliRadice.next();
	Position<String> figlio=null;
	for(int j=1;j<=3;j++)
	  figlio = T.examAddChild(""+j, figlioRadice);
	T.examAddChild(""+10, figlio);
	figliRadice.next();	
	figliRadice.next();
	figlioRadice = figliRadice.next();
	Position<String> nipoteRadice=null;
	for(int j=1;j<=3;j++)
		nipoteRadice=T.examAddChild(""+(7-j), figlioRadice);
	T.examAddChild(""+3, figlioRadice);
	for(int j=1;j<=3;j++)
	 T.examAddChild(""+ (5-j), nipoteRadice);
	    
	System.out.println("\nII test");
	System.out.println("T e` l'albero disegnato all'inizio del file");	
	for(int i=0;i<11;i++)
	System.out.println("La profondita` del primo nodo contenente "+ i+ " e`: " +depthOf(T,""+i));
	
	

}
//restituisce la profondita` del primo nodo incontrato contenente x
	public static <E> int depthOf(Tree<E> T, E x){
		if(T.isEmpty())return -1;
		return post(T, x,0,T.root());
	
   } 
	
	private static <E>int post(Tree<E> T, E x, int p, Position<E> v){
		
		if(T.isExternal(v)){
			if(v.element().equals(x))return p;
			return -1;
		}
		int ret = -1;
		for(Position<E>  f: T.children(v)){
			ret = post(T, x, p + 1, f);
			if(ret > 0){
				return ret;
			}
			
		}
		if(v.element().equals(x))return p;
		return -1;
	}
 
 
 
 
 
 
 
	 
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
