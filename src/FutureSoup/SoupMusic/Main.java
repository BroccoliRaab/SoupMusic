package FutureSoup.SoupMusic;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
    public static final String TITLE = "SoupMusic";
    public static final int DEFAULT_WIDTH = 900;
    public static final int DEFAULT_HEIGHT = 500;
    public static HBox infoPane;
    private Track currentTrack;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //primaryStage.setScene(new Scene(root, DEFAULTWIDTH, DEFAULTHEIGHT));

        //BorderPane is a layout with a center, top, bottom, left, and right
         //Left will have selection of by what to sort: Contr. Artist, Album Artist, Album, Genres, Years, Composers, ECT
        BorderPane mainPane = new BorderPane();

        Scene mainScene = new Scene(mainPane, DEFAULT_WIDTH, DEFAULT_HEIGHT);

        primaryStage.setScene(mainScene);

        mainScene.getStylesheets().add("FutureSoup/SoupMusic/resources/style.css");

        primaryStage.setTitle(TITLE);

        HBox controls = new HBox();

        VBox bodyV = new VBox();

        bodyV.setId("bodyVBox");

        mainPane.setCenter(bodyV);

        VBox leftPane = new VBox();
        VBox queuePane = new VBox();

        //Uncomment this and put path to mp3 file to get to work
        //Player.setCurrentTrack(new Track(new File("F:\\Music\\OSTs\\Shinsekai Yori Original Soundtrack CD1\\01. Traditional Song Of Shadows Part One.mp3")));

        currentTrack= Player.getCurrentTrack();
        if (currentTrack != null) {
            infoPane = currentTrack.getInfoPane();
        }else {
            infoPane = new HBox();
        }

        leftPane.setPadding(new Insets(0, 0, 0, 0));
        leftPane.setId("leftPane");

        leftPane.setPrefWidth(240);



        /*HBox infoPane = new HBox();
        infoPane.setPadding(new Insets(5, 0, 5, 5));
        infoPane.setId("infoPane");

        VBox textInfoPane = new VBox();
        textInfoPane.setPadding(new Insets(0, 0, 0, 5));
        textInfoPane.setId("textInfoPane");

        //||||| This is just Temp to get idea of visuals
        //VVVVV
        Image imageAlbumArt = new Image(getClass().getResourceAsStream("resources/images/albumArtDef.png"), 100, 100, true, true);
        ImageView imageViewAlbumArt = new ImageView(imageAlbumArt);
        infoPane.getChildren().addAll(imageViewAlbumArt, textInfoPane);

        DropShadow albumArtShadow = new DropShadow();
        albumArtShadow.setColor(Color.BLACK);

        imageViewAlbumArt.setEffect(albumArtShadow);

        //Label artistLabel = new Label("Artist Name");

        Text artistLabel = new Text();
        artistLabel.setText("Artist Name");
        artistLabel.setId("infoText");
        //Label songLabel = new Label("Song Name");

        Text songLabel = new Text();
        songLabel.setText("Song Title");
        songLabel.setId("infoText");

        Text albumLabel = new Text();
        albumLabel.setText("Album Name");
        albumLabel.setId("infoText");

        Text yearLabel = new Text();
        yearLabel.setText("Year");
        yearLabel.setId("infoText");

        Text genreLabel = new Text();
        genreLabel.setText("Genre");
        genreLabel.setId("infoText");

        textInfoPane.getChildren().addAll( songLabel, artistLabel, albumLabel, yearLabel, genreLabel);

        */
        queuePane.setPadding(new Insets(0, 0, 0, 0));
        queuePane.setId("queuePane");
        leftPane.getChildren().addAll(infoPane, queuePane);


        HBox queueControls = new HBox();
        queueControls.setId("queueControls");



        mainPane.setLeft(leftPane);

        controls.setPadding(new Insets(0,0,0,0));
        controls.setId("controlsBar");
        controls.setSpacing(10);
        controls.setAlignment(Pos.CENTER);
        controls.setMaxHeight(40);
        //controls.setFillHeight(true);

        PlayPauseButton playPauseButton = new PlayPauseButton(0);
        playPauseButton.setId("playButton");

        SkipButton forwardSkip = new SkipButton(SkipButton.FORWARD);
        forwardSkip.setId("forwardSkip");

        SkipButton backwardSkip = new SkipButton(SkipButton.BACKWARD);
        backwardSkip.setId("backwardSkip");





        controls.getChildren().addAll(backwardSkip, playPauseButton, forwardSkip);

        mainPane.setBottom(controls);

        primaryStage.show();
        
    }


    public static void main(String[] args) {
        launch(args);
    }
}
