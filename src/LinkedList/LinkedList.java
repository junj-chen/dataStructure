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

    // 获取元素
    public E get(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("下标出错");
        Node cur = dummyHead.next;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size -1);
    }

    //设置值
    public void set(int index, E e){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("下标出错");
        Node cur = dummyHead.next;

        for (int i = 0; i < index; i++)
            cur = cur.next;
        cur.e = e;
    }

    // 查找某个元素值
    public boolean contains(E e){
        Node cur = dummyHead.next;

        while (cur != null){
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    // 从链表中删除元素
    public E remove(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("下标出错");

        Node pre = dummyHead;
        for (int i = 0; i < index; i++){
            pre = pre.next;   //查找到待删除元素的前一个元素
        }
        Node ret = pre.next;  //需要删除的元素
        pre.next = ret.next;
        ret.next = null;

        return ret.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null){
            res.append(cur.e + "->");
            cur = cur.next;
        }
        res.append("null");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 520);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.remove(1);
        System.out.println(linkedList);
    }


}
