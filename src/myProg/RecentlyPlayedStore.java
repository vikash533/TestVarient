package myProg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RecentlyPlayedStore {

	 protected int capacity;
	    protected Map<String, LinkedList<String>> userSongsMap;

	    public RecentlyPlayedStore(int capacity) {
	        this.capacity = capacity;
	        this.userSongsMap = new HashMap<>();
	    }

	    public void addSong(String user, String song) {
	        if (!userSongsMap.containsKey(user)) {
	            userSongsMap.put(user, new LinkedList<>());
	        }
	        LinkedList<String> songsList = userSongsMap.get(user);
	        songsList.addFirst(song);
	        if (songsList.size() > capacity) {
	            songsList.removeLast();
	        }
	    }

	    public List<String> getRecentlyPlayedSongs(String user) {
	        LinkedList<String> songsList = userSongsMap.get(user);
	        if (songsList == null) {
	            return new ArrayList<>();
	        }
	        return new ArrayList<>(songsList);
	    }

}
