package juego.pieza;

/**
 *
 * @author emers
 */
public enum Alliance {
    
    BLANCO{
        @Override
        public int getDireccion(){
            return -1;
        }

        @Override
        public boolean esNegra() {
            return false;
        }

        @Override
        public boolean esBlanca() {
            return true;
        }
    },
    NEGRO{
        @Override
        public int getDireccion(){
            return 1;
        }

        @Override
        public boolean esNegra() {
            return true;
        }

        @Override
        public boolean esBlanca() {
            return false;
        }
    };
    
    
    
    public abstract int getDireccion();
    public abstract boolean esNegra();
    public abstract boolean esBlanca();
}
