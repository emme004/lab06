package it.unibo.generics.graph.impl;

public class CheckPath<N> {
    private Integer distance;
    private N father;
    private final N oneNode;

    public CheckPath(final N node) {
        this.father = null;
        this.distance = null;
        this.oneNode = node;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(final Integer distance) {
        this.distance = distance;
    }

    public N getFather() {
        return father;
    }

    public void setFather(N father) {
        this.father = father;
    }

    public N getOneNode() {
        return oneNode;
    } 
}
