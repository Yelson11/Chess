/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego.jugador;

import java.util.Collection;

import juego.pieza.ColorPieza;
import juego.pieza.Pieza;
import juego.tablero.Movimiento;
import juego.tablero.Tablero;

/**
 *
 * @author edamazzio
 */
public class JugadorNegras extends Jugador {

    public JugadorNegras(final Tablero tablero, final Collection<Movimiento> movimientosPermitidosBlancas,
            final Collection<Movimiento> movimientosPermitidosNegras) {
        super(tablero, movimientosPermitidosNegras, movimientosPermitidosBlancas);
    }

    @Override
    public Collection<Pieza> getPiezasActivas() {
        return this.tablero.getPiezasNegras();
    }

    @Override
    public ColorPieza getColor() {
        return ColorPieza.NEGRO;
    }

    @Override
    public Jugador getOponente() {
        return this.tablero.jugadorBlancas();
    }

}
