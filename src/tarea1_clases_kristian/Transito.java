/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1_clases_kristian;

/**
 *
 * @author User
 */
public class Transito {
    private Multa[] multas;
    private int contador;
    
    public Transito(){
        this.multas = new Multa[100];
        this.contador=0;
    }
    
    public Multa buscar(int codigo) {
        for (int i=0;i<contador;i++) {
            if (multas[i].getCodigo() == codigo) {
                return multas[i];
            }
        }
        return null;
    }
    
    public void agregar(int codigo, String nombre, String tipo) {
        if (contador>=multas.length) {
            String mensaje="No hay espacio en el arreglo para agregar más multas.";
            return;
        }else if (buscar(codigo) != null) {
            String mensaje="El código de multa "+codigo+" ya existe.";
            return;
        }

        multas[contador]=new Multa(codigo, nombre, tipo);
        contador++;
    }
}
