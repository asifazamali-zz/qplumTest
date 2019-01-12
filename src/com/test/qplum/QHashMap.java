package com.test.qplum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class QHashMap {
    private static final int PRESENT = 1;
    HashMap<Integer, Integer> hashMap;
    ArrayList<Integer> arrayList;

    QHashMap(){
        hashMap = new HashMap<>();
        arrayList = new ArrayList<>();
    }

    public void insert(int x){
        if(!hashMap.containsKey(x)) {
            hashMap.put(x, PRESENT);
            arrayList.add(x);
        }
    }

    public boolean delete(int x){
        if(hashMap.containsKey(x)) {
            arrayList.remove(x);
            hashMap.remove(x);
            return true;
        }
        return false;
    }

    public boolean search(int x){
        return  hashMap.containsKey(x);
    }

    public int getRandom(){
        int ind = (new Random()).nextInt(arrayList.size());
        return arrayList.get(ind);
    }


    public static void main(String args[]){
        QHashMap qHashMap = new QHashMap();
        qHashMap.insert(1);
        qHashMap.insert(3);
        qHashMap.insert(4);
        qHashMap.insert(5);
        qHashMap.insert(6);
        qHashMap.insert(7);
        qHashMap.insert(8);
        qHashMap.insert(9);
        qHashMap.insert(10);
        System.out.println(qHashMap.getRandom());
        qHashMap.delete(3);
        System.out.println(qHashMap.getRandom());
        System.out.println(qHashMap.search(7));
        qHashMap.delete(7);
        System.out.println(qHashMap.search(7));
        System.out.println(qHashMap.getRandom());

    }
}
