package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：songdalin
 * @date ：2020-12-21 上午 09:47
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class CycleFindBiHuanTest {

    public static List<List<Integer>> lists = new ArrayList<>();

    /**
     * node集合
     */
    private static List<String> nodes= new ArrayList<String>();

    public static void main(String[] args){

        nodes.add("0");
        nodes.add("1");
        nodes.add("2");


        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(3);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);

        find();

    }

    public static void find() {
        List<String> saveTmp = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            System.out.println("i=" + i);
            String startNode = nodes.get(i);
            for (int j=0; j < lists.get(i).size(); j++) {
                System.out.println("j=" + j);
                String endNode = String.valueOf(lists.get(i).get(j));
                String modeStr = endNode+"-"+startNode;
                if (saveTmp.contains(modeStr)) {
                    System.out.println("circle:"+ startNode + "-" + modeStr);
                    return;
                }
                saveTmp.add(startNode + "-" + endNode);
            }
        }
        System.out.println("no circle");
    }

/*    *//**
     * @Title find
     * @Description 寻找闭环
     * @date 2018年5月17日
     * @return
     *//*
    public static List<String>  find() {
        // 从出发节点到当前节点的轨迹
        List<Integer> trace =new ArrayList<Integer>();
        //返回值
        List<String> reslut = new ArrayList<>();
        if(lists.size()>0) {
            findCycle(0, trace,reslut);
        }
        if(reslut.size()==0) {
            reslut.add("no cycle!");
        }
        return reslut;
    }
    *//**
     * @Title findCycle
     * @Description dfs
     * @date 2018年5月17日
     * @param v
     * @param trace
     * @param reslut
     *//*
    private static void findCycle(int v,List<Integer> trace,List<String> reslut)
    {
        int j;
        //添加闭环信息
        if((j=trace.indexOf(v))!=-1) {
            StringBuffer sb = new StringBuffer();
            String startNode = nodes.get(trace.get(j));
            while(j<trace.size()) {
                sb.append(nodes.get(trace.get(j))+"-");
                j++;
            }
            reslut.add("cycle:"+sb.toString()+startNode);
            return;
        }
        trace.add(v);
        for(int i=0;i<nodes.size();i++){
            if(lists.get(v).get(i)==1) {
                findCycle(i,trace,reslut);
            }
        }
        trace.remove(trace.size()-1);
    }*/
}
