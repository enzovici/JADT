package ADT_StackContainer;

import position.Position;
import stack.Stack;

public interface MyStackPosition<E> extends Position<E> {

	public Position<Stack<E>> position();

	public void setPosition(Position<Stack<E>> p);
}
