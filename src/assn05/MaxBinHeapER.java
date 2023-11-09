package assn05;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MaxBinHeapER  <V, P extends Comparable<P>> implements BinaryHeap<V, P> {

    private List<Prioritized<V,P>> _heap;
    /**
     * Constructor that creates an empty heap of hospital.Prioritized objects.
     */
    public MaxBinHeapER() {
        _heap = new ArrayList<>();
    }

    /**
     * Constructor that builds a heap given an initial array of hospital.Prioritized objects.
     */
    // TODO (Part 3): overloaded constructor
    public MaxBinHeapER(Prioritized<V, P>[] initialEntries ) {
        /*
        Build heap:

         */
    }

    @Override
    public int size() {
        return _heap.size();
    }

    // TODO: enqueue
    @Override
    public void enqueue(V value, P priority) {
        /*
        Insert in breadth-first order
        perform a bubble up operation
            compare with parent, if order not correct, swap
            recurse upwards
         */
        _heap.add(new Patient(value, priority));
        bubbleUp();
    }

    // TODO: enqueue
    public void enqueue(V value) {
        _heap.add(new Patient(value));
        bubbleUp();
    }

    //left child: 2i+1
    //right child: 2i+2
    //parent: floor((i-1)/2)

    // TODO: dequeue
    @Override
    public V dequeue() {
        /*
        Remove from top of heap, replace with last element
        Bubble it down (recursively)
            find max of left/right and swap
            recurse down
         */

        if (_heap.size() == 0) return null;

        V top = _heap.get(0).getValue();
        _heap.set(0, _heap.get(_heap.size() - 1));

        //bubble down
        int index = 0;
        while (2 * index + 2 < _heap.size()){ //while the (hypothetical) child's indices are valid
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            if (_heap.get(left).getPriority().compareTo(_heap.get(right).getPriority()) > 0) { //left is bigger than right
                swap(index, left);
                index = left;
            }
            else {
                swap(index, right);
                index = right;
            }
        }
        return top;
    }

    private void swap(int index1, int index2) {
        Prioritized temp = _heap.get(index1);
        _heap.set(index1, _heap.get(index2));
        _heap.set(index2, temp);

    }

    private void bubbleUp(){
        int index = _heap.size() - 1;
        while (index > 0) {
            int parentIndex = (index-1)/2;

            if (_heap.get(index).getPriority().compareTo(_heap.get(parentIndex).getPriority()) > 0){
                swap(index, parentIndex);
            }
            index = parentIndex;
        }
    }

    // TODO: getMax
    @Override
    public V getMax() {
       if (_heap.size() == 0) return null;
       return _heap.get(0).getValue();
    }

    @Override
    public Prioritized<V, P>[] getAsArray() {
        Prioritized<V,P>[] result = (Prioritized<V, P>[]) Array.newInstance(Prioritized.class, size());
        return _heap.toArray(result);
    }
}