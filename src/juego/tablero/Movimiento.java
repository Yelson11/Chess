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
    final int coordenadaDestino;
    
    private Movimiento(final Tablero tablero, final Pieza piezaMover, final int coordenadaDestino)
    {
        this.tablero = tablero;
        this.pieza = piezaMover;
        this.coordenadaDestino = coordenadaDestino;
    }

    public abstract Tablero ejecutar();
    
    public static final class MovimientoImportante extends Movimiento
    {
        
        public MovimientoImportante(final Tablero tablero, final Pieza piezaMover, final int destinoCoordenada) {
            super(tablero, piezaMover, destinoCoordenada);
        }

        @Override
        public Tablero ejecutar() {
            // TODO Auto-generated method stub
            return null;
        }
        
    }
    
    public static final class MovimientoAtaque extends Movimiento
    {
        
        final Pieza piezaAtaque;
        
        public MovimientoAtaque(final Tablero tablero, final Pieza piezaMover, final int destinoCoordenada, final Pieza piezaAtaque) {
            super(tablero, piezaMover, destinoCoordenada);
            this.piezaAtaque = piezaAtaque;
        }

        @Override
        public Tablero ejecutar() {
            // TODO Auto-generated method stub
            return null;
        }
        
    }

	public int getCoordenadaDestino() {
        
        return this.coordenadaDestino;

	}

    
}
