package hr.algebra.gameComponent.controller;

import hr.algebra.gameComponent.model.Card;
import hr.algebra.gameComponent.model.CardImageView;
import hr.algebra.res.ConstValues;
import hr.algebra.utils.AlertUtil;
import hr.algebra.utils.threads.Timer;
import hr.algebra.utils.threads.TimerLabelSetter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.TimerTask;

public class GameComponentController implements Initializable, TimerLabelSetter {

    private final ObservableList<CardImageView> playerCards = FXCollections.observableArrayList();
    private final ObservableList<CardImageView> attackCards = FXCollections.observableArrayList();

    @FXML
    public ImageView adutCard;
    @FXML
    public Label timer;
    @FXML
    public Label otherPlayerNameLeft;
    @FXML
    public Label otherPlayerCardCountLeft;
    @FXML
    public Label otherPlayerNameMiddle;
    @FXML
    public Label otherPlayerCardCountMiddle;
    @FXML
    public Label otherPlayerNameRight;
    @FXML
    public Label otherPlayerCardCountRight;
    @FXML
    private FlowPane battleSpace;
    @FXML
    private HBox playerCardsViewer;


    @Override
    public void setTime(String time) {
        timer.setText(time);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initBattleSpace();
        initPlayerHolder();
        startCountDown();
    }

    private void startCountDown() {
        Timer timer = new Timer(this, 10, this::timerIsDone);
        timer.start();
    }

    private void timerIsDone() {
        AlertUtil.showInformationAlert("Info", "Timer", "Timer is done");
    }

    private void initPlayerHolder() {
        fillPlayerCardCollection();
        playerCardsViewer.setPrefHeight(ConstValues.getPlayerCardsViewerHeight());
        playerCardsViewer.getChildren().addAll(playerCards);
    }

    private void fillPlayerCardCollection() {
        playerCards.addAll(
                new CardImageView(Card.ACE_CLUB, Card.ACE_CLUB, false, this::removeFromPlayerCards),
                new CardImageView(Card.EIGHT_CLUB, Card.ACE_CLUB, false, this::removeFromPlayerCards),
                new CardImageView(Card.FIVE_CLUB, Card.ACE_CLUB, false, this::removeFromPlayerCards),
                new CardImageView(Card.ACE_DIAMOND, Card.ACE_CLUB, false, this::removeFromPlayerCards),
                new CardImageView(Card.ACE_HEART, Card.ACE_CLUB, false, this::removeFromPlayerCards),
                new CardImageView(Card.EIGHT_CLUB, Card.ACE_CLUB, false, this::removeFromPlayerCards),
                new CardImageView(Card.FIVE_CLUB, Card.ACE_CLUB, false, this::removeFromPlayerCards),
                new CardImageView(Card.ACE_DIAMOND, Card.ACE_CLUB, false, this::removeFromPlayerCards),
                new CardImageView(Card.ACE_HEART, Card.ACE_CLUB, false, this::removeFromPlayerCards),
                new CardImageView(Card.EIGHT_SPADE, Card.ACE_CLUB, false, this::removeFromPlayerCards)
        );
    }

    private void removeFromPlayerCards(CardImageView cardImageView) {
        playerCardsViewer.getChildren().remove(cardImageView);
    }

    private void initBattleSpace() {
        filAttackCardCollection();
        battleSpace.getChildren().addAll(attackCards);
    }

    private void filAttackCardCollection() {
        attackCards.addAll(
                new CardImageView(Card.ACE_CLUB, Card.ACE_CLUB, true, (cardImageView) -> {
                }),
                new CardImageView(Card.EIGHT_CLUB, Card.ACE_CLUB, true, (cardImageView) -> {
                }),
                new CardImageView(Card.FIVE_CLUB, Card.ACE_CLUB, true, (cardImageView) -> {
                }),
                new CardImageView(Card.ACE_DIAMOND, Card.ACE_CLUB, true, (cardImageView) -> {
                }),
                new CardImageView(Card.ACE_HEART, Card.ACE_CLUB, true, (cardImageView) -> {
                }),
                new CardImageView(Card.EIGHT_CLUB, Card.ACE_CLUB, true, (cardImageView) -> {
                })
        );
    }
}
