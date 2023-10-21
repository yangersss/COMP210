package assn04;

public class Main {
  public static void main(String[] args) {
    /*
    This is a basic example of how to create a BST and add values
    to it (which have been commented out).
    You should add more examples and use this class to debug your code
    */
    BST<Integer> bst = new NonEmptyBST<>(3);
    bst.insert(52);
    //bst.printPreOrderTraversal();
    //bst.printPostOrderTraversal();

  }

}
