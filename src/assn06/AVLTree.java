package assn06;

import assn04.EmptyBST;
import assn04.NonEmptyBST;

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
        if (this.isEmpty()) _value = element;
        else if (element.compareTo(_value) >= 0 && _right.isEmpty()) _right._value = element;
        else if (element.compareTo(_value) < 0 && _left.isEmpty()) _left._value = element;
        else if (element.compareTo(_value) >= 0) _right.insert(element);
        else _left.insert(element);
        //self-balancing

        _size ++;
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
        //remove
        if (_value.compareTo(element) < 0) _left = (AVLTree<T>) _left.remove(element);
        else if (_value.compareTo(element) > 0) _right = (AVLTree<T>) _right.remove(element);
        else{
            if (_left.isEmpty() && _right.isEmpty()) return new AVLTree<T>(); // leaf
            else if (_left.isEmpty()) return _right; // single child
            else if (_right.isEmpty()) return _left;
            else { //two children
                _value = _right.findMin();
                _right = (AVLTree<T>) _right.remove(_right.findMin());
            }
        }
        //self-balancing


        return this;
    }

    @Override
    public T findMin() {
         if (isEmpty()) {
             throw new RuntimeException("Illegal operation on empty tree");
         }
         if (_left.isEmpty()) {
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
