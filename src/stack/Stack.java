package stack;

/**
 * 实现一个栈，基于数组的方式
 *
 */

public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    // 入栈
    void push(E e);
    // 出栈
    E pop();
    // 获取栈顶元素
    E peek();

}
