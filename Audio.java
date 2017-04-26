
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class Audio extends Application {
	AudioClip audioClip = new AudioClip("http://www.cs.armstrong.edu/liang/common/audio/anthem/anthem2.mp3");

@Override
public void start(Stage primaryStage) {
	Button button1 = new Button("Play");
	Button button2 = new Button("Loop");
	Button button3 = new Button("Stop");

	HBox hBox = new HBox(5);
	hBox.setAlignment(Pos.CENTER);
	hBox.getChildren().addAll(button1, button2, button3);

	button1.setOnAction(e -> {
	audioClip.setCycleCount(1);
	audioClip.play();
	});

	button2.setOnAction(e -> {
	audioClip.setCycleCount(Timeline.INDEFINITE);
	audioClip.play();
	});

	button3.setOnAction(e -> {
	audioClip.stop();
	});

	Scene scene = new Scene(hBox, 300, 300);
	primaryStage.setScene(scene);
	primaryStage.show();

	}

public static void main(String[] args) {
	launch(args);

	}

}
