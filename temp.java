
import java.util.ArrayList;
import java.util.Collection;

public class MyMinHeap<E extends Comparable<E>> implements MinHeapInterface<E>{
    protected ArrayList<E> data;

    /**
     * No-argument constructor that initializes data to 
     * an empty ArrayList.
     */
    public MyMinHeap()
    {
        data = new ArrayList<E>();
    }

    /**
     * Initializes a min-heap using the elements in collection.
     * First, initialize data using the 
     * ArrayList(Collection<? extends E> collection) constructor 
     * by directly passing in the collection argument.
     * Next, iterate through data backward, percolating each element down. 
     * We will soon write the percolateDown() helper method, 
     * which can be used here.
     * Throws NullPointerException if collection or any element 
     * in collection is null.
     * @param collection the arraylist being inserted
     */
    public MyMinHeap(Collection<? extends E> collection)
    {
        if(collection == null) 
            throw new NullPointerException();
       
        data = new ArrayList<E>(collection); // does this work?
        for(int i = data.size() - 1; i > 0; i--)
        {
            if(data.get(i) == null) 
                throw new NullPointerException();
            //data.add(0, collection.);
            //if(i <= data.size()/2)
                percolateUp(i);
            //else 
                //percolateDown(i);
        }//whyyyyy
        for(int i = 0; i < data.size(); i++)
        {
           percolateDown(i);
        }//whyyyyy
    }

    /**
     * Swap the elements at from and to indices in data.
     * You may assume from and to will be within bounds.
     * @param from the index being swaped
     * @param to the index being swaped
     */
    protected void swap(int from, int to)
    {
        Object temp = data.get(to);
    
        data.set(to, data.get(from));

        data.set(from, (E)temp);
    }
    /**
     * Calculate and return the parent index of the parameter index.
     * This method is irrelevant to what is currently in data 
     * and should not make any changes to data.
     * You may assume index > 0.
     * @param index the child index
     * @return the parent index
     */
    protected static int getParentIdx(int index)
    {
        return (index-1)/2;
    }

    /**
     * Calculate and return the left child index of the parameter index.
     * This method is irrelevant to what is currently in data
     *  and should not make any changes to data.
     * You may assume index >= 0.
     * @param index the parent index
     * @return the index of left child
     */
    protected static int getLeftChildIdx(int index)
    {
        if(index == 0)
            return 1;
        return index*2 + 1;
    }

    /**
     * Calculate and return the right child index of the parameter index.
     * This method is irrelevant to what is currently in data 
     * and should not make any changes to data.
     * You may assume index >= 0.
     * @param index the index of right child
     * @return the right child
     */
    protected static int getRightChildIdx(int index)
    {
        if(index == 0)
            return 2;
        return index*2 + 2;
    }

    /**
     * Return the index of the smaller child of the element at index. 
     * If the two children are equal,
     * return the index of the left child. 
     * If the node at index is a leaf (has no children), return -1.
     * Note that it's also possible for a single node in 
     * our heap to have only one child. 
     * In this case, return the index of the left child 
     * (we know that this is a heap so all nodes are as far left as possible)
     * You may assume that index will be within bounds.
     * getMinChildIndex depends on what is currently in data, 
     * but does not make any changes to data.
     * @param index the index of min child
     * @return the min child of the index
     */
    protected int getMinChildIdx(int index)
    {
        int left = getLeftChildIdx(index);
        int right = getRightChildIdx(index);
        // could we use the null property to check for leaf?
        boolean leftNotInBound = left >= data.size();
        boolean rightNotInBound = right >= data.size();
        if( leftNotInBound && rightNotInBound)
        { // Is a leaf node's children null?
            return -1;
        }
        else
        {
            if(rightNotInBound)
            {
                return left;
            }//how to compare generics?
            if(data.get(left).compareTo(data.get(right)) <= 0)
            {
                return left;
            }
            else
            {
                return right;
            }
        }

    }

