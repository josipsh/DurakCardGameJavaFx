package hr.algebra.chatComponent.controller;

import hr.algebra.chatComponent.model.Message;
import hr.algebra.chatComponent.model.MessageViewHolder;
import hr.algebra.sharedModel.User;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ChatComponentController implements Initializable {

    @FXML
    public TextField messageTextField;
    @FXML
    public Button sendButton;
    @FXML
    public ListView<MessageViewHolder> messagesListView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initListeners();
        fakeReceive();
    }

    private void initListeners() {
        sendButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                MessageViewHolder message = new MessageViewHolder(
                        new Message(
                                new User(1, "Pero", "Peric", "Perica"),
                                messageTextField.getText().trim(),
                                true));

                messagesListView.getItems().add(message);
                messageTextField.setText("");
                scrollToMessage(message);
            }
        });
    }

    private void scrollToMessage(MessageViewHolder message) {
        messagesListView.scrollTo(message);
    }

    private void fakeReceive() {
        for (int i = 0; i < 5; i++) {
            MessageViewHolder message = new MessageViewHolder(
                    new Message(
                            new User(1, "Ivan", "Ivic", "Ivica"),
                            "This is message",
                            false));
            messagesListView.getItems().add(message);
            scrollToMessage(message);
        }
    }
}
