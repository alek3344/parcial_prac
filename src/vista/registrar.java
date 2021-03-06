/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.AudioLibro;
import modelo.Libro;
import modelo.ListaPublicacion;
import modelo.Publicacion;
import static vista.registrar.modelo;

/**
 *
 * @author asus
 */
public class registrar extends javax.swing.JPanel {
    
    public static ListaPublicacion modelo;
    public static Publicacion publicacion;
    FileWriter salvar;
    

    public void registrarPublicacion() {
        Publicacion nuevaPublicacion = this.leerNuevaPublicacion();
        this.modelo.insertarPublicacion(nuevaPublicacion);
    }
    
    public Publicacion leerNuevaPublicacion() {
        
        boolean salir=true;
        
        while(salir == true)
        {
            try
            {
                String isbn = textidbn.getText();
                String titulo = texttitulo.getText();
                String autor = textautor.getText();
                int anio = Integer.parseInt(textañop.getText());
                double costo = Double.parseDouble(textcosto.getText());
                int tipo = selectipo.getSelectedIndex();

                if (tipo == 1) {
                    int nPag = Integer.parseInt(textnpajinas1.getText());
                    int edicion = Integer.parseInt(textnedicion1.getText());

                    publicacion = new Libro(nPag, edicion, isbn, titulo, autor, anio, costo);
                }
                if (tipo == 2) {

                    int nPag = 0;
                    int edicion = 0;
                    String formato = textformat.getText();
                    double duracion = Double.parseDouble(textduracion.getText());
                    double peso = Double.parseDouble(textpeso.getText());
                    publicacion = new AudioLibro(isbn,titulo,autor,anio,costo,duracion,peso,formato);
                    
                    if (tipo == 0) 
                    {
                        JOptionPane.showMessageDialog(null, "ingrese el tipo");
                    }
                }
                
                salir = false;
            }catch(java.lang.NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "llene todos los campos");
                salir = true;
                textidbn.setText("");
                texttitulo.setText("");
                textautor.setText("");
                textañop.setText("");
                textcosto.setText("");
                selectipo.setSelectedIndex(0);
                textnpajinas1.setText("");
                textnedicion1.setText("");
                textformat.setText("");
                textduracion.setText("");
                textpeso.setText("");
            }
        }
        
