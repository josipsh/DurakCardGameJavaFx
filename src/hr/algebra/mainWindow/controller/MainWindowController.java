package hr.algebra.mainWindow.controller;


import hr.algebra.utils.AlertUtil;
import hr.algebra.utils.logger.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void onCloseApplicationClick() {
        Platform.exit();
    }

    @FXML
    public void onOpenSettingsClick() {
        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass()
                            .getResource("/hr/algebra/settingsWindow/view/SettingsWindowView.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Settings");
            stage.setScene(new Scene(root, 400, 400));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            Logger.log(e.getMessage(), e);
        }

    }

    @FXML
    public void onGenerateDocumentationClick() {
        AlertUtil.showInformationAlert("Enter file path!", "generate documentation", "This is body");
    }

}
