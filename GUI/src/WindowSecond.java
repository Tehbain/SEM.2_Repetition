import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class WindowSecond extends Stage {
    private VBox mainPane = new VBox();

    public WindowSecond() {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setTitle("Second Window");
        requestFocus();
        setScene(new Scene(mainPane));
    }
}
