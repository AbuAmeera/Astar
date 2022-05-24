package com.example.astar;

public class Node implements Comparable<Node>{
    String city;
    double distance,g,h,cost;
    Node parent;
    double x , y;
    String adjacent;

    @Override
    public String toString() {
        return "Node{" +
                "city='" + city + '\'' +
                '}';
    }

    @Override
    public int compareTo(Node node) {

        return Double.compare(this.cost,node.cost);
    }

    public double calculateDistance_totarget(Node target) {

//        if(h!=Double.MAX_VALUE){
//            return h;
//        }

        double x1 = this.x;
        double x2 = target.getX();
        double y1 = this.y;
        double y2 = target.getY();
        return Math.sqrt(Math.pow(x2-x1,2)+ Math.pow(y2-y1,2));
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double c) {
        this.cost = c;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }


    public String getAdjacent() {
        return adjacent;
    }

    public void setAdjacent(String adjacent) {
        this.adjacent = adjacent;
    }
}
