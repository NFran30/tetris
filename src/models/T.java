package models;

import java.awt.*;

public class T extends Tetronimo
{
    public T()
    {
        super.r1.setLocation( 0, 0 );
        super.r2.setLocation( Tetronimo.SIZE,   0);
        super.r3.setLocation( Tetronimo.SIZE, -Tetronimo.SIZE);
        super.r4.setLocation( Tetronimo.SIZE * 2, 0 );

        super.add( r1 );
        super.add( r2 );
        super.add( r3 );
        super.add( r4 );
    }

    @Override
    public void rotate()
    {
        super.rotate();
        Point curLoc = super.getLocation();

        //Sent rotational point for T object
        super.setLocation( -Tetronimo.SIZE, -Tetronimo.SIZE);

        //Get next rectangle location -90 degree
        rotateTetronimo(curLoc);
    }
}

