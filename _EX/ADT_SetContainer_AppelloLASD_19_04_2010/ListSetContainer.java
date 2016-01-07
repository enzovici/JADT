package ADT_SetContainer_AppelloLASD_19_04_2010;
import java.util.*;

import nodeList.NodePositionList;
import nodeList.PositionList;
import position.*;
import comparator.DefaultComparator;
import set.Set;

public class ListSetContainer<E> implements SetContainer<E>{

	private PositionList<Set<E>> lista;
	private Comparator<Integer> comp;
	
	
	public ListSetContainer(){
		lista = new NodePositionList<Set<E>>();
		comp = new DefaultComparator<Integer>();
	}
	
	public Set<E> insert(E e) {
		MySet<E> insieme = new MySet<E>();
		insieme.insert(e);
		lista.addLast(insieme);
		insieme.setPosition(lista.last());
		return insieme;
	}

	public int insert(Set<E> S, E e) {
		MySet<E> insieme = (MySet<E>) S;
		
		if(insieme.position()==null)
			throw new InvalidPositionException("Non esiste questo insieme nel contenitore..");
		
		insieme.insert(e);
		lista.remove(insieme.position());
		ordinaInsiemi(insieme);
		return insieme.size();
	}

	public Set<E> removeSmallest() {
		MySet<E> ins = (MySet<E>)lista.first().element();
		lista.remove(ins.position());
		
		while(comp.compare(ins.size(),lista.first().element().size())==0)
			lista.remove(lista.first());
		
		return ins;
	}
	
	public int size(){
		return lista.size();
	}
	
	public boolean isEmpty(){
		return lista.isEmpty();
	}
	
	public String toString(){
		String stampa="";
		for(Set<E> s : lista){
			stampa+="[";
			for(E e: s.elements())
				stampa+=e+"-";
			stampa=stampa.substring(0,stampa.length()-1);
			stampa+="] ";
		}
		return stampa;
	}
	
	private void ordinaInsiemi(Set<E> s) {
		MySet<E> insieme = (MySet<E>) s;
		
		for(Position<Set<E>> set : lista.positions()){
			if(comp.compare(insieme.size(),set.element().size())<=0){
				lista.addBefore(set,insieme);
				insieme.setPosition(lista.prev(set));
				return;
			}
		}
		lista.addLast(insieme);
		insieme.setPosition(lista.last());
	}


}
