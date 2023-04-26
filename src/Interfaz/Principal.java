package Interfaz;

import Modificadores.Acciones.BMPtoJPEGImage;
import Modificadores.Acciones.JPEGImageHandlerColors;
import Modificadores.Acciones.JPEGtoBMPImage;
import Modificadores.BmpHandlerCopy;
import Modificadores.JPEGHandler;
import Modificadores.MisClases.ListaSimple;
import Modificadores.MisClases.Usuario;
import Modificadores.MisClases.ctrlUsuario;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author mesoi
 */
public class Principal extends javax.swing.JFrame {

    public static Usuario credencial = null;
    public static int posicion = -1;
    public static String direccion = "C:\\Users\\mesoi\\Documents\\Prueba";
    public static String nombreArchivo = "alumnos.txt";
    public static String dir = "C:/Users/mesoi/Documents/Prueba/Temporal/";
    private FlatSVGIcon.ColorFilter fl;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        verificar();
        
        FlatSVGIcon biblioteca = new FlatSVGIcon("img/biblioteca.svg", 15, 15);
        FlatSVGIcon editor = new FlatSVGIcon("img/editar.svg", 18, 18);
        FlatSVGIcon convertidor = new FlatSVGIcon("img/convertidor.svg", 16, 16);
        fl = new FlatSVGIcon.ColorFilter(new Function<Color, Color>() {
            @Override
            public Color apply(Color t) {
                return Color.white;
            }

        });
        biblioteca.setColorFilter(fl);
        editor.setColorFilter(fl);
        convertidor.setColorFilter(fl);
        buttonRound1.setIcon(biblioteca);
        buttonRound3.setIcon(editor);
        buttonRound2.setIcon(convertidor);
    }

    public void verificar() {
        File archivo = new File(direccion, nombreArchivo);
        if (archivo.exists()) {
            try {
                FileInputStream archivoEntrada = new FileInputStream("C:\\Users\\mesoi\\Documents\\Prueba\\alumnos.txt");
                ObjectInputStream objetoEntrada = new ObjectInputStream(archivoEntrada);
                ListaSimple<Usuario> lista = (ListaSimple<Usuario>) objetoEntrada.readObject();
                ctrlUsuario.usuarios = lista;
            } catch (Exception e) {

            }
        }
    }

    public void iniciarSesion() {
        if (!txtNombreU.getText().trim().isEmpty()) {
            String nombre = txtNombreU.getText();
            Usuario nuevoUsuario = new Usuario(nombre);
            Usuario busqueda = ctrlUsuario.obtenerLista().find(nuevoUsuario);
            if (busqueda == null) {
                ctrlUsuario.nuevoUsuario(nombre);
                credencial = nuevoUsuario;
                File archivo = new File(direccion, nombreArchivo);
                if (!archivo.exists()) {
                    serializar();
                } else {
                    serializar();
                }

            } else {
                credencial = (Usuario) ctrlUsuario.obtenerLista().find(nuevoUsuario);
            }
            posicion = ctrlUsuario.posicionUsuario(nombre);
            Biblioteca b = new Biblioteca();
            b.setVisible(true);
            this.dispose();
            ctrlUsuario.obtenerLista().imprimirLista();
        } else {
            JOptionPane.showMessageDialog(null, "No se ingreso ningún nombre");
        }
    }

    public void serializar() {
        try {
            FileOutputStream archivoSalida = new FileOutputStream("C:\\Users\\mesoi\\Documents\\Prueba\\alumnos.txt");
            ObjectOutputStream objetoSalida = new ObjectOutputStream(archivoSalida);
            objetoSalida.writeObject(ctrlUsuario.obtenerLista());
            objetoSalida.close();
            archivoSalida.close();
            System.out.println("El ArrayList de Alumnos ha sido serializado y guardado en alumnos.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ingresaraSerie() {
        try {
            FileInputStream archivoEntrada = new FileInputStream("C:\\Users\\mesoi\\Documents\\Prueba\\alumnos.txt");
            ObjectInputStream objetoEntrada = new ObjectInputStream(archivoEntrada);
            ListaSimple<Usuario> lista = (ListaSimple<Usuario>) objetoEntrada.readObject();

            objetoEntrada.close();
            archivoEntrada.close();
            System.out.println("El ArrayList de Alumnos ha sido deserializado desde alumnos.ser");
            System.out.println("Lista de Alumnos deserializada: ");

            // Serializar nuevamente el ArrayList actualizado y guardarlo en el archivo
            FileOutputStream archivoSalida2 = new FileOutputStream("alumnos.ser");
            ObjectOutputStream objetoSalida2 = new ObjectOutputStream(archivoSalida2);
            objetoSalida2.writeObject(lista);
            objetoSalida2.close();
            archivoSalida2.close();
            System.out.println("Se ha agregado un nuevo alumno a la serialización.");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deserializar() {
        try {
            FileInputStream archivoEntrada = new FileInputStream("C:\\Users\\mesoi\\Documents\\Prueba\\alumnos.txt");
            ObjectInputStream objetoEntrada = new ObjectInputStream(archivoEntrada);
            ListaSimple<Usuario> lista = (ListaSimple<Usuario>) objetoEntrada.readObject();

            objetoEntrada.close();
            archivoEntrada.close();
            System.out.println("El ArrayList de Alumnos ha sido deserializado desde alumnos.ser");
            System.out.println("Lista de Alumnos deserializada: ");
            for (int i = 0; i < lista.getSize(); i++) {
                Usuario temp = (Usuario) lista.get(i);
                System.out.println(temp.getNombre());
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void test() {
        try {
            // Crear un objeto BmpHandlerCopy con el nombre del archivo original
            JPEGImageHandlerColors bmpHandlerCopy = new JPEGImageHandlerColors("C:\\Users\\mesoi\\Documents\\Prueba\\CC.jpg");
            JPEGHandler.runHandler(bmpHandlerCopy);

            System.out.println("Archivo de copia generado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreU = new javax.swing.JTextField();
        buttonRound1 = new Elementos.ButtonRound();
        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        buttonRound2 = new Elementos.ButtonRound();
        buttonRound3 = new Elementos.ButtonRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(31, 33, 37));

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ugallery");

        jPanel2.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario");

        txtNombreU.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        txtNombreU.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUActionPerformed(evt);
            }
        });

        buttonRound1.setBorder(null);
        buttonRound1.setForeground(new java.awt.Color(255, 255, 255));
        buttonRound1.setText(" Ingresar a Biblioteca");
        buttonRound1.setBorderColor(new java.awt.Color(35, 113, 248));
        buttonRound1.setColor(new java.awt.Color(35, 113, 248));
        buttonRound1.setColorClick(new java.awt.Color(54, 115, 192));
        buttonRound1.setColorOver(new java.awt.Color(70, 126, 196));
        buttonRound1.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        buttonRound1.setRadius(20);
        buttonRound1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreU)
                    .addComponent(buttonRound1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreU, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel3.setOpaque(false);

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Montserrat", 3, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("o");

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );

        jPanel4.setOpaque(false);

        buttonRound2.setForeground(new java.awt.Color(255, 255, 255));
        buttonRound2.setText("Convertidor");
        buttonRound2.setColorClick(new java.awt.Color(94, 82, 203));
        buttonRound2.setColorOver(new java.awt.Color(105, 93, 209));
        buttonRound2.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        buttonRound2.setRadius(20);
        buttonRound2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound2ActionPerformed(evt);
            }
        });

        buttonRound3.setForeground(new java.awt.Color(255, 255, 255));
        buttonRound3.setText("Editor");
        buttonRound3.setColorClick(new java.awt.Color(94, 82, 203));
        buttonRound3.setColorOver(new java.awt.Color(105, 93, 209));
        buttonRound3.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        buttonRound3.setRadius(20);
        buttonRound3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonRound2, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(buttonRound3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonRound2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreUActionPerformed

    private void buttonRound1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound1ActionPerformed
        // TODO add your handling code here:
        iniciarSesion();
    }//GEN-LAST:event_buttonRound1ActionPerformed

    private void buttonRound3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound3ActionPerformed
        // TODO add your handling code here:
        //System.out.println(usuarios.getSize());
        Editor e = new Editor();
        e.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonRound3ActionPerformed

    private void buttonRound2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound2ActionPerformed
        // TODO add your handling code here:
        //deserealizar();
        Convertidor c = new Convertidor();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonRound2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            UIManager.setLookAndFeel(new FlatOneDarkIJTheme());
            //UIManager.put("TextComponent.arc", 999);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>   
        UIManager.put("List.selectionBackground", new Color(97, 93, 133));
        UIManager.put("Component.focusedBorderColor", new Color(133, 119, 240));
        UIManager.put("List.selectionInactiveBackground", new Color(58, 60, 82));
        UIManager.put("List.cellMargins", new Insets(5, 5, 5, 5));
        
        UIManager.put("ProgressBar.foreground", new Color(115, 218, 190));
        UIManager.put("ProgressBar.selectionBackground", new Color(115, 218, 190));
        UIManager.put("ProgressBar.selectionForeground", new Color(29, 29, 38));
        UIManager.put("ProgressBar.arc", 10);
        
        UIManager.put("CheckBox.icon.selectedBorderColor", new Color(189, 121, 75));

        UIManager.put("CheckBox.icon.focusColor", new Color(14, 189, 246));
        UIManager.put("CheckBox.icon.selectedBackground", new Color(255, 255, 255));

        UIManager.put("CheckBox.icon.checkmarkColor", new Color(30, 31, 40));
        UIManager.put("CheckBox.icon.background", new Color(52, 56, 57));
        UIManager.put("CheckBox.icon.borderWidth", 0);

        UIManager.put("Component.arrowType", "chevron");
        UIManager.put("ComboBox.buttonStyle", "chevron");
        UIManager.put("TitlePane.font", new Font("Montserrat", 0, 13));
        UIManager.put("Component.arc", 12);
        UIManager.put("TextComponent.arc", 12);
        UIManager.put("TextArea.arc", 12);
        UIManager.put("TextArea.margin", new Insets(7, 7, 7, 7));
        UIManager.put("defaultFont", new Font("Montserrat", 0, 13));
        
        //84f2a7 132, 242, 167 rgb(42, 48, 53)
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Elementos.ButtonRound buttonRound1;
    private Elementos.ButtonRound buttonRound2;
    private Elementos.ButtonRound buttonRound3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtNombreU;
    // End of variables declaration//GEN-END:variables
}
