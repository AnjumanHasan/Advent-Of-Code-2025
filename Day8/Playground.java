package Day8;

import java.io.BufferedReader;
import java.util.ArrayList;

import Utils.utils;

public class Playground {
    public static void main(String[] args) {
       try {
        BufferedReader bufferedReader = utils.initializeBufferedReader();
        String line = bufferedReader.readLine();
        ArrayList<Point> coords = new ArrayList<>();
        while(line!=null){
            String[] points = line.split(",");
            int x = Integer.parseInt(points[0]);
            int y = Integer.parseInt(points[1]);
            int z = Integer.parseInt(points[2]);
            coords.add(new Point(x, y, z));
            line = bufferedReader.readLine();
        }
        
       } catch (Exception e) {
        // TODO: handle exception
       }
    }
}
