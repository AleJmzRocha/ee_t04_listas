package ListaLigada;

public interface ILista<T>{
	public void inserta_inicio(T dato);
    
	public void inserta_final(T dato);
	    
	public void inserta_antes_de(T dato, T referencia);
	    
	public void inserta_despues_de(T dato, T referencia);
	 
	   
	public T elimina_primero();
	    
	public T elimina_ultimo();
	    
	public T elimina_elemento(T dato);
	    
	public T elimina_antes(T dato);
	    

	public T busca_desordenado(T dato);
	    
	public T busca_rescursivo(INodo<T> p, T dato);
	    

	public T obtenDatoEnPosicion(Integer posicion);
	    

	public String recorreRecursivo(INodo<T> p);
	    
	public String recorreIterativo();
	    

	public void inserta_ordenado(T dato);
}