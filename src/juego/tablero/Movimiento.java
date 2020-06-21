package juego.tablero;

import juego.pieza.Pieza;

/**
 *
 * @author emers
 */
public abstract class Movimiento 
{
    final Tablero tablero;
    final Pieza pieza;
    final int destinoCoordenada;
    
    private Movimiento(final Tablero tablero, final Pieza piezaMover, final int destinoCoordenada)
    {
        this.tablero = tablero;
        this.pieza = piezaMover;
        this.destinoCoordenada = destinoCoordenada;
    }
    
    public static final class MajorMove extends Movimiento
    {
        
        public MajorMove(final Tablero tablero, final Pieza piezaMover, final int destinoCoordenada) {
            super(tablero, piezaMover, destinoCoordenada);
        }
        
    }
    
    public static final class AttackMove extends Movimiento
    {
        
        final Pieza piezaAtaque;
        
        public AttackMove(final Tablero tablero, final Pieza piezaMover, final int destinoCoordenada, final Pieza piezaAtaque) {
            super(tablero, piezaMover, destinoCoordenada);
            this.piezaAtaque = piezaAtaque;
        }
        
    }
    
}
