package models;

import wheelsunh.users.Animator;
import wheelsunh.users.Rectangle;
import wheelsunh.users.ShapeGroup;

import java.awt.*;
import java.util.Random;

/**
 * Tetronimo.java:
 * An abstract class to model the base capaabilities of a tetronimo
 *
 * @author Nick Frangedakis
 * @version 1.0 Aug 2, 2020
 *
 * @see java.awt.Color
 */
public abstract class Tetronimo extends ShapeGroup
{
    /**
     * Constant to represent the size of the tetronimo
     */
    public static final int SIZE= 20;

    protected Rectangle r1;
    protected Rectangle r2;
    protected Rectangle r3;
    protected Rectangle r4;

    protected int curRotation = 1;
    private Color[] tetroimoColorPallet;
    private Color tetronimoColor;

    /**
     * Generates the four rectangles for the tetronino and puts them on the screen, they are at the default coordinates
     * to start
     */
    public Tetronimo()
    {
        super();

        //Color Pallet Scheme
        tetroimoColorPallet = new Color[] {new Color(3, 65, 174), new Color(114, 203, 59),
                new Color(255, 213, 0), new Color(255, 151, 28), new Color(255, 50, 19)};

        //Randomizes color scheme for next Tetronimo
        tetronimoColor = tetroimoColorPallet[new Random().nextInt(5)];

        this.r1 = new Rectangle();
        this.r1.setSize( Tetronimo.SIZE, Tetronimo.SIZE );
        this.r1.setFrameColor( Color.BLACK );
        this.r1.setColor(tetronimoColor);

        this.r2 = new Rectangle();
        this.r2.setSize( Tetronimo.SIZE, Tetronimo.SIZE );
        this.r2.setFrameColor( Color.BLACK );
        this.r2.setColor(tetronimoColor);

        this.r3 = new Rectangle();
        this.r3.setSize( Tetronimo.SIZE, Tetronimo.SIZE );
        this.r3.setFrameColor( Color.BLACK );
        this.r3.setColor(tetronimoColor);

        this.r4 = new Rectangle();
        this.r4.setSize( Tetronimo.SIZE, Tetronimo.SIZE );
        this.r4.setFrameColor( Color.BLACK );
        this.r4.setColor(tetronimoColor);
    }

    /**
     * Increments the rotation of the tetronimo, other classes need to override this to provide the full functionality
     */
    public void rotate()
    {
        this.curRotation++;
    }

    /**
     * Shifts the tetronimo left one row
     */
    public void shiftLeft()
    {
        super.setLocation( super.getXLocation() - Tetronimo.SIZE, super.getYLocation() );
    }

    /**
     * Shifts the tetronimo right one row
     */
    public void shiftRight()
    {
        super.setLocation( super.getXLocation() + Tetronimo.SIZE, super.getYLocation() );
    }

    private int[] ccwTetronimo90(int x, int y)
    {
        //Matrix to rotate the rectangle object clockwise 90 degrees
        int[][] rotateMatrix = new int[][] {{0, 1}, {-1, 0}};
        int[] nextLocation = new int[2];

        nextLocation[0] = (rotateMatrix[0][0] * x) + (rotateMatrix[0][1] * y);
        nextLocation[1] = (rotateMatrix[1][0] * x) + (rotateMatrix[1][1] * y);

        return nextLocation;
    }

    protected void rotateTetronimo(Point curLoc)
    {
        //Get next rectangle location -90 degree
        int[] nextPointR1 = ccwTetronimo90(r1.getXLocation(), r1.getYLocation());
        int[] nextPointR2 = ccwTetronimo90(r2.getXLocation(), r2.getYLocation());
        int[] nextPointR3 = ccwTetronimo90(r3.getXLocation(), r3.getYLocation());
        int[] nextPointR4 = ccwTetronimo90(r4.getXLocation(), r4.getYLocation());

        //Set new Rectangle points for
        r1.setLocation( nextPointR1[0], nextPointR1[1]);
        r2.setLocation( nextPointR2[0], nextPointR2[1]);
        r3.setLocation( nextPointR3[0], nextPointR3[1]);
        r4.setLocation( nextPointR4[0], nextPointR4[1]);

        super.setLocation( curLoc );
    }

    public int getRectangleXLocation (int rectNumber)
    {
        //Allows get location of one of the 4 rectangles
        switch (rectNumber)
        {
            case 1 :
                return r1.getXLocation();
            case 2:
                return r2.getXLocation();
            case 3:
                return r3.getXLocation();
            case 4:
                return r4.getXLocation();
            default:
                return -1;      //TODO: This should be some form of error
        }
    }

    public int getRectangleYLocation (int rectNumber)
    {
        //Allows get location of one of the 4 rectangles
        switch (rectNumber)
        {
            case 1 :
                return r1.getYLocation();
            case 2:
                return r2.getYLocation();
            case 3:
                return r3.getYLocation();
            case 4:
                return r4.getYLocation();
            default:
                return -1;      //TODO: This should be some form of error
        }
    }
}