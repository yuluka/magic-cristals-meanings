package control;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AllCristals {

    @FXML
    private ImageView BTTN_BACK;
	
    @FXML
    private ImageView BTTN_SEARCH;

    @FXML
    private Pane PANE_CRISTALS;

    @FXML
    private TextField TXT_CRISTAL_NAME;

    @FXML
    private ScrollPane SCRLLPANE;

    @FXML
    void back(MouseEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("../ui/main-window.fxml"));
    	loader.setController(new MainWindow());
    	Parent root = loader.load();
    	
    	Stage st = new Stage();
    	Scene sc = new Scene(root);
    	st.setScene(sc);
    	st.show();
    	
    	Stage auxStage = (Stage) BTTN_BACK.getScene().getWindow();
    	auxStage.close();
    }

    @FXML
    void showBackTooltip(MouseEvent event) {
    	Tooltip t = new Tooltip("Atrás");
    	Tooltip.install(BTTN_BACK, t);
    }
    
    @FXML
    void search(MouseEvent event) {
    	
    }

    @FXML
    void showSearchTooltip(MouseEvent event) {
    	Tooltip t = new Tooltip("Buscar piedra");
    	Tooltip.install(BTTN_SEARCH, t);
    }
	
}
