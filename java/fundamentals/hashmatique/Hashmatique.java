import java.util.HashMap;
import java.util.Set;

public class Hashmatique {
  public void hashmap () {
    HashMap<String, String> trackList = new HashMap<String, String>();
    trackList.put("Curiosity","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");
    trackList.put("First","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");
    trackList.put("Love","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");
    trackList.put("Romance","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");
    System.out.println(trackList.get("Love"));

    Set<String> tracks = trackList.keySet();
    for (String track: tracks) {
      System.out.println(track + ": " + trackList.get(track));
    }
  }

}