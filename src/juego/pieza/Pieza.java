package juego.pieza;

import java.util.Collection;
import juego.tablero.Movimiento;
import juego.tablero.Tablero;

/**
 *
 * @author emers
 */
public abstract class Pieza {
    final TipoPieza tipoPieza;
    protected final ColorPieza piezaColor;
    protected final int posicionPieza;
    protected final boolean ifFirstMove;

    Pieza(final TipoPieza tipoPieza, final ColorPieza piezaColor, final int posicionPieza,
            final boolean esPrimerMovimiento) {
        this.posicionPieza = posicionPieza;
        this.piezaColor = piezaColor;
        this.ifFirstMove = isFirstMove();
        this.tipoPieza = tipoPieza;
    }

    public int getPosicionPieza() {
        return this.posicionPieza;
    }

    public ColorPieza getPiezaColor() {
        return this.piezaColor;
    } 

    public TipoPieza getTipoPieza() {
        return this.tipoPieza;
    }

    public boolean isFirstMove() {
        return this.ifFirstMove;
    }

    public abstract Collection<Movimiento> calculaMovimientosLegales(final Tablero tablero);

    public enum TipoPieza {

        ALFIL("♗", "♝"), REY("♔", "♚"), CABALLO("♘", "♞"), REINA("♕", "♛"), TORRE("♖", "♖"), PEON("♙", "☗");

        private String piezaBlanca;
        private String piezaNegra;

        public String toString(ColorPieza color) {
            return color == ColorPieza.BLANCO ? piezaBlanca : piezaNegra;
        }

        TipoPieza(final String piezaBlanca, final String piezaNegra) {
            this.piezaBlanca = piezaBlanca;
            this.piezaNegra = piezaNegra;
        }

        
    }

}
