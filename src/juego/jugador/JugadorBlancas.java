/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.jugador;

import java.util.Collection;

import juego.pieza.Color;
import juego.pieza.Pieza;
import juego.tablero.Movimiento;
import juego.tablero.Tablero;

/**
 *
 * @author edamazzio
 */
public class JugadorBlancas extends Jugador {

    public JugadorBlancas(final Tablero tablero, final Collection<Movimiento> movimientosPermitidosBlancas,
            final Collection<Movimiento> movimientosPermitidosNegras) {

        super(tablero, movimientosPermitidosBlancas, movimientosPermitidosNegras);

    }

    @Override
    public Collection<Pieza> getPiezasActivas() {
        return this.tablero.getPiezasBlancas();
    }

    @Override
    public Color getColor() {
        return Color.BLANCO;
    }

    @Override
    public Jugador getOponente() {
        return this.tablero.jugadorNegras();
    }

}
