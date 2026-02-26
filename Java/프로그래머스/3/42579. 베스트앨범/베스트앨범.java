import java.util.*;



class Solution {
    
    class Song implements Comparable<Song>{
        int id;
        long play;
        
        Song(int id, long play){
            this.id = id;
            this.play = play;
        }
        
        @Override
        public int compareTo(Song song){
            if(this.play == song.play) return Integer.compare(this.id, song.id); // 오름차순
            return Long.compare(song.play, this.play); // 내림차순
        }
    }
    
    
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Long> genrePlayCount = new HashMap<>();
        HashMap<String, List<Song>> songsByGenre = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0L)+plays[i]);
            songsByGenre.putIfAbsent(genres[i], new ArrayList<>());
            songsByGenre.get(genres[i]).add(new Song(i, plays[i]));
        }
        
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((a,b) -> { return Long.compare(genrePlayCount.get(b), genrePlayCount.get(a)); });
        // Collections.sort(sortedGenres, (a,b) -> ... ) 으로 대체 가능
        
        List<Integer> answerList = new ArrayList<>();
        for(String genre: sortedGenres){
            List<Song> songs = songsByGenre.get(genre);
            songs.sort(null); // Compartable<Song> 인터페이스의 compareTo를 override했으므로 정렬함수를 인자로 넣지 않아도 됨
            // Collections.sort(songs); 으로 대체 가능
            for(int i=0; i<Math.min(songs.size(), 2); i++){
                answerList.add(songs.get(i).id);
            }
            
        }
        
        return answerList.stream().mapToInt(Integer::intValue).toArray();
        // mapToInt(Integer::intValue) 대신 mapToInt(i->i)로 대체 가능
    }
}