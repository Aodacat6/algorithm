package com.company.aoe;

import java.util.Stack;

/**
 * @author ：songdalin
 * @date ：2020-12-19 下午 03:42
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class CriticalPathSort {

    int[] etv, ltv;
    Stack stack = new Stack(); //存储入度为0的顶点，便于每次寻找入度为0的顶点时都遍历整个邻接表
    Stack stack2 = new Stack(); //将顶点序号压入拓扑序列的栈
    static Node[] adjList;


    public static Edge getAdjvex(Node node) {
        Edge e = node.firstedge;
        while(e != null) {
            if(e.next == null) break;
            else
                e = e.next;
        }
        return e;
    }
   
    /**
     * 关键路径算法
     */
    public void CriticalPath() {
        Edge e;
        int gettop, k, j;
        int ete, lte;
        if(!this.ToplogicalSort()) {
            System.out.println("该网中存在回路!");
            return;
        }
        ltv = new int[adjList.length];
        for (int i = 0; i < adjList.length; i++) {
            ltv[i] = etv[etv.length - 1];
        }

        while(!stack2.isEmpty()) {
            gettop = (int) stack2.pop();
            for(e = adjList[gettop].firstedge; e != null; e = e.next) {
                k = e.adjevex;
                if(ltv[k] - e.weight < ltv[gettop]) {
                    ltv[gettop] = ltv[k] - e.weight;
                }
            }
        }
        for (int i = 0; i < adjList.length; i++) {
            for(e = adjList[i].firstedge; e != null; e = e.next) {
                k = e.adjevex;
                ete = etv[i];
                lte = ltv[k] - e.weight;
                if(ete == lte) {
                    System.out.print("<" + adjList[i].data + "," + adjList[k].data + "> length: " + e.weight + ",");
                }
            }
        }
    }

    /**
     * 通过拓扑排序求得etv
     * @return
     */
    public boolean ToplogicalSort() {
        Edge e;
        int k, gettop;
        int count = 0;
        etv = new int[adjList.length];
        for (int i = 0; i < adjList.length; i++) {
            if(adjList[i].in == 0) {
                stack.push(i);
            }
        }
        for (int i = 0; i < adjList.length; i++) {
            etv[i] = 0;
        }

        while(!stack.isEmpty()) {
            gettop = (int) stack.pop();
            count++;
            stack2.push(gettop);
            for (e = adjList[gettop].firstedge; e != null; e = e.next) {
                k = e.adjevex;
                if((--adjList[k].in) == 0) {
                    stack.push(k);
                }
                if(etv[gettop] + e.weight > etv[k]) {
                    etv[k] = etv[gettop] + e.weight;
                }
            }
        }
        if(count < adjList.length) return false;
        else return true;

    }


    public static void main(String[] args) {
        //入度 连接到该点的边的个数
/*        int[] ins = {0, 1, 1, 2, 2, 1, 1, 2, 1, 2};
        //当前节点可以连到哪些节点
        int[][] adjvexs = {
                {2, 1},
                {4, 3},
                {5, 3},
                {4},
                {7, 6},
                {7},
                {9},
                {8},
                {9},
                {}
        };
        //当前节点连接到的节点的长度
        int[][] widths = {
                {4, 3},
                {6, 5},
                {7, 8},
                {3},
                {4, 9},
                {6},
                {2},
                {5},
                {3},
                {}
        };*/
        int[] ins = {1, 1, 1, 2, 2, 1, 1, 2, 1, 2};
        //当前节点可以连到哪些节点
        int[][] adjvexs = {
                {2, 1},
                {4, 3},
                {5, 3, 1},
                {4},
                {7, 6},
                {7},
                {9},
                {8},
                {9},
                {}
        };
        //当前节点连接到的节点的长度
        int[][] widths = {
                {4, 3},
                {6, 5},
                {7, 8, 1},
                {3},
                {4, 9},
                {6},
                {2},
                {5},
                {3},
                {}
        };
        adjList = new Node[ins.length];
        for (int i = 0; i < ins.length; i++) {
            adjList[i] = new Node("V"+i, ins[i],null);
            if(adjvexs[i].length > 0) {
                for (int j = 0; j < adjvexs[i].length; j++) {
                    if(adjList[i].firstedge == null)
                        adjList[i].firstedge = new Edge(adjvexs[i][j], widths[i][j], null);
                    else {
                        getAdjvex(adjList[i]).next = new Edge(adjvexs[i][j], widths[i][j], null);
                    }
                }
            }
        }

        CriticalPathSort c = new CriticalPathSort();
        c.CriticalPath();

    }

}
