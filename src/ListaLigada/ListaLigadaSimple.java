package ListaLigada;
import javax.swing.JOptionPane;

public class ListaLigadaSimple<T extends Comparable<T>> implements ILista<T>{
	private Nodo<T> inicio;
	
	public ListaLigadaSimple(){
    	inicio = null;
    }
	
	public Nodo<T> getInicio(){
        return inicio;
    }
	
	/**
     * Este método sobrescribe el método toString() de la clase Object
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
    
    @Override
	public void inserta_inicio(T dato){
        Nodo<T> nuevo = new Nodo<T>(dato);
        nuevo.setSiguiente(inicio);
        inicio = nuevo;
    }
	
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
            JOptionPane.showMessageDialog(null,"Lista vacía");
        }
		return dato;
    }
	
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
					JOptionPane.showMessageDialog(null, "El elemento no se encuentra en la lista");
		}catch(NullPointerException e){
            JOptionPane.showMessageDialog(null,"Lista vacía");
        }
		return aux.getDato();
	}
	
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
			JOptionPane.showMessageDialog(null,"Lista vacía");
		}
		return aux.getDato();
	}
	
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
			return d;
		return null;
//		else
//			JOptionPane.showMessageDialog(null, "El elemento SÍ se encuentra en la lista");
	}
	
	public void busquedaOrdenada(T dato){
		Nodo<T> aux = inicio;
		while(aux != null && (aux.getDato().compareTo(dato)<0))
			aux = aux.getSiguiente();
		
		if(aux == null || (aux.getDato().compareTo(dato)>0))
			JOptionPane.showMessageDialog(null,"El elemento NO se encuentra en la lista");
		else
			JOptionPane.showMessageDialog(null, "El elemento SÍ se encuentra en la lista");
	}
	
    @Override
	public T busca_rescursivo(INodo<T> nodito, T dato){
		Nodo<T> nuevo = (Nodo<T>) nodito;
		if(nuevo == null)
			if(nuevo.getDato().compareTo(dato) == 0)
				JOptionPane.showMessageDialog(null, "El elemento se encuentra en la lista");
			else
				busca_rescursivo(nuevo.getSiguiente(),nuevo.getSiguiente().getDato());
		else
			JOptionPane.showMessageDialog(null,"El elemento NO se encuentra en la lista");
		return nuevo.getDato();
	}
	
    @Override
	public T obtenDatoEnPosicion(Integer posicion) {
		return null;
	}
	
	public static void main(String[] args) {
		ListaLigadaSimple<Integer> list = new ListaLigadaSimple<Integer>();
		list.inserta_final(1);
		list.inserta_final(2);
		list.inserta_final(3);
		list.inserta_final(4);
		list.inserta_final(5);
		System.out.println(list);
		//list.recorreRecursivo(list.getInicio().getDato());
		//list.busquedaRecursiva(4);
		//System.out.println(list);
	}	
}