package hot100;

public class MinStack {
    // 这道题的难点在于如何在O(1)的时间复杂度内完成
    // 我们可以用两个栈来实现
    // 一个栈用来存储数据
    // 另一个栈用来存储当前栈中的最小值
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public MinStack() {
        // 初始化
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        // 先把数据压入数据栈
        dataStack.push(x);
        // 然后判断最小栈是否为空
        // 如果为空则直接把数据压入最小栈
        // 如果不为空则比较当前数据和最小栈的栈顶元素
        // 如果当前数据小于等于最小栈的栈顶元素则把当前数据压入最小栈
        // 否则把最小栈的栈顶元素再次压入最小栈
        if (minStack.isEmpty()) {
            minStack.push(x);// 如果最小栈为空则直接把数据压入最小栈
        } else {
            if (x <= minStack.peek()) {
                minStack.push(x);
            } else {
                minStack.push(minStack.peek());
            }
        }
    }
    public void pop() {
        // 先判断数据栈是否为空
        // 如果为空则直接返回
        // 如果不为空则把数据栈和最小栈的栈顶元素都弹出
        if (dataStack.isEmpty()) {
            return;
        } else {
            dataStack.pop();
            minStack.pop();
        }
    }

    public int top() {
        // 先判断数据栈是否为空
        // 如果为空则直接返回
        // 如果不为空则返回数据栈的栈顶元素
        if (dataStack.isEmpty()) {
            return -1;
        } else {
            return dataStack.peek();
        }
    }

    public int getMin() {
        // 先判断最小栈是否为空
        // 如果为空则直接返回
        // 如果不为空则返回最小栈的栈顶元素
        if (minStack.isEmpty()) {
            return -1;
        } else {
            return minStack.peek();
        }
    }

}
