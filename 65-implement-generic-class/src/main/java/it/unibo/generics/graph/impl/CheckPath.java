package it.unibo.generics.graph.impl;

public class CheckPath<N> {
    private int distance;
    private N father;
    private N oneNode;

    public CheckPath(N node) {
        this.distance = 0;
        this.father = null;
        this.oneNode = node;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(final int distance) {
        this.distance = distance;
    }

    public N getFather() {
        return father;
    }

    public void setFather(final N father) {
        this.father = father;
    }

    public N getOneNode() {
        return oneNode;
    } 
}
