package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainWindow implements Initializable {
	
    @FXML
    private ImageView BTTN_ADD_STONE;

    @FXML
    private ImageView BTTN_SEARCH_BY_SIGN;

    @FXML
    private ImageView BTTN_SEE_STONES;
    
    @FXML
    void addStone(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/add-cristal.fxml"));
    	loader.setController(new AddCristal());
    	Parent root = loader.load();
    	
    	Stage st = new Stage();
    	Scene sc = new Scene(root);
    	st.setScene(sc);
    	st.show();
    	
    	Stage auxSt = (Stage) BTTN_ADD_STONE.getScene().getWindow();
    	auxSt.close();
    }

    @FXML
    void seeSigns(MouseEvent event) {

    }

    @FXML
    void seeStones(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/all-cristals.fxml"));
    	loader.setController(new AllCristals());
    	Parent root = loader.load();
    	
    	Stage st = new Stage();
    	Scene sc = new Scene(root);
    	st.setScene(sc);
    	st.show();
    	
    	Stage auxStage = (Stage) BTTN_SEE_STONES.getScene().getWindow();
    	auxStage.close();
    }

    @FXML
    void showAddStoneTooltip(MouseEvent event) {
    	Tooltip t = new Tooltip("Agregar una piedra");
    	Tooltip.install(BTTN_ADD_STONE, t);
    }
    
    @FXML
    void showSeeStonesTooltip(MouseEvent event) {
    	Tooltip t = new Tooltip("Ver todas las piedras");
    	Tooltip.install(BTTN_SEE_STONES, t);
    }
    
    @FXML
    void showSeeSignsTooltip(MouseEvent event) {
    	Tooltip t = new Tooltip("Ver piedras por signos");
    	Tooltip.install(BTTN_SEARCH_BY_SIGN, t);
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
