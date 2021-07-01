
public class Music {

    public String name;
    public String artist;
    public int rated;

    public Music() {
    }

    public Music(String name, String artist, int rated) {
        this.name = name;
        this.artist = artist;
        this.rated = rated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getRated() {
        return rated;
    }

    public void setRated(int rated) {
        this.rated = rated;
    }

    @Override
    public String toString() {
        return this.name + "|" + this.artist + "|" + this.rated;
    }

}
