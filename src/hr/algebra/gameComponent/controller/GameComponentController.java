package hr.algebra.gameComponent.controller;

import hr.algebra.gameComponent.model.Card;
import hr.algebra.gameComponent.model.CardImageView;
import hr.algebra.res.ConstValues;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class GameComponentController implements Initializable {

    private final ObservableList<CardImageView> playerCards = FXCollections.observableArrayList();
    private final ObservableList<CardImageView> attackCards = FXCollections.observableArrayList();

    @FXML
    private HBox playerCardsViewer;

    @FXML
    private FlowPane battleSpace;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initBattleSpace();
        initPlayerHolder();
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

    private void removeFromPlayerCards(CardImageView cardImageView){
        playerCardsViewer.getChildren().remove(cardImageView);
    }
    private void initBattleSpace() {
        filAttackCardCollection();
        battleSpace.getChildren().addAll(attackCards);
    }

    private void filAttackCardCollection() {
        attackCards.addAll(
                new CardImageView(Card.ACE_CLUB, Card.ACE_CLUB, true, (cardImageView) -> {} ),
                new CardImageView(Card.EIGHT_CLUB, Card.ACE_CLUB, true, (cardImageView) -> {}),
                new CardImageView(Card.FIVE_CLUB, Card.ACE_CLUB, true, (cardImageView) -> {}),
                new CardImageView(Card.ACE_DIAMOND, Card.ACE_CLUB, true, (cardImageView) -> {}),
                new CardImageView(Card.ACE_HEART, Card.ACE_CLUB, true, (cardImageView) -> {}),
                new CardImageView(Card.EIGHT_CLUB, Card.ACE_CLUB, true, (cardImageView) -> {})
        );
    }
}
