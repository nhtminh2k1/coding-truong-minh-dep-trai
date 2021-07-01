
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class MainMusic {

    public static void main(String[] args) {
        MusicList ml = new MusicList();
        System.out.println("Question 1: ");
        while (true) {
            try {
                File file = new File("D:\\javaProject\\CSD\\Code review\\Assignment1.4\\src\\songs.txt");
                Scanner scannerFile = new Scanner(file);
                ml.scanFile(scannerFile);
                break;
            } catch (FileNotFoundException e) {
                System.err.println("Directory cannot found!");
            }
        }
        ml.addLast(new Music("Dancing in the moonlight", "King Harvest", 4));
        ml.addLast(new Music("Dancing in the moonlight", "Jubel", 3));
        ml.addLast(new Music("Fields of gold", "Eva Cassidy", 2));
        ml.addLast(new Music("Fields of gold", "Fourplay", 2));
        ml.addLast(new Music("Papa", "Paul Anka", 4));
        ml.addLast(new Music("Fields of gold", "Celtic Woman", 3));

        System.out.println("Question 2:");
        ml.traverse();

        System.out.println("Question 3:");
        //System.out.println("----debug---" + ml.findMaxByRated());
        //System.out.println( ml.searchByRated());
        ml.searchByRated();

        
        System.out.println("Question 5: ");
        ml.traverse();
        
        System.out.println("Quesion 6: ");
        Scanner sc = new Scanner(System.in);
        try {
            FileWriter fw = new FileWriter("D:\\javaProject\\CSD\\Code review\\Assignment1.4\\src\\output.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < ml.size(); i++) {
                //bw.write(ml.getMusic(i).getName() + " | " + ml.getMusic(i).getArtist() + " | " + ml.getMusic(i).getRated());
                bw.write(ml.get(i).info.getName() + " | " + ml.get(i).info.getArtist() + " | " + ml.get(i).info.getRated());
                bw.newLine();
            }
            bw.close();
            fw.close();
            System.out.println("Done!");
        } catch (IOException e) {
        }
    }
}
