/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author p_a_u
 */
public class ArbolGeneral {
    NodoGeneral raiz;
    int i=0;
    public ArbolGeneral(){
    raiz=null;
    }
    public boolean insertar(char dato,String path){
    /*
        1.raiz es null
        2.path vacio
        3.Buscar padre
        4.crear hijo
        5.Enlazar padre con hijo
        
        */
    if(raiz==null){
        raiz=new NodoGeneral(dato);
        if(raiz==null)return false;
        return true;
        }
    if(path.isEmpty())return false;
    
    NodoGeneral padre=buscarNodo(path);
    if(padre==null) return false;
    //revisar si existe un hijo con la misma letra que deseo
    //insertar
    NodoGeneral hijoYaExiste=buscarNodo(path+"/"+dato);
    //si existe el hijo(es decir es!=null) entonces
    //retorno false;
    
    if(hijoYaExiste!=null)return false;
    NodoGeneral nuevo= new NodoGeneral(dato);
    return padre.enlazar(nuevo);
    }
private NodoGeneral buscarNodo(NodoGeneral Dad, String[] vector, int aux){
   // System.out.print("Entra a buscar nodo");
        if(i<vector.length){     
             
            Dad = Dad.obtenerHijo(vector[i].charAt(0));
            if(Dad == null) return null;
            i=i++;
            //System.out.print("Inserta:"+vector[i]);
            //Gpi
            Dad = buscarNodo(Dad, vector, i);
        }
        return Dad;
    }
    
    private NodoGeneral buscarNodo(String path){
        path = path.substring(1);
        String vector[]= path.split("/");
        int a = 1;
        if(vector[0].charAt(0)==raiz.dato){
        if(vector.length==1)return raiz;
        NodoGeneral padre =raiz;
        return buscarNodo(padre, vector, a);
        }
        
        return null;
    }
    
    
    
    public boolean eliminar(String path){
    if(raiz==null)return false;
    NodoGeneral hijo=buscarNodo(path);
    if(hijo==null)return false;
    if(!hijo.esHoja())return false;
    if(hijo==raiz){raiz=null;return true;}
    
    String pathPadre=obtenerPathPadre(path);
    NodoGeneral padre=buscarNodo(pathPadre);
    return padre.desenlazar(hijo);
    }

    private String obtenerPathPadre(String path) {
        int posicionANTESUltimaDiagonal=path.lastIndexOf("/")-1;
        return path.substring(0,posicionANTESUltimaDiagonal);
        
    }
}
