package controllers;

import models.Square;
import models.StraightLine;
import models.Tetronimo;
import models.L;
import views.TetrisBoard;

import java.awt.*;
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

    private int[][] tetronimoPositionBoard;

    /**
     * Constructor to take in a tetris board so the controller and the board can communicate
     *
     * @param tetrisBoard A tetris board instance
     */
    public TetrisController( TetrisBoard tetrisBoard )
    {
        this.TETRIS_BOARD = tetrisBoard;
        initializePositionKeeper();

    }

    /**
     * Fills the Tetronimo board position keeper with 0's (Open spaces)
     */
    private void initializePositionKeeper()
    {
        //Initialize the array that track the location of the landed tetronimos
        tetronimoPositionBoard = new int[TETRIS_BOARD.HEIGHT][TETRIS_BOARD.WIDTH];

        for(int x = 0; x < TETRIS_BOARD.HEIGHT; x++)
            for(int y = 0; y < TETRIS_BOARD.WIDTH; y++)
                tetronimoPositionBoard[x][y] = 0;
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
        }

        tetronimo = new StraightLine();

        tetronimo.setLocation( 40 + (5 * Tetronimo.SIZE), 0 );

        return tetronimo;
    }

    /**
     * Method to determine if the tetronimo has landed (INCOMPLETE)
     *
     * @param tetronimo The tetronimo to evaluate
     * @return True if the tetronimo has landed (on the bottom of the board or another tetronimo), false if it has not
     */
    public boolean tetronimoLanded(Tetronimo tetronimo)
    {
        return checkLocationPostMove(tetronimo);
    }

    private boolean checkLocationPostMove(Tetronimo tetronimo)
    {
        boolean returnStatus = true;
        int collisionPoint = 480;
        int col, row;
        int closestCollision;
        Point[] currPoints = new Point[4];

        //Check Tetrominio orientation
        for (int i = 1; i < 5; i++)
        {
            col = (tetronimo.getRectangleXLocation(i) / Tetronimo.SIZE - 1);
            row = (tetronimo.getRectangleYLocation(i) / Tetronimo.SIZE);

            //Placeholder for coordinates of each
            currPoints[i-1] = new Point();
            currPoints[i-1].setLocation(row, col);

            //Set Tetronimo's current position
            tetronimoPositionBoard[row][col] = 1;

            //Set comparable value column closest to collision
            closestCollision = Integer.MAX_VALUE;
            for (int x = row; x < TetrisBoard.HEIGHT; x++)
            {
                if (tetronimoPositionBoard[x][col] == 1)
                    if (closestCollision > Math.abs(x - row))
                    {
                        closestCollision = Math.abs(x - row);

                        //Check to see if Tetronimo's next move would be collision
                        if (closestCollision == 1)
                            returnStatus = false;
                    }
            }
        }

        //When Tetronimo hasn't landed erase previous position on Position Board
        if (returnStatus)
            for (int i = 0; i < currPoints.length; i++)
                tetronimoPositionBoard[currPoints[i].x][currPoints[i].y] = 0;

        //Return the distance to the closest collision
        return returnStatus;
    }

    public int checkAwardedPoints(int linesCleared)
    {
        //Key for scoring depending on how many lines are cleared
        int[] pointsPerLineArray = new int[] {100, 300, 500, 800};

        //TODO: Need to add method to check how many liens will clear also check level due to tier for points

        return scoreKeeper + (pointsPerLineArray[linesCleared - 1] * this.currentLevel);
    }
}
