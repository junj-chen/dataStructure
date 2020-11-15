package stack;


public class ArrayStack<E> implements Stack<E> {

    // 1.成员变量，初始数组
    Array<E> array;

    // 构造函数
    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }
    // 默认构造函数，初始化容量
    public ArrayStack(){
        array = new Array<>();
    }

    // 获取 当前栈的 大小
    @Override
    public int getSize(){
        return array.getSize();
    }

    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    // 获取数组栈的容量
    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void push(E e){
        array.addLast(e);
    }

    @Override
    public E pop(){
        return array.removeLast();
    }

    @Override
    public E peek(){
        return array.getLast();
    }

    @Override
    public String toString() {
       StringBuilder res = new StringBuilder();
       res.append("Stack: ");
       res.append('[');

        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1)
                res.append(", ");
        }
       res.append("] top");
        return res.toString();
    }

    /**
     * 测试 栈
     * @param args
     */
    public static void main(String[] args) {

        ArrayStack<Integer> stack = new ArrayStack<>();

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
