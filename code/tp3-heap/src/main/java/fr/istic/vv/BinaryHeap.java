package fr.istic.vv;

import java.util.ArrayList;
import java.util.Comparator;

class BinaryHeap<T> {

    private ArrayList<T> heap;
    private Comparator<T> comparator;

    public BinaryHeap(Comparator<T> comparator) {
        this.heap = new ArrayList<>();
        this.comparator = comparator;
    }

    public T pop() {
        if(heap.size()>0){
            T min = heap.get(0);

            for(int i=0; i<heap.size()-1;i++){
                swap(i,i+1);
            }
            heap.remove(heap.size()-1);

            return min;
        }
        else{
            return null;
        }
    }

    public T peek() {
        if(heap.size()>0){
            return heap.get(0);
        }
        else{
            return null;
        }
    }

    public void push(T element) {
        heap.add(element);

        int current = heap.size()-1;

        while((current>=1) && (comparator.compare(heap.get(current), heap.get(current-1))<0)){
            swap(current-1,current);
            current--;
        }
    }

    public int count() {
        return heap.size();
    }

    private void swap(int index1, int index2) {
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

}