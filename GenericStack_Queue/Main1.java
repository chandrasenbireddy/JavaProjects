public class Main1 {
    public static void main(String[] args){
        GenericStack<String> stack = new GenericStack<>();
        stack.push("Chocolate");
        stack.push("Stawberry");
        stack.push("Grapes");
        stack.push("Banana");
        stack.push("Milk");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.size());

        System.out.println("Queue Start");

        GenericQueue<Integer> queue = new GenericQueue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.size());
        System.out.println(queue);
    }
}
