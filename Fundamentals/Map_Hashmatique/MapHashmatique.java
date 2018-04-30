import java.util.HashMap;

public class MapHashmatique {
    public void trackList(){
        HashMap<String, String> tracks = new HashMap<>();
        tracks.put("Track 1", "Lyrics 1");
        tracks.put("Track 2", "Lyrics 2");
        tracks.put("Track 3", "Lyrics 3");
        tracks.put("Track 4", "Lyrics 4");
        System.out.println(tracks.get("Track 1"));
        System.out.println(tracks);
    }
}