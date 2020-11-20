package stack;

import java.util.Random;

public class Main {

    // 用于计算 数组队列 与 循环队列之间 时间消耗
    private static double testStack(Stack<Integer> stack, int opCount){

        long startTime = System.nanoTime();

        Random random = new Random();

        // 入队
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }

        // 出队
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;


    }

    public static void main(String[] args) {
        int opCount = 100000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack, time: " + time1 + " s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);
        System.out.println("LinkedListStack, time: " + time2 + " s");

    }


}
