package BlackJack;

import java.awt.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BJCardTest {

    @Test
    void getRank() {
        BJCard card = new BJCard(1, 1); // Ace of Spades
        assertEquals(1, card.getRank());
    }

    @Test
    void setRank() {
        BJCard card = new BJCard(1, 1); // Ace of Spades
        card.setRank(14); // King
        assertEquals(14, card.getRank());
    }

    @Test
    void getSuit() {
        BJCard card = new BJCard(1, 1); // Ace of Spades
        assertEquals(1, card.getSuit());
    }

    @Test
    void setSuit() {
        BJCard card = new BJCard(1, 1); // Ace of Spades
        card.setSuit(2); // Hearts
        assertEquals(2, card.getSuit());
    }

    @Test
    void hideCard() {
        BJCard card = new BJCard(1, 1); // Ace of Spades
        card.hideCard();
        assertTrue(card.isHidden());
    }

    @Test
    void showCard() {
        BJCard card = new BJCard(1, 1); // Ace of Spades
        card.hideCard();
        card.showCard();
        assertFalse(card.isHidden());
    }

    @Test
    void isHidden() {
        BJCard card = new BJCard(1, 1); // Ace of Spades
        assertFalse(card.isHidden());
        card.hideCard();
        assertTrue(card.isHidden());
    }

    @Test
    void getText() {
        BJCard aceOfSpades = new BJCard(1, 1);
        assertEquals("A\u2660", aceOfSpades.getText());

        BJCard kingOfHearts = new BJCard(14, 2);
        assertEquals("K\u2665", kingOfHearts.getText());

        BJCard tenOfDiamonds = new BJCard(10, 3);
        assertEquals("10\u2666", tenOfDiamonds.getText());
    }

    @Test
    void getFontColor() {
        BJCard heartCard = new BJCard(1, 2); // Ace of Hearts
        assertEquals(Color.RED, heartCard.getFontColor());

        BJCard spadeCard = new BJCard(1, 1); // Ace of Spades
        assertEquals(Color.BLACK, spadeCard.getFontColor());
    }
}
