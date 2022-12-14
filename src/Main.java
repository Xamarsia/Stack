public class Main {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < 6; i++) {
            stack.add(i);
        }

        for(int i = 0; i < 6; i++) {
            System.out.println(stack.pop());
        }

        System.out.println(stack.size());

        stack.push(9);

        System.out.println("Values are equal:  " + (stack.peek() == 9));
        System.out.println("The stack is empty:  " + stack.empty());

        for(int i = 0; i < 6; i++) {
            stack.add(i);
        }

        System.out.println("Search index in the stack:  " + stack.search(2));
        System.out.println("Object not in the stack:  " + stack.search(6));

        System.out.println("Object contains in the stack:  " + stack.contains(3));
    }
}