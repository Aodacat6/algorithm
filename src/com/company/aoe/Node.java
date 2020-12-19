package com.company.aoe;

/**
 * @author ：songdalin
 * @date ：2020-12-19 下午 03:40
 * @description：
 * @modified By：
 * @version: 1.0
 */
public class Node {

    public int in;
    public Object data;
    public Edge firstedge;

    public Node(Object data, int in, Edge firstedge) {
        this.data = data;
        this.in = in;
        this.firstedge = firstedge;
    }
}
