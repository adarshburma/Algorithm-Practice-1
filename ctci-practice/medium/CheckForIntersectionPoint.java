package org.practice.courses.courseapi;

public class CheckForIntersectionPoint {
    static void swap (Point a, Point b){
        double x = a.x;
        double y = a.y;
        a.setLocation(b.x, b.y);
        b.setLocation(x,y);
    }

    static boolean isBetween(double start, double middle, double end){
        return end > start ? start <= middle && middle <= end : end <= middle && middle <= start;
    }

    static boolean pointIsBetween(Point start, Point middle, Point end){
        return isBetween(start.x, middle.x, end.x) && isBetween(start.y, middle.y, end.y);
    }

    static Point findIntersection(Point start1, Point end1, Point start2, Point end2){
        if(start1.x > end1.x) swap(start1, end1);
        if(start2.x > end2.x) swap(start2, end2);
        if(start1.x > start2.x) {
            swap(start1, start2);
            swap(end1, end2);
        }

        Line l1 = new Line(start1, end1);
        Line l2 = new Line(start2, end2);

        //if lines are parallel slopes are equal and intercepts should match

        if(l1.slope == l2.slope){
            if(l1.intercept == l2.intercept){
                if(pointIsBetween(start1, start2, end1)){
                    return start2;
                }
            }
            return null;
        }

        double x = (l2.intercept - l1.intercept)/(l1.slope - l2.slope);
        double y = l1.slope * x + l1.intercept;

        Point intersection = new Point(x, y);

        if(pointIsBetween(start1, intersection, end1) && pointIsBetween(start2, intersection, end2)){
            return intersection;
        }

        return null;
    }
    static class Line{
        double intercept, slope;
        Line(Point start, Point end){
            double deltaX= end.x - start.x;
            double deltaY= end.y - start.y;
            this.slope = deltaY/deltaX;
            this.intercept = end.y - slope * end.x;
        }
    }
    static class Point{
        double x,y;
        Point(double x, double y){
            this.x = x;
            this.y = y;
        }
        void setLocation(double x, double y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args){
        Point start1 = new Point(1,1);
        Point end1 = new Point(10, 1);
        Point start2 = new Point(1,2);
        Point end2 = new Point(10,2);

        Point intersection = findIntersection(start1, end1, start2, end2);
        if(intersection != null){
            System.out.print("Intersection point: "+ intersection.x + " ," + intersection.y);
        } else{
            System.out.print("No intersection ....");
        }

    }
}
