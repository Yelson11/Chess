package juego.pieza;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import juego.tablero.Espacio;
import juego.tablero.Movimiento;
import juego.tablero.Movimiento.AttackMove;
import juego.tablero.Movimiento.MajorMove;
import juego.tablero.Tablero;
import juego.tablero.tableroUtilitarios;
/**
 *
 * @author emers
 */
public class King extends Pieza
{

    private final static int[] CANDIDATOS_MOVIMIENTOS_VECTOR = {-9, -8, -7, -1, 1, 7, 8, 9};
    
    public King(Alliance piezaAlliance, int posicionPieza) {
        super(posicionPieza, piezaAlliance);
    }

    @Override
    public Collection<Movimiento> calculaMovimientosLegales(Tablero tablero) 
    {
        
        final List<Movimiento> movimientosLegales = new ArrayList<>();
        
        for(final int candidatoActual : CANDIDATOS_MOVIMIENTOS_VECTOR)
        {
            final int candidateDestinationCoordinate = this.posicionPieza + candidatoActual;
            
            
            if(isFirstColumnExclusion(this.posicionPieza, candidatoActual) || isEighthColumnExclusion(this.posicionPieza, candidatoActual))
            {
                continue;
            }
            
            
            
            if(tableroUtilitarios.espacioEsValido(candidateDestinationCoordinate))
            {
                final Espacio espacioDestinoCandidato = tablero.getEspacio(candidateDestinationCoordinate);
                if(!espacioDestinoCandidato.espacioOcupado())
                {
                    movimientosLegales.add(new MajorMove(tablero, this, candidateDestinationCoordinate));
                }else
                {
                    final Pieza piezaDestino = espacioDestinoCandidato.getPieza();
                    final Alliance piezaAlliance = piezaDestino.getPiezaAlliance();
                    
                    if(this.piezaAlliance != piezaAlliance)
                    {
                        movimientosLegales.add(new AttackMove(tablero, this, candidateDestinationCoordinate, piezaDestino));
                    }
                }
                
                
            }
            
            
        }
        
        
        
        
        return ImmutableList.copyOf(movimientosLegales);
    }
    
    
    private static boolean isFirstColumnExclusion(final int posicionActual, final int candidateOffSet)
    {
        return tableroUtilitarios.PRIMERA_COLUMNA[posicionActual] && (candidateOffSet == -9) || (candidateOffSet == -1) || 
                (candidateOffSet == 7);
    }
    
    private static boolean isEighthColumnExclusion(final int posicionActual, final int candidateOffSet)
    {
        return tableroUtilitarios.EIGHTH_COLUMNA[posicionActual] && (candidateOffSet == -7) || (candidateOffSet == 1) || (candidateOffSet == 9);
    }
    
}
