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
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.ProgramData;

public class AddCristal {

    @FXML
    private ImageView BTTN_BACK;
    
    @FXML
    private Button BTTN_SAVE;

    @FXML
    private ImageView BTTN_EDIT_PIC;

    @FXML
    private ImageView IMG_CRISTAL_PIC;

    @FXML
    private TextArea TXTA_CRISTAL_DESCRIPTION;

    @FXML
    private TextField TXT_CRISTAL_NAME;
    
    @FXML
    private TextField TXT_SIGNS;
    
    private String urlPic;

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
    		urlPic = file.toURI().toString();
    		
    		IMG_CRISTAL_PIC.setImage(new Image(urlPic));
    	}
    }

    @FXML
    void saveCristal(ActionEvent event) {
    	String name = TXT_CRISTAL_NAME.getText();
    	String description = TXTA_CRISTAL_DESCRIPTION.getText();
    	String signs = TXT_SIGNS.getText();
    	
    	if(name.isEmpty() || description.isEmpty() || signs.isEmpty()
    			|| urlPic.isEmpty()) {
    		showIncompleteInformationAlert();
    	} else if(ProgramData.searchStone(name) == -1) {
    		showAlreadyExistingStoneAlert();
    	} else {
			ProgramData.addStone(name, description, description, signs);
			
			showCorrectCreationAlert();
		}
    }
    
    public void showIncompleteInformationAlert() {
		Alert alert = new Alert(AlertType.WARNING);
		
		alert.setTitle("Información incompleta");
		alert.setHeaderText("La información no está completa");
		alert.setContentText("No se ha introducido la información "
				+ "necesaria para crear la piedra.");
		
		alert.show();
	}
    
    public void showAlreadyExistingStoneAlert() {
		Alert alert = new Alert(AlertType.WARNING);
		
		alert.setTitle("Piedra existente");
		alert.setHeaderText("La piedra ya existe");
		alert.setContentText("Ya existe una piedra con el nombre "
				+ "digitado.");
		
		alert.show();
	}
    
    public void showCorrectCreationAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		
		alert.setTitle("Piedra creada");
		alert.setHeaderText("La piedra se ha creado");
		alert.setContentText("La piedra se ha creado de manera "
				+ "correcta.");
		
		alert.show();
	}

    @FXML
    void showBackTooltip(MouseEvent event) {
    	Tooltip t = new Tooltip("Atrás");
    	Tooltip.install(BTTN_BACK, t);
    }

    @FXML
    void showEditTooltip(MouseEvent event) {
    	Tooltip t = new Tooltip("Editar imagen de la piedra");
    	Tooltip.install(BTTN_EDIT_PIC, t);
    }
    
}
