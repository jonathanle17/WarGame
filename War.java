import java.util.List;
import java.util.ArrayList;
import java.util.*;
/**
 * War game class
 *
 * @author Mr. Jaffe
 * @version 2022-10-19
 */
public class War
{
    Deck[] player;

    public War() {
        Deck deck = new Deck();
        deck.initializeNewDeck();
        deck.shuffle();
        player = deck.dealDeck();

        this.runEventLoop();
    }     

    public void runEventLoop() 
    {
        for (int turn=0; turn<=300; turn++) 
        {
            if (player[0].getDeckSize() == 0) 
            {
                System.out.println("Player 1 has no more cards. Therefore, Player 2 is the winner.");
                break;
            }
            else if (player[1].getDeckSize() == 0) 
            {
                System.out.println("Player 2 has no more cards. Therefore, Player 1 is the winner.");
                break;
            }
            else {
                Card player1 = player[0].dealCardFromDeck();
                Card player2 = player[1].dealCardFromDeck();
                System.out.println("Player 1: " + player1.getFace() + " of " + player1.getSuit());
                System.out.println("Player 2: " + player2.getFace() + " of " + player2.getSuit());

                if (player1.getRank() > player2.getRank()) 
                {
                    player[0].addCardToDeck(player1);
                    player[0].addCardToDeck(player2);
                    System.out.println("Player 1 wins round " + turn);
                    System.out.println("Player 1 has " + player[0].getDeckSize() + " cards");
                    System.out.println("Player 2 has " + player[1].getDeckSize() + " cards");
                    System.out.println();
                }
                else if (player2.getRank() > player1.getRank()) 
                {
                    player[1].addCardToDeck(player1);
                    player[1].addCardToDeck(player2);
                    System.out.println("Player 2 wins round " + turn);
                    System.out.println("Player 1 has " + player[0].getDeckSize() + " cards");
                    System.out.println("Player 2 has " + player[1].getDeckSize() + " cards");
                    System.out.println();
                }
                else 
                {
                    Deck wardeck = new Deck();
                    int wdecklength = wardeck.getDeckSize();
                    wardeck.addCardToDeck(player1);
                    wardeck.addCardToDeck(player2);
                    System.out.println("Battle was a tie. Commence war.");

                    if (player[0].getDeckSize() < 4) 
                    {
                        System.out.println("Player 1 is unable to compete in war. Therefore, Player 2 wins.");
                        break;
                    }
                    else if (player[1].getDeckSize() < 4) 
                    {
                        System.out.println("Player 2 is unable to compete in war. Therefore, Player 1 wins.");
                        break;
                    }
                    else 
                    {
                        for (int x=0; x<4; x++) 
                        {
                            player1 = player[0].dealCardFromDeck();
                            player2 = player[1].dealCardFromDeck();
                            wardeck.addCardToDeck(player1);
                            wardeck.addCardToDeck(player2);
                        }
                        player1 = player[0].dealCardFromDeck();
                        player2 = player[1].dealCardFromDeck();
                        System.out.println("Player 1: " + player1.getFace() + " of " + player1.getSuit());
                        System.out.println("Player 2: " + player2.getFace() + " of " + player2.getSuit());

                        if (player1.getRank() > player2.getRank()) 
                        {
                            player[0].addCardToDeck(player1);
                            player[0].addCardToDeck(player2);
                            Card pot;
                            for (int p1warwin=0; p1warwin<wdecklength; p1warwin++) 
                            {
                                pot = wardeck.dealCardFromDeck();
                                player[0].addCardToDeck(pot);
                            }
                            System.out.println("Player 1 wins the war and round " + turn);
                            System.out.println("Player 1 has " + player[0].getDeckSize() + " cards");
                            System.out.println("Player 2 has " + player[1].getDeckSize() + " cards");
                            System.out.println();
                        }
                        else if (player2.getRank() > player1.getRank()) 
                        {
                            player[1].addCardToDeck(player1);
                            player[1].addCardToDeck(player2);
                            Card pot;
                            for (int p2warwin=0; p2warwin<wdecklength; p2warwin++) 
                            {
                                pot = wardeck.dealCardFromDeck();
                                player[1].addCardToDeck(pot);
                            }
                            System.out.println("Player 2 wins the war and round " + turn);
                            System.out.println("Player 1 has " + player[0].getDeckSize() + " cards");
                            System.out.println("Player 2 has " + player[1].getDeckSize() + " cards");
                            System.out.println();
                        }
                        if (player[0].getDeckSize() == 0) 
                        {
                            System.out.println("Player 1 has no more cards. Therefore, Player 2 wins.");
                            break;
                        }
                        else if (player[1].getDeckSize() == 0) 
                        {
                            System.out.println("Player 2 has no more cards. Therefore, Player 1 wins.");
                            break;
                        }
                    }    
                } 
            }
            if (turn >= 300) 
            {
                if (player[0].getDeckSize() > player[1].getDeckSize()) 
                {
                    System.out.println("After 300 rounds, Player 1 has more cards. Therefore, Player 1 is the winner.");
                    break;
                }
                else 
                {
                    System.out.println("After 300 rounds, Player 2 has more cards. Therefore, Player 2 is the winner.");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) 
    {
        System.out.print("\u000C");
        War war = new War();
    }

}
