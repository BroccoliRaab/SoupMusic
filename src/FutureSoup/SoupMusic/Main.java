package FutureSoup.SoupMusic;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
    public static final String TITLE = "SoupMusic";
    public static final int DEFAULT_WIDTH = 900;
    public static final int DEFAULT_HEIGHT = 500;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //primaryStage.setScene(new Scene(root, DEFAULTWIDTH, DEFAULTHEIGHT));

        //BorderPane is a layout with a center, top, bottom, left, and right
        //Left will have selection of by what to sort: Contr. Artist, Album Artist, Album, Genres, Years, Composers, ECT
        BorderPane mainPane = new BorderPane();

        Scene mainScene = new Scene(mainPane, DEFAULT_WIDTH, DEFAULT_HEIGHT);

        primaryStage.setScene(mainScene);

        mainScene.getStylesheets().add("Style.css");

        primaryStage.setTitle(TITLE);

        HBox controls = new HBox();

        VBox bodyV = new VBox();

        bodyV.setId("bodyVBox");


        mainPane.setCenter(bodyV);

        VBox queuePane = new VBox();

        queuePane.setPadding(new Insets(0, 250, 0, 0));
        queuePane.setId("queuePane");
        mainPane.setLeft(queuePane);

        controls.setPadding(new Insets(0,0,0,0));
        controls.setId("controlsBar");
        controls.setSpacing(10);
        controls.setAlignment(Pos.CENTER);
        controls.setMaxHeight(40);
        //controls.setFillHeight(true);

        PlayPauseButton playPauseButton = new PlayPauseButton(0);
        playPauseButton.setId("playButton");



        playPauseButton.setMaxHeight(35);
        playPauseButton.setMaxWidth(35);

        controls.getChildren().add(playPauseButton);

        mainPane.setBottom(controls);

        primaryStage.show();
        
    }


    public static void main(String[] args) {
        launch(args);
    }
}
