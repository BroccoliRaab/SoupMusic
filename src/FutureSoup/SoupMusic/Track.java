package FutureSoup.SoupMusic;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

import java.io.File;
import java.io.IOException;


public  class Track {
    private final AudioFile audioFile;
    private final Tag tag;
    private final AudioHeader audioHeader;

    public Track(File file) throws TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException, IOException {
        audioFile = AudioFileIO.read(file);
        tag = audioFile.getTag();
        audioHeader = audioFile.getAudioHeader();
    }

    public org.jaudiotagger.audio.AudioFile getAudioFile() {
        return audioFile;
    }

}
