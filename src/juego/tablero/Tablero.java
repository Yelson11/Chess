package juego.tablero;

import juego.jugador.JugadorNegras;
import juego.jugador.Jugador;
import juego.jugador.JugadorBlancas;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import java.util.HashMap;

import juego.pieza.Alfil;
import juego.pieza.Color;
import juego.pieza.Rey;
import juego.pieza.Caballo;
import juego.pieza.Peon;
import juego.pieza.Pieza;
import juego.pieza.Reina;
import juego.pieza.Torre;

/**
 *
 * @author emers
 */
public class Tablero {
    private final List<Casilla> tableroJuego;
    protected final Collection<Pieza> piezasBlancas;
    protected final Collection<Pieza> piezasNegras;

    private final JugadorBlancas jugadorBlancas;
    private final JugadorNegras jugadorNegras;

    private final Jugador jugadorActual;

    private Tablero(Builder builder) {

        this.tableroJuego = crearTableroJuego(builder);
        this.piezasBlancas = calcularPiezasActivas(this.tableroJuego, Color.BLANCO);
        this.piezasNegras = calcularPiezasActivas(this.tableroJuego, Color.NEGRO);

        final Collection<Movimiento> movimientosPermitidosBlancas = calcularMovimientosPermitidos(this.piezasBlancas);
        final Collection<Movimiento> movimientosPermitidosNegras = calcularMovimientosPermitidos(this.piezasNegras);

        this.jugadorBlancas = new JugadorBlancas(this, movimientosPermitidosBlancas, movimientosPermitidosNegras);
        this.jugadorNegras = new JugadorNegras(this, movimientosPermitidosBlancas, movimientosPermitidosNegras);

        this.jugadorActual = null;

    }

    public Jugador jugadorActual(){
        return this.jugadorActual;
    }

    public Collection<Pieza> getPiezasNegras() {
        return this.piezasNegras;
    }

    public Collection<Pieza> getPiezasBlancas() {
        return this.piezasBlancas;
    }

    public Jugador jugadorBlancas() {
        return this.jugadorBlancas;
    }

    public Jugador jugadorNegras() {
        return this.jugadorNegras;
    }

    @Override
    public String toString() {
        final StringBuilder constructorString = new StringBuilder();
        for (int i = 0; i < tableroUtilitarios.NUM_CASILLAS; i++) {
            final String textoCasilla = this.tableroJuego.get(i).toString();
            constructorString.append(String.format("%3s", textoCasilla));
            if ((i + 1) % tableroUtilitarios.NUM_CASILLAS_POR_FILA == 0) {
                constructorString.append("\n");
            }
        }
        return constructorString.toString();
    }

    private Collection<Movimiento> calcularMovimientosPermitidos(final Collection<Pieza> piezas) {

        final List<Movimiento> movimientosPermitidos = new ArrayList<>();

        for (final Pieza pieza : piezas) {
            movimientosPermitidos.addAll(pieza.calculaMovimientosLegales(this));
        }

        return ImmutableList.copyOf(movimientosPermitidos);
    }

    private static Collection<Pieza> calcularPiezasActivas(final List<Casilla> tableroJuego, final Color color) {
        final List<Pieza> piezasActivas = new ArrayList<>();

        for (final Casilla casilla : tableroJuego) {
            if (casilla.casillaEstaOcupada()) {
                final Pieza pieza = casilla.getPieza();
                if (pieza.getPiezaColor() == color) {
                    piezasActivas.add(pieza);
                }
            }
        }
        return ImmutableList.copyOf(piezasActivas);
    }

    public Casilla getCasilla(final int coordenadaCasilla) {
        return tableroJuego.get(coordenadaCasilla);
    }

    private static List<Casilla> crearTableroJuego(final Builder builder) {
        final Casilla[] casillas = new Casilla[tableroUtilitarios.NUM_CASILLAS];
        for (int i = 0; i < tableroUtilitarios.NUM_CASILLAS; i++) {
            casillas[i] = Casilla.crearCasilla(i, builder.configuracionTablero.get(i));
        }
        return ImmutableList.copyOf(casillas);
    }

    public static Tablero crearTableroEstandar() {
        final Builder builder = new Builder();
        // Black Layout
        builder.setPieza(new Torre(Color.NEGRO, 0));
        builder.setPieza(new Caballo(Color.NEGRO, 1));
        builder.setPieza(new Alfil(Color.NEGRO, 2));
        builder.setPieza(new Reina(Color.NEGRO, 3));
        builder.setPieza(new Rey(Color.NEGRO, 4));
        builder.setPieza(new Alfil(Color.NEGRO, 5));
        builder.setPieza(new Caballo(Color.NEGRO, 6));
        builder.setPieza(new Torre(Color.NEGRO, 7));
        builder.setPieza(new Peon(Color.NEGRO, 8));
        builder.setPieza(new Peon(Color.NEGRO, 9));
        builder.setPieza(new Peon(Color.NEGRO, 10));
        builder.setPieza(new Peon(Color.NEGRO, 11));
        builder.setPieza(new Peon(Color.NEGRO, 12));
        builder.setPieza(new Peon(Color.NEGRO, 13));
        builder.setPieza(new Peon(Color.NEGRO, 14));
        builder.setPieza(new Peon(Color.NEGRO, 15));
        // White Layout
        builder.setPieza(new Peon(Color.BLANCO, 48));
        builder.setPieza(new Peon(Color.BLANCO, 49));
        builder.setPieza(new Peon(Color.BLANCO, 50));
        builder.setPieza(new Peon(Color.BLANCO, 51));
        builder.setPieza(new Peon(Color.BLANCO, 52));
        builder.setPieza(new Peon(Color.BLANCO, 53));
        builder.setPieza(new Peon(Color.BLANCO, 54));
        builder.setPieza(new Peon(Color.BLANCO, 55));
        builder.setPieza(new Torre(Color.BLANCO, 56));
        builder.setPieza(new Caballo(Color.BLANCO, 57));
        builder.setPieza(new Alfil(Color.BLANCO, 58));
        builder.setPieza(new Reina(Color.BLANCO, 59));
        builder.setPieza(new Rey(Color.BLANCO, 60));
        builder.setPieza(new Alfil(Color.BLANCO, 61));
        builder.setPieza(new Caballo(Color.BLANCO, 62));
        builder.setPieza(new Torre(Color.BLANCO, 63));
        // white to move
        builder.setMoveMaker(Color.BLANCO);
        // build the board
        return builder.build();
    }

    public static class Builder {

        Map<Integer, Pieza> configuracionTablero;
        Color nextMoveMaker;

        public Builder() {
            this.configuracionTablero = new HashMap<Integer, Pieza>();
        }

        public Builder setPieza(final Pieza pieza) {
            this.configuracionTablero.put(pieza.getPosicionPieza(), pieza);
            return this;
        }

        public Builder setMoveMaker(final Color nextMoveMaker) {
            this.nextMoveMaker = nextMoveMaker;
            return this;
        }

        public Tablero build() {
            return new Tablero(this);
        }

    }

}
