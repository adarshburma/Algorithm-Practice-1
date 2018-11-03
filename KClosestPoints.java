package org.practice.courses.courseapi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPoints {

    static List<Point> distancesFromOrigin(List<int[]> points){
        int[] distances = new int[points.size()];
        List<Point> pointlist = new ArrayList<>();
        for(int[] point : points){
            Point newPoint = new Point(point[0], point[1]);
            double sumOfsquares = Math.pow(point[0], 2) + Math.pow(point[1],2);
            int distance = (int)Math.sqrt(sumOfsquares);
            newPoint.setDistance(distance);
            pointlist.add(newPoint);
        }

        return pointlist;
    }


    static class Point{
        int x;
        int y;
        int distance;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        int getX(){
            return this.x;
        }

        int getY(){
            return this.y;
        }

        int getDistance(){
            return this.getDistance();
        }

        void setX(int x){
            this.x = x;
        }

        void setY(int y){
            this.y = y;
        }

        void setDistance(int distance){
            this.distance = distance;
        }
    }

    static List<Point> findThreeMinimum(List<int[]> points, List<Point> pointList, int k){
        List<Point> res = new ArrayList<>();
        PriorityQueue<Point> queue = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.distance - o2.distance > 0){
                    return 1;
                }
                return -1;
            }
        });

        for(Point i : pointList){
            queue.offer(i);
            k--;
            if(k == 0){
                break;
            }
        }

        for(int i = k; i < pointList.size(); i++){
            if(pointList.get(i).distance < queue.peek().distance){
                queue.poll();
                queue.offer(pointList.get(i));
            }
        }

        while(!queue.isEmpty()){
            res.add(queue.poll());
        }

        return res;
    }

    public static void main(String[] args){
        List<int[]> points = new ArrayList<>();

        points.add(new int[] {0,-2});
        points.add(new int[] {-1,0});
        points.add(new int[] {-2,-4});
        points.add(new int[] {3,-5});
        points.add(new int[] {-2,-3});
        points.add(new int[] {3,2});


        List<Point> res = findThreeMinimum(points,distancesFromOrigin(points), 3);
        for(Point point : res){
            System.out.println(point.x + " ," + point.y);
        }
    }

}
