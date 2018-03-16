package FutureSoup.SoupMusic;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlayPauseButton extends StateButton {

    Image imagePlay = new Image(getClass().getResourceAsStream("play.png"), 50, 50, true, true);
    Image imagePause = new Image(getClass().getResourceAsStream("pause.png"), 50, 50, true, true);
    ImageView imageViewPlay = new ImageView(imagePlay);
    ImageView imageViewPause = new ImageView(imagePause);

    public static int PLAY_BUTTON_VISIBLE = 0;
    public static int PAUSE_BUTTON_VISIBLE = 1;

    @Override
    public void state0Action() {
        this.setGraphic(imageViewPause);
    }

    @Override
    public void state1Action() {
        this.setGraphic(imageViewPlay);
    }
    public PlayPauseButton(int defaultState){
        super(defaultState);
        if (defaultState == PLAY_BUTTON_VISIBLE){
            this.setGraphic(imageViewPlay);
        }else if (defaultState == PAUSE_BUTTON_VISIBLE){
            this.setGraphic(imageViewPause);
        }

    }
}
