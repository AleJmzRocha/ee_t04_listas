package ListaLigada;
import javax.swing.JOptionPane;

/**
 * @author Jim�nez Rocha Alejandra
 * Clase que implementa los m�todos de la interface ILista<T>.
 */
public class ListaLigadaSimple<T extends Comparable<T>> implements ILista<T>{
	/**
	 * Creaci�n del nodo que contendr� el dato y la liga.
	 */
	private Nodo<T> inicio;
	
	/**
	 * Constructor que incializa la lista en nula.
	 */
	public ListaLigadaSimple(){
    	inicio = null;
    }
	
	/**
	 * M�todo que permite obtener el inicio de la lista.
	 * @return
	 */
	public Nodo<T> getInicio(){
        return inicio;
    }
	
	/**
	 * M�todo que permite cambiar el inicio de la lista.
	 * @return
	 */
	public void setInicio(Nodo<T> inicio){
		this.inicio = inicio;
	}
	
	/**
     * Este m�todo sobrescribe el m�todo toString() de la clase Object.
     * Imprime la lista con las datos de �sta misma.
     */
    @Override
    public String toString(){
        Nodo<T> iterador = inicio;
        String s = "";
         while( iterador != null ){ 
             s += iterador.getDato() + " --> ";
             iterador = iterador.getSiguiente(); 
         } 
         s += null;
         return s;
    }
        
    /**
     *Implementaci�n del m�todo inserta_inicio(T dato) de la interface ILista<T>.
     *Permite agregar un elemento al inicio de la lista.
     *@param dato
     */
    @Override
	public void inserta_inicio(T dato){
        Nodo<T> nuevo = new Nodo<T>(dato);
        nuevo.setSiguiente(inicio);
        inicio = nuevo;
    }
	
    /**
     *Implementaci�n del m�todo inserta_final(T dato) de la interface ILista<T>.
     *Permite agregar un elemento al final de la lista.
     *@param dato
     */
    @Override
	public void inserta_final(T dato){
        Nodo<T> temporal = inicio;
        if(inicio == null)
        	inserta_inicio(dato);
        else{
             while(temporal.getSiguiente() != null)
                   temporal = temporal.getSiguiente();
             temporal.setSiguiente(new Nodo<T>(dato));
        }        
    }
	
    /**
     *Implementaci�n del m�todo recorreIterativo() de la interface ILista<T>.
     *M�todo que permite recorrer la lista de inicio a fin.
     */
    @Override
	public String recorreIterativo(){
    	Nodo<T> temporal = inicio;
    	String s = "";
    	while(temporal != null){
    		s += temporal.getDato() + " --> ";
    		temporal = temporal.getSiguiente();
    	}
    	s += "null";
		return s;
    }
	
    /**
     *Implementaci�n del m�todo recorreRecursivo(INodo<T> p) de la interface ILista<T>.
     *M�todo que permite recorrer la lista recursivamente, es decir, 
     *llam�ndose el mismo m�todo dentro de �ste mismo pero con el nodo siguiente.
     *@param dato
     */
    @Override
	public String recorreRecursivo(INodo<T> p){
		String s = "";
    	if(p != null){
    		s += ((Nodo<T>) p).getDato() + " --> ";
    		//System.out.println(p.getDato());
    		recorreRecursivo(((Nodo<T>)p).getSiguiente());
    	}
    	s += "null";
    	return s;
    }
	
    /**
     *Implementaci�n del m�todo inserta_antes_de(T dato, T referencia) de la interface ILista<T>.
     *M�todo que permite agregar un elemento antes de otro que se desee.
     *@param dato, referencia
     */
    @Override
	public void inserta_antes_de(T dato, T referencia){
        Nodo<T> temporal = inicio, nodoEncontrado = null, nuevo;
        Boolean band = true;
        while(temporal.getDato() != referencia && band)
              if(temporal.getSiguiente() != null){
                  nodoEncontrado = temporal;
                  temporal = temporal.getSiguiente();
              }else
                  band = false;
                  
        if(band)
           if(temporal == inicio)
        	   inserta_inicio(dato);
           else{
               nuevo = new Nodo<T>(dato);
               nuevo.setSiguiente(temporal);
               nodoEncontrado.setSiguiente(nuevo);
            }              
    }
	
