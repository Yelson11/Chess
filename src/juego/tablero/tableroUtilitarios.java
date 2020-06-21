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
    
    public static final boolean[] SECOND_ROW = null;
    public static final boolean[] SEVENTH_ROW = null;
    
    public static final int num_espacios = 64;
    public static final int num_espacios_por_fila = 8;
    
    private tableroUtilitarios()
    {
        throw new RuntimeException("No me puedes instanciar");
    }
    
    private static boolean[] initColumn(int columnNumber)
    {
        final boolean[] column = new boolean[num_espacios];
        do{
            column[columnNumber] = true;
            columnNumber += num_espacios_por_fila;
        } while(columnNumber < num_espacios);
        return column;
    }
    
    
    public static boolean espacioEsValido(final int coordenada)
    {
        return coordenada >=0 && coordenada < num_espacios;
    }
    
}
