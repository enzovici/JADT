package arrayList;

public class TestArrayList {
	public static void main(String[] args) {
		ArrayIndexList<String> A = new ArrayIndexList<String>();
		ArrayIndexList<String> B = new ArrayIndexList<String>();
		//A.add(1,a); //da' errore
		//A.get(7); //lancia errore
		A.add(0,"a");
		System.out.println(A.get(0));
		A.isEmpty();
		//A.remove(1); //da’ errore
		A.add(1, "b");
		A.add(2, "c");
		A.add(3, "d");
		System.out.println("Contenuto del vector" + A.toString());
		A.set(2, "cc");
		System.out.println(A.get(2));
		System.out.println("Contenuto del vector" + A.toString());
		A.remove(1);
		System.out.println("Contenuto di A:" + A.toString());
		//Cloniamo A e controlliamo se dopo il clone sono rimasti inalterati
		B = (ArrayIndexList<String>)A.clone();
		System.out.println("Contenuto di B:" + B.toString());
		System.out.println("Contenuto di A:" + A.toString());
		
		//Controlliamo se A e B sono uguali 
		System.out.println("A e B sono uguali? " + A.equals(B));
		//eliminiamo un elemento ad uno dei dui vettori e ricontrolliamo
		System.out.println("Grandezza di B = " + B.size());
		B.remove(2);
		System.out.println("Grandezza di B dopo remove = " + B.size());
		System.out.println("Contenuto di B:" + B.toString());
		System.out.println("Dopo il remove sono uguali? " + A.equals(B));
		B.add(2,"e");
		System.out.println("Contenuto di B dopo l'add:" + B.toString());
		B.invertTo(2);
		
		System.out.println("Contenuto di B dopo invertTo():" + B.toString());
		}
	}
