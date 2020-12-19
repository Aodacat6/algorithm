package com.company.aoe;

/**
 * @author ：songdalin
 * @date ：2020-12-19 下午 03:40
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class Edge {

    public int adjevex;
    public int weight;
    public Edge next;

    public Edge(int adjevex, Edge next) {
        this.adjevex = adjevex;
        this.next = next;
    }

    public Edge(int adjevex, int weight, Edge next) {
        this.adjevex = adjevex;
        this.weight = weight;
        this.next = next;
    }
}
