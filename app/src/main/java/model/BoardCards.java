package model;

import java.util.List;

/**
 * Created by anbu.ezhilan on 7/05/2017.
 */

public final class BoardCards {

    private BoardCards() { }

    // Inner class which defines table contents */


    private int cardId;
    private String cardTitle;
    private String cardDescription;
    private String cardPoints;
    private List<BoardCards> getAllCards;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardTitle() {
        return cardTitle;
    }

    public void setCardTitle(String cardTitle) {
        this.cardTitle = cardTitle;
    }

    public String getCardDescription() {
        return cardDescription;
    }

    public void setCardDescription(String cardDescription) {
        this.cardDescription = cardDescription;
    }

    public String getCardPoints() {
        return cardPoints;
    }

    public void setCardPoints(String cardPoints) {
        this.cardPoints = cardPoints;
    }

    public List<BoardCards> getGetAllCards() {
        return getAllCards;
    }

    public void setGetAllCards(List<BoardCards> getAllCards) {
        this.getAllCards = getAllCards;
    }
}
