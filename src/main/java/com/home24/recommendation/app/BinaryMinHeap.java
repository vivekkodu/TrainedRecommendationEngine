package com.home24.recommendation.app;

import java.lang.reflect.Array;

/**
 * Created by VIVEK VERMA on 1/14/2017.
 */
public class BinaryMinHeap<E extends Comparable<E>> {
    private int heapSize = 0;
    private int capacity;
    private E[] heap;

    public BinaryMinHeap(int capacity, Class<E> clazz){
        this.capacity = capacity;
        this.heap = (E[]) Array.newInstance(clazz, capacity);
    }

    public void insert(E element){
        if(heapSize == capacity){
            if(this.heap[0].compareTo(element) < 0) {
                this.removeMin();
            }
            else{
                // New element is smaller than the top element.
                return;
            }
        }

        heap[heapSize] = element;
        this.heapifyUp(heapSize);
        heapSize++;
    }

    public void removeMin(){
        if(heapSize == 0){
            return;
        }

        heap[0] = heap[heapSize-1];
        heap[heapSize-1] = null;
        heapSize--;

        this.heapifyDown(0);
    }

    public E getMin(){
        if(heapSize == 0){
            return null;
        }else{
            return heap[0];
        }
    }

    public int getHeapSize(){
        return this.heapSize;
    }

    private void heapifyUp(int index){
        if (index == 0){
            return;
        }

        int parentId;
        int siblingIndex;
        boolean isIndexLeftChild = index%2 ==1;
        if(isIndexLeftChild){
            siblingIndex = index + 1;
            parentId = index/2;
        }else{
            siblingIndex = index - 1;
            parentId = index/2 -1;
        }

        if(this.heap[index].compareTo(this.heap[parentId]) < 0){
            E temp = this.heap[index];
            this.heap[index] = this.heap[parentId];
            this.heap[parentId] = temp;

            if(siblingIndex < this.heapSize && this.heap[siblingIndex].compareTo(this.heap[parentId]) < 0){
                this.heap[parentId] = this.heap[siblingIndex];
                this.heap[siblingIndex] = temp;
            }

            heapifyUp(parentId);
        }
    }

    private void heapifyDown(int index){
        boolean rootLargerThanLeftChild = false;
        boolean rootLargerThanRightChild = false;

        if(2 * index + 1 < this.heapSize && this.heap[index].compareTo(this.heap[2 * index + 1]) > 0){
            rootLargerThanLeftChild = true;
        }

        if(2 * index + 2 < this.heapSize && this.heap[index].compareTo(this.heap[2 * index + 2]) > 0){
            rootLargerThanRightChild = true;
        }

        if(rootLargerThanLeftChild && rootLargerThanRightChild){
            if(this.heap[2 * index + 1].compareTo(this.heap[2* index + 2]) < 0){
                E temp = this.heap[index];
                this.heap[index] = this.heap[2 * index + 1];
                this.heap[2 * index + 1] = temp;
                heapifyDown(2 * index + 1);
            }else{
                E temp = this.heap[index];
                this.heap[index] = this.heap[2 * index + 2];
                this.heap[2 * index + 2] = temp;
                heapifyDown(2 * index + 2);
            }
        }else if(rootLargerThanRightChild){
            E temp = this.heap[index];
            this.heap[index] = this.heap[2 * index + 2];
            this.heap[2 * index + 2] = temp;
            heapifyDown(2 * index + 2);
        }else if(rootLargerThanLeftChild){
            E temp = this.heap[index];
            this.heap[index] = this.heap[2 * index + 1];
            this.heap[2 * index + 1] = temp;
            heapifyDown(2 * index + 1);
        }
    }
}
