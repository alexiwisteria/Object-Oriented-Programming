/**
 * File: BJHand.java
 * Description: Implementation of a BlackJack hand.
 * Instructor's Name: Jeff Light
 *
 * @author: alexisbinch
 * @since: 7/2/24
 */

package BlackJack;

import BlackJackBase.PCard;
import BlackJackBase.PHand;

import java.util.ArrayList;
import java.util.List;

public class BJHand implements PHand {
    private final List<BJCard> cards;

    public BJHand() {
        this.cards = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return cards.size();
    }

    @Override
    public void addCard(PCard card) {
        if (card instanceof BJCard) {
            cards.add((BJCard) card);
        } else {
            throw new IllegalArgumentException("Only BJCard instances are allowed");
        }
    }

    @Override
    public PCard getCard(int index) {
        if (index >= 0 && index < cards.size()) {
            return cards.get(index);
        }
        return null; // or throw an exception
    }

    @Override
    public PCard removeCard(int index) {
        if (index >= 0 && index < cards.size()) {
            return cards.remove(index);
        }
        return null; // or throw an exception
    }

    @Override
    public int getValue() {
        int value = 0;
        int aceCount = 0;

        for (BJCard card : cards) {
            int cardValue = card.getRank();
            if (cardValue == 1) { // Ace
                aceCount++;
                value += 11;
            } else if (cardValue >= 10) {
                value += 10;
            } else {
                value += cardValue;
            }
        }

        // Adjust for Aces if value is greater than 21
        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        }

        return value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PCard card : cards) {
            sb.append(card.getText()).append("\n");
        }
        return sb.toString();
    }
}
