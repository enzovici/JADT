package stack;

public class TestStack {
	public static void main(String[] args) {
	ArrayStack<Integer> A = new ArrayStack<Integer>();
	A.push(7);
	A.pop();
	A.push(9);
	System.out.println("Contenuto dello stack A: " + A.toString());
	ArrayStack<Integer> B = new ArrayStack<Integer>();
	B.push(1);
	B.push(2);
	B.push(3);
	System.out.println("Contenuto dello stack B: " + B.toString());
	System.out.println("A e B sono uguali? " + A.equals(B));
	ArrayStack<Integer> C = new ArrayStack<Integer>();
	C = (ArrayStack<Integer>)B.clone();
	System.out.println("Clone di B: " + C.toString());
	System.out.println("B e C sono uguali? " + C.equals(B));
	
	//Prova per il double
	ArrayStack<Integer> D = new ArrayStack<Integer>();
	D.push(1);
	D.push(2);
	D.push(1);
	D.push(1);
	D.push(2);
	D.push(1);
	System.out.println("Lo stack D è " + D.toString());
	System.out.println("D è double ? " + D.Double());
	System.out.println("Lo stack D dopo il double è " + D.toString());
	
	ArrayStack<Integer> E = new ArrayStack<Integer>();
	E.push(1);
	E.push(2);
	E.push(1);
	E.push(3);
	System.out.println("Lo stack E è " + E.toString());
	System.out.println("E è double ? " + E.Double());
	System.out.println("Lo stack E dopo il double è " + E.toString());
	}
	
}