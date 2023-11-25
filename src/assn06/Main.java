package assn06;

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

        System.out.println("height and size after insertion");
        System.out.println(tree.height());
        System.out.println(tree.size());

        tree.remove(40);
        tree.remove(84);
        tree.remove(12);
        tree.remove(31);
        tree.remove(1337);
        System.out.println("height and size after removal");
        System.out.println(tree.height());
        System.out.println(tree.size());

        System.out.println("testing with given code");
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
        System.out.println("height and size after 50 random:");
        System.out.println(avl_bst.height());
        System.out.println(avl_bst.size());


        // Now insert 50 integers in increasing order which would
        // cause a simple BST to become very tall but for our
        // self-balancing tree won't be too bad (should be 7)
        for (int i=0; i<50; i++) {
            avl_bst = avl_bst.insert(i);
            System.out.println("okay, inserted, now height and size:");
            System.out.println(avl_bst.height());
            System.out.println(avl_bst.size());
        }
        System.out.println("height and size after 50 increasing:");
        System.out.println(avl_bst.height());
        System.out.println(avl_bst.size());
    }
}