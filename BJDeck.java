/**
 * File: BJDeck.java
 * Description: A short description of the project. This does not need to be long.
 * Instructor's Name: Jeff Light
 *
 * @author: alexisbinch
 * @since: 7/2/24
 */

package BlackJack;

import BlackJackBase.PCard;
import BlackJackBase.PDeck;

import java.util.ArrayList;
import java.util.Collections;

public class BJDeck implements PDeck {
    private ArrayList<BJCard> cards;

    public BJDeck() {
        cards = new ArrayList<>();
        int[] suits = {1, 2, 3, 4}; // SPADE, HEART, DIAMOND, CLUB
        int[] ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}; // ACE to KING

        for (int suit : suits) {
            for (int rank : ranks) {
                cards.add(new BJCard(rank, suit));
            }
        }
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public void addCard(PCard card) {
        if (card instanceof BJCard) {
            cards.add((BJCard) card);
        } else {
            throw new IllegalArgumentException("Invalid card type");
        }
    }

    @Override
    public BJCard dealCard() {
        if (!cards.isEmpty()) {
            return cards.remove(cards.size() - 1);
        } else {
            return null; // or handle the empty deck scenario
        }
    }

    @Override
    public BJCard dealHiddenCard() {
        if (!cards.isEmpty()) {
            BJCard card = cards.remove(cards.size() - 1);
            card.hideCard();
            return card;
        } else {
            return null; // or handle the empty deck scenario
        }
    }

    @Override
    public int cardCount() {
        return cards.size();
    }

    public int cardsRemaining() {
        return cards.size();
    }

}













