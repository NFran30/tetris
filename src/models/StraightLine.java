package models;

import java.awt.Point;

/**
 * StraightLine.java:
 * Creates a straight line tetronimo
 *
 * @author Nick Frangedakis
 * @version 1.0 Aug 2, 2020
 *
 * @see java.awt.Point
 */
public class StraightLine extends Tetronimo
{
    /**
     * Creates the tetronimo and puts it in the vertical orientation
     */
    public StraightLine()
    {
        super.r1.setLocation( 0, 0 );
        super.r2.setLocation( Tetronimo.SIZE,0  );
        super.r3.setLocation( Tetronimo.SIZE * 2, 0 );
        super.r4.setLocation( Tetronimo.SIZE * 3, 0 );

        super.add( r1 );
        super.add( r2 );
        super.add( r3 );
        super.add( r4 );
    }

    /**
     * Rotates the tetronimo
     */
    @Override
    public void rotate()
    {
        super.rotate();
        Point curLoc = super.getLocation();

        //Sent rotational point for StraitLine object
        super.setLocation( -Tetronimo.SIZE, 0);

        //Get next rectangle location -90 degree
        rotateTetronimo(curLoc);
    }

    /**
     * Gets the height of the tetronimo based on the orientation
     *
     * @return The height of the tetronimo
     */
    @Override
    public int getHeight()
    {
        if( this.curRotation % 4 == 0 )
        {
            return Tetronimo.SIZE * 2;
        }
        else if (this.curRotation % 4 == 1 || this.curRotation % 4 == 3)
        {
            return Tetronimo.SIZE;
        }
        else if (this.curRotation % 4 == 2)
        {
            return Tetronimo.SIZE * 3;
        }
        else
            return -1;  //TODO: NEED A WAY TO HANDLE THIS, THREW A NEGATIVE NUMBER BUT SHOULD NEVER HAPPEN
    }

    /**
     * Gets the width of the tetronimo based on the orientation
     *
     * @return The width of the tetronimo
     */
    @Override
    public int getWidth()
    {
        if( this.curRotation % 4 == 1 )
        {
            return Tetronimo.SIZE * 3;
        }
        else if (this.curRotation % 4 == 2)
        {
            return Tetronimo.SIZE;
        }
        else if (this.curRotation % 4 == 3)
        {
            return Tetronimo.SIZE * 2;
        }
        else
        {
            return Tetronimo.SIZE;
        }

       /* if( this.curRotation % 2 == 0 )
        {
            return Tetronimo.SIZE * 4;
        }
        else
        {
            return Tetronimo.SIZE;
        }*/
    }
}