    /**
     *Implementaci�n del m�todo inserta_despues_de(T dato, T referencia) de la interface ILista<T>.
     *M�todo que permite agregar un elemento despu�s de otro que se desee.
     *@param dato, referencia
     */
    @Override
	public void inserta_despues_de(T dato, T referencia){
        Nodo<T> temporal = inicio, nuevo;
        Boolean band = true;
        while(temporal.getDato() != referencia && band)
              if(temporal.getSiguiente() != null)
                 temporal = temporal.getSiguiente();
              else
                 band = false;
        
        if(band)
           if(temporal == inicio)
        	   inserta_inicio(dato);
           else{
               nuevo = new Nodo<T>(dato);
               nuevo.setSiguiente(temporal.getSiguiente());
               temporal.setSiguiente(nuevo);
           }
    }
	
    /**
     *Implementaci�n del m�todo inserta_ordenado(T dato) de la interface ILista<T>.
     *M�todo que, al insertar elementos, permite que �stos se agreguen de manera descendente.
     *@param dato
     */
    @Override
	public void inserta_ordenado(T dato){
        Nodo<T> temporal = inicio, nodoEncontrado = null, nuevo;
        Boolean band = true;
        
        if(inicio == null)
        	inserta_inicio(dato);
        else{
           while((dato.compareTo(temporal.getDato()))<0 && band)
                 if(temporal.getSiguiente() != null){
                    nodoEncontrado = temporal;
                    temporal = temporal.getSiguiente();
                }else
                    band = false;
                    
           if(band)
              if(temporal == inicio)
            	  inserta_inicio(dato);
              else{
                 nuevo = new Nodo<T>(dato);
                 nuevo.setSiguiente(temporal);
                 nodoEncontrado.setSiguiente(nuevo);
              }
           else
        	   inserta_final(dato);
        }
    }
	
    /**
     *Implementaci�n del m�todo elimina_primero() de la interface ILista<T>.
     *M�todo que elimina el primer elemento de la lista.
     *@return dato
     */
    @Override
	public T elimina_primero(){
		T dato = null;
		if(inicio.getSiguiente() != null){
			dato = inicio.getDato();
			inicio = inicio.getSiguiente();
		}
		else 
			inicio = null;
		return dato;
	}
	
