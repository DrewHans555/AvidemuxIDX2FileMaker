package avidemuxidx2filemaker;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Drew Hans
 */
public class GUIController implements Initializable {

    @FXML //fx:id="path" value will be injected by the FXMLLoader
    private TextField path;

    @FXML //fx:id="button" value will be injected by the FXMLLoader
    private Button button;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked the button!");
        String thePath = path.getText();

        if (thePath == null) {
            popupMessage("Input Required!");
        } else {
            try {
                AvidemuxIDX2FileMaker.startBatch(thePath);
                path.clear();
            } catch (Exception e) {
                System.out.println("An Exception was thrown in "
                        + "handleButtonAction method!");
            }
        }
    }//end handleButtonAction method

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set to null for error checking when handleButtonAction is called
        path.setText(null);
    }//end initialize method

    private void popupMessage(String s) {
        TextField tf = new TextField(s);
        tf.setMinHeight(50);
        tf.setMinWidth(300);
        tf.setEditable(false);
        Stage popupStage = new Stage();
        Group root = new Group();
        root.getChildren().add(tf);
        Scene scene = new Scene(root);
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("You Screwed Up...");
        popupStage.setScene(scene);
        popupStage.show();
    }//end popupMessage method

}//end GUIController class
