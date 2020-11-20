package stack;

public class LinkedListStack<E> implements Stack<E> {

    // 成员变量
    private LinkedList<E> list;

    public LinkedListStack(){
        list = new LinkedList<>();// 初始化一个具有头结点的 node
    }


    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack top ");
        res.append(list);
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for (int i = 0; i < 5; i++){
            // 入栈
            stack.push(i);
            System.out.println(stack);
        }

        // 出栈测试
        stack.pop();
        System.out.println(stack);
    }

}
