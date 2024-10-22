package BlackJack;

import BlackJackBase.PCard;

import java.awt.*;

public class BJCard extends PCard {
// Attributes

    private int rank;
    private int suit;
    private boolean hidden;

    public final int ACE = 1;
    public final int TWO = 2;
    public final int THREE = 3;
    public final int FOUR = 4;
    public final int FIVE = 5;
    public final int SIX = 6;
    public final int SEVEN = 7;
    public final int EIGHT = 8;
    public final int NINE = 9;
    public final int TEN = 10;
    public final int JACK = 11;
    public final int KNIGHT = 12;
    public final int QUEEN = 13;
    public final int KING = 14;

    public final int SPADE = 1;
    public final int HEART = 2;
    public final int DIAMOND = 3;
    public final int CLUB = 4;
// Constructors
public BJCard(int rank, int suit) {
    this.rank = rank;
    this.suit = suit;
    this.hidden = false;
}
// Getters & Setters

    // rank
    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
    this.rank = rank;
    }

    // suit
    public int getSuit() {
    return suit;
    }
    public void setSuit(int suit) {
    this.suit = suit;
    }

// Methods

    @Override
    public void hideCard(){
    this.hidden = true;
    }

    @Override
    public void showCard(){
    this.hidden = false;
    }

    @Override
    public boolean isHidden() {
    return this.hidden;
    }

    public String getText(){
    String rankStr;
    switch (this.rank){
        case ACE:
            rankStr = "A";
        break;

        case TWO:
            rankStr = "2";
        break;

        case THREE:
            rankStr = "3";
        break;

        case FOUR:
            rankStr = "4";
        break;

        case FIVE:
            rankStr = "5";
        break;

        case SIX:
            rankStr = "6";
        break;

        case SEVEN:
            rankStr = "7";
        break;

        case EIGHT:
            rankStr = "8";
        break;

        case NINE:
            rankStr = "9";
        break;

        case TEN:
            rankStr = "10";
        break;

        case JACK:
            rankStr = "J";
        break;

        case KNIGHT:
            rankStr = "K";
        break;

        case QUEEN:
            rankStr = "Q";
        break;

        case KING:
            rankStr = "K";
        break;

        default:
            rankStr = "?";
    }
    String suitStr;
    switch (this.suit){
        case SPADE:
            suitStr = "♠";
        break;

        case HEART:
            suitStr = "♥";
        break;

        case DIAMOND:
            suitStr = "♦";
        break;

        case CLUB:
            suitStr = "♣";
        break;

        default:
            suitStr = "?";
    }

    return rankStr + suitStr;

    }

    @Override
    public Color getFontColor() {

    if (this.suit == HEART || this.suit == DIAMOND){return Color.RED;}

    else {return Color.BLACK;}

}


}
