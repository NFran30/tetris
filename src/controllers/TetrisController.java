package controllers;

import models.Square;
import models.StraightLine;
import models.Tetronimo;
import models.L;
import models.T;
import views.TetrisBoard;

import java.util.Random;

//TODO: all of the necessary logic for the game, scoring, how many points to assign to player, gameover, alike

/**
 * TetrisController.java:
 * Class to hold all the game logic for tetris
 *
 * @author Nick Frangedakis
 * @version 1.0 Aug 2, 2020
 */
public class TetrisController
{
    private final TetrisBoard TETRIS_BOARD;
    private int scoreKeeper = 0;

    private int currentLevel = 1;

    /**
     * Constructor to take in a tetris board so the controller and the board can communicate
     *
     * @param tetrisBoard A tetris board instance
     */
    public TetrisController( TetrisBoard tetrisBoard )
    {
        this.TETRIS_BOARD = tetrisBoard;
    }

    /**
     * Randomly chooses the next tetronimo and returns it (INCOMPLETE)
     *
     * @return The next tetronimo to be played
     */
    public Tetronimo getNextTetromino()
    {
        Tetronimo tetronimo;
        Random random = new Random();

        //Randomly generates one of the 4 Tetrominos
        /*
        switch (random.nextInt(4))
        {
            case 0 :
                tetronimo = new StraightLine();
                break;
            case 1 :
                tetronimo = new Square();
                break;
            case 2 :
                tetronimo = new L();
                break;
            default:
                tetronimo = new StraightLine();         //TODO: Need to remove this and make an exception
        }*/

        tetronimo = new T();

        tetronimo.setLocation( 40 + (5 * Tetronimo.SIZE), 0 );

        return tetronimo;
    }

    /**
     * Method to determine if the tetronimo has landed (INCOMPLETE)
     *
     * @param tetronimo The tetronimo to evaluate
     * @return True if the tetronimo has landed (on the bottom of the board or another tetronimo), false if it has not
     */
    public boolean tetronimoLanded( Tetronimo tetronimo )
    {
        int nextY = tetronimo.getYLocation() + tetronimo.getHeight() + Tetronimo.SIZE;

        //TODO: Call method to check the score
        return nextY <= 480;
    }

    public int checkAwardedPoints(int linesCleared)
    {
        //Key for scoring depending on how many lines are cleared
        int[] pointsPerLineArray = new int[] {100, 300, 500, 800};

        //TODO: Need to add method to check how many liens will clear also check level due to tier for points

        return scoreKeeper + (pointsPerLineArray[linesCleared - 1] * this.currentLevel);
    }
}
