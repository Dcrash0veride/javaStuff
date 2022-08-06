import java.util.Scanner;
import java.util.ArrayList;

public class Solution {


    static class Stack {
        ArrayList<String> stack = new ArrayList<>();
        int topOfStack = -1;

        public void push(String data) {
            stack.add(data);
            topOfStack++;
        }

        public String pop() {
            if (topOfStack == -1) {
                return "Stack Empty";
            } else {
                String temp = stack.get(topOfStack);
                stack.remove(topOfStack);
                topOfStack--;
                return temp;
            }
        }

        public String peek() {
            if (topOfStack == -1) {
                return "Stack Empty";
            } else {
                return stack.get(topOfStack);
            }
        }

        public int size() {
            return stack.size();
        }
    }

    public static boolean compareChar(String input) {
        String reOpenBraces = "([{<";
        String reClosedBraces = ")]}>";
        Stack stackOpen = new Stack();
        for (int i = 0; i < input.length(); i++) {
            if (reOpenBraces.contains(String.valueOf(input.charAt(i)))) {
                stackOpen.push(String.valueOf(input.charAt(i)));
            } else if (reClosedBraces.contains((String.valueOf(input.charAt(i))))) {
                String brace = stackOpen.pop();
                String myBracker = String.valueOf(input.charAt(i));
                if (myBracker.equals(")") && brace.equals("(")) {

                } else if (myBracker.equals("]") && brace.equals("[")) {

                } else if (myBracker.equals("}") && brace.equals("{")) {

                } else if (myBracker.equals(">") && brace.equals("<")) {
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /* Read Lines from System.in for each line output "valid" for every open symbol in the set
    "([{ <" if it has a matching closing symbol ")]}>" and they are not interleaved
    else output invalid
     */

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNextLine()) {
                String newIn = sc.next();
                if (newIn.equals("exit")) {
                    break;
                } else {
                    if (compareChar(newIn)) {
                        System.out.println("Valid");
                    } else {
                        System.out.println("Invalid");
                    }
                }
            }
        }
    }
}



