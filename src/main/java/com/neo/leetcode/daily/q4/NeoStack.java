package com.neo.leetcode.daily.q4;

public class NeoStack<T> {
    private final int DEFAULT_STACK_SIZE = 8;

    private int top = -1; // 栈顶指针

    T[] objects = null;

    public NeoStack() {
        this.objects = (T[]) new Object[DEFAULT_STACK_SIZE];
    }

    public NeoStack(int size) {
        this.objects = (T[]) new Object[size];
    }

    //出栈
    public T pop(){
        if(isEmpty()){
            return null;
        }
        return objects[top--];
    }

    //入栈
    public void push(T t){
        if(top++ > DEFAULT_STACK_SIZE){
            throw new IllegalStateException("超出栈的大小");
        }
        objects[top] = t;
    }

    //返回栈顶元素
    public T peek(){
        if(isEmpty()){
            return null;
        }
        return objects[top];
    }

    //是否为空
    public boolean isEmpty(){
        return top == -1;
    }


    public void clear(){
        objects = (T[])new Object[DEFAULT_STACK_SIZE];
        top = -1;
    }

    public int length(){
        return  top;
    }


}
