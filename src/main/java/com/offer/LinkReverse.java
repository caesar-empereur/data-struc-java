package com.offer;

import java.util.LinkedList;

/**
 * @Description 链表反转，从尾到头打印链表
 * @author: yangyingyang
 * @date: 2020/10/12.
 */
public class LinkReverse {

    public static void main(String[] args) {
        //构造一个链表
        Node head = new Node();
        head.setData(1);
        Node curr = head;
        for (int i=2; i<10; i++){
            Node next = new Node();
            next.setData(i);
            curr.setNext(next);
            curr = next;
        }

        reverseNodePrint(head);
    }

    /**
     * 反转链表
     * 利用栈的先进后厨的特性，把链表压入到栈里面，再从栈弹出
     *
     * LinkedList 可以当作栈的结构来使用
     * @param head
     */
    private static void reverseNodePrint(Node head){
        LinkedList<Integer> list = new LinkedList<>();
        while (head.getNext() != null){
            System.out.println("原始数据 " + head.getData());
            list.addFirst(head.getData());
            head = head.getNext();
        }

        while (!list.isEmpty()){
            System.out.println("反转数据 " + list.removeFirst());
        }
    }

    private static class Node{
        private Integer data;
        private Node next;

        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
