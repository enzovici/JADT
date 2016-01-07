package deque;

public class TestDeque {
	public static void main(String[] args){
	
	NodeDeque<Integer> A = new NodeDeque<Integer>();
	NodeDeque<Integer> B = new NodeDeque<Integer>();
	NodeDeque<Integer> B_rev = new NodeDeque<Integer>();
	A.addFirst(1);
	A.addFirst(4);
	A.addLast(2);
	A.addFirst(3);
	
	System.out.println("A " + A.toString());
	System.out.println("A.size = " + A.size());
	B = (NodeDeque<Integer>) A.clone();
	System.out.println("B dopo il clone->" + B.toString());
	System.out.println("B.size = " + B.size());
	System.out.println("A = B ? " + A.equals(B));
	System.out.println("A " + A.toString());
	
	B_rev = (NodeDeque<Integer>) B.reverse();
	System.out.println("B_rev " + B_rev.toString());
	System.out.println("B = B_rev ? " + B.equals(B_rev));
	}
}
