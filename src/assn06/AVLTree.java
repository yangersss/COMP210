package assn06;

public class AVLTree<T extends Comparable<T>> implements SelfBalancingBST<T> {
    // Fields
    private T _value;
    private AVLTree<T> _left;
    private AVLTree<T> _right;
    private int _height;
    private int _size;
    
    public AVLTree() {
        _value = null;
        _left = null;
        _right = null;
        _height = -1;
        _size = 0;
    }

    /**
     * Rotates the tree left and returns
     * AVLTree root for rotated result.
     */
     private AVLTree<T> rotateLeft() {
         // You should implement left rotation and then use this 
         // method as needed when fixing imbalances.
    	 // TODO
         AVLTree<T> root = this._right;
         AVLTree<T> temp = this._right._left;
         this._right._left = this;
         this._right = temp;

         //now adjust height and size
         _height = 1 + Math.max(_left == null ? -1 : _left._height, _right == null ? -1 : _right._height);
         root._height = 1 + Math.max(root._left._height, root._right == null ? -1 : root._right._height);

         _size = 1 + (_left == null ? 0 : _left._size) + (_right == null ? 0 : _right._size);
         root._size = 1 + (root._left._size) + (root._right == null ? 0 : root._right._size);

         return root;
     }
    
    /**
     * Rotates the tree right and returns
     * AVLTree root for rotated result.
     */
     private AVLTree<T> rotateRight() {
         // You should implement right rotation and then use this 
         // method as needed when fixing imbalances.
    	 // TODO
         AVLTree<T> root = this._left;
         AVLTree<T> temp = this._left._right;
         this._left._right = this;
         this._left = temp;

         //like in rotateLeft()
         _height = 1 + Math.max(_left == null ? -1 : _left._height, _right == null ? -1 : _right._height);
         root._height = 1 + Math.max(root._left._height, root._right == null ? -1 : root._right._height);

         _size = 1 + (_left == null ? 0 : _left._size) + (_right == null ? 0 : _right._size);
         root._size = 1 + (root._left._size) + (root._right == null ? 0 : root._right._size);

         return root;
     }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int height() {
        return _height;
    }

    @Override
    public int size() {
        return _size;
    }

    @Override
    public SelfBalancingBST<T> insert(T element) {
    	// TODO
        //insertion
        if (this.isEmpty()){
            //System.out.println("if this.isEmpty()");
            _value = element;
            _size = 1;
            _height = 0;
        } else {
            //System.out.println("entered the else statement");
            if (element.compareTo(_value) >= 0) {
                //System.out.println("if element.compareTo(_value) >= 0");
                if (_right == null) _right = new AVLTree<>();
                _right = (AVLTree<T>) _right.insert(element);
            } else {
                //System.out.println("2nd else statement");
                if (_left == null) _left = new AVLTree<>();
                _left = (AVLTree<T>) _left.insert(element);
            }
            //update size and height
            //size = 1+size of left and right
            //height = 1+max(height of left and right)
            //System.out.println("updating size + height");
            _size = 1 + (_left == null ? 0 : _left._size) + (_right == null ? 0 : _right._size);
            _height = 1 + Math.max(_left == null ? -1 : _left._height, _right == null ? -1 : _right._height);
        }
        //self-balancing

        return this;
    }

    @Override
    public SelfBalancingBST<T> remove(T element) {
    	// TODO
        /*
        first, search (go left, go right)
        if it's a leaf, delete parent reference to it
        DECREASE SIZE WHEN REMOVING TODO
        */
        System.out.println("called remove function");
        if (this == null) {
            System.out.println("Node not found, nothing to remove");
            return this;
        }

        if (element.compareTo(_value) < 0){
            if (_left != null){
                System.out.println("go left");
                _left = (AVLTree<T>) _left.remove(element);
            }
        }
        else if (element.compareTo(_value) > 0){
            if (_right != null){
                System.out.println("go right");
                _right = (AVLTree<T>) _right.remove(element);
            }
        }
        else{ //found node
            System.out.println("found node");
            if (_left != null && _right != null){
                _value = _right.findMin();
                _right = (AVLTree<T>) _right.remove(_value);
            } else if (_left != null) {
                System.out.println("node with only left child");
                return _left;
            } else if (_right != null) {
                System.out.println("node with only right child");
                return _right;
            } else {
                System.out.println("leaf node");
                return null;
            }
        }

        //update size and height
        _size = 1 + (_left == null ? 0 : _left._size) + (_right == null ? 0 : _right._size);
        _height = 1 + Math.max(_left == null ? -1 : _left._height, _right == null ? -1 : _right._height);

        //self balancing

        return this;
    }

    @Override
    public T findMin() {
         if (isEmpty()) {
             throw new RuntimeException("Illegal operation on empty tree");
         }
         if (_left == null) {
             return _value;
         } else {
             return _left.findMin();
         }
    }

    @Override
    public T findMax() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal operation on empty tree");
        }
        if (_right.isEmpty()) {
            return _value;
        } else {
            return _right.findMax();
        }
    }

    @Override
    public boolean contains(T element) {
    	// TODO
        if (_value == null) return false;
        else if (_value.equals(element)) return true;
        else if (_value.compareTo(element) < 0) return _left.contains(element);
        else return _right.contains(element);
    }

    @Override
    public T getValue() {
        return _value;
    }

    @Override
    public SelfBalancingBST<T> getLeft() {
        if (isEmpty()) {
            return null;
        }
        return _left;
    }

    @Override
    public SelfBalancingBST<T> getRight() {
        if (isEmpty()) {
            return null;
        }
         return _right;
    }

}
