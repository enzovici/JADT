package ADT_ListContainer;

import position.Position;
import position.PositionList;

public interface ListPosition<E> extends Position<E>{

	public void setPosition(Position<PositionList<E>> pos);
	
	public Position<PositionList<E>> position();
	
}
