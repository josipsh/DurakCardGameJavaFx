package hr.algebra.gameComponent.model;

import hr.algebra.res.ConstValues;
import hr.algebra.utils.AlertUtil;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.StackPane;

import java.io.File;
import java.util.function.Consumer;

public class CardImageView extends StackPane {

    ImageView imageView;
    ImageView defenseImageView;
    Image image;
    private final Card card;
    private final Card adutCard;

    private final boolean isThisCardImageViewAttack;
    private final Consumer<CardImageView> whenDefenseIsSuccessful;

    public CardImageView(Card card, Card adutCard, boolean isCardImageViewAttack, Consumer<CardImageView> whenDefenseIsSuccessful) {
        super();

        this.card = card;
        this.adutCard = adutCard;
        this.isThisCardImageViewAttack = isCardImageViewAttack;
        this.whenDefenseIsSuccessful = whenDefenseIsSuccessful;

        String imagePath = "src\\hr\\algebra\\res\\icon\\cardsImages\\" + card.toString() + ".png";

        File file = new File(imagePath);
        image = new Image(
                file.toURI().toString(),
                ConstValues.getCardViewHolderWidth(),
                ConstValues.getCardViewHolderHeight(),
                true,
                true
        );

        imageView = new ImageView(image);
        imageView.setFitWidth(ConstValues.getCardViewHolderWidth());
        imageView.setFitHeight(ConstValues.getCardViewHolderHeight());

        defenseImageView = new ImageView();
        defenseImageView.setFitWidth(ConstValues.getCardViewHolderWidth());
        defenseImageView.setFitHeight(ConstValues.getCardViewHolderHeight());

        super.getChildren().addAll(imageView, defenseImageView);
        super.getStyleClass().add("card-holder");

        initDragAndDrop();
    }

    private void initDragAndDrop() {
        this.setOnDragDetected(this::handleDragDetected);
        this.setOnDragDone(this::handleDragDone);
        this.setOnDragOver(this::handleDragOver);
        this.setOnDragDropped(this::handleDragDropped);
        this.setOnDragEntered(this::handleDragEntered);
        this.setOnDragExited(this::handleDragExited);
    }

    private void handleDragDetected(MouseEvent event) {
        if (isThisCardImageViewAttack) {
            return;
        }

        Dragboard db = this.startDragAndDrop(TransferMode.MOVE);

        ClipboardContent content = new ClipboardContent();
        content.putImage(image);
        content.putString(String.valueOf(card.getValue()));

        db.setContent(content);
        event.consume();
    }

    private void handleDragDone(DragEvent dragEvent) {
        if (dragEvent.getTransferMode() == TransferMode.MOVE){
            whenDefenseIsSuccessful.accept(this);
        }
    }

    private void handleDragOver(DragEvent event) {
        if (isEventDataValid(event)) {
            event.acceptTransferModes(TransferMode.MOVE);
        }
        event.consume();
    }

    private void handleDragDropped(DragEvent event) {
        try {
            if (!isEventDataValid(event)) {
                event.setDropCompleted(true);
                event.consume();
                return;
            }

            Dragboard db = event.getDragboard();
            String cardValue = db.getString();
            Card defenseCard = Card.getCardFromValue(Integer.parseInt(cardValue));
            Image defenseImageFromClipboard = db.getImage();

            boolean isValid = card.isDefenseStronger(defenseCard, adutCard);
            if (isValid && isThisCardImageViewAttack && defenseImageView.getImage() == null) {

                defenseImageView.setImage(defenseImageFromClipboard);
                defenseImageView.setFitWidth(75);
                setAlignment(defenseImageView, Pos.BOTTOM_RIGHT);
                event.setDropCompleted(true);
                event.consume();
            }
        } catch (Exception e) {
            AlertUtil.showErrorAlert("Error occurred", "Something bad happened", e.getMessage());

            event.setDropCompleted(false);
            event.consume();
        }
    }

    private void handleDragEntered(DragEvent event) {
        try {
            if (!isEventDataValid(event)) {
                return;
            }

            Dragboard db = event.getDragboard();
            String cardValue = db.getString();
            Card defenseCard = Card.getCardFromValue(Integer.parseInt(cardValue));

            boolean isValid = card.isDefenseStronger(defenseCard, adutCard);
            if (isValid && isThisCardImageViewAttack) {
                this.setStyle("-fx-background-color: #0f0;");
            } else if (!isValid && isThisCardImageViewAttack) {
                this.setStyle("-fx-background-color: #f00;");
            }

            event.consume();
        } catch (Exception e) {
            AlertUtil.showErrorAlert("Error occurred", "Something bad happened", e.getMessage());
            event.consume();
        }
    }

    private void handleDragExited(DragEvent event) {
        this.setStyle("-fx-background-color: transparet;");
        event.consume();
    }

    private boolean isEventDataValid(DragEvent event) {
        return event.getGestureSource() != this
                && isThisCardImageViewAttack
                && event.getDragboard().hasString()
                && event.getDragboard().hasImage();
    }

    public Card getCard() {
        return card;
    }
}
