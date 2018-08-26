package org.practice.courses.courseapi;

import java.util.ArrayList;
import java.util.List;

public class RatMaze {

    public static void main(String args[]){
        RatMaze2 ratmaze = new RatMaze2();
        RatMaze2.Cell a = new RatMaze2.Cell("A");
        RatMaze2.Cell b = new RatMaze2.Cell("B");
        RatMaze2.Cell c = new RatMaze2.Cell("C");
        RatMaze2.Cell d = new RatMaze2.Cell("D");
        RatMaze2.Cell e = new RatMaze2.Cell("E");
        RatMaze2.Cell f = new RatMaze2.Cell("F");
        RatMaze2.Cell g = new RatMaze2.Cell("G");
        RatMaze2.Cell h = new RatMaze2.Cell("H");
        RatMaze2.Cell i = new RatMaze2.Cell("I");

        a.addNeighbor(b);
        b.addNeighbor(a, e, c);
        c.addNeighbor(b);
        d.addNeighbor(a);
        e.addNeighbor(b, f, g);
        f.addNeighbor(e, h);
        g.addNeighbor(e, h);
        h.addNeighbor(g, f, i);
        i.addNeighbor(h);
        i.setEnd(true);

        List<RatMaze2.Cell> path = new ArrayList<>();
        ratmaze.findAll(d, path);
        ratmaze.printPath(path);
    }

    public boolean findAll(Cell current, List<Cell> currentPath){
        currentPath.add(current);
        if(current.isEnd()){
            return true;
        }

        for(Cell neighbor : current.getNeighbours()){
            if(!currentPath.contains(neighbor)){
                List<Cell> neighborPath = new ArrayList<>();
                neighborPath.addAll(currentPath);

                if(findAll(neighbor, neighborPath)){
                    currentPath.clear();
                    currentPath.addAll(neighborPath);
                    return true;
                }
            }
        }
        return false;
    }

    public void printPath(List<Cell> path){
        for(Cell cell: path){
            System.out.println(cell.id + "->");
        }
        System.out.println("END");
    }

    public static class Cell {
        String id;
        boolean end = false;
        List<Cell> neighbours = new ArrayList<>();

        public Cell(String id){
            this.id= id;
        }

        public void setEnd(boolean value){
            this.end = value;
        }

        public boolean isEnd(){
            return end;
        }

        public void addNeighbor(Cell ... neighbours){
            for(Cell neighbour : neighbours){
               this.neighbours.add(neighbour);
            }
        }

        public List<Cell> getNeighbours(){
            return this.neighbours;
        }

        public String getId(){
            return id;
        }

        public void setId(String id){
            this.id = id;
        }
    }
}
