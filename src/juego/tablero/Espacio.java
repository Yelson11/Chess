package juego.tablero;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import juego.pieza.Pieza;


/**
 *
 * @author emers
 */
public abstract class Espacio 
{
    
    protected final int espacioCoordenada;
    
    private static final Map<Integer, espacioVacio> espacios_vacios = crearEspaciosVaciosPosibles();
    
    private static Map<Integer, espacioVacio> crearEspaciosVaciosPosibles() 
    {
        final Map<Integer, espacioVacio> mapaVacio = new HashMap<>();
        
        for(int i =0; i < tableroUtilitarios.num_espacios; i++)
        {
            mapaVacio.put(i, new espacioVacio(i));
        }
        
        //Collections.unmodifiableMap(mapaVacio);
        return ImmutableMap.copyOf(mapaVacio);
    }
    
    private Espacio(int espacioCoordenada)
    {
        this.espacioCoordenada = espacioCoordenada;
    }
    
    public abstract boolean espacioOcupado();
    
    public abstract Pieza getPieza();
    
    public static Espacio crearEspacio(final int espacioCoordenada, final Pieza pieza)
    {
        return pieza != null ? new espacioOcupado(espacioCoordenada, pieza) : espacios_vacios.get(espacioCoordenada);
    }
    
    public static final class espacioVacio extends Espacio
    {
        
        espacioVacio(final int coordenada)
        {
            super(coordenada);
        }
        
        @Override
        public boolean espacioOcupado()
        {
            return false;
        }
        public Pieza getPieza()
        {
            return null;
        }
        
    }
    
     public static final class espacioOcupado extends Espacio
    {
         
        private final Pieza piezaEnEspacio;
        
        espacioOcupado(int espacioCoordenada, Pieza piezaEnEspacio)
        {
            super(espacioCoordenada);
            this.piezaEnEspacio = piezaEnEspacio;
        }
        
        @Override
        public boolean espacioOcupado()
        {
            return true;
        }
        public Pieza getPieza()
        {
            return this.piezaEnEspacio;
        }
        
    }
    
    
    
}
