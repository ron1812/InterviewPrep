package com.practice.core;

public class DoublyLinkedListCustom<T> {

    private Node<T> rootNode;
    private Node<T> currentNode;

    public void add(T value) {

        if(rootNode == null) {

            rootNode = new Node(value);
            currentNode =  rootNode;
        }else {

            Node newNode = new Node(value);

            currentNode.setNextNode(newNode);
            newNode.setPreviousNode(currentNode);
            currentNode = newNode;
        }
    }

    public T printMiddle() {
        if(rootNode == null)
            return null;

        if(rootNode.getNextNode() == null)
            return rootNode.getNodeValue();

        Node slowPointer = rootNode;
        Node fastPointer = rootNode;

        while(fastPointer != null && fastPointer.getNextNode() != null) {
            fastPointer = fastPointer.getNextNode();
            if(fastPointer != null)
                fastPointer = fastPointer.getNextNode();

            slowPointer = slowPointer.getNextNode();
        }

        return (T) slowPointer.getNodeValue();
    }

    public void printList() {
        System.out.print(rootNode.getNodeValue()+"\t");

        Node currNode = rootNode.getNextNode();
        while (currNode != null){
            System.out.print(currNode.getNodeValue()+"\t");
            currNode = currNode.getNextNode();
        }
    }

    public void printReverseList() {
        System.out.print(currentNode.getNodeValue()+"\t");

        Node currNode = currentNode.getPreviousNode();
        while (currNode != null){
            System.out.print(currNode.getNodeValue()+"\t");
            currNode = currNode.getPreviousNode();
        }
    }

    public static void main(String[] args) {

        DoublyLinkedListCustom<Integer> customList = new DoublyLinkedListCustom();
        customList.add(5);
        customList.add(6);
        customList.add(-6);
        customList.add(-600);
        customList.add(90);
        customList.add(900);

        System.out.println("Print Doubly Linked list ");
        customList.printList();

        System.out.println("\nPrint Doubly Linked list in reverse order");
        customList.printReverseList();

        System.out.println("\nPrint Middle element of Doubly Linked list");
        System.out.println(customList.printMiddle());
    }
}

class Node<T> {

    private T nodeValue;
    private Node<T> nextNode;
    private Node<T> previousNode;

    public Node(T nodeValue,Node<T> nextNode,Node<T> preNode) {
        this.nextNode = nextNode;
        this.previousNode = preNode;
        this.nodeValue = nodeValue;
    }

    public Node(T nodeValue) {
        this.nodeValue = nodeValue;
    }

    public T getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(T nodeValue) {
        this.nodeValue = nodeValue;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }
}
