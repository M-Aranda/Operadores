package org.esque.esomismo.gui;

import javax.swing.JOptionPane;

public class Aplicacion extends javax.swing.JFrame {

    public Aplicacion() {
        initComponents();
        this.setTitle("Calculadora simple");
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNum1 = new javax.swing.JLabel();
        lblNum2 = new javax.swing.JLabel();
        lblOperador = new javax.swing.JLabel();
        btnCalcular = new javax.swing.JButton();
        txtNum1 = new javax.swing.JTextField();
        txtNum2 = new javax.swing.JTextField();
        txtOperador = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNum1.setText("Numero 1: ");

        lblNum2.setText("Numero 2:");

        lblOperador.setText("Operador: ");

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNum1)
                            .addComponent(lblNum2)
                            .addComponent(lblOperador))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNum2, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(txtOperador)
                            .addComponent(txtNum1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(btnCalcular)))
                .addContainerGap(214, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNum1)
                    .addComponent(txtNum1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNum2)
                    .addComponent(txtNum2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOperador)
                    .addComponent(txtOperador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(btnCalcular)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        String num1 = txtNum1.getText();
        String num2 = txtNum2.getText();
        /**
         * Validado
         * No estoy seguro de que sea bueno que el software tire mas de un error
         * si detecta varios tipos de error, pero tampoco se si sea buena idea
         * simplemente decir que hay un eror sin dar informacion de en donde
         * esta el error
         */

        int numero1 = 0;
        int numero2 = 0;
        int res = 0;
        boolean numerosValidos = true;
        boolean hayError = false;
//        String regex = "\\d+";

//        if(!num1.matches(regex)|| !num2.matches(regex) || (!num1.matches(regex)&& !num2.matches(regex)) || num1.isEmpty() || num2.isEmpty() || (num1.isEmpty() && num2.isEmpty()) ){
//           numerosValidos = false; 
//        }
//        numero1 = Integer.parseInt(num1);
//        numero2 = Integer.parseInt(num2);
//        if (num1.isEmpty() || num2.isEmpty() || (num1.isEmpty() && num2.isEmpty())) {
//            numerosValidos = false;
//        }
        try {
            numero1 = Integer.parseInt(num1);
            numero2 = Integer.parseInt(num2);
        } catch (Exception e) {
            numerosValidos = false;
        }

        if (!numerosValidos) {
            String ttlNoHayNumerosValidos = "Error";
            String msgNoHayNumerosValidos = "Ambos campos de numeros deben ser numeros enteros";
            int tipoErrorN = JOptionPane.ERROR_MESSAGE;

            JOptionPane.showMessageDialog(this, msgNoHayNumerosValidos, ttlNoHayNumerosValidos, tipoErrorN);

            txtNum1.setText(null);
            txtNum2.setText(null);
            
            hayError = true;
        }

        String operacion = txtOperador.getText();
        String tipoDeOperacion = "nada";

        if (operacion.isEmpty()) {
            String tituloError = "Error!";
            String mensajeError = "Debe seleccionar un tipo de operador";
            int tipoError = JOptionPane.ERROR_MESSAGE;

            JOptionPane.showMessageDialog(this, mensajeError, tituloError, tipoError);

            txtNum1.setText(null);
            txtNum2.setText(null);
            hayError = true;

        } else if (operacion.equalsIgnoreCase("+")) {
            res = numero1 + numero2;
            tipoDeOperacion = "suma";
        } else if (operacion.equalsIgnoreCase("-")) {
            res = numero1 - numero2;
            tipoDeOperacion = "resta";
        } else if (operacion.equalsIgnoreCase("/")) {
            res = numero1 / numero2;
            tipoDeOperacion = "division";
        } else if (operacion.equalsIgnoreCase("*")) {
            res = numero1 * numero2;
            tipoDeOperacion = "multiplicacion";

        }

//        if (operacion.equals("+") || operacion.equals("-") || operacion.equals("/") || operacion.equals("*")) {
        if (!hayError) {
            String titulo = "Resultado";
            String mensaje = "El resultado de la " + tipoDeOperacion + " entre " + num1 + " y " + num2 + " es " + res;
            int tipo = JOptionPane.INFORMATION_MESSAGE;

            JOptionPane.showMessageDialog(this, mensaje, titulo, tipo);

        }

//        } else {
//            txtNum1.setText(null);
//            txtNum2.setText(null);
//            txtOperador.setText(null);
//
//            String tituloErrorIngreso = "Error en el ingreso de datos";
//            String msgErrorIngreso = "No hay operadores validos en el campo de operadores";
//            int tipoErrorAlCalcular = JOptionPane.ERROR_MESSAGE;
//            JOptionPane.showMessageDialog(null, msgErrorIngreso, tituloErrorIngreso, tipoErrorAlCalcular);
//
//        }

    }//GEN-LAST:event_btnCalcularActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Aplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aplicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aplicacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JLabel lblNum1;
    private javax.swing.JLabel lblNum2;
    private javax.swing.JLabel lblOperador;
    private javax.swing.JTextField txtNum1;
    private javax.swing.JTextField txtNum2;
    private javax.swing.JTextField txtOperador;
    // End of variables declaration//GEN-END:variables
}
