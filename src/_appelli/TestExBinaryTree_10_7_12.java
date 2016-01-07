package _appelli;

import position.Position;
import binaryTree.*;


public class TestExBinaryTree_10_7_12 {
		public static void main(String[] args){
			
			LinkedBinaryTree<String> T = new LinkedBinaryTree<String>();
			
			T.addRoot("Root");
			
			BTPosition<String> root = (BTPosition<String>) T.root();
			
			BTNode<String> b = new BTNode<String>("b",root,null,null);
			BTNode<String> c = new BTNode<String>("c",root,null,null);
			
			root.setRight(b);
			root.setLeft(c);
			
			
			BTNode<String> d = new BTNode<String>("d",b,null,null);
			BTNode<String> e = new BTNode<String>("e",b,null,null);
			
			b.setRight(d);
			b.setLeft(e);
			
			BTNode<String> f = new BTNode<String>("f",c,null,null);
			BTNode<String> g = new BTNode<String>("g",c,null,null);
			
			c.setRight(f);
			c.setLeft(g);
			
			BTNode<String> h = new BTNode<String>("h",g,null,null);
			BTNode<String> i = new BTNode<String>("i",g,null,null);
			
			g.setRight(h);
			g.setLeft(i);
			
			
			
			//System.out.println(T.left(c).element());
			
			System.out.println(ExBinaryTree_10_7_12.check(T));
			
		}
}

