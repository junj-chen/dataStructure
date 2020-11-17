package LinkedList;

public class LinkedList<E> {

    // 创建节点
    private class Node{
        public E e;
        public Node next;

        // 构造函数
        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }
    }

    // 链表的成员变量
    private Node dummyHead;  // 虚拟头结点
    private int size;

    // 构造函数
    public LinkedList(){
        dummyHead = new Node(null, null);  //创建一个虚拟头结点
        size = 0;
    }

    // 获取链表中的元素个数
    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    // 在链表的index 位置添加新的元素 e
    public void add(int index, E e){

        if (index < 0 || index > size)
            throw new IllegalArgumentException("下标出错");

        Node pre = dummyHead;  // 指向 虚拟头结点
        for (int i = 0; i < index; i++){
            pre = pre.next;  //移动指针,找到下标的前一个指针
        }
//            Node node = new Node(e);
//            node.next = pre.next;
//            pre.next = node;
        pre.next = new Node(e, pre.next);
        size ++;
    }

    // 链表头添加元素
    public void addFirst(E e){
        add(0, e);  //添加元素
        size ++;
    }

    // 链表末尾添加新的元素
    public void addLast(E e){
        add(size, e);
    }





}
