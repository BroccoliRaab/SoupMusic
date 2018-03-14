package FutureSoup.SoupMusic;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
    public static final String TITLE = "MusicSoup";
    public static final int DEFAULT_WIDTH = 900;
    public static final int DEFAULT_HEIGHT = 500;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //primaryStage.setScene(new Scene(root, DEFAULTWIDTH, DEFAULTHEIGHT));

        //BorderPane is a layout with a center, top, bottom, left, and right
        //Left will have slection of by what to sort: Contr. Artist, Album Artist, Album, Genres, Years, Composers, ECT
        BorderPane mainPane = new BorderPane();

        Scene mainScene = new Scene(mainPane, DEFAULT_WIDTH, DEFAULT_HEIGHT);

        primaryStage.setScene(mainScene);

        primaryStage.setTitle(TITLE);

        primaryStage.show();
        
    }


    public static void main(String[] args) {
        launch(args);
    }
}
