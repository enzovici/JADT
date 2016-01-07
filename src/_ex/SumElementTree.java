package _ex;

import exception.EmptyTreeException;
import position.Position;
import tree.Tree;

public class SumElementTree {
			
	public static int sumAllNodes(Tree<Integer> T){
		
		if(T.isEmpty())throw new EmptyTreeException("Errore: albero vuoto");
		return sumAllNodes(T,T.root(),0);
		
	}
	
	
	public static int sumAllNodes(Tree<Integer> T, Position<Integer> v,int sum){
		if(T.isInternal(v)){
			for(Position<Integer> c: T.children(v)) sum += sumAllNodes(T, c, sum);
		}
		
		return sum +v.element();
		
	}
	
	
}
