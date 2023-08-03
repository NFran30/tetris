package models;

import java.awt.*;

public class L extends Tetronimo
{
    public L()
    {
        //Initializes proper orientation for L Tetronimo
        super.r1.setLocation( 0, 0 );
        super.r2.setLocation( Tetronimo.SIZE,0  );
        super.r3.setLocation( Tetronimo.SIZE * 2 , 0 );
        super.r4.setLocation( Tetronimo.SIZE * 2, -Tetronimo.SIZE );

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

        //Sent rotational point for L object
        super.setLocation( -(Tetronimo.SIZE * 2), -Tetronimo.SIZE );

        //Get next rectangle location -90 degree
        rotateTetronimo(curLoc);
    }
}
