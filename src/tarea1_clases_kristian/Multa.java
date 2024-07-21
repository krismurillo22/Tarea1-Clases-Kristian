/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea1_clases_kristian;

/**
 *
 * @author User
 */
public class Multa {
    
    private int codigo;
    private String nombreinfractor;
    private String tipo;
    private double montoPagar;
    private boolean pagada;
    
    public static double TIPO_GRAVE = 1000.0;
    public static double TIPO_MEDIO = 500.0;
    public static double TIPO_LEVE = 100.0;
    
    public Multa(int codigo, String nombre, String tipo){
        this.codigo=codigo;
        nombreinfractor=nombre;
        this.tipo=tipo;
        pagada=false;
        
        if (this.tipo.equals("LEVE")){
            this.montoPagar=TIPO_LEVE;
        }else if (this.tipo.equals("MEDIO")){
            this.montoPagar=TIPO_MEDIO;
        }else if (this.tipo.equals("GRAVE")){
            this.montoPagar=TIPO_GRAVE;
        }else if(this.tipo.equals("    ")){
            this.tipo = "LEVE";
            this.montoPagar=TIPO_LEVE;
        }
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public double getMontoPagar() {
        return montoPagar;
    }
    
    public boolean isPagada() {
        return pagada;
    }
    
    public String print(){
        String estado = pagada ? "Pagada por un monto de: Lps. "+montoPagar:"Multa pendiente";
        String print ="Código: "+this.codigo+
                    "\nNombre del Infractor: "+this.nombreinfractor+
                    "\nTipo de Multa: "+this.tipo+
                    "\nMonto a Pagar: "+this.montoPagar+
                    "\n"+estado;
        return print;
    }
    
    public String pay() {
        this.pagada = true;
        return "Multa con Código "+codigo+" fue pagada por un monto de Lps. "+montoPagar;
    }
}
