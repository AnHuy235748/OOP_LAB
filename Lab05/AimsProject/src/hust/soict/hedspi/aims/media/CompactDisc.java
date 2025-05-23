package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc() {
        super();
    }

    public CompactDisc(String title, String category, float cost, String director) {
        super(title, category, cost, director);
    }

    public CompactDisc(String title, String category, String artist, String director, float cost) {
        super(title, category, director, 0, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    public CompactDisc(int id, String title, String category, String artist, String director, float cost) {
        super(id, title, category, director, 0, cost);
        this.artist = artist;
    }

    public CompactDisc(int id, String title, String category, String director, int length, float cost,
                       ArrayList<Track> tracks) {
        super(title, category, director, 0, cost);
        this.artist = artist;
        this.tracks = tracks;
    }

    public String getArtist() { return artist; }
    public List<Track> getTracks() { return tracks; }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track '" + track.getTitle() + "' is already exist within this CD.");
        } else {
            tracks.add(track);
            System.out.println("Track '" + track.getTitle() + "' is added to CD '" + getTitle() + "'.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.remove(track)) {
            System.out.println("Track '" + track.getTitle() + "' is removed from CD '" + getTitle() + "'.");
        } else {
            System.out.println("Track '" + track.getTitle() + "' wasn't found within this CD.");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() {
        if (getLength() <= 0) {
            System.out.println("Cannot play CD: " + getTitle() + " - No playable tracks.");
            return;
        }
        System.out.println("--- Playing CD: " + getTitle() + " by " + artist + " ---");
        System.out.println("CD Director: " + getDirector());
        System.out.println("Total CD Length: " + getLength() + " seconds");
        System.out.println("Tracks:");
        if (tracks.isEmpty()) {
            System.out.println("No tracks on this CD.");
        } else {
            for (Track track : tracks) {
                track.play();
                System.out.println("---");
            }
        }
        System.out.println("--- Finished playing CD: " + getTitle() + " ---");
    }

    @Override
    public String toString() {
        return "CD - ID: " + getId() + " - Title: " + getTitle() +
                " - Category: " + getCategory() + " - Artist: " + artist +
                " - Director: " + getDirector() + " - Length: " + getLength() + "s" +
                " - Cost: " + getCost() + "$" + " - Tracks: " + tracks.size();
    }
}