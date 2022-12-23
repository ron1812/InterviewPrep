package com.practice.queuestack;

import java.util.Stack;

public class QueueUsingStack {

    /*
    enQueue(q,  x)
  1) Push x to stack1 (assuming size of stacks is unlimited).
Here time complexity will be O(1)

deQueue(q)
  1) If both stacks are empty then error.
  2) If stack2 is empty
       While stack1 is not empty, push everything from stack1 to stack2.
  3) Pop the element from stack2 and return it.
Here time complexity will be O(n)

     */
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public QueueUsingStack(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    private void push(Stack<Integer> stackToPush, Integer intToPush){
        stackToPush.push(intToPush);
    }

    public void enqueue(Integer intToPush){
        push(stack1,intToPush);
    }

    private Integer pop(Stack<Integer> stackToPop){
        return stackToPop.pop();
    }

    public Integer dequeue(){
        if(stack1.isEmpty() && stack2.isEmpty()){
            return Integer.MAX_VALUE;
        }

        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                push(stack2,pop(stack1));
            }
        }

        return pop(stack2);
    }

    public static void main(String[] args) {
        QueueUsingStack queueUsingStack = new QueueUsingStack();
        queueUsingStack.enqueue(1);
        queueUsingStack.enqueue(2);

        System.out.println(queueUsingStack.dequeue());
        System.out.println(queueUsingStack.dequeue());

        queueUsingStack.enqueue(3);


        System.out.println(queueUsingStack.dequeue());
    }

}
