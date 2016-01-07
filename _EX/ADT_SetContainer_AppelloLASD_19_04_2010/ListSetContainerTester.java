package ADT_SetContainer_AppelloLASD_19_04_2010;

import set.Set;


public class ListSetContainerTester {

	public static void main(String[] args) {
		
		ListSetContainer<Integer> lista = new ListSetContainer<Integer>();
		
		Set<Integer> ins1=lista.insert(8);
		lista.insert(ins1,19);
		lista.insert(ins1,111);
		lista.insert(ins1,23);
		lista.insert(ins1,8);
		lista.insert(ins1,8);
		lista.insert(ins1,5);
		lista.insert(ins1,3);	
		lista.insert(ins1,300);
		lista.insert(ins1,18);
		lista.insert(ins1,77);
		
		
		Set<Integer> ins2=lista.insert(9);
		lista.insert(ins2,19);
		lista.insert(ins2,111);
		lista.insert(ins2,23);
		lista.insert(ins2,8);
		lista.insert(ins2,8);
		lista.insert(ins2,5);
	
		
		Set<Integer> ins3=lista.insert(10);
		lista.insert(ins3,1);
		lista.insert(ins3,2);
		//lista.insert(ins3,3);
		
		
		Set<Integer> ins4=lista.insert(11);
		lista.insert(ins4,22);
		lista.insert(ins4,33);
		lista.insert(ins4,44);
		
		
		Set<Integer> ins5=lista.insert(12);
		lista.insert(ins5,55);
		lista.insert(ins5,66);
		lista.insert(ins5,77);
		
	
		System.out.println(lista.size());
		System.out.println(lista.isEmpty());
		System.out.println(lista.toString());
		lista.removeSmallest();
		System.out.println(lista.toString());
		//lista.removeSmallest();
		//System.out.println(lista.toString());
		
	}

}
