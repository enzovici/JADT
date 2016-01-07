package sequence;

import position.Position;

public class TestSequence {

	public static void main(String[] args) {

	    NodeSequence<String> S = new NodeSequence<String>();
	    
	    S.addFirst("a");
	    Position<String> prima = S.first();
	    
	    S.addLast("b");
    	S.addLast("c");
	    S.addLast("c");
	    S.addLast("c");
	    S.addLast("b");
	    S.addLast("d");
	    S.addLast("d");
	    S.addLast("a");
	    S.addLast("x");
	    Position<String> x1=S.last();
	    S.addLast("x");

	    System.out.println("***************************************************************");
	    System.out.print("Ecco gli elementi nella sequenza");
	    System.out.println(S.toString());
	    
	    System.out.println("Dammi l'elemento in posizione 2: " + S.get(2));
	    
	 //   S.makeFirst(x1);
	    System.out.print("Ecco gli elementi nella sequenza dopo il makeFirst di a2:");
	    System.out.println(S.toString());
	}
}
