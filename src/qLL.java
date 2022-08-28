public class qLL {
    NodeLL.singlyLL list;

    public qLL() {
       list = new NodeLL.singlyLL();
       System.out.println("The Q has been created");
    }

    public boolean isEmpty() {
        if (list.head == null) {
            return true;
        } else {
            return false;
        }
    }

    public void enQue(int value) {
        list.insertSLL(value, list.size);
        System.out.println( value + " has been inserted");
    }

    public int deQue() {
        int value = -1;
        if (isEmpty()) {
            System.out.println("The Q is empty");
            return value;
        } else {
            value = list.head.value;
            list.deleteNodeSLL(0);
            return value;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("The q is empty");
            return -1;
        } else {
            return list.head.value;
        }
    }

    public void deleteQuu() {
        list.deleteEntireSLL();
        System.out.println("Q has been deleted");
    }



    static class NodeLL {
        public int value;
        public NodeLL next;

        static class singlyLL {
            public NodeLL head;
            public NodeLL tail;
            public int size;

            public NodeLL createSLL(int nodeValue) {
                head = new NodeLL();
                NodeLL node = new NodeLL();
                node.next = null;
                node.value = nodeValue;
                tail = new NodeLL();
                head = node;
                tail = node;
                size = 1;
                return head;
            }

            // Insertion Method in SLL
            public void insertSLL(int nodeValue, int location) {
                NodeLL node = new NodeLL();
                node.value = nodeValue;
                if (head == null) {
                    createSLL(nodeValue);
                    return;
                } else if (location == 0) {
                    node.next = head;
                    head = node;
                } else if (location >= size) {
                    node.next = null;
                    tail.next = node;
                    tail = node;
                } else {
                    NodeLL tempNode = head;
                    int index = 0;
                    while (index < location - 1) {
                        tempNode = tempNode.next;
                        index++;
                    }
                    NodeLL nextNode = tempNode.next;
                    tempNode.next = node;
                    node.next = nextNode;
                }
                size++;
            }

            public void traverseSLL() {
                if (head == null) {
                    System.out.println("SLL does not exist");
                } else {
                    NodeLL tempNode = head;
                    for (int i = 0; i < size; i++) {
                        System.out.print(tempNode.value);
                        if (i != size - 1) {
                            System.out.print("->");
                        }
                        tempNode = tempNode.next;
                    }
                }
                System.out.println(" ");
            }

            public int searchSLL(int nodeValue) {
                if (head == null) {
                    System.out.println("No list to search dawg");
                } else {
                    NodeLL tempNode = head;
                    for (int i = 0; i < size; i++) {
                        if (tempNode.value != nodeValue) {
                            tempNode = tempNode.next;
                        } else {
                            return i;
                        }
                    }
                    return -1;
                }
                return -1;
            }

            public void deleteNodeSLL(int index) {
                if (head == null) {
                    System.out.println("SLL does not exist");
                    return;
                } else if (index == 0) {
                    head = head.next;
                    size--;
                    if (size == 0) {
                        tail = null;
                    }
                } else if (index >= size) {
                    NodeLL tempNode = head;
                    for (int i = 0; i < size - 1; i++) {
                        tempNode = tempNode.next;
                    }
                    if (tempNode == head) {
                        tail = head = null;
                        size--;
                        return;
                    }
                    tempNode.next = null;
                    tail = tempNode;
                    size--;
                } else {
                    NodeLL tempNode = head;
                    for (int i = 0; i < index - 1; i++) {
                        tempNode = tempNode.next;
                    }
                    tempNode.next = tempNode.next.next;
                    size--;
                    return;
                }
            }

            public void deleteEntireSLL() {
                head = null;
                tail = null;
            }
        }
    }

    public static void main(String[] args) {
        qLL myQll = new qLL();
        System.out.println(myQll);
        boolean result = myQll.isEmpty();
        System.out.println(result);
        myQll.enQue(4);
        myQll.enQue(5);
        myQll.enQue(6);
        System.out.println(myQll.peek());
        System.out.println(myQll.peek());
        System.out.println(myQll.deQue());
        System.out.println(myQll.deQue());
        System.out.println(myQll.peek());
        myQll.deleteQuu();
        System.out.println(myQll.isEmpty());
        System.out.println(myQll.peek());


    }
}

The Q has been created
qLL@4dd8dc3
true
4 has been inserted
5 has been inserted
6 has been inserted
4
4
4
5
6
Q has been deleted
true
The q is empty
-1

Process finished with exit code 0

