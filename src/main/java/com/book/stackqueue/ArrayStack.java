package com.book.stackqueue;

/**
 * Created by yang on 2020/9/20.
 * 以数组为存储同期的栈的结构
 */
public class ArrayStack<T> {

    private T[] array;

    private int top;

    public ArrayStack() {
        top = -1;
        array = (T[])new Object[10];
    }

    public ArrayStack(int n) {
        if (n<=0){
            throw new RuntimeException("参数错误");
        }
        top = -1;
        array = (T[])new Object[n];
    }

    /*
    入栈
     */
    public void push(T object){
        //数组满了之后需要扩容
        if (top == array.length-1){
            T[] newArray = (T[])new Object[top*2];
            for (int i=0; i<=top; i++){
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[top++] = object;
    }

    /*
    出战
     */
    public T pop(){
        if (top == -1){
            throw new RuntimeException("栈为空");
        }
        return array[top--];
    }

    /*
    获取栈顶元素
     */
    public T getHead(){
        if (top == -1){
            throw new RuntimeException("栈为空");
        }
        return array[top];
    }

    public int size(){
        return top+1;
    }
}
