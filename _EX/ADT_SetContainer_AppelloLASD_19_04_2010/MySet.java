package ADT_SetContainer_AppelloLASD_19_04_2010;

import position.Position;
import set.ListSet;
import set.Set;

public class MySet<E> extends ListSet<E> {

	private Position<Set<E>> location;
	
	public MySet(){
		super();
		location=null;
	}
	
	public void setPosition(Position<Set<E>> pos) {
		location=pos;
	}
	
	public Position<Set<E>> position(){
		return location;
	}
}
