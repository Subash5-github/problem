public class ResizableArray {
    private int[] array;
    private int size;
    private int capacity;

    public ResizableArray() {
        capacity = 10; 
        array = new int[capacity];
        size = 0; 
    }

    private void resize() {
        int[] newArray = new int[capacity * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        capacity *= 2;
    }

    public void add(int element) {
        if (size == capacity) {
           
            resize();
        }
        array[size++] = element;
    }

    public void display() {
        System.out.print("Array elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ResizableArray dynamicArray = new ResizableArray();

     
        dynamicArray.add(10);
        dynamicArray.add(20);
        dynamicArray.add(30);
        dynamicArray.add(40);
        dynamicArray.add(50);
        dynamicArray.display();

    
        dynamicArray.add(60);
        dynamicArray.add(70);
        dynamicArray.add(80);
        dynamicArray.add(90);
        dynamicArray.add(100);
        dynamicArray.display();
    }
}

