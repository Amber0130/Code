package com.itheima.service.impl;

import com.itheima.service.IAccountservice;

import java.rmi.MarshalledObject;
import java.util.*;

public class Accountserviceimpl3 implements IAccountservice {
    private String[] mystrs;
    private List<String> myList;
    private Set<String> myset;
    private Map<String, String> myMap;
    private Properties myprops;

    public void setMystrs(String[] mystrs) {
        this.mystrs = mystrs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMyset(Set<String> myset) {
        this.myset = myset;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyprops(Properties myprops) {
        this.myprops = myprops;
    }

    public void saveAccount() {
        System.out.println(Arrays.toString(mystrs));
        System.out.println(myList);
        System.out.println(myset);
        System.out.println(myprops);
        System.out.println(myMap);
    }
}
