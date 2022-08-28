public class circularQArray {
    int[] arr;
    int topIndex;
    int beginningIndex;
    int size;

    public circularQArray(int size) {
        this.arr = new int[size];
        this.size = size;
        this.topIndex = -1;
        this.beginningIndex = -1;
        System.out.println("Circular Q successfully created with size of " + size);
    }

    public boolean isEmpty() {
        if (topIndex == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (topIndex + 1 == beginningIndex) {
            return true;
        } else if (beginningIndex == 0 && topIndex + 1 == size) {
            return true;
        } else {
            return false;
        }
    }

    public void enQuue(int value) {
        if (isFull()) {
            System.out.println("The Q is full!");
        } else if (isEmpty()) {
            beginningIndex = 0;
            topIndex++;
            arr[topIndex] = value;
            System.out.println("The value " + value + " has successfully been inserted");
        } else {
            if (topIndex + 1 == size) {
                topIndex = 0;
            } else {
                topIndex++;
            }
            arr[topIndex] = value;
            System.out.println("The value " + value + " has successfully been inserted");
        }
    }

    public int dequu() {
        if (isEmpty()) {
            System.out.println("The q is empty");
            return -1;
        } else {
            int result = arr[beginningIndex];
            arr[beginningIndex] = 0;
            if (beginningIndex == topIndex) {
                beginningIndex = topIndex = -1;
            } else if (beginningIndex + 1 == size) {
                beginningIndex = 0;
            } else {
                beginningIndex++;
            }
            return result;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("The q is empty");
            return -1;
        } else {
            return arr[beginningIndex];
        }
    }

    public void deleteCQ() {
        arr = null;
        System.out.println("the q has been deleted");
    }

    public static void main(String[] args) {
        circularQArray myNewQ = new circularQArray(5);
        System.out.println(myNewQ.isEmpty());
        System.out.println(myNewQ.isFull());
        myNewQ.enQuue(4);
        myNewQ.enQuue(5);
        myNewQ.enQuue(6);
        myNewQ.enQuue(7);
        myNewQ.enQuue(8);
        myNewQ.enQuue(9);
        int result = myNewQ.dequu();
        System.out.println(result);
        int result2 = myNewQ.dequu();
        System.out.println(result2);
        System.out.println(myNewQ.peek());
        myNewQ.deleteCQ();
    }
}

Circular Q successfully created with size of 5
true
false
The value 4 has successfully been inserted
The value 5 has successfully been inserted
The value 6 has successfully been inserted
The value 7 has successfully been inserted
The value 8 has successfully been inserted
The Q is full!
4
5
6
the q has been deleted

Process finished with exit code 0
