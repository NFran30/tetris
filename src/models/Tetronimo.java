package models;

import wheelsunh.users.Animator;
import wheelsunh.users.Rectangle;
import wheelsunh.users.ShapeGroup;

import java.awt.Color;
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
}