package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：songdalin
 * @date ：2020-12-19 下午 04:56
 * @description：
 * @modified By：
 * @version: 1.0
 */


    public class DsfCycle {

        /**
         * 限制node最大数
         */
        private static  int MAX_NODE_COUNT = 100;

        /**
         * node集合
         */
        private static List<String> nodes= new ArrayList<String>();

        /**
         * 有向图的邻接矩阵
         */
        private static int[][] adjacencyMatrix = new  int[MAX_NODE_COUNT][MAX_NODE_COUNT];

        /**
         * @Title addNode
         * @Description 添加节点
         * @date 2018年5月17日
         * @param nodeName
         * @return
         */
        private static int addNode(String nodeName){
            if(!nodes.contains(nodeName)) {
                if(nodes.size()>=MAX_NODE_COUNT) {
                    System.out.println("nodes超长:"+nodeName);
                    return -1;
                }
                nodes.add(nodeName);
                return  nodes.size()-1;
            }
            return nodes.indexOf(nodeName);
        }

        /**
         * @Title addLine
         * @Description 添加线，初始化邻接矩阵
         * @date 2018年5月17日
         * @param startNode
         * @param endNode
         */
        public static void addLine(String startNode, String endNode){
            int startIndex = addNode(startNode);
            int endIndex = addNode(endNode);
            if(startIndex>=0&&endIndex>=0) {
                adjacencyMatrix[startIndex][endIndex] = 1 ;
            }
        }

        /**
         * @Title find
         * @Description 寻找闭环
         * @date 2018年5月17日
         * @return
         */
        public static List<String>  find() {
            // 从出发节点到当前节点的轨迹
            List<Integer> trace =new ArrayList<Integer>();
            //返回值
            List<String> reslut = new ArrayList<>();
            if(adjacencyMatrix.length>0) {
                findCycle(0, trace,reslut);
            }
            if(reslut.size()==0) {
                reslut.add("no cycle!");
            }
            return reslut;
        }
        /**
         * @Title findCycle
         * @Description dfs
         * @date 2018年5月17日
         * @param v
         * @param trace
         * @param reslut
         */
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
                if(adjacencyMatrix[v][i]==1) {
                    findCycle(i,trace,reslut);
                }
            }
            trace.remove(trace.size()-1);
        }
        //测试
        public static void main(String[] args) {
            DsfCycle.addLine("A", "B");
            DsfCycle.addLine("A", "C");
            DsfCycle.addLine("B", "A");
            DsfCycle.addLine("B", "D");
            DsfCycle.addLine("D", "");
            List<String> reslut = DsfCycle.find();
            for (String string : reslut) {
                System.out.println(string);
            }
        }
    }


