/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author p_a_u
 */
//contiene una lista que hace referancia a los nodos
//hijos
//metodo :INsertar-->Enlazar
//,eliminar--->Desenlazar
//buscarNodo--->ObtenerHijo

public class NodoGeneral {
    char dato;
    NodoHijo ini,fin;
    
    public NodoGeneral(char v){
    dato=v;
    ini=fin=null;
    
    }
    
    public boolean enlazar(NodoGeneral hijo){
    //PENDIENTE la construccion del codigo que enlaza
    //al padre con el hijo y que es identico a un insertar 
    //de lista doble ,pero sin el valor,usando mas bien
    //una direccion 
    NodoHijo puntero=new NodoHijo(hijo);
    if(puntero==null)return false;
    if(ini==null&&fin==null){
    ini=fin=puntero;
    return true;
    
        }
    fin.sig=puntero;
    puntero.ant=fin;
    fin=puntero;
    return true;
    }
    public boolean esHoja(){
    return ini==null&&fin==null;
    
    }
    
    public NodoGeneral obtenerHijo(char valorHijoBuscado){
    //pendiente
    if(esHoja())return null;
    for(NodoHijo buscar=ini;buscar!=null;buscar=buscar.sig){
        if(buscar.direccionHijo.dato==valorHijoBuscado){
        return buscar.direccionHijo;
                
                
                
                
                
                
            }
        }
    return null;
    }

    public boolean desenlazar(NodoGeneral hijo) {
        if(ini==fin) {
         if(fin.direccionHijo==hijo){
             ini=fin=null;
             return true;
          
              }
         return false;
         } 
        NodoHijo temp=ini;
        if(ini.direccionHijo==hijo){
        ini=temp.sig;
        ini.ant=temp.sig=temp=null;
        return true;
        }
        if(fin.direccionHijo==hijo){
        temp=fin;
        fin=temp.ant;
        fin.sig=temp.ant=temp=null;
        return true;
        }
        temp=temp.sig;
        while(temp.direccionHijo!=hijo&&temp!=null){
        temp=temp.sig;
        }
        if(temp==null)return false;
        temp.sig.ant=temp.ant;
        temp.ant.sig=temp.sig;
        temp.sig=temp.ant=temp=null;
        return true;
         
    }
}
