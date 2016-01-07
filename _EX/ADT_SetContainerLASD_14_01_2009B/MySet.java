package ADT_SetContainerLASD_14_01_2009B;

import position.Position;
import set.ListSet;
import set.Set;

public class MySet<E> extends ListSet<E> {
	
	private Position<Set<E>> location;
	
	
	public MySet(){
		super();
		location=null;
	}
	
	public Position<Set<E>> position(){
		return location;
	}

	public void setPosition(Position<Set<E>> temp){
		location=temp;
	}
}
