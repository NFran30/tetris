package models;

import java.awt.*;

public class Square extends Tetronimo
{
    public Square()
    {
        super.r1.setLocation( 0, 0 );
        super.r2.setLocation( 0 , Tetronimo.SIZE );
        super.r3.setLocation( Tetronimo.SIZE , 0 );
        super.r4.setLocation( Tetronimo.SIZE, Tetronimo.SIZE);

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

        //not in use
    }
}
