package juego.pieza;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import juego.tablero.Movimiento;
import juego.tablero.Movimiento.MajorMove;
import juego.tablero.Tablero;
import juego.tablero.tableroUtilitarios;

/**
 *
 * @author emers
 */
public class Peon extends Pieza
{
    
    private final static int[] CANDIDATOS_MOVIMIENTOS_VECTOR = {8, 16, 7, 9};

    public Peon(final Alliance piezaAlliance, final int posicionPieza) {
        super(posicionPieza, piezaAlliance);
    }

    @Override
    public Collection<Movimiento> calculaMovimientosLegales(final Tablero tablero) {
        
        final List<Movimiento> movimientosLegales = new ArrayList<>();
        
        for(final int candidatoActual : CANDIDATOS_MOVIMIENTOS_VECTOR)
        {
            final int candidateDestinationCoordinate = this.posicionPieza + (this.getPiezaAlliance().getDireccion()* candidatoActual);
            
            if(!tableroUtilitarios.espacioEsValido(candidateDestinationCoordinate))
            {
                continue;
            }
            
            if(candidatoActual ==8 && tablero.getEspacio(candidateDestinationCoordinate).espacioOcupado())
            {
                movimientosLegales.add(new MajorMove(tablero, this, candidateDestinationCoordinate));
            }else if(candidatoActual == 16 && this.isFirstMove() && 
                    (tableroUtilitarios.SECOND_ROW[this.posicionPieza]) && this.getPiezaAlliance().esNegra() || 
                    (tableroUtilitarios.SEVENTH_ROW[this.posicionPieza]) && this.getPiezaAlliance().esBlanca())
            {
                final int behindCandidateDestination = this.posicionPieza + (this.piezaAlliance.getDireccion() * 8);
                if(!tablero.getEspacio(behindCandidateDestination).espacioOcupado() && !tablero.getEspacio(candidateDestinationCoordinate).espacioOcupado())
                {
                    movimientosLegales.add(new MajorMove(tablero, this, candidateDestinationCoordinate));
                }
            }else if(candidatoActual == 7 && !(tableroUtilitarios.EIGHTH_COLUMNA[this.posicionPieza] && this.piezaAlliance.esBlanca() ||
                    tableroUtilitarios.PRIMERA_COLUMNA[this.posicionPieza] && this.piezaAlliance.esNegra()))
            {
                if(tablero.getEspacio(candidateDestinationCoordinate).espacioOcupado())
                {
                    final Pieza piezaCandidata = tablero.getEspacio(candidateDestinationCoordinate).getPieza();
                    if(this.piezaAlliance != piezaCandidata.getPiezaAlliance())
                    {
                        movimientosLegales.add(new MajorMove(tablero, this, candidateDestinationCoordinate));
                    }
                }
            
            }else if(candidatoActual == 9 && !(tableroUtilitarios.PRIMERA_COLUMNA[this.posicionPieza] && this.piezaAlliance.esBlanca() ||
                    tableroUtilitarios.EIGHTH_COLUMNA[this.posicionPieza] && this.piezaAlliance.esNegra()))
            {
                if(tablero.getEspacio(candidateDestinationCoordinate).espacioOcupado())
                {
                    final Pieza piezaCandidata = tablero.getEspacio(candidateDestinationCoordinate).getPieza();
                    if(this.piezaAlliance != piezaCandidata.getPiezaAlliance())
                    {
                        movimientosLegales.add(new MajorMove(tablero, this, candidateDestinationCoordinate));
                    }
                }
            }
                
        
        }
        
        
        
        return ImmutableList.copyOf(movimientosLegales);
    }
    
    
}
