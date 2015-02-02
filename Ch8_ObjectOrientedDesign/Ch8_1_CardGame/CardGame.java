package com.CrackingTheCodingInterview.Ch8_ObjectOrientedDesign.Ch8_1_CardGame;

import java.util.ArrayList;
import java.util.Random;

// 8.1 - Implement the data structures for a generic deck of cards
class CardGame
{
    public static void main(String[] input)
    {
        CardGame cg = new CardGame();
        cg.createCardGame("Blackjack");
    }

    public CardGame createCardGame(String type)
    {
        Deck d = new Deck();

        return new CardGame();
    }

    class Deck
    {
        // Main storage system of cards will be this ArrayList.
        ArrayList<Card> deck = new ArrayList<Card>();

        int dealt_index = 0;

        public Deck()
        {
            Integer[] values = {1,2,3,4,5,6,7,8,9,10,11,12,13};
            String[] suits = {"Clubs","Hearts","Diamonds","Spades"};

            for (String s : suits)
            {
                for (Integer v: values)
                {
                    Card c = new Card(s,v);
                    this.deck.add(c);
                }
            }

            shuffle();
        }

        // Shuffle the deck. Use the Fisher-Yates algorithm, meaning randomly exchange each element with one of the untouched elements.
        // Each element receives an equal chance of being shuffled into any position.
        public void shuffle()
        {
            Random rand = new Random();
            // Shuffling mechanism is Fisher-Yates, or randomly exchange each element one time.
            for (int i = 0; i < 52; i++) // Runs in O(n) time.
            {
                // Generate random integer between i and 51;
                // rand.nextInt excludes the top value (51), so add 1 to make it inclusive of 51.
                int random_new_position = rand.nextInt(51 - i + 1) + i;
                exch(i, random_new_position);
            }
        }

        public void exch(int old_position, int new_position)
        {
            Card temp = this.deck.get(old_position);
            this.deck.set(old_position, this.deck.get(new_position));
            this.deck.set(new_position, temp);
        }

        public Card[] deal_hand(int number)
        {
            Card[] hand = (Card[]) new Card[number];
            int count = 0;
            while (count < number) {
                Card card = deal_card();
                if (card != null) {
                    hand[count] = card;
                    count++;
                }
            }

            return hand;
        }

        public Card deal_card()
        {
            // Check if no more cards from the deck are available
            if (this.deck.size() - this.dealt_index == 0) {
                return null;
            }

            Card card = deck.get(dealt_index);
            dealt_index++;

            return card;
        }
    }

    class Card
    {
        String suit;
        Integer value;

        public Card(String suit, Integer value)
        {
            this.suit = suit;
            this.value = value;
        }
    }

    class Hand
    {
        ArrayList<Card> hand = new ArrayList<Card>();

        public void add_card(Card input)
        {
            this.hand.add(input);
        }
    }
}
