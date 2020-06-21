package juego.tablero;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import juego.pieza.Alfil;
import juego.pieza.Alliance;
import juego.pieza.King;
import juego.pieza.Knight;
import juego.pieza.Peon;
import juego.pieza.Pieza;
import juego.pieza.Reina;
import juego.pieza.Torre;

/**
 *
 * @author emers
 */
public class Tablero 
{
    private final List<Espacio> tableroJuego;
    private final Collection<Pieza> piezasBlancas;
    private final Collection<Pieza> piezasNegras;
    
    
    private Tablero(Builder builder)
    {
        this.tableroJuego = crearTableroJuego(builder);
        this.piezasBlancas = calcularPiezasActivas(this.tableroJuego, Alliance.BLANCO);
        this.piezasNegras = calcularPiezasActivas(this.tableroJuego, Alliance.NEGRO);
    }
    
    private Collection<Pieza> calcularPiezasActivas(final List <Espacio> tableroJuego, final Alliance alliance)
    {
        final List<Pieza> piezasActivas = new ArrayList<>();
        
        for(final Espacio espacio : tableroJuego)
        {
            if(espacio.espacioOcupado())
            {
                final Pieza pieza = espacio.getPieza();
                if(pieza.getPiezaAlliance() == alliance)
                {
                    piezasActivas.add(pieza);
                }
            }
        }
        return ImmutableList.copyOf(piezasActivas);
    }
    
    
    public Espacio getEspacio(final int espacioCoordinar)
    {
        return tableroJuego.get(espacioCoordinar);
    }
    
    private static List<Espacio> crearTableroJuego(final Builder builder)
    {
        final Espacio[] espacios = new Espacio[tableroUtilitarios.num_espacios];
        for(int i =0; i < tableroUtilitarios.num_espacios; i++)
        {
            espacios[i] = Espacio.crearEspacio(i, builder.configuracionTablero.get(i));
        }
        return ImmutableList.copyOf(espacios);
    }
    
    public static Tablero crearTableroEstandar()
    {
        final Builder builder = new Builder();
        // Black Layout
        builder.setPieza(new Torre(Alliance.NEGRO, 0));
        builder.setPieza(new Knight(Alliance.NEGRO, 1));
        builder.setPieza(new Alfil(Alliance.NEGRO, 2));
        builder.setPieza(new Reina(Alliance.NEGRO, 3));
        builder.setPieza(new King(Alliance.NEGRO, 4));
        builder.setPieza(new Alfil(Alliance.NEGRO, 5));
        builder.setPieza(new Knight(Alliance.NEGRO, 6));
        builder.setPieza(new Torre(Alliance.NEGRO, 7));
        builder.setPieza(new Peon(Alliance.NEGRO, 8));
        builder.setPieza(new Peon(Alliance.NEGRO, 9));
        builder.setPieza(new Peon(Alliance.NEGRO, 10));
        builder.setPieza(new Peon(Alliance.NEGRO, 11));
        builder.setPieza(new Peon(Alliance.NEGRO, 12));
        builder.setPieza(new Peon(Alliance.NEGRO, 13));
        builder.setPieza(new Peon(Alliance.NEGRO, 14));
        builder.setPieza(new Peon(Alliance.NEGRO, 15));
        // White Layout
        builder.setPieza(new Peon(Alliance.BLANCO, 48));
        builder.setPieza(new Peon(Alliance.BLANCO, 49));
        builder.setPieza(new Peon(Alliance.BLANCO, 50));
        builder.setPieza(new Peon(Alliance.BLANCO, 51));
        builder.setPieza(new Peon(Alliance.BLANCO, 52));
        builder.setPieza(new Peon(Alliance.BLANCO, 53));
        builder.setPieza(new Peon(Alliance.BLANCO, 54));
        builder.setPieza(new Peon(Alliance.BLANCO, 55));
        builder.setPieza(new Torre(Alliance.BLANCO, 56));
        builder.setPieza(new Knight(Alliance.BLANCO, 57));
        builder.setPieza(new Alfil(Alliance.BLANCO, 58));
        builder.setPieza(new Reina(Alliance.BLANCO, 59));
        builder.setPieza(new King(Alliance.BLANCO, 60));
        builder.setPieza(new Alfil(Alliance.BLANCO, 61));
        builder.setPieza(new Knight(Alliance.BLANCO, 62));
        builder.setPieza(new Torre(Alliance.BLANCO, 63));
        //white to move
        builder.setMoveMaker(Alliance.BLANCO);
        //build the board
        return builder.build();
    }
    
    public static class Builder
    {
        
        Map<Integer, Pieza> configuracionTablero;
        Alliance nextMoveMaker;
        
        public Builder()
        {
        
        }
        
        public Builder setPieza(final Pieza pieza)
        {
            this.configuracionTablero.put(pieza.getPiezaPosicion(), pieza);
            return this;
        }
        
        public Builder setMoveMaker(final Alliance nextMoveMaker)
        {
            this.nextMoveMaker = nextMoveMaker;
            return this;
        }
        
        public Tablero build()
        {
            return new Tablero(this);
        }
    }
    
    
}
