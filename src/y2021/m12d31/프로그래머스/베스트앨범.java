package 십이월31.프로그래머스;

import java.util.*;

public class 베스트앨범 {

    static class Song implements Comparable<Song>{

        String genre;
        int plays;
        int id;
        public Song(String genre, int plays, int id) {
            this.genre = genre;
            this.plays = plays;
            this.id = id;
        }


        @Override
        public int compareTo(Song o) {
            return Integer.compare( o.plays,this.plays);
        }
    }
    public static int[] solution(String[] genres, int[] plays) {

        Map<String, List<Song>> album = new HashMap<>();
        Map<String, Integer> genreCount = new HashMap<>();
        for (int i=0;i<genres.length;i++){
            genreCount.put(genres[i], genreCount.getOrDefault(genres[i], 0)+plays[i]);
            if (album.get(genres[i]) == null) album.put(genres[i],   new ArrayList<Song>());
            else album.get(genres[i]).add(new Song(genres[i], plays[i], i));
        }
        for (String key : album.keySet()) Collections.sort(album.get(key));

        Map<String, Integer> result = sortMapByValue(genreCount);
        int [] ans = new int[genreCount.keySet().size()*2];
        int idx =0 ;
        for (String gen : result.keySet()){
            List<Song> songs = album.get(gen);

            ans[idx++] = songs.get(0).id;
            if (songs.size()>1)
            ans[idx++] = songs.get(1).id;

        }



        return ans;

    }

    public static LinkedHashMap<String, Integer> sortMapByValue(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, (o2, o1) -> o1.getValue().compareTo(o2.getValue()));

        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})) );
    }
}
