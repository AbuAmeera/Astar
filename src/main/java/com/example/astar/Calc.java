package com.example.astar;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Calc {

    public static ArrayList<ArrayList<Node> > adj = new ArrayList<ArrayList<Node> >();

    public void Scan(String text) throws FileNotFoundException {

        File file = new File(text);
        Scanner scan = new Scanner(file);
        //scan.useDelimiter(",");

        while (scan.hasNextLine()) {

            StringBuilder p = new StringBuilder();
            p.append(scan.nextLine());
            int space = p.indexOf(",");
            int space1 = p.lastIndexOf(",");

            String city = p.substring(0,space);
            double x = Double.parseDouble( p.substring(space+1,space1) );
            double y = Double.parseDouble( p.substring(space1+1) );

            Node n = new Node();

            n.setCity(city);
            n.setX(x);
            n.setY(y);
            ArrayList<Node> nlist = new ArrayList<Node>();
            nlist.add(n);
            adj.add(nlist);

        }
    }

    public void Scan1(String text) throws FileNotFoundException {

        File file = new File(text);
        Scanner scan = new Scanner(file);
        //scan.useDelimiter(",");

        while (scan.hasNextLine()) {

            StringBuilder p = new StringBuilder();
            p.append(scan.nextLine());
            int space = p.indexOf(",");
            int space1 = p.lastIndexOf(",");

            String city1 = p.substring(0,space);
            String city2 = p.substring(space+1,space1);
            double dist = Double.parseDouble( p.substring(space1+1) );
            int in1 = find(city1);
            int in2 = find(city2);

            Node n = adj.get(in1).get(0);
            n.setDistance(dist);


            Node n1 = adj.get(in2).get(0);
            n1.setDistance(dist);

            for (int i=0;i<adj.size();i++){

                if (adj.get(i).get(0).getCity().equalsIgnoreCase(n.getCity())){
                    adj.get(i).add(n1);
                }
                if (adj.get(i).get(0).getCity().equalsIgnoreCase(n1.getCity())){
                    adj.get(i).add(n);
                }

            }

        }
    }
    public int find(String city){
        int flag =-1;
        for (int i=0;i<adj.size();i++){

            if ( adj.get(i).get(0).getCity().equalsIgnoreCase(city) ){
                flag = i;
            }

        }
        return flag;
    }
    public static int find1 (PriorityQueue<Node> end,PriorityQueue<Node> start,String city){

        for (int i=0;i< end.size();i++){
            if (end.poll().getCity().equalsIgnoreCase(city)){
                return 1;
            }

        }
        for (int i=0;i< start.size();i++){
            if (start.poll().getCity().equalsIgnoreCase(city)){
                return 1;
            }

        }
        return -1;

    }

    public Node shotestBath(String sCity,String eCity){

        PriorityQueue<Node> start = new PriorityQueue<Node>();
        PriorityQueue<Node> end = new PriorityQueue<Node>();

        int index;

        index = find(sCity);
        int in = find(eCity);
        start.add(adj.get(index).get(0));
        Node curr = start.peek();

        curr.setH(curr.calculateDistance_totarget(adj.get(in).get(0)));

        while (!start.isEmpty()){
            if (curr.getCity().equalsIgnoreCase(eCity)){
                return curr;
            }
            else{
                index = find(curr.getCity());

                for (int i=1;i<adj.get(index).size();i++){

                    Node n1 = adj.get(index).get(i);
                    n1.setDistance(adj.get(index).get(i).getDistance());
                    double totaldist =curr.getG() + n1.getDistance();

                        if ( !start.contains(n1) && !end.contains(n1) ){
                            n1.setG(totaldist);

                            if (i == adj.get(index).size()) {
                                n1.setH(n1.calculateDistance_totarget(adj.get(in).get(i)));
                            }
                            n1.setCost(n1.getG()+n1.getH());
                            n1.setParent(curr);
                            start.add(n1);
                        }
                        else{
                            if (totaldist < n1.getG()){
                                n1.setG(totaldist);
                                n1.setCost(n1.getG()+n1.getH());
                                n1.setParent(curr);

                                if (end.contains(n1)){
                                    Node del= n1;
                                    end.remove(n1);
                                    start.add(n1);
                                }
                            }

                        }

                }
                end.add(curr);
                start.remove(curr);
                curr=start.peek();
            }
        }

        return null;
    }

    public String getPath(String sCity,String eCity){

        Node ans = shotestBath(sCity,eCity);

        if (ans == null){
            return "NOPATH";
        }
        String dist = ans.getG()+"";
        String path = dist+" | ";
        path += ans.getCity()+" | ";
        int flag = 1;
        while (ans.getParent() != null){
            path += ans.getParent().getCity()+" | ";
            //drawLine(ans,ans.getParent());
            ans = ans.getParent();
            if (flag == 4){
                path += "\n";
                flag = 1;
            }
            flag++;

        }


        return path;
    }




}
