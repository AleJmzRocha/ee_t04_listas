package ListaLigada;
/**
 * @author Jim�nez Rocha Alejandra
 * Clase gen�rica Nodo<T> que implementa la interface ILista<T>
 */
public class Nodo<T extends Comparable<T>> implements INodo<T>{
	/**
	 * El nodo contendr�:
	 * El dato declarado como dato
	 * La liga declarado como siguiente;
	 */
    private T dato;
    private Nodo<T> siguiente;
    
    /**
     * Construtor que incializa los atributos pasando como par�metro el dato
     * @param dato
     */
    public Nodo(T dato){
        this.dato = dato;
        siguiente = null;
    }
    
    /**
     * M�todo que permite obtener el dato del nodo
     * @return dato
     */
    public T getDato(){
        return dato;
    }
    
    /**
     * M�todo que permite cambiar el dato del nodo
     * @param dato
     */
    public void setDato(T dato){
        this.dato = dato;
    }
    
    /**
     * M�todo que permite obtener el nodo siguiente
     * @return siguiente
     */
    public Nodo<T> getSiguiente(){
        return siguiente;
    }
    
    /**
     * M�todo que permite cambiar la liga del nodo
     * @param siguiente
     */
    public void setSiguiente(Nodo<T> siguiente){
        this.siguiente = siguiente;
    }
}