

public class MusicNode {
    Music info;
    MusicNode next;

    public MusicNode(Music info, MusicNode next) {
        this.info = info;
        this.next = next;
    }

    public MusicNode(Music x) {
        this(x,null);
    }
    
}