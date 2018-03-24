package FutureSoup.SoupMusic;


public class Player {
    private static Track currentTrack;

    public static void setCurrentTrack(Track track){
        currentTrack = track;
    }
    public static Track getCurrentTrack(){
        return currentTrack;
    }
    public static void removeCurrentTrack(){
        currentTrack = null;
    }
}
