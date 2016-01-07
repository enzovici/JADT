package _ex;

import nodeList.PositionList;
import exception.EmptyTreeException;
import position.Position;
import tree.LinkedTree;
import tree.TreeNode;
import tree.TreePosition;

public class ExTree29_04<E> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		

	}
	
	
	public boolean cerca(LinkedTree<E> T, E el){
		if(T.isEmpty())throw new EmptyTreeException("albero vuoto");
		
		boolean flag = true;
		Position<E> root = T.root();
		return search(T,root,el);
	}
	
	
	public boolean search(LinkedTree<E> T,Position<E> v, E el){
		if(T.isExternal(v))return (v.element().equals(el));
		
		boolean flag = v.element().equals(el);
		if(flag == true)return true;
		
		for(Position<E> vChild : T.children(v)){
			flag = search(T,vChild,el);
			if(flag)return true;
			
		}
		
		
		return false;
	}

}
