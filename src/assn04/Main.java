package assn04;

public class Main {
  public static void main(String[] args) {
    /*
    This is a basic example of how to create a BST and add values
    to it (which have been commented out).
    You should add more examples and use this class to debug your code
    */
    BST<Integer> bst = new NonEmptyBST<>(78);
    bst.insert(31);
    bst.insert(84);
    bst.insert(13);
    bst.insert(38);
    bst.insert(10);
    bst.insert(40);
    bst.insert(12);
    bst.insert(39);
    bst.insert(47);
    System.out.println(bst.findMin());
    //bst.remove();
    //bst.printPreOrderTraversal();
    //bst.printPostOrderTraversal();

  }

}
