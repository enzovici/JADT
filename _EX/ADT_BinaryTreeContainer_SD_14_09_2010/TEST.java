package ADT_BinaryTreeContainer_SD_14_09_2010;
import binaryTree.BinaryTree;
import position.Position;

public class TEST {

	/**
	 * NOME: Francesco
	 * COGNOME: Isernia
	 * MATRICOLA:  0510201785
	 */
	public static void main(String[] args) {
		
		ListBTContainer<Integer> lista = new ListBTContainer<Integer>();

		BinaryTree<Integer> A = lista.insert(1);
		BinaryTree<Integer> C = lista.insert(3);	
		BinaryTree<Integer> B = lista.insert(2);
		
		
		Position<Integer> a1 = lista.insertLeft(A, A.root(),7);
		Position<Integer> a2 = lista.insertRight(A,A.root(),9);
		Position<Integer> a3 = lista.insertLeft(A,a1,12);
		Position<Integer> a4 = lista.insertRight(A,a1,13);
		
		
		Position<Integer> b1 = lista.insertLeft(B, B.root(),3);
		Position<Integer> b2 = lista.insertRight(B,B.root(),4);
		Position<Integer> b3 = lista.insertLeft(B,b1,88);
		
		
		
		
	/*	//nodi albero A
		Position<Integer> a1 = lista.insertLeft(A, A.root(),7);
		Position<Integer> a2 = lista.insertRight(A,A.root(),9);
		Position<Integer> a3 = lista.insertLeft(A,a1,12);
		Position<Integer> a4 = lista.insertRight(A,a1,13);
		Position<Integer> a5 = lista.insertLeft(A, a2,77);
		Position<Integer> a6 = lista.insertRight(A,a2,88);
		
		//Nodi albero B
		Position<Integer> b1 = lista.insertLeft(B, B.root(),3);
		Position<Integer> b2 = lista.insertRight(B,B.root(),4);
		Position<Integer> b3 = lista.insertLeft(B,b1,88);
		*/
		
		System.out.println(lista.toString());
		
		System.out.println("\nQuantità di alberi nel contenitore prima della rimozione: "+lista.size());
		
		MyBTree<Integer> alberoRimosso = (MyBTree<Integer>) lista.remove();
		String stampa="[";
		for(Position<Integer> p : alberoRimosso.positions())
			stampa+=p.element()+" ";
		stampa.substring(0,stampa.length()-1);
		stampa+="]";
		
		System.out.println("Albero avente maggior numero di figli rimossi è : "+stampa);
		
		System.out.println("Quantità di alberi nel contenitore: "+lista.size());
		
		System.out.println("Il contenitore è vuoto ? "+lista.isEmpty());
	}

}
