package ObserverPattern;

import java.util.*;

public class ObserverPattern {

	public static void main(String[] args) {

		ConcreteSubject ns = new ConcreteSubject();

		BinaryObserver bs = new BinaryObserver(ns);
		DecimalObserver ds = new DecimalObserver(ns);
		OctalObserver os = new OctalObserver(ns);

		HexidecimalObserver hs = new HexidecimalObserver(ns);

		ns.setVal(10);
		System.out.println("Before");
		System.out.println(bs.s);
		System.out.println(ds.s);
		System.out.println(os.s);
		System.out.println(hs.s);

		System.out.println("------------");
		ns.setVal(15);
		System.out.println("After");
		System.out.println(bs.s);
		System.out.println(ds.s);
		System.out.println(os.s);
		System.out.println(hs.s);

	}
}

interface Subject {
	public void registerObserver(Observer o);

	public void removeObserver(Observer o);

	public void notifyObserver();
}

interface Observer {

	public void update(int v);

}

class ConcreteSubject implements Subject {

	private ArrayList<Observer> list;
	private int currVal;

	public ConcreteSubject() {
		this.list = new ArrayList<>();
		this.currVal = 0;
	}

	public void setVal(int nVal) {
		this.currVal = nVal;
		notifyObserver();
	}

	public int getVal() {
		return this.currVal;
	}

	@Override
	public void registerObserver(Observer o) {
		this.list.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		this.list.remove(o);

	}

	@Override
	public void notifyObserver() {
		for (Observer o : this.list) {
			o.update(currVal);
		}

	}

}

class BinaryObserver implements Observer {
	String s = "";
	int v = 0;
	ConcreteSubject cs;

	BinaryObserver(ConcreteSubject cs) {
		this.cs = cs;
		this.cs.registerObserver(this);
	}

	public void update(int v) {

		this.v = v;
		s = Integer.toBinaryString(v);
	}

}

class DecimalObserver implements Observer {
	String s = "";
	int v = 0;
	ConcreteSubject cs;

	DecimalObserver(ConcreteSubject cs) {
		this.cs = cs;
		this.cs.registerObserver(this);
	}

	public void update(int v) {

		this.v = v;
		s = v + "";
	}
}

class OctalObserver implements Observer {
	String s = "";
	int v = 0;
	ConcreteSubject cs;

	OctalObserver(ConcreteSubject cs) {
		this.cs = cs;
		this.cs.registerObserver(this);
	}

	public void update(int v) {

		this.v = v;
		s = Integer.toOctalString(v);
		// s=Integer.toHexString(v);
	}
}

class HexidecimalObserver implements Observer {
	String s = "";
	int v = 0;
	ConcreteSubject cs;

	HexidecimalObserver(ConcreteSubject cs) {
		this.cs = cs;
		this.cs.registerObserver(this);
	}

	public void update(int v) {

		this.v = v;

		s = Integer.toHexString(v);
	}
}
