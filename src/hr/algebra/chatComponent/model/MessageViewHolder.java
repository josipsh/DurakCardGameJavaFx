package hr.algebra.chatComponent.model;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class MessageViewHolder extends GridPane {
    private final Message message;

    public MessageViewHolder(Message message) {
        this.message = message;

        this.setPrefWidth(-1);
        this.setPrefHeight(-1);
        initViewHolder();
    }

    private void initViewHolder() {
        if (message.isUserAuthor()){
            this.getStyleClass().add("send-message");
            this.setAlignment(Pos.CENTER_RIGHT);

            Label content = setupContent();
            setConstraints(content, 0,0);
            getChildren().add(content);
        }else {
            this.getStyleClass().add("received-message");
            Label author = setupUserName();
            Label content = setupContent();

            setConstraints(author, 0,0);
            setConstraints(content, 0,1);
            getChildren().add(author);
            getChildren().add(content);
        }
    }

    private Label setupContent() {
        Label content = new Label(message.getContent());
        content.getStyleClass().add("message-content");
        return content;
    }

    private Label setupUserName() {
        Label author = new Label(message.getUser().getUserName());
        author.getStyleClass().add("message-author-info");
        return author;
    }
}
