package queue;

/**
 * 基于动态数组方式实现的 队列
 * @param <E>
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();

}
