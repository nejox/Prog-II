package übung19;

public class Baum<E extends Comparable<E>> {
	Knoten<E> root;

	public void insert(Knoten<E> k) {
		if (root == null) {
			root = k;
		} else {
			insert(root, k);
		}
	}

	protected void insert(Knoten<E> tmp, Knoten<E> k) {

		if (k.compareTo(tmp) <= 0) {
			// insertLeft
			if (tmp.getLeft() == null) {
				tmp.setLeft(k);
			} else {
				insert(tmp.getLeft(), k);
			}
		} else {
			if (tmp.getRight() == null) {
				tmp.setRight(k);
			} else {
				insert(tmp.getRight(), k);
			}
		}
	}

	public void ausgabe() {
		ausgabe(root);
	}

	protected void ausgabe(Knoten<E> k) {

		if (k.getLeft() != null) {
			ausgabe(k.getLeft());
		}
		System.out.println(k.getElement());

		if (k.getRight() != null) {
			ausgabe(k.getRight());
		}
	}

	public static class Knoten<E extends Comparable<E>> implements Comparable<Knoten<E>> {
		private E element;
		private Knoten<E> right;
		private Knoten<E> left;

		public Knoten(E element) {
			super();
			this.element = element;
		}

		public E getElement() {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}

		public Knoten<E> getRight() {
			return right;
		}

		public void setRight(Knoten<E> right) {
			this.right = right;
		}

		public Knoten<E> getLeft() {
			return left;
		}

		public void setLeft(Knoten<E> left) {
			this.left = left;
		}

		@Override
		public int compareTo(Knoten<E> o) {
			return this.element.compareTo( o.element);
		}

	}

}
