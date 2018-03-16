package FutureSoup.SoupMusic;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlayPauseButton extends StateButton {

    Image imagePlay = new Image(getClass().getResourceAsStream("play.png"), 50, 50, true, true);
    Image imagePause = new Image(getClass().getResourceAsStream("pause.png"), 50, 50, true, true);
    ImageView imageViewPlay = new ImageView(imagePlay);
    ImageView imageViewPause = new ImageView(imagePause);

    public static int PLAYBUTTONVISBLE = 0;
    public static int PAUSEUTTONVISBLE = 1;

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
        if (defaultState == PLAYBUTTONVISBLE){
            this.setGraphic(imageViewPlay);
        }else if (defaultState == PAUSEUTTONVISBLE){
            this.setGraphic(imageViewPause);
        }

    }
}