        return publicacion;
    }

    public void textPublicaciones() {

        try {
            salvar = new FileWriter("datos.txt");
            List<Publicacion> lista = this.modelo.leerPublicaciones();
            for (Publicacion p : lista) {
                salvar.write(p.getDataStringFormat());
            }

            salvar.close();
        } catch (IOException x) {
            JOptionPane.showMessageDialog(null, "error");
        }

    } 
    
    /**
     * Creates new form NewJPanel
     */
    public registrar() {
        
        initComponents();
        panelaudiolibro.setVisible(false);
        this.modelo = new ListaPublicacion();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ATRAS = new javax.swing.JButton();
        selectipo = new javax.swing.JComboBox<>();
        GUARDAR = new javax.swing.JButton();
        textidbn = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        texttitulo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textautor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textañop = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textcosto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        panellibro = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        textnpajinas1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        textnedicion1 = new javax.swing.JTextField();
        panelaudiolibro = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        textformat = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        textduracion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        textpeso = new javax.swing.JTextField();
        limpiar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ATRAS.setBackground(new java.awt.Color(0, 0, 255));
        ATRAS.setForeground(new java.awt.Color(153, 153, 255));
        ATRAS.setText("ATRAS");
        ATRAS.setBorder(null);
        ATRAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ATRASActionPerformed(evt);
            }
        });
        jPanel1.add(ATRAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 510, 124, 47));

        selectipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "seleccion", "libro", "audio libro" }));
        selectipo.setToolTipText("");
        selectipo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        selectipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectipoActionPerformed(evt);
            }
        });
        jPanel1.add(selectipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 136, -1, -1));

        GUARDAR.setBackground(new java.awt.Color(255, 255, 51));
        GUARDAR.setForeground(new java.awt.Color(255, 153, 0));
        GUARDAR.setText("GUARDAR");
        GUARDAR.setBorder(null);
        GUARDAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GUARDARActionPerformed(evt);
            }
        });
        jPanel1.add(GUARDAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 510, 116, 47));

        textidbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textidbnActionPerformed(evt);
            }
        });
        jPanel1.add(textidbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 109, 106, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ISBN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 75, 132, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("REGISTRO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 33, 163, 30));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TITULO");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 171, 59, -1));

        texttitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texttituloActionPerformed(evt);
            }
        });
        jPanel1.add(texttitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 193, 106, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("AUTOR");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 249, -1, -1));

        textautor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textautorActionPerformed(evt);
            }
        });
        jPanel1.add(textautor, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 271, 106, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("AÑO PUBLICACION");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 354, -1, -1));

        textañop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textañopActionPerformed(evt);
            }
        });
        textañop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textañopKeyTyped(evt);
            }
        });
        jPanel1.add(textañop, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 382, 106, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("COSTO");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 438, -1, -1));
        jPanel1.add(textcosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 466, 106, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("TIPO");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 113, -1, -1));

        panellibro.setBackground(new java.awt.Color(0, 51, 51));
        panellibro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("N° DE PAGINAS");
        panellibro.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 34, -1, -1));

        textnpajinas1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textnpajinas1KeyTyped(evt);
            }
        });
        panellibro.add(textnpajinas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 68, 103, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("N° DE EDICION");
        panellibro.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 141, -1, -1));

        textnedicion1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textnedicion1KeyTyped(evt);
            }
        });
        panellibro.add(textnedicion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 175, 103, -1));

        jPanel1.add(panellibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 195, 190, 280));

        panelaudiolibro.setBackground(new java.awt.Color(0, 51, 51));
        panelaudiolibro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("FORMATO");
        panelaudiolibro.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));
        panelaudiolibro.add(textformat, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 103, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("DURACION");
        panelaudiolibro.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));
        panelaudiolibro.add(textduracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 103, -1));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("PESO");
        panelaudiolibro.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        textpeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textpesoActionPerformed(evt);
            }
        });
        panelaudiolibro.add(textpeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 110, -1));

        jPanel1.add(panelaudiolibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 170, 280));

        limpiar.setBackground(new java.awt.Color(102, 255, 102));
        limpiar.setForeground(new java.awt.Color(0, 153, 0));
        limpiar.setText("LIMPIAR");
        limpiar.setBorder(null);
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });
        jPanel1.add(limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 510, 130, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ATRASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ATRASActionPerformed
        Libreria.fondo.setVisible(true);
    }//GEN-LAST:event_ATRASActionPerformed

    private void selectipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectipoActionPerformed

        if(selectipo.getSelectedItem().equals("audio libro"))
        {
            panellibro.setVisible(false);
            panelaudiolibro.setVisible(true);
        }
        if(selectipo.getSelectedItem().equals("libro"))
        {
            panellibro.setVisible(true);
            panelaudiolibro.setVisible(false);
        }
    }//GEN-LAST:event_selectipoActionPerformed

    private void textidbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textidbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textidbnActionPerformed

    private void texttituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texttituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texttituloActionPerformed

    private void textañopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textañopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textañopActionPerformed

    private void textautorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textautorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textautorActionPerformed

    private void textpesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textpesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textpesoActionPerformed

    private void GUARDARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GUARDARActionPerformed
        leerNuevaPublicacion();
        registrarPublicacion();
        textPublicaciones();
    }//GEN-LAST:event_GUARDARActionPerformed

    private void textañopKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textañopKeyTyped
        char validar = evt.getKeyChar();
        
        if (Character.isLetter(validar))
        {
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(this, "solo numeros en año pub.");
        }
    }//GEN-LAST:event_textañopKeyTyped

    private void textnpajinas1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textnpajinas1KeyTyped
        char validar = evt.getKeyChar();
        
        if (Character.isLetter(validar))
        {
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(this, "solo numeros en n° pajinas");
        }
    }//GEN-LAST:event_textnpajinas1KeyTyped

    private void textnedicion1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textnedicion1KeyTyped
        char validar = evt.getKeyChar();
        
        if (Character.isLetter(validar))
        {
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(this, "solo numeros en num edic.");
    }//GEN-LAST:event_textnedicion1KeyTyped
    }
    
    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        textidbn.setText("");
        texttitulo.setText("");
        textautor.setText("");
        textañop.setText("");
        textcosto.setText("");
        selectipo.setSelectedIndex(0);
        textnpajinas1.setText("");
        textnedicion1.setText("");
        textformat.setText("");
        textduracion.setText("");
        textpeso.setText("");
    }//GEN-LAST:event_limpiarActionPerformed

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ATRAS;
    private javax.swing.JButton GUARDAR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JButton limpiar;
    private javax.swing.JPanel panelaudiolibro;
    public static javax.swing.JPanel panellibro;
    private javax.swing.JComboBox<String> selectipo;
    private javax.swing.JTextField textautor;
    private javax.swing.JTextField textañop;
    private javax.swing.JTextField textcosto;
    private javax.swing.JTextField textduracion;
    private javax.swing.JTextField textformat;
    private javax.swing.JTextField textidbn;
    private javax.swing.JTextField textnedicion1;
    private javax.swing.JTextField textnpajinas1;
    private javax.swing.JTextField textpeso;
    private javax.swing.JTextField texttitulo;
    // End of variables declaration//GEN-END:variables
}
