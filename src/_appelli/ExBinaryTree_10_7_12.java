package _appelli;

import position.Position;
import exception.EmptyTreeException;
import binaryTree.*;

public class ExBinaryTree_10_7_12 {
	
	public static <E> boolean check(LinkedBinaryTree<E> T){
	
	int countDX = 0;
	int countSX = 0;
		
	if(T.isEmpty())throw new EmptyTreeException("albero vuoto");
	BTPosition<E> v = (BTPosition<E>) T.root();
	
	if(!(T.hasRight(v)))return false;
		
	if(!(T.hasLeft(v))){
		if(T.isInternal(v))return true;
	}
	
	countDX = preorderCount(T,T.right(v),countDX);
	countSX = preorderCount(T,T.left(v),countSX);
	System.out.println(countSX+ " - " +countDX);
	if(countDX >= countSX)return true;
	return false;
		
	}
	
	private static <E> int preorderCount(LinkedBinaryTree<E> T, Position<E> position,int count){
		
		if(T.hasRight(position)){
			Position<E> v = T.right(position);
			if(T.isInternal(v)){
				count++;
				preorderCount(T,T.right(position),count);
			}
		}
		
		if(T.hasLeft(position)){
			Position<E> v = T.left(position);
			if(T.isInternal(v)){
				count++;
				preorderCount(T,T.left(position),count);
			}
		}
		
		
	return count + 1;
	}
	
	
}

