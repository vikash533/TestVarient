package myProg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PopularSongStore extends RecentlyPlayedStore {

	public PopularSongStore(int capacity) {
		super(capacity);	
	}
	public List<String> getMostPopularSongs() {
        Map<String, Integer> songCountMap = new HashMap<>();
        for (LinkedList<String> songsList : userSongsMap.values()) {
            for (String song : songsList) {
                songCountMap.put(song, songCountMap.getOrDefault(song, 0) + 1);
            }
        }
        List<Map.Entry<String, Integer>> songCountList = new ArrayList<>(songCountMap.entrySet());
        songCountList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        List<String> popularSongs = new ArrayList<>();
        for (Map.Entry<String, Integer> songCount : songCountList) {
            popularSongs.add(songCount.getKey());
            if (popularSongs.size() == capacity) {
                break;
            }
        }
        return popularSongs;
	}

}
