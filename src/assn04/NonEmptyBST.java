package assn04;

public class NonEmptyBST<T extends Comparable<T>> implements BST<T> {
	private T _element;
	private BST<T> _left;
	private BST<T> _right;

	public NonEmptyBST(T element) {
		_left = new EmptyBST<T>();
		_right = new EmptyBST<T>();
		_element = element;
	}

	// TODO: insert
	@Override
	public BST<T> insert(T element){
		//base case: if it goes into the left, if it goes into the right
		if (element.compareTo(_element) >= 0 && _right.isEmpty()) _right = new NonEmptyBST<T>(element); //if the right is empty and it goes in the right
		else if (element.compareTo(_element) < 0 && _left.isEmpty()) _left = new NonEmptyBST<T>(element);
		else if (element.compareTo(_element) >= 0) _right.insert(element);
		else _left.insert(element);
		return this;
	}

	// TODO: findMin
	@Override
	public T findMin() {
		if (_left.isEmpty()) return _element;
		else return _left.findMin();
	}

	// TODO: remove
	@Override
	public BST<T> remove(T element) {
		/*
		* if this is only element, return empty bst
		* if it's a leaf, delete parent reference to it
		* */
		// find the node first
		// if (_left.isEmpty() && _right.isEmpty()) return new EmptyBST<>(); //if tree is only one element

		if (element.compareTo(_element) < 0){ //go left
			_left = _left.remove(element);
		}
		else if (element.compareTo(_element) > 0) { //go right
			_right = _right.remove(element);
		}
		else{ //they're equal, remove this element
			if (_left.isEmpty() && _right.isEmpty()) return new EmptyBST(); // leaf
			else if (_left.isEmpty()) return _right; // single child
			else if (_right.isEmpty()) return _left;
			else { //two children
				_element = _right.findMin();
				_right.remove(_right.findMin());
			}
		}
		return this;
	}

	// TODO: printPreOrderTraversal
	@Override
	public void printPreOrderTraversal() {
	}

	// TODO: printPostOrderTraversal
	@Override
	public void printPostOrderTraversal() {
	}

	@Override
	public int getHeight() {
		   return Math.max(_left.getHeight(), _right.getHeight())+1;
	}

	@Override
	public BST<T> getLeft() {
		return _left;
	}

	@Override
	public BST<T> getRight() {
		return _right;
	}

	@Override
	public T getElement() {
		return _element;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}
}
