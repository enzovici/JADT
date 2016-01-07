package _ex;

import nodeList.NodePositionList;
import nodeList.PositionList;
import position.Position;
import tree.LinkedTree;
import tree.TreeNode;
import tree.TreePosition;

public class ExamTree<E> extends LinkedTree<E> {
	 
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





		
	
