package stack;

import java.util.ArrayList;

@SuppressWarnings("all") // unterdrueckt alle Warnings
public class Stack extends ArrayList {

	public Object pop() {
		return super.remove(super.size() - 1);
	}

	public void push(Object e) {
		super.add(e);
	}
}
