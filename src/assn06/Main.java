package assn06;

import assn04.BST;
import assn04.NonEmptyBST;

public class Main {
    public static void main(String[] args) {

        System.out.println("testing insertion and deletion without self-balancing or rotation: ");
        AVLTree<Integer> tree = new AVLTree<>();
        tree.insert(78);
        tree.insert(31);
        tree.insert(84);
        tree.insert(13);
        tree.insert(38);
        tree.insert(10);
        tree.insert(40);
        tree.insert(12);
        tree.insert(39);
        tree.insert(47);

        // Create a new empty tree.
        SelfBalancingBST<Integer> avl_bst = new AVLTree<>();

        // Insert 50 random integers.
        // Note how we need to capture the result of insert back into
        // the variable avl_bst because the post-insertion root that is
        // returned may be different from the original root because of the insertion.
        // result should be about 6.
        for (int i=0; i<50; i++) {
            avl_bst = avl_bst.insert((int) (Math.random()*100));
        }
        System.out.println(avl_bst.height());

        // Now insert 50 integers in increasing order which would
        // cause a simple BST to become very tall but for our
        // self-balancing tree won't be too bad (should be 7)
        for (int i=0; i<50; i++) {
            avl_bst = avl_bst.insert(i);
        }
        System.out.println(avl_bst.height());
    }
}
