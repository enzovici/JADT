package set;

import nodeList.PositionList;

public class TestOrderedListSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		OrderedListSet<String> A = new OrderedListSet<String>();
		A.fastInsert("a");
		A.fastInsert("b");
		A.fastInsert("b");
		A.fastInsert("c");
		A.fastInsert("d");
		PositionList<String> str = A.getSet();
		
		for(String e : str)System.out.print(e + " ");
		
		OrderedListSet<String> B = new OrderedListSet<String>();
		B.fastInsert("e");
		
		OrderedListSet<String> C = new OrderedListSet<String>();
		
		C =  (OrderedListSet<String>) A.union(B);
		str = C.getSet(); 
		
		System.out.println();
		for(String e : str)System.out.print(e + " ");
		
		
		
	}

}
