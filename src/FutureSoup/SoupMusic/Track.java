package FutureSoup.SoupMusic;

import javafx.geometry.Insets;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.images.Artwork;
import org.jaudiotagger.tag.images.StandardArtwork;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;


public  class Track {
    private final AudioFile audioFile;
    private final Tag tag;
    private final AudioHeader audioHeader;

    private final int length;
    private final String title;
    private final String artist;
    private final String album;
    private final String year;
    private final String track;
    private final String composer;
    private final String artistSort;
    private final String genre;

    private Artwork artwork;

    private Image artworkImage;

    private final Media media;
    private final MediaPlayer mediaPlayer;




    private final HBox infoPane;
    private final ImageView imageViewAlbumArt;




    public Track(File file) throws TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException, IOException {
        audioFile = AudioFileIO.read(file);
        tag = audioFile.getTag();
        audioHeader = audioFile.getAudioHeader();

        length = audioHeader.getTrackLength();

        title = tag.getFirst(FieldKey.TITLE);
        artist = tag.getFirst(FieldKey.ARTIST);
        album = tag.getFirst(FieldKey.ALBUM);
        year = tag.getFirst(FieldKey.YEAR);
        track = tag.getFirst(FieldKey.TRACK);
        composer = tag.getFirst(FieldKey.COMPOSER);
        artistSort = tag.getFirst(FieldKey.ARTIST_SORT);
        genre = tag.getFirst(FieldKey.GENRE);

        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);


        artwork = tag.getFirstArtwork();
        if (artwork != null) {
            artworkImage = new Image(new ByteArrayInputStream(artwork.getBinaryData()), 100, 100, true, false);
        }else{

            artworkImage = new Image(getClass().getResourceAsStream("resources/images/albumArtDef.png"), 100, 100, true, true);
        }


        //||||| This is constructing infoPane
        //VVVVV

        infoPane = new HBox();
        infoPane.setPadding(new Insets(5, 0, 5, 5));
        infoPane.setId("infoPane");
        infoPane.setMaxWidth(250);


        VBox textInfoPane = new VBox();
        textInfoPane.setPadding(new Insets(0, 0, 0, 5));
        textInfoPane.setId("textInfoPane");



        imageViewAlbumArt = new ImageView(artworkImage);
        infoPane.getChildren().addAll(imageViewAlbumArt, textInfoPane);

        DropShadow albumArtShadow = new DropShadow();
        albumArtShadow.setColor(Color.BLACK);

        imageViewAlbumArt.setEffect(albumArtShadow);

        Text artistLabel = new Text();
        artistLabel.setText(artist);
        artistLabel.setId("infoText");

        Text songLabel = new Text();
        songLabel.setText(title);
        songLabel.setId("infoText");

        Text albumLabel = new Text();
        albumLabel.setText(album);
        albumLabel.setId("infoText");

        Text yearLabel = new Text();
        yearLabel.setText(year);
        yearLabel.setId("infoText");

        Text genreLabel = new Text();
        genreLabel.setText(genre);
        genreLabel.setId("infoText");

        textInfoPane.getChildren().addAll( songLabel, artistLabel, albumLabel, yearLabel, genreLabel);

    }

    public org.jaudiotagger.audio.AudioFile getAudioFile() {
        return audioFile;
    }

    public Tag getTag() {
        return tag;
    }

    public AudioHeader getAudioHeader() {
        return audioHeader;
    }

    public int getLength() {
        return length;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public String getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }


    public String getTrack() {
        return track;
    }

    public String getComposer() {
        return composer;
    }

    public String getArtistSort() {
        return artistSort;
    }

    public Artwork getArtwork() {
        return artwork;
    }

    public Image getArtworkImage() {
        return artworkImage;
    }

    public Media getMedia() {
        return media;
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public HBox getInfoPane() {
        return infoPane;
    }

    public ImageView getImageViewAlbumArt() {
        return imageViewAlbumArt;
    }
}
