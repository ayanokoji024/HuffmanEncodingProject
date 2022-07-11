package com.company.BinaryTreeClass;


import java.util.Objects;

public class BinaryTreeClass implements Comparable<BinaryTreeClass> {

    private final char character;
    private final int count;
    private final BinaryTreeClass leftChild;
    private final BinaryTreeClass rightChild;

    public BinaryTreeClass getLeftChild() {
        return leftChild;
    }

    public BinaryTreeClass getRightChild() {
        return rightChild;
    }

    public char getCharacter() {
        return character;
    }

    public int getCount() {
        return count;
    }

    public BinaryTreeClass(int c, char ch, BinaryTreeClass ln, BinaryTreeClass rn) {
       this.character = ch;
       this.count = c;
       this.leftChild = ln;
       this.rightChild = rn;
    }

    public boolean isLeaf(){
        return this.leftChild==null && this.rightChild==null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BinaryTreeClass)) return false;
        BinaryTreeClass that = (BinaryTreeClass) o;
        return character == that.character && count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(character, count);
    }

    @Override
    public int compareTo(BinaryTreeClass b) {
        if(this.count-b.count!=0)   return this.count-b.count;
        else return Integer.compare(this.count, b.count);
    }
}
