package ADT_ListContainer;

import position.*;

public class ListContainerTester {

	public static void main(String[] args) {

		
		PositionList<Integer> listaInt = new NodePositionList<Integer>();
		
		listaInt.addLast(8);
		listaInt.addLast(9);
		listaInt.addLast(10);
		
		ListContainer<Integer> container = new ListContainer<Integer>();
		
		container.insert(listaInt);
		
		
		
	}

}
