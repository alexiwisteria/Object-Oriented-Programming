/**
 * File: PlayBlackJack.java
 * Description: The Main file of BlackJackGame.
 * Instructor's Name: Jeff Light
 *
 * @author: alexisbinch
 * @since: 7/2/24
 */

package BlackJackTest;

import BlackJack.BJDeck;
import BlackJack.BJHand;
import BlackJackBase.PGame;

import java.awt.Color;
import java.awt.EventQueue;

public class PlayBlackJack {
    public static void main(String[] args) {

/* BJCard aceSpade = new BJCard(1, 1);
BJCard sixHeart = new BJCard(6, 2);
BJCard jackSpade = new BJCard(11, 1);
BJCard knightHeart = new BJCard(12, 2);
BJCard queenDiamond = new BJCard(13, 3);
BJCard kingClub = new BJCard(14, 4);

CardTest.run(aceSpade);
CardTest.run(sixHeart);
CardTest.run(jackSpade);
CardTest.run(knightHeart);
CardTest.run(queenDiamond);
CardTest.run(kingClub);

BJDeck deck = new BJDeck();
DeckTest.run(deck);

// Create necessary objects
        BJDeck deck = new BJDeck();
        BJHand hand = new BJHand();

// Shuffle the deck and deal some cards to the hand for testing
        deck.shuffle();
        hand.addCard(deck.dealCard());
        hand.addCard(deck.dealCard());

// Call the run method from HandTest
        HandTest.run(deck, hand);*/

        BJDeck deck = new BJDeck();
        BJHand dealer = new BJHand();
        BJHand player = new BJHand();

        PGame.setBackgroundColor(Color.DARK_GRAY);
        PGame.setBannerColor(Color.BLACK);
        PGame.setBannerTextColor(Color.YELLOW);
        PGame.setStatusTextColor(Color.RED);
        PGame.setButtonColor(Color.GRAY);
        PGame.setButtonHighlightColor(Color.MAGENTA);
        PGame.setButtonTextColor(Color.BLACK);
        PGame.setFont("Arial");

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                PGame.run(deck, dealer, player);
            }
        });
    }
}