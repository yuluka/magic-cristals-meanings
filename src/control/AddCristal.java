package control;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AddCristal {

    @FXML
    private ImageView BTTN_BACK;

    @FXML
    private ImageView BTTN_EDIT_PIC;

    @FXML
    private ImageView IMG_CRISTAL_PIC;

    @FXML
    private TextArea TXTA_CRISTAL_DESCRIPTION;

    @FXML
    private TextField TXT_CRISTAL_NAME;

    @FXML
    void back(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/main-window.fxml"));
    	loader.setController(new MainWindow());
    	Parent root = loader.load();
    	
    	Stage st = new Stage();
    	Scene sc = new Scene(root);
    	st.setScene(sc);
    	st.show();
    	
    	Stage auxSt = (Stage) BTTN_BACK.getScene().getWindow();
    	auxSt.close();
    }

    @FXML
    void editPicture(MouseEvent event) {
    	FileChooser fc = new FileChooser();
    	fc.setTitle("Seleccione la imagen de la piedra");
    	File file = fc.showOpenDialog(BTTN_BACK.getScene().getWindow());
    	
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Seleccionar imagen");
    	
    	if(file != null) {
    		IMG_CRISTAL_PIC.setImage(new Image(file.toURI().toString()));
    	}
    }

    @FXML
    void saveCristal(ActionEvent event) {
    	
    }

    @FXML
    void showBackTooltip(MouseEvent event) {

    }

    @FXML
    void showEditTooltip(MouseEvent event) {

    }
    
}
