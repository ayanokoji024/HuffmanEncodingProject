package com.company.HuffmanCode;


import java.util.HashMap;
import java.util.PriorityQueue;


import com.company.BinaryTreeClass.BinaryTreeClass;

public class HuffmanCode {
    private String path;
    private static int[] map = new int[256];
    private PriorityQueue<BinaryTreeClass> minHeap = new PriorityQueue<>();
    private HashMap<Character, String> lookUpTable = new HashMap<>();

    public void setPath(String path) {
        this.path = path;
    }

    public int[] getMap() {
        return map;
    }

    public HashMap<Character, String> getLookUpTable() {
        return lookUpTable;
    }

    public void frequencyFromText(String text){            //File to String Argument
        for (char c: text.toCharArray())    map[c]++;
    }

    public void buildHuffmanTree(){

        for (int i = 0; i < 256; i++) {
            if(map[i]>0){
                minHeap.add(new BinaryTreeClass(map[i], (char) i, null, null));
            }
        }

        if(minHeap.size()==1){
            minHeap.add(new BinaryTreeClass(1, '\0', null, null));
        }

        while(minHeap.size() > 1){
            final BinaryTreeClass left = minHeap.poll();
            final BinaryTreeClass right = minHeap.poll();
            final BinaryTreeClass parent = new BinaryTreeClass(left.getCount() + right.getCount(), '\0', left, right);

            minHeap.add(parent);

        }

    }


    public void buildLookUpTable() {
        buildLookUpTableImpl(minHeap.peek(), "", lookUpTable);
    }

    private void buildLookUpTableImpl(BinaryTreeClass peek, String s, HashMap<Character, String> lookUpTable) {
        if (!peek.isLeaf()){
            buildLookUpTableImpl(peek.getLeftChild(), s+"0", lookUpTable);
            buildLookUpTableImpl(peek.getRightChild(), s+"1", lookUpTable);
        }
        else{
            lookUpTable.put((peek.getCharacter()), s);
        }

    }

    public void compression(){

    }



}
