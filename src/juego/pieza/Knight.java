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
import static juego.tablero.tableroUtilitarios.espacioEsValido;

/**
 *
 * @author emers
 */
public class Knight extends Pieza
{
    
    private final static int[] movimientos_coordinados_candidatos = {-17, -15, -10, -6, 6, 10, 15, 17};

    public Knight(final Alliance piezaAlliance, final int posicionPieza) 
    {
        super(posicionPieza, piezaAlliance);
    }

    @Override
    public List<Movimiento> calculaMovimientosLegales(final Tablero tablero) 
    {
        

        Collection<Movimiento> movimientosLegales = new ArrayList<>();
        
        for(final int candidatoActual : movimientos_coordinados_candidatos)
        {
            
            final int destinoCandidato = this.posicionPieza + candidatoActual;
            
            if(espacioEsValido(destinoCandidato))
            {
                if(isFirstColumnExclusion(this.posicionPieza, candidatoActual) || isSecondColumnExclusion(this.posicionPieza, candidatoActual)
                        || isSeventhColumnExclusion(this.posicionPieza, candidatoActual)
                        || isEighthColumnExclusion(this.posicionPieza, candidatoActual))
                {
                    continue;
                }
                
                
                final Espacio destinoCandidatoEspacio = tablero.getEspacio(destinoCandidato);
                if(!destinoCandidatoEspacio.espacioOcupado())
                {
                    movimientosLegales.add(new MajorMove(tablero, this, destinoCandidato));
                }else
                {
                    final Pieza piezaDestino = destinoCandidatoEspacio.getPieza();
                    final Alliance piezaAlliance = piezaDestino.getPiezaAlliance();
                    
                    if(this.piezaAlliance != piezaAlliance)
                    {
                        movimientosLegales.add(new AttackMove(tablero, this, destinoCandidato, piezaDestino));
                    }
                }
            }
            
        }   
        
        return ImmutableList.copyOf(movimientosLegales);
    }
    
    private static boolean isFirstColumnExclusion(final int posicionActual, final int candidateOffSet)
    {
        return tableroUtilitarios.PRIMERA_COLUMNA[posicionActual] && (candidateOffSet == -17) || (candidateOffSet == -10) || 
                (candidateOffSet == 6) || (candidateOffSet == -15);
    }
    
    private static boolean isSecondColumnExclusion(final int posicionActual, final int candidateOffSet)
    {
        return tableroUtilitarios.SEGUNDA_COLUMNA[posicionActual] && (candidateOffSet == -10) || (candidateOffSet == 6);
    }

    private static boolean isSeventhColumnExclusion(final int posicionActual, final int candidateOffSet)
    {
        return tableroUtilitarios.SEVENTH_COLUMNA[posicionActual] && (candidateOffSet == -6) || (candidateOffSet == 10);
    }
    
    private static boolean isEighthColumnExclusion(final int posicionActual, final int candidateOffSet)
    {
        return tableroUtilitarios.EIGHTH_COLUMNA[posicionActual] && (candidateOffSet == -15) || (candidateOffSet == -6) || 
                (candidateOffSet == 10) || (candidateOffSet == 17);
    }

}
