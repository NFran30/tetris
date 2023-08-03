package models;

import java.awt.*;

public class L extends Tetronimo
{
    public L()
    {
        super.r1.setLocation( 0, 0 );
        super.r2.setLocation( 0, Tetronimo.SIZE );
        super.r3.setLocation( 0, Tetronimo.SIZE * 2 );
        super.r4.setLocation( Tetronimo.SIZE, Tetronimo.SIZE * 2 );

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
        super.setLocation( 0, 0 );

        if( super.curRotation % 2 == 0 )
        {
            super.r1.setLocation( 0, 0 );
            super.r2.setLocation( Tetronimo.SIZE, 0 );
            super.r3.setLocation( Tetronimo.SIZE * 2, 0 );
            super.r4.setLocation( Tetronimo.SIZE * 3, 0 );
        }
        else
        {
            super.r1.setLocation( 0, 0 );
            super.r2.setLocation( 0, Tetronimo.SIZE );
            super.r3.setLocation( 0, Tetronimo.SIZE * 2 );
            super.r4.setLocation( 0, Tetronimo.SIZE * 3 );
        }

        super.setLocation( curLoc );
    }
}
