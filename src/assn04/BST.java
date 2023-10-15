package assn04;

public interface BST<T extends Comparable<T>> {

  /**
   * Inserts element into the tree in the appropriate position.
   * Either returns the mutated tree after insertion or a new tree
   * with the inserted element.
   *
   * @param element to be added to the tree
   * @return BST<T> after insertion
   **/
  BST<T> insert(T element);

  /**
   * Removes the element from the tree if it is present.
   * Either returns the possibly mutated tree after removal or an empty tree.
   *
   * @param element to be removed from tree
   * @return BST<T> after removal
   */
  BST<T> remove(T element);

  /**
   * Prints the tree in depth-first pre-order traversal.
   * Print the elements all in one line with a space after each element.
   */
  void printPreOrderTraversal();

  /**
   * Prints the tree in post-order traversal.
   * Print the elements all in one line with a space after each element.
   */
  void printPostOrderTraversal();

  //@return int which is based on the number of edges. -1 for an EmptyBST.
  int getHeight();

/**
 * Following are some methods which are self-explanatory.
 */
  T findMin();

  BST<T> getLeft();

  BST<T> getRight();

  T getElement();
  
  boolean isEmpty();
}
