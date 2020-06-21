package juego.pieza;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import juego.tablero.Espacio;
import juego.tablero.Movimiento;
import juego.tablero.Tablero;
import juego.tablero.tableroUtilitarios;

/**
 *
 * @author emers
 */
public class Torre extends Pieza
{
    
    private final static int[] CANDIDATOS_MOVIMIENTOS_VECTOR = {-8, -1, 1, 8};

    public Torre(Alliance piezaAlliance, int posicionPieza) {
        super(posicionPieza, piezaAlliance);
    }

    @Override
    public Collection<Movimiento> calculaMovimientosLegales(final Tablero tablero) 
    {
        
        final List<Movimiento> movimientosLegales = new ArrayList<>();
        
        for(final int candidateCoordinateOffSet: CANDIDATOS_MOVIMIENTOS_VECTOR)
        {
            
            int candidateDestinationCoordinate = this.posicionPieza;
            
            while(tableroUtilitarios.espacioEsValido(candidateDestinationCoordinate))
            {
                
                if(isFirstColumnExclusion(this.posicionPieza, candidateDestinationCoordinate)
                        || isEighthColumnExclusion(this.posicionPieza, candidateDestinationCoordinate))
                {
                    break;
                }
                
                
                candidateDestinationCoordinate += candidateCoordinateOffSet;
                
                if(tableroUtilitarios.espacioEsValido(candidateDestinationCoordinate))
                {
                    final Espacio destinoCandidatoEspacio = tablero.getEspacio(candidateDestinationCoordinate);
                    if(!destinoCandidatoEspacio.espacioOcupado())
                    {
                        movimientosLegales.add(new Movimiento.MajorMove(tablero, this, candidateDestinationCoordinate));
                    }else
                    {
                        final Pieza piezaDestino = destinoCandidatoEspacio.getPieza();
                        final Alliance piezaAlliance = piezaDestino.getPiezaAlliance();

                        if(this.piezaAlliance != piezaAlliance)
                        {
                            movimientosLegales.add(new Movimiento.AttackMove(tablero, this, candidateDestinationCoordinate, piezaDestino));
                        }
                    }
                    break;
                }
                
            }
 
        }
        return ImmutableList.copyOf(movimientosLegales);
    }
    
    
    private static boolean isFirstColumnExclusion(final int posicionActual, final int candidateOffSet)
    {
        return tableroUtilitarios.PRIMERA_COLUMNA[posicionActual] && (candidateOffSet == -1);
    }
    
    private static boolean isEighthColumnExclusion(final int posicionActual, final int candidateOffSet)
    {
        return tableroUtilitarios.EIGHTH_COLUMNA[posicionActual] && (candidateOffSet == 1);
    } 
    
    
}
