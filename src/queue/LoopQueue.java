package queue;



/**
 *  实现一个循环 队列
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {

    // 成员变量
    private E[] data;  // 存储数据

    // 维护指针
    private int front, tail;

    // 队列的大小
    private int size;

    // 构造函数
    public LoopQueue(int capacity){
        // +1 是因为 需要保持 (tail + 1) % length == front ，判断队列满
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    // 默认构造函数
    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;  // 多出一个是用于判断队列满
    }


    @Override
    public int getSize() {
        return size;
    }

    // 判断队列是否为空
    @Override
    public boolean isEmpty() {
        return tail == front;  // 看两个指针是否相同
    }
    // 入队操作
    @Override
    public void enqueue(E e) {
        // 判断队列是否满了
        if ((tail + 1) % data.length == front)
            resize(getCapacity() * 2);   // 进行扩容操作

        data[tail] = e;
        // 维护尾指针
        tail = (tail + 1) % data.length;
        size++;

    }

    // 扩容操作
    private void resize(int newCapacity){

        // 分配空间
        E[] newData = (E[])new Object[newCapacity + 1];  // +1 是保证判断队列满

        // 遍历存值
        for (int i = 0; i < size; i++){
            newData[i] = data[(i + front) % data.length];  // i + front ,表示 front不在下标为 0 的地方， % 是因为 循环出现 front 出现在 tail 的后面
        }

        // 维护指针
        data = newData;
        front = 0;  // 指向新的数组后，新数组的起始位置
        tail = size; // 扩容后，数组的大小肯定大于 size
        // size 大小不变
    }

    // 出队操作
    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("队列为空");
        // 返回出队的值
        E ret = data[front];

        // 维护 指针
        front = (front + 1) % data.length;
        size --;

        // 如果队列太大，进行缩容
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);

        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("队列为空");

        return data[front];
    }

    //


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue: size = %d，capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length){
            res.append(data[i]);
            if ((i + 1) % data.length != tail){  // 非最后一个元素的情况
                res.append(", ");
            }
        }

        res.append("] tail");
        return res.toString();
    }


    public static void main(String[] args) {

        LoopQueue<Integer> queue = new LoopQueue<>();

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
