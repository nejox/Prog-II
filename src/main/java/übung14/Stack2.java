package übung14;

import java.util.ArrayList;

public class Stack2 {
	private ArrayList<Object> stack = new ArrayList<>();

	public void push(Object e) {
		stack.add(e);
	}

	public Object pop() {
		if (stack.size() == 0) {
			throw new RuntimeException("Empty Stack");
		}
		return stack.remove(stack.size() - 1);
	}

	public ArrayList<Object> getStack() {
		return stack;
	}

	public int getSize() {
		return stack.size();
	}

}
