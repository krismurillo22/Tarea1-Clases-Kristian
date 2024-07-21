/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1_clases_kristian;

import javax.swing.JOptionPane;

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
        if (contador >= multas.length) {
            JOptionPane.showMessageDialog(null, "No hay espacio en el arreglo para agregar más multas.");
            return;
        }else if (buscar(codigo) != null) {
            JOptionPane.showMessageDialog(null, "El código de multa " + codigo + " ya existe. El código debe ser único.");
            return;
        }

        multas[contador]=new Multa(codigo, nombre, tipo);
        contador++;
    }
    
    public void pagar(int codigo) {
        Multa multa=buscar(codigo);
        if (multa != null) {
            multa.pay();
            JOptionPane.showMessageDialog(null, "La multa con código " + codigo + " fue pagada.");
        } else {
            JOptionPane.showMessageDialog(null, "La multa con código " + codigo + " no existe.");
        }
    }
    
    public String imprimir(){
        String todasmultas = "";
        for(int contar=0;contar<multas.length;contar++){
            if (multas[contar]!=null){
                todasmultas+=multas[contar].print()+"\n";
            }
        }
        return todasmultas;
    }
    
    public String reportes(){
        int contadorpagados=0;
        int contadornopagados=0;
        
        for (int contar=0; contar<contador;contar++) {
            if (multas[contar].isPagada()) {
                contadorpagados++;
            } else {
                contadornopagados++;
            }
        }
        
        String reportes="Cantidad de Multas generadas: "+contador+
                        "\nCantidad de Multas Pagadas con su monto en Lps.: "+contadorpagados+
                        "\nCantidad de Multas pendientes de pagar con su monto en Lps.: "+contadornopagados;
        
        return reportes;
    }
}
