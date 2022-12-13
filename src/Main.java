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
    }
}