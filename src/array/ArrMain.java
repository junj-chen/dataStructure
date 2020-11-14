package array;

import java.util.Arrays;

public class ArrMain {

    private int[] data;

    private  int size;

    public ArrMain(int capacity){
        data = new int[capacity];
        size = 0;
    }

    // 默认构造函数，初始化为10个元素大小
    public ArrMain(){
        this(10);
    }


    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public void addLast(int e){
        if (size == data.length)
            throw new IllegalArgumentException("数组已满");

        data[size] = e;
        size++;
    }

    // 第一个位置插入元素
    public void addFirst(int e){
        add(0, e);
    }


    // 在某一个位置插入元素,
    public void add(int index, int e){

        if (size == data.length)
            throw new IllegalArgumentException("数组已满");

        if (index < 0 || index > data.length)
            throw new IllegalArgumentException("下标越界");

        int i = 0;

        // 数组操作时，通过移动最后一个元素，进行数组的移动
        for (i = size - 1; i >= index; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public int get(int index){
        if (index <0 || index >= size)
            throw new IllegalArgumentException("下标出错");

        return data[index];
    }

    public void set(int index, int e){
        if (index <0 || index >= size)
            throw new IllegalArgumentException("下标出错");

        data[index] = e;
    }

    //
    public boolean contains(int e){

        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return true;
        }
        return false;
    }

    public int remove(int index){
        int old = 0;
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("下标出错");

        old = data[index];
        for (int i = index; i < size; i++){
            data[i] = data[i + 1];
        }
        size--;

        return old;

    }

    // 返回索引值
    public int find(int e){
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return i;
        }
        return -1;
    }

    public int removeFirst(){
        return remove(0);
    }

    public int removeLast(){
        return remove(size - 1);
    }

    // 数组中删除一个元素
    public void removeElement(int e){

        int index = find(e);
        if (index != -1)
            remove(index);
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

        ArrMain arrMain = new ArrMain(20);

        ArrMain ee = new ArrMain(20);

        String s1 = new String("aaa");
        String s2 = new String("aaa");

        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);   // 引用对比

        for (int i = 0; i < 10; i++){
            arrMain.addLast(i);
        }

//        System.out.println(arrMain.getSize());
//        System.out.println(arrMain.getCapacity());
        System.out.println(arrMain);

        arrMain.add(2, 10);
        System.out.println(arrMain);
        arrMain.addFirst(-1);
        System.out.println(arrMain);
        arrMain.remove(11);
        System.out.println(arrMain);

    }


}
