package client.io;

import java.io.*;
import java.util.ArrayList;

public class TrajectoryFile {
    public static ArrayList<double []> getPointList(File file) throws IOException{
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e){
            System.out.println(file.toString() + " adresindeki dosya bulunamadı.");
        }

        skipLines(reader, 6);

        String line = reader.readLine();

        ArrayList<double []> pointList = new ArrayList<>();

        while (line != null){
            pointList.add(getXandY(line));

            line = reader.readLine();
        }

        reader.close();

        return pointList;
    }

    private static void skipLines(BufferedReader reader, int lineNumber) throws IOException {
        for (int i = 0; i < lineNumber; i++) {
            reader.readLine();
        }
    }

    private static double[] getXandY(String line){
        String[] splitted = line.split(",");

        double[] xy = new double[2];

        xy[0] = Double.parseDouble(splitted[0]);
        xy[1] = Double.parseDouble(splitted[1]);

        return xy;
    }
}
