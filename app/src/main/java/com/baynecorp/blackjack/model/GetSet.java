package com.baynecorp.blackjack.model;

public class GetSet {
    public static CardDeck[] card;
    public static int hit =  3;
    public static int playerScore  = 0;
    public static int dealerScore = 0;
    public static int dealerHit = 1;
    public static int buttonPressed  = 1;
    public static boolean isStanding = false;
    public static int cash = 3000;
    public static int bet = 0;
    public static int horizontalMove = 0;
    public static int verticalMove = 400;
    public static int isDouble = 0; // should be boolean
    public static int doubleAmount = 0;
    public static int playerBust = 0; // should be boolean
    public static int playerBlackjack = 0;
    public static boolean isBlackJack = false;
    public static boolean isBust = false;
    public static int iswin = 0;
    public static int islose = 0;
}
