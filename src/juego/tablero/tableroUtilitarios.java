package juego.tablero;

/**
 *
 * @author emers
 */
public class tableroUtilitarios 
{
    
    public static final boolean[] PRIMERA_COLUMNA = initColumn(0);
    public static boolean[] SEGUNDA_COLUMNA = initColumn(1);
    public static boolean[] SEVENTH_COLUMNA = initColumn(6);
    public static boolean[] EIGHTH_COLUMNA = initColumn(7);
    
    public static final boolean[] SECOND_ROW = inicializarFila(8);
    public static final boolean[] SEVENTH_ROW = inicializarFila(48);
    
    public static final int NUM_CASILLAS = 64;
    public static final int NUM_CASILLAS_POR_FILA = 8;
    
    private tableroUtilitarios(){
        throw new RuntimeException("No me puedes instanciar");
    }
    
    private static boolean[] initColumn(int columnNumber){
        final boolean[] column = new boolean[NUM_CASILLAS];
        do{
            column[columnNumber] = true;
            columnNumber += NUM_CASILLAS_POR_FILA;
        } while(columnNumber < NUM_CASILLAS);
        return column;
    }
    
    private static boolean[] inicializarFila (int numeroFila){
        final boolean[] fila = new boolean[NUM_CASILLAS];
        do {
            fila[numeroFila] = true;
            numeroFila++;
        }
        while (numeroFila % NUM_CASILLAS_POR_FILA != 0);
        
        return fila;
    }
    
    public static boolean casillaEsValida(final int coordenada){
        return coordenada >=0 && coordenada < NUM_CASILLAS;
    }
    
}
