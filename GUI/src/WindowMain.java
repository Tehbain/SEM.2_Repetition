import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class WindowMain extends Application {
    private final VBox mainPane = new VBox();
    // Eller bare en HBox med VBoxe.

    @Override
    public void start(Stage stage) throws Exception {
        mainPane.setPadding(new Insets(10));
        mainPane.setPrefHeight(500);
        mainPane.setPrefWidth(750);
        Scene scene = new Scene(mainPane);
        stage.setTitle("TITLE");
        scene.setFill(Color.DIMGRAY);
        stage.setScene(scene);
        stage.show();
        initGUI();
    }


    private void initGUI() {
        VBox vbButtons = new VBox();
        Button btnYeet = new Button("Yeet");
        btnYeet.setOnAction(e -> {
            System.out.println("YEET!");
            new WindowSecond().showAndWait();
        });
        vbButtons.getChildren().add(btnYeet);
        mainPane.getChildren().add(vbButtons);
    }
}
