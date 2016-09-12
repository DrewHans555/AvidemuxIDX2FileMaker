package avidemuxidx2filemaker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Drew Hans
 */
public class AvidemuxIDX2FileMaker extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("DrewHans555 IDX2FileMaker");
        stage.setScene(scene);
        stage.show();
    }//end start method

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }//end main method

    public static void startBatch(String directoryPath) {
        try {
            File theDirectory = new File(directoryPath);
            File[] arrayOfFiles = theDirectory.listFiles();
            for (int i = 0; i < arrayOfFiles.length; i++) {
                //if statement weeds out other directories/folders
                if (arrayOfFiles[i].isFile()) {
                    createIDX2File(directoryPath, theDirectory, arrayOfFiles[i]);
                }
            }
            System.out.println("Operation successful!");
        } catch (Exception e) {
            System.out.println("An exception was thrown in startBatch method");
        }

    }//end startBatch method

    public static void createIDX2File(String dirPathString, File theDir, File theFile) {
        try {
            File theIDX2file = new File(theDir + "//" + theFile.getName() + ".idx2");

            if (theIDX2file.createNewFile()) {
                System.out.println(theIDX2file.toString() + " creation successful!");
                writeToIDX2File(theDir, theFile, theIDX2file);
            } else {
                System.out.println(theIDX2file.toString() + " already exists.");
            }
        } catch (Exception e) {
            System.out.println("Exception thrown, something went horribly "
                    + "wrong in createIDX2File method.");
        }
    }//end createIDX2File method

    public static void writeToIDX2File(File theDir, File theFile, File theIDX2file) {
        String s = "PSD1\n"
                + "[System]\n"
                + "Version=5\n"
                + "Type=P\n"
                + "File=" + theDir + "\\" + theFile.getName() + "\n"
                + "Append=0";

        FileWriter fw;
        try {
            fw = new FileWriter(theIDX2file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(s);
            bw.close();
        } catch (Exception e) {
            System.out.println("Exception thrown, something went horribly "
                    + "wrong in writeToIDX2File method.");
        }
    }//end writeToIDX2File() method

}//end AvidemuxIDX2FileMaker class
