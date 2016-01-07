package ADT_ListContainer;

import position.NodePositionList;
import position.Position;
import position.PositionList;

public class MyPositionList<E> extends NodePositionList<E> implements ListPosition<E> {

	private Position<PositionList<E>> location;
	
	
	public MyPositionList(){
		super();
		location =null;
	}
	
	
	public Position<PositionList<E>> position() {
		return location;
	}


	public void setPosition(Position<PositionList<E>> pos) {
		location = pos;
	}

	
	public E element() {
		return null;
	}

}
