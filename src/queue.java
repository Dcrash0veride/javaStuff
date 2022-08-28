public class queue {
    int top;
    int beginning;
    int[] arr;

    public queue(int size) {
        this.top = -1;
        this.beginning = -1;
        this.arr = new int[size];
        System.out.println("The Q has been created Succesfully");

    }

    public boolean isFull() {
        if (top == arr.length -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (beginning == -1 || beginning == arr.length) {
            return true;
        } else {
            return false;
        }
    }

    public void enQueue(int value) {
        if (isFull()) {
            System.out.println("The q is full");
        } else if (isEmpty()) {
            beginning = 0;
            top++;
            arr[top] = value;
            System.out.println("Successfully inserted " + value + " in the queue");
        } else {
            top++;
            arr[top] = value;
            System.out.println("Successfully inserted " + value + " in the Q");
        }

    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("The q is empty");
            return -1;
        } else {
            int result = arr[beginning];
            beginning++;
            if (beginning > top) {
                beginning = top = -1;
            }
            return result;
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return arr[beginning];
        } else {
            return -1;
        }
    }

    public void deleteQ() {
        arr = null;
        System.out.println("Q Deleted");
    }

    public static void main(String[] args) {
    queue myQ = new queue(5);
    System.out.println(myQ.top);
    System.out.println(myQ.isFull());
    System.out.println(myQ.isEmpty());
    myQ.enQueue(3);
    myQ.enQueue(6);
    myQ.enQueue(2);
    myQ.enQueue(4);
    myQ.enQueue(78);
    myQ.enQueue(67);
    int res = myQ.peek();
    System.out.println(res);
    int res2 = myQ.deQueue();
    System.out.println(res2);
    int res3 = myQ.deQueue();
    System.out.println(res3);
    int res4 = myQ.deQueue();
    System.out.println(res4);
    myQ.deQueue();
    myQ.deQueue();
    myQ.deleteQ();
}
}

The Q has been created Succesfully
-1
false
true
Successfully inserted 3 in the queue
Successfully inserted 6 in the Q
Successfully inserted 2 in the Q
Successfully inserted 4 in the Q
Successfully inserted 78 in the Q
The q is full
3
3
6
2
Q Deleted

Process finished with exit code 0
