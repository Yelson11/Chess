package juego.tablero;

import juego.pieza.Pieza;
import juego.tablero.Tablero.ConstructorTablero;

/**
 *
 * @author emers
 */
public abstract class Movimiento 
{
    final Tablero tablero;
    final Pieza piezaMovida;
    final int coordenadaDestino;
    
    private Movimiento(final Tablero tablero, final Pieza piezaMovida, final int coordenadaDestino)
    {
        this.tablero = tablero;
        this.piezaMovida = piezaMovida;
        this.coordenadaDestino = coordenadaDestino;
    }

    public abstract Tablero ejecutar();
    
    public static final class MovimientoMayor extends Movimiento
    {
        
        public MovimientoMayor(final Tablero tablero, final Pieza piezaMover, final int destinoCoordenada) {
            super(tablero, piezaMover, destinoCoordenada);
        }

        @Override
        public Tablero ejecutar() {
            
            final Tablero.ConstructorTablero constructorTablero = new ConstructorTablero();

            for (final Pieza pieza : this.tablero.jugadorActual().getPiezasActivas()){
                //TODO hashcode and equals for pieces
                if (!this.piezaMovida.equals(pieza)){
                    constructorTablero.setPieza(pieza);
                }
            }

            for (final Pieza pieza : this.tablero.jugadorActual().getOponente().getPiezasActivas()){
                constructorTablero.setPieza(pieza);
            }

            //mueve la pieza movida
            constructorTablero.setPieza(null);
            constructorTablero.setMoveMaker(this.tablero.jugadorActual().getOponente().getColor());
            return constructorTablero.construirTablero();

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
