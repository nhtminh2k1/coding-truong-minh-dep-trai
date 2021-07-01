
package assignmentcdd;


public class Song {
    String name ;
    String artist;
    int Rated;

    public Song() {
    }

    public Song(String name, String artist, int Rated) {
        this.name = name;
        this.artist = artist;
        this.Rated = Rated;
    }

    @Override
    public String toString() {
        return "Song{" + "name=" + name + ", artist=" + artist + ", Rated=" + Rated + '}';
    }
    
}