    /**
     *Implementaci�n del m�todo elimina_ultimo() de la interface ILista<T>.
     *M�todo que elimina el �ltimo elemento de la lista.
     *@return dato
     */
    @Override
	public T elimina_ultimo(){
        Nodo<T> temporal = inicio, anterior = null;
        T dato = null;
        try{
            if(inicio.getSiguiente() == null)
               inicio = null;
               else{
                   while(temporal.getSiguiente() != null){
                       anterior = temporal;
                       dato = temporal.getDato();
                       temporal = temporal.getSiguiente();
                    }                
                    anterior.setSiguiente(null);
            }     
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null,"Lista vac�a.");
        }
		return dato;
    }
	
    /**
     *Implementaci�n del m�todo elimina_elemento(T dato) de la interface ILista<T>.
     *M�todo que permite la eliminaci�n del elemento que se desee.
     *@param dato
     */
    @Override
	public T elimina_elemento(T dato){
		Nodo<T> aux = inicio, temp = null;
		Boolean band = true;
		
		try{			
			while(aux.getDato() != dato & band)
				if(aux.getSiguiente() != null){
					temp = aux;
					aux = temp.getSiguiente();
				}else
					band = false;
			
			if(band){
				if(inicio == aux)
					inicio = aux.getSiguiente();
				else
					temp.setSiguiente(aux.getSiguiente());
			}else
					JOptionPane.showMessageDialog(null, "El elemento no se encuentra en la lista.");
		}catch(NullPointerException e){
            JOptionPane.showMessageDialog(null,"Lista vac�a");
        }
		return aux.getDato();
	}
	
    /**
     *Implementaci�n del m�todo elimina_antes(T dato) de la interface ILista<T>.
     *M�todo que permite la eliminaci�n del elemento est� antes del referenciado. 
     *@param dato
     */
    @Override
	public T elimina_antes(T dato){
		Nodo<T> temp = inicio, aux = inicio, aux2 = null;
		Boolean band =true;
		
		try{
			if(inicio.getDato() == dato)
				JOptionPane.showMessageDialog(null,"No existe un nodo que preceda al que se desea eliminar");
			else{
				while(temp.getDato() != dato && band)
					if(temp.getSiguiente() != null){
						aux2 = aux;
						aux = temp;
						temp = temp.getSiguiente();
					}else
						band = false;
			}
		
			if(band)
				if(inicio.getSiguiente() == temp) //El elemento a eliminar es el primero
					inicio = temp;
				else
					aux2.setSiguiente(temp);
			else
				JOptionPane.showMessageDialog(null,"El elemento no se encuentra en la lista");
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null,"Lista vac�a");
		}
		return aux.getDato();
	}
	
    /**
     *Implementaci�n del m�todo busca_desordenado(T dato) de la interface ILista<T>.
     *M�todo que permite la b�squeda de un elemento en una lista que no est� ordenada.
     *@param dato
     */
    @Override
	public T busca_desordenado(T dato){
		Nodo<T> aux = inicio;
		T d = null;
		while(aux != null && aux.getDato() != dato){
			d = aux.getDato();
			aux = aux.getSiguiente();
		}
		
		if(aux == null)
//			JOptionPane.showMessageDialog(null, "El elemento NO se encuentra en la lista");
			return null;
		return d;
//		else
//			JOptionPane.showMessageDialog(null, "El elemento S� se encuentra en la lista");
	}
	
    /**
     *M�todo que permite la b�squeda de un elemento en una lista que se orden� previamente.
     *@param dato
     */
	public void busquedaOrdenada(T dato){
		Nodo<T> aux = inicio;
		while(aux != null && (aux.getDato().compareTo(dato)<0))
			aux = aux.getSiguiente();
		
		if(aux == null || (aux.getDato().compareTo(dato)>0))
			JOptionPane.showMessageDialog(null,"El elemento NO se encuentra en la lista");
		else
			JOptionPane.showMessageDialog(null, "El elemento S� se encuentra en la lista");
	}
	
	/**
     *Implementaci�n del m�todo busca_rescursivo(INodo<T> nodito, T dato) de la interface ILista<T>.
     *M�todo que permite la b�squeda de un elemento en una lista de forma recursiva.
     *@param dato
     */
    @Override
	public T busca_rescursivo(INodo<T> nodito, T dato){
		Nodo<T> nuevo = (Nodo<T>) nodito;
		if(nuevo == null)
			if(nuevo.getDato().compareTo(dato) == 0)
				JOptionPane.showMessageDialog(null, "El elemento se encuentra en la lista.");
			else
				busca_rescursivo(nuevo.getSiguiente(),nuevo.getSiguiente().getDato());
		else
			JOptionPane.showMessageDialog(null,"El elemento NO se encuentra en la lista.");
		return nuevo.getDato();
	}
	
    /**
     *Implementaci�n del m�todo obtenDatoEnPosicion(Integer posicion) de la interface ILista<T>.
     *M�todo que permite obtener el dato en la posici�n deseada de la lista.
     *@param posicion
     */
    @Override
	public T obtenDatoEnPosicion(Integer posicion) {
    	Integer cont = 0;
    	T dato = null;
    	Nodo<T> aux = inicio;
    	try{
    		while(aux != null){
    			if(cont == posicion)
    				dato = aux.getDato();
    			else{
    				aux = aux.getSiguiente();
    				cont++;
    			}
    		}
    	}catch(NullPointerException npe){
    		JOptionPane.showMessageDialog(null, "Lista vac�a.");
    	}
		return dato;
	}
	
    /**
     * Prueba de la clase.
     * @param args
     */
	public static void main(String[] args) {
		ListaLigadaSimple<Integer> list = new ListaLigadaSimple<Integer>();
		list.inserta_inicio(42);
		list.inserta_inicio(22);
		list.inserta_final(1);
		list.inserta_final(2);
		list.inserta_antes_de(43, 1);
		list.inserta_ordenado(23);
		list.inserta_ordenado(36);
		System.out.println(list);
	}	
}