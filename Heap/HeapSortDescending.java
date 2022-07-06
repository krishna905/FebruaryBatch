package Heap;

public class HeapSortDescending {
    private int maxSize;
    private int heap[];
    private int size;

    HeapSortDescending(int maxSize) {
        this.maxSize = maxSize;
        this.heap = new int[maxSize];
        this.size = 0;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return (2 * index + 1);
    }

    private int rightChild(int index) {
        return (2 * index + 2);
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    private void printHeap() {
        System.out.println("Current Heap: ");
        for(int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    private boolean isLeaf(int index) {
        return (index >= size / 2) && (index < size);
    }

    private void maxHeapify(int index) {
        if(!isLeaf(index)) {
            if(heap[index] < heap[leftChild(index)]
            || heap[index] < heap[rightChild(index)]) {
                if(heap[leftChild(index)] > heap[rightChild(index)]) {
                    swap(index, leftChild(index));
                    maxHeapify(leftChild(index));
                }
                else {
                    swap(index, rightChild(index));
                    maxHeapify(rightChild(index));
                }
            }
        }
    }

    private int extractFirstElement() {
        int rootElement = heap[0];
        heap[0] = heap[size - 1];
        size--;

        maxHeapify(0);

        return rootElement;
    }

    //insert into a max heap
    private void insert(int element) {
        heap[size] = element;

        int current = size;
        while(heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }

        size++;
    }

    public static void main(String[] args) {
        HeapSortDescending heapSortDescending = new HeapSortDescending(15);
        int requiredSize = 9;
        int range = 50;

        for(int i = 0; i < requiredSize; i++) {
            int randomNumber = (int)(Math.random() * range + 1);

            heapSortDescending.insert(randomNumber);
        }

        heapSortDescending.printHeap();

        System.out.println("Sorted: ");
        int initialSize = heapSortDescending.size;
        for(int i = 0; i < initialSize; i++) {
            int rootElement = heapSortDescending.extractFirstElement();
            System.out.print(rootElement + " ");
        }
        System.out.println();
    }
}
