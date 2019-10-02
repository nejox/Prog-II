package übung17;

import java.util.ArrayList;

public class GenericStack<E> { //extends ArrayList<E>
	ArrayList<E> stack = new ArrayList<>();

	public static void main(String[] args) {
		GenericStack<String> s = new GenericStack<>();
		s.push("Hallo");
		s.push("Welt");
		System.out.println(s.pop());
		System.out.println(s.pop());
	}

	public void push(E element) {
		stack.add(element);
	}

	public E pop() {
		return stack.remove(stack.size() - 1);
	}
}
