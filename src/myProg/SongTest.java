package myProg;

public class SongTest {

	public static void main(String[] args) {
		 RecentlyPlayedStore store = new RecentlyPlayedStore(5);
		    store.addSong("Alice", "S1");
		    store.addSong("Alice", "S2");
		    store.addSong("Bob", "S3");
		    store.addSong("Bob", "S1");
		    store.addSong("Charlie", "S2");
		    store.addSong("Charlie", "S3");

		    System.out.println(store.getRecentlyPlayedSongs("Alice")); // [Song2, Song1]
		    System.out.println(store.getRecentlyPlayedSongs("Bob")); // [Song1, Song3]
		    System.out.println();
	}

}
