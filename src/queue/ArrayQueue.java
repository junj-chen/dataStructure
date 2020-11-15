package queue;

public class ArrayQueue<E> implements Queue<E> {

    // 成员变量，基于动态数组实现
    private Array<E> array;

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayQueue(){
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    // 入队操作
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    // 出队操作
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    // 重写toString方法
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++){
            res.append(array.get(i));
            if (i != array.getSize() - 1){
                res.append(", ");
            }
        }

        res.append(" ] tail");
        return res.toString();
    }

    // 测试 队列
    public static void main(String[] args) {

        ArrayQueue<Integer> queue = new ArrayQueue<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }

        }

    }
}
