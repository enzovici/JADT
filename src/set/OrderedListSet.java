package set;

import java.util.Comparator;
import java.util.Iterator;

import comparator.DefaultComparator;

import nodeList.NodePositionList;
import nodeList.PositionList;
import position.Position;



public class OrderedListSet<E> implements Set<E> {

	private PositionList<E> set;
	private Comparator<E> c;
	
	//utile nell' implementazione di Partition
	private Position<Set<E>> loc;
	
	public OrderedListSet() {
		set = new NodePositionList<E>();
		c = new DefaultComparator();
	}
	
	public OrderedListSet(Comparator<E> comp){
		set = new NodePositionList<E>();
		c = comp;
	}
	
	public OrderedListSet(PositionList<E> l, Comparator<E> comp){
		this(comp);
		Iterator<E> it = l.iterator();
		while(it.hasNext()){
			set.addLast(it.next());
		}
	}
	
	public OrderedListSet(E x, Comparator<E> comp){
		this();
		c = comp;
		set.addFirst(x);
	}
	
	@Override
	public int size() {
		return set.size();
	}

	@Override
	public boolean isEmpty() {
		return (size() == 0);
	}

	@Override
	public Set<E> union(Set<E> B) {
		UnionMerge<E> uM = new UnionMerge<E>();
		PositionList<E> result = new NodePositionList<E>();
		uM.merge(set,((OrderedListSet<E>) B).set, c,result);
	 set = result;
	 
	 return this;
	}

	
	@Override
	public Set<E> intersect(Set<E> B) {
	IntersectMerge<E> iM = new IntersectMerge<E>();
	PositionList<E> result = new NodePositionList<E>();
	iM.merge(set, ((OrderedListSet<E>)B).set, c, result);
	set = result;
	return this;
	}

	@Override
	public Set<E> subtract(Set<E> B) {
		SubstractMerge<E> sM = new SubstractMerge<E>();
		PositionList<E> result = new NodePositionList<E>();
		sM.merge(set, ((OrderedListSet<E>)B).set, c, result);
		set = result;
		return this;
	}

	public void fastUnion(Set<E> B){
		PositionList<E> blist = ((OrderedListSet<E>)B).set;
		while(!blist.isEmpty())
			set.addFirst(blist.remove(blist.last()));
	}

	
	public void fastInsert(E x){
		set.addFirst(x);
		
	}
	
	public void setLocation(Position<Set<E>> x){
		loc = x;
	}
	
	public Position<Set<E>> location(){
		return this.loc;
	}
	
	public PositionList<E> getSet(){
		return this.set;
	}
	
}