    /**
     * Percolate the element at index up until no heap properties
     *  are violated by this element 
     * (the heap properties will not be violated once this element's
     *  parent is not greater than it). 
     * Do this by swapping the element with its parent as needed.
     * Note the case where the element that you are percolating is
     *  equal to the parent. 
     * In this case, the heap property requiring that a node 
     * be no greater than 
     * its children is already satisfied, 
     * so you should not swap the element you are percolating
     *  with the parent.
     * You may assume that index will be within bounds.
     * percolateUp makes changes in data.
     * @param index the index of the element being percolate up
     */
    protected void percolateUp(int index)
    {
        if(index == 0)
        {

        }
        else
        {
            int parent = getParentIdx(index);
            while(index > 0)
            {
                if(data.get(parent).compareTo(data.get(index)) > 0)
                {
                    swap(index, parent);
                    index = parent;
                    parent = getParentIdx(index);
                }
                else
                {
                    break;
                }
            }
        }
    }

    /**
     * Percolate the element at index down until no heap properties
     *  are violated by this element 
     * (the heap properties will not be violated once this element 
     * is not greater than its children). 
     * If swapping is needed, always swap places with the smaller child. 
     * If both children are equal and swapping is needed, swap with the 
     * left child.
     * Note the case where the element that you are percolating is 
     * equal to the smaller child. 
     * In this case, the heap property requiring that a node be 
     * no greater than its children is already satisfied, 
     * so you should not swap the element you are percolating with the child.
     * You may assume that index will be within bounds.
     * percolateDown makes changes in data.
     * @param index the index of the element being percolate down
     */
    protected void percolateDown(int index)
    {
        //leaf base case
        
        while (index != -1){
            int minChild = getMinChildIdx(index);
            E value = data.get(index);
            if(minChild == -1)
            {
                break;
            }
            if(data.get(minChild).compareTo(value) < 0)
            {
                swap(index, minChild);
                index = minChild;
            }
            else 
            {
                break;
            }
        }
    }

    /**
     * Remove the element at index from data and return it.
     * If we are removing the last element then the heap properties 
     * are maintained.
     * In other cases, we will replace the deleted element with the
     *  last element in the heap 
     * (the right-most node in the bottom-most level of the heap)
     *  to fix the completeness property.
     * Then, either percolate this element down or percolate 
     * this element up as necessary 
     * until no heap properties are violated by this element 
     * (only one of these actions will be necessary to maintain 
     * the heap property, 
     * all fixes to the key order property should be by perc
     * olating the replacement element).
     * The deleteIndex explanation can be found in the Appendix
     * You can assume that index will be within bounds.
     * deleteIndex makes changes in data.
     * @param index the index of deleting element
     * @return the element on that index
     */
    protected E deleteIndex(int index)
    {
        if(index == data.size() - 1)
        {
            return data.remove(index);
        }
        E temp = (E)data.get(index);
        E replace = data.get(data.size()-1);
        data.remove(data.size()-1);
        data.set(index, replace);
        if(temp.compareTo(replace) > 0)
        {
            percolateUp(index);
        }
        else
        {
            percolateDown(index);
        }
        
        return temp;

    }

    /**
     * Add element to the end of the heap (so that it is the 
     * right-most element in the bottom-most level) and percolate 
     * only the inserted element up until no heap properties are violated 
     * (all fixes to the heap properties should be by this percolation).
     * Throw a NullPointerException and do not add to the heap 
     * if element is null.
     * The insertion explanation can be found in the Appendix
     * @param element the obejct being inserted
     */
    public void insert(E element)
    {
        if(element == null)
            throw new NullPointerException();
        data.add (element);
        percolateUp(data.size()-1);
    }

    /**
     * Return the root (this will be the smallest) element of the heap. 
     * If the heap is empty, return null instead.
     * @return the root of the heap
     */
    public E getMin()
    {
        if(data.size() == 0)
            return null;
        return data.get(0);
    }

    /**
     * Remove and return the root (this will be the smallest) 
     * element in the heap. 
     * Use deleteIndex() helper method here. 
     * If the heap is empty, return null instead.
     * @return the root of the heap
     */
    public E remove()
    {
        if(data.size() == 0)
            return null;
        return deleteIndex(0);
    }

    /**
     * Return the number of elements in this min-heap.
     * @return the length of the data
     */
    public int size()
    {
        return data.size();
    }

    /**
     * Clear out the entire heap (the heap should be empty after this call).
     */
    public void clear()
    {
        data = new ArrayList<E>();
    }
}
