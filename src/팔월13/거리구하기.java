package 팔월13;

import java.util.ArrayList;
import java.util.List;

public class 거리구하기 {
    static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Point start = new Point(50,25);
        Point dest = new Point(10,30);
        List<Point> list = new ArrayList<>();
        list.add(new Point(100,50));
        list.add(new Point(50,80));
        list.add(new Point(200,100));


        list.add(dest);
        list.add(0, start);

        int d=0;
        for(int i=0;i<list.size()-1;i++){

            d+=distance(list.get(i),list.get(i+1));
        }
        System.out.println(d);

    }
    static int distance(Point A, Point B){
        //return Math.sqrt(Math.pow(A.x-B.x,2)+Math.pow(A.y-B.y,2));
    return Math.abs(A.x -B.x) +Math.abs(A.y-B.y);
    }

}
