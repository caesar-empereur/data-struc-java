package com.stackqueue;

/**
 * Created by yang on 2020/9/20.
 *
 * 以链表为存储容器的栈结构
 */
public class LinkStack<T> {

    private Node<T> top;

    private int length;

    public LinkStack() {
        length = 0;
        top=null;
    }

    /*
    入栈操作
     */
    public void push(T obj){
        top = new Node<>(obj, top);
        length++;
    }

    /*
    栈顶出栈操作
     */
    public T pop(){
        if (top == null){
            return null;
        }
        T returnValue = top.value;
        top = top.next;
        length--;
        return returnValue;
    }

    /*
    获取栈顶元素
     */
    public T getHead(){
        if (top == null){
            return null;
        }
        return top.value;
    }

    /*
    获取栈顶元素
     */
    public T peek(){
        if (top == null){
            return null;
        }
        return top.value;
    }

    public int size(){
        return length;
    }

    public boolean isEmpty(){
        return  top == null;
    }

    /*
    一次访问栈中的每个元素
     */
    public void access(){
        if (top == null){
            return;
        }
//        do {
//            System.out.println(top.value);
//        } while ((top = top.next) != null);
        Node<T> temp = top;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void clear(){
        top = null;
    }

    private static class Node<T>{
        private T value;
        private Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

    }
}
