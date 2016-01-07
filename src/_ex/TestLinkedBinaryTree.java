package _ex;

import binaryTree.*;
import position.Position;


public class TestLinkedBinaryTree {
	 public static void main(String[] args){
		 
		LinkedBinaryTree<Integer> albero = new LinkedBinaryTree<Integer>();
		albero.addRoot(0);
		Position<Integer>  last =  albero.insertLeft(albero.root(), 1);
		System.out.println(last.element());
		 
		 
	 }
}
