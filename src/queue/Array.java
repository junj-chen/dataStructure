package queue;

public class Array<E> {

    /**
     * 实现动态数组
     */

    private E[] data;

    private  int size;

    public Array(int capacity){
        // 泛型 -> 先使用object类型，然后强制类型转换
        data = (E[])new Object[capacity];
        size = 0;
    }

    // 默认构造函数，初始化为10个元素大小
    public Array(){
        this(10);
    }

    // 判断是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public void addLast(E e){
        add(size, e);
    }

    // 第一个位置插入元素
    public void addFirst(E e){
        add(0, e);
    }


    // 在某一个位置插入元素,
    public void add(int index, E e){


        if (index < 0 || index > size)
            throw new IllegalArgumentException("下标越界");

        // 数组不够， 开始扩容，动态数组实现
        if (size == data.length)
            resize(2*data.length); //扩容的大小为 当前数组长度的两倍

        int i = 0;

        // 数组操作时，通过移动最后一个元素，进行数组的移动
        for (i = size - 1; i >= index; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public E get(int index){
        if (index <0 || index >= size)
            throw new IllegalArgumentException("下标出错");

        return data[index];
    }

    // 获取最后一个元素
    public E getLast(){
        // 通过使用 get 方法，有效避免下标出错
        return get(size - 1);
    }
    // 获取第一个元素
    public E getFirst(){
        return get(0);
    }


    public void set(int index, E e){
        if (index <0 || index >= size)
            throw new IllegalArgumentException("下标出错");

        data[index] = e;

    }

    //
    public boolean contains(E e){

        for (int i = 0; i < size; i++) {
            // 值 比较
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    public E remove(int index){

        if (index < 0 || index >= size)
            throw new IllegalArgumentException("下标出错");

        E old = data[index];
        // 删除时，注意下标
        for (int i = index + 1; i < size; i++){
            data[i - 1] = data[i];
        }

        size--;
        // 指向一个引用，可以进行手动释放
        data[size] = null;  // GC 自动回收

        // 如果数组容量太大，进行容量的减少
        /**
         * 该代码会出现复杂度的震荡，使用 lazy 机制，当size == length / 4时候，才进行容量的裁剪
         */
//        if (size == data.length / 2)
//            resize(data.length / 2);

        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);

        return old;

    }

    // 返回索引值
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    // 数组中删除一个元素
    public void removeElement(E e){

        int index = find(e);
        if (index != -1)
            remove(index);
    }

    /**
     * 扩容函数， 私有的方法，不允许被外部调用
     * @param newCapacity
     */
    private void resize(int newCapacity){

        // 新建一个数组，容量为原始数组的两倍
        E[] newData = (E[])new Object[newCapacity];

        for (int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        // data 指向 newData, size 不用改变， 数组的容量已经发生变化，原始data指向的数据失去引用，会被回收
        data = newData;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d，capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++){
            res.append(data[i]);
            if (i != size - 1){
                res.append(",");
            }
        }

        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {

        Array<Integer> arrMain = new Array<>(); // 默认容量 10

        for (int i = 0; i < 10; i++){
            arrMain.addLast(i);
        }
        System.out.println(arrMain);

        // 添加一个元素，动态扩容
        arrMain.add(1, 100);
        System.out.println(arrMain);

        arrMain.addFirst(-1);
        System.out.println(arrMain);

        // 减少数据
        arrMain.remove(2);
        System.out.println(arrMain);

        arrMain.removeElement(5);
        System.out.println(arrMain);

        arrMain.removeFirst();
        System.out.println(arrMain);

        /**
         *  输出：
         * Array: size = 10，capacity = 10
         * [0,1,2,3,4,5,6,7,8,9]
         * Array: size = 11，capacity = 20
         * [0,100,1,2,3,4,5,6,7,8,9]
         * Array: size = 12，capacity = 20
         * [-1,0,100,1,2,3,4,5,6,7,8,9]
         * Array: size = 11，capacity = 20
         * [-1,0,1,2,3,4,5,6,7,8,9]
         * Array: size = 10，capacity = 10
         * [-1,0,1,2,3,4,6,7,8,9]
         * Array: size = 9，capacity = 10
         * [0,1,2,3,4,6,7,8,9]
         */
    }


}
