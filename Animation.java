
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;
import javafx.util.Duration;

public class Animation extends Application {
	TextField speed = new TextField();
	TextField prefix = new TextField();
	TextField numberOfImages = new TextField();
	TextField URL = new TextField();
	StackPane stackPane = new StackPane();
	Timeline animation;
	int num = 1;

@Override
public void start(Stage primaryStage) {
	int COLUMN_COUNT = 27;
	speed.setPrefColumnCount(COLUMN_COUNT);
	prefix.setPrefColumnCount(COLUMN_COUNT);
	numberOfImages.setPrefColumnCount(COLUMN_COUNT);
	URL.setPrefColumnCount(COLUMN_COUNT);

	Button button = new Button("Start Animation");

	GridPane gridPane = new GridPane();
	gridPane.setAlignment(Pos.BOTTOM_CENTER);
	gridPane.add(new Label("Enter information for animation"), 0, 0);
	gridPane.add(new Label("Animation speed in milliseconds"), 0, 1);
	gridPane.add(speed, 1, 1);
	gridPane.add(new Label("Image file prefix"), 0, 2);
	gridPane.add(prefix, 1, 2);
	gridPane.add(new Label("Number of images"), 0, 3);
	gridPane.add(numberOfImages, 1, 3);
	gridPane.add(new Label("Audio file URL"), 0, 4);
	gridPane.add(URL, 1, 4);

	BorderPane borderPane = new BorderPane();
	borderPane.setBottom(gridPane);
	borderPane.setCenter(stackPane);
	borderPane.setTop(button);
	BorderPane.setAlignment(button, Pos.TOP_RIGHT);

	animation = new Timeline(
	new KeyFrame(Duration.millis(1000), e -> nextImage()));
	animation.setCycleCount(Timeline.INDEFINITE);

	button.setOnAction(e -> {
	if (URL.getText().length() > 0) {
	MediaPlayer mediaPlayer = new MediaPlayer(new Media(URL.getText()));
	mediaPlayer.play();

	}

	if (speed.getText().length() > 0)
	animation.setRate(Integer.parseInt(speed.getText()));
	animation.play();
	});

	Scene scene = new Scene(borderPane, 675, 675);
	primaryStage.setScene(scene);
	primaryStage.show();

	}

	private void getImage() {
	stackPane.getChildren().clear();
	stackPane.getChildren().add(new ImageView(new Image("http://cs.armstrong.edu/liang/common/image/" + prefix.getText() + num + ".gif")));

	}

	private void nextImage() {
	num = num < Integer.parseInt(numberOfImages.getText()) ? num += 1 : 1;
	getImage();

	}

public static void main(String[] args) {
	launch (args);

	}

}
