package StrategyPattern;

public class StrategyPattern {

	public static void main(String[] args) {
		// changing behavior at run time
		
		mathsOperation opr = new mathsOperation(new addOperation());
		System.out.println("Using Add Behaviour " +opr.perform(12,4) );
		
		opr = new mathsOperation(new subOperation());
		System.out.println("Using Sub Behaviour " +opr.perform(12,4) );
		
		opr = new mathsOperation(new mulOperation());
		System.out.println("Using Mul Behaviour " +opr.perform(12,4) );
		
		opr = new mathsOperation(new divOperation());
		System.out.println("Using Div Behaviour " +opr.perform(12,4) );

	}
}

class mathsOperation{
	Strategy myOpr;
	
	public mathsOperation(Strategy myOpr) {
		this.myOpr = myOpr;
	}
	
	public int perform(int x,int y) {
		return myOpr.doOperation(x,y);
	}
	
}

interface Strategy{
	public int doOperation(int x,int y);
}

class addOperation implements Strategy{

	@Override
	public int doOperation(int x, int y) {
		return x+y;
	}
	
}

class subOperation implements Strategy{

	@Override
	public int doOperation(int x, int y) {
		return x-y;
	}
	
}

class mulOperation implements Strategy{

	@Override
	public int doOperation(int x, int y) {
		return x*y;
	}
	
}

class divOperation implements Strategy{

	@Override
	public int doOperation(int x, int y) {
		return x/y;
	}
	
}