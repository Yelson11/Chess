package juego.pieza;

import java.util.Collection;
import java.util.List;
import juego.tablero.Movimiento;
import juego.tablero.Tablero;




/**
 *
 * @author emers
 */
public abstract class Pieza 
{
    
    protected final int posicionPieza;
    protected final Alliance piezaAlliance;
    protected final boolean ifFirstMove;
    
    Pieza(final int posicionPieza, final Alliance piezaAlliance)
    {
        this.posicionPieza = posicionPieza;
        this.piezaAlliance = piezaAlliance;
        this.ifFirstMove = false;
    }
    
    public int getPiezaPosicion()
    {
        return this.posicionPieza;
    }
    
    public Alliance getPiezaAlliance()
    {
        return this.piezaAlliance;
    }
    
    public boolean isFirstMove(){
        return this.ifFirstMove;
    }
    
    public abstract Collection<Movimiento> calculaMovimientosLegales(final Tablero tablero);
    
    
    
}
