package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MainWindow implements Initializable {

    @FXML
    private ImageView BTTN_ADD_STONE;

    @FXML
    private ImageView BTTN_SEARCH_BY_SIGN;

    @FXML
    private ImageView BTTN_SEE_STONES;

    @FXML
    void addStone(MouseEvent event) {

    }

    @FXML
    void seeSigns(MouseEvent event) {

    }

    @FXML
    void seeStones(MouseEvent event) {

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
