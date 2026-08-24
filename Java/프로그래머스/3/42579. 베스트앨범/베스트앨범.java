import java.util.*;



class Solution {
    class Song{
        int id;
        int play;
        Song(int id, int play){
            this.id = id;
            this.play = play;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> playCountByGenre = new HashMap<>();
        Map<String, List> songByGenre = new HashMap<>();
        
        for(int i=0 ; i<genres.length; i++){
            playCountByGenre.put(genres[i], 
                                 playCountByGenre.getOrDefault(genres[i], 0)+plays[i]);
            songByGenre.putIfAbsent(genres[i], new ArrayList<Song>());
            songByGenre.get(genres[i]).add(new Song(i, plays[i]));
        }
        
        List<String> genreOrder = new ArrayList<>(playCountByGenre.keySet());
        Collections.sort(genreOrder, (a, b) -> 
                  { return -Integer.compare(playCountByGenre.get(a), playCountByGenre.get(b)); });
        
        // for(String genre: genreOrder){
        //     System.out.printf("Genre: %s, Play: %d\n", genre, playCountByGenre.get(genre));
        // }
        
        List<Integer> answerList = new ArrayList<>();
        
        for(String genre: genreOrder){
            List<Song> songList = songByGenre.get(genre);
            songList.sort((a, b)->{
                if(a.play == b.play){ 
                    return Integer.compare(a.id, b.id); 
                }else{
                    return -Integer.compare(a.play, b.play);
                }
            });
            for(int i=0; i<Math.min(2, songList.size()); i++){
                
                answerList.add(songList.get(i).id);
                //System.out.println(songList.get(i).id);
            }
        }
        
        
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++){
            answer[i]=answerList.get(i);
        }
        
        return answer;
    }
}