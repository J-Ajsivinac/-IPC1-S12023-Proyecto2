package Interfaz;

import static Interfaz.Principal.logo;
import Modificadores.Acciones.*;

import Modificadores.JPEGHandler;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.io.File;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author mesoi
 */
public class Editor extends javax.swing.JFrame {

    private String ruta;
    private FlatSVGIcon.ColorFilter fl;

    /**
     * Creates new form Editor
     */
    public Editor() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Editor");
        this.setIconImage(logo.getImage());
        FlatSVGIcon imagenL = new FlatSVGIcon("img/imagen1.svg", 24, 24);
        FlatSVGIcon subirI = new FlatSVGIcon("img/subir.svg", 22, 22);
        fl = new FlatSVGIcon.ColorFilter(new Function<Color, Color>() {
            @Override
            public Color apply(Color t) {
                return Color.white;
            }

        });
        imagenL.setColorFilter(fl);
        subirI.setColorFilter(fl);
        btnSubir.setIcon(subirI);
        lblImagenLogo.setIcon(imagenL);
    }

    public void cargarImg() {
        ruta = "";
        JFileChooser archivos = new JFileChooser();
        FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JPG, JPEG & BMP", "jpg", "jpeg", "bmp");
        archivos.setFileFilter(filtrado);

        int respuesta = archivos.showOpenDialog(this);
        if (respuesta == archivos.APPROVE_OPTION) {
            lblNombreA.setText(archivos.getSelectedFile().getPath());
            ruta = archivos.getSelectedFile().getPath();
        }
    }

    public void seleccionar() {
        JLabel[] labels = {label1, label2, label3, label4, label5};
        JPanel[] paneles = {panel1, panel2, panel3, panel4, panel5};
        JCheckBox[] opciones = {check1, check2, check3, check4, check5};
        for (int i = 0; i < labels.length; i++) {
            if (opciones[i].isSelected()) {
                //labels[i].setForeground(Color.black);
                paneles[i].setBackground(new Color(57, 66, 89));
            } else {
                //labels[i].setForeground(Color.white);
                paneles[i].setBackground(new Color(31, 33, 37));
            }
        }
    }

    public void activar(JCheckBox caja) {
        caja.setSelected(!caja.isSelected());
        seleccionar();
    }

    public void ejecutar() throws Exception {
        if (ruta == null) {
            JOptionPane.showMessageDialog(null, "Seleccione una imagen");
            return;
        }

        JCheckBox[] opciones = {check1, check2, check3, check4, check5};
        int indiceInicial = ruta.lastIndexOf(".");
        String extension = ruta.substring(indiceInicial + 1, ruta.length());
        for (int i = 0; i < opciones.length; i++) {
            if (opciones[i].isSelected()) {
                switch (i) {
                    case 0:
                        File crear = new File(Principal.dir);
                        new File(crear.getParent()).mkdirs();
                        if (extension.equals("bmp")) {
                            BMPtoJPEGImage filtroConversion = new BMPtoJPEGImage(ruta);
                            JPEGHandler.runHandler(filtroConversion);
                        } else {
                            JPEGtoBMPImage filtroConversion1 = new JPEGtoBMPImage(ruta);
                            JPEGHandler.runHandler(filtroConversion1);
                        }
                        break;
                    case 1:
                        if (!extension.equals("bmp")) {
                            JPEGImageCopy fitroCopiar = new JPEGImageCopy(ruta);
                            JPEGHandler.runHandler(fitroCopiar);
                        }

                        break;
                    case 2:
                        if (!extension.equals("bmp")) {
                            JPEGImageHandlerColors filtroColores = new JPEGImageHandlerColors(ruta);
                            JPEGHandler.runHandler(filtroColores);
                        }
                        break;
                    case 3:
                        if (!extension.equals("bmp")) {
                            JPEGImageHandlerRotator filtroRotar = new JPEGImageHandlerRotator(ruta);
                            JPEGHandler.runHandler(filtroRotar);
                        }
                        break;
                    case 4:
                        if (!extension.equals("bmp")) {
                            JPEGImageHandlerBN filtroBN = new JPEGImageHandlerBN(ruta);
                            JPEGHandler.runHandler(filtroBN);
                        }
                        break;
                    default:
                        throw new AssertionError();
                }
            }
        }
        ruta = "";
        check1.setSelected(false);
        check2.setSelected(false);
        check3.setSelected(false);
        check4.setSelected(false);
        check5.setSelected(false);
        lblNombreA.setText("");
        JOptionPane.showMessageDialog(null, "Filtros Aplicados");

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
        panelRound1 = new Elementos.PanelRound();
        panel1 = new Elementos.PanelRound();
        label1 = new javax.swing.JLabel();
        check1 = new javax.swing.JCheckBox();
        panel2 = new Elementos.PanelRound();
        label2 = new javax.swing.JLabel();
        check2 = new javax.swing.JCheckBox();
        panel3 = new Elementos.PanelRound();
        label3 = new javax.swing.JLabel();
        check3 = new javax.swing.JCheckBox();
        panel4 = new Elementos.PanelRound();
        label4 = new javax.swing.JLabel();
        check4 = new javax.swing.JCheckBox();
        panel5 = new Elementos.PanelRound();
        label5 = new javax.swing.JLabel();
        check5 = new javax.swing.JCheckBox();
        jLabel19 = new javax.swing.JLabel();
        buttonRound2 = new Elementos.ButtonRound();
        panelRound2 = new Elementos.PanelRound();
        panelRound3 = new Elementos.PanelRound();
        lblImagenLogo = new javax.swing.JLabel();
        lblNombreA = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnSubir = new Elementos.ButtonRound();
        jLabel1 = new javax.swing.JLabel();
        buttonRound3 = new Elementos.ButtonRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(31, 33, 37));

        panelRound1.setBackground(new java.awt.Color(39, 44, 51));
        panelRound1.setForeground(new java.awt.Color(39, 44, 51));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);

        panel1.setBackground(new java.awt.Color(31, 33, 37));
        panel1.setForeground(new java.awt.Color(255, 0, 51));
        panel1.setRoundBottomLeft(12);
        panel1.setRoundBottomRight(12);
        panel1.setRoundTopLeft(12);
        panel1.setRoundTopRight(12);
        panel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel1MouseClicked(evt);
            }
        });

        label1.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("JPEG a BMP y Viceversa");

        check1.setBorder(null);
        check1.setPreferredSize(new java.awt.Dimension(25, 25));
        check1.setRequestFocusEnabled(false);
        check1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                check1ItemStateChanged(evt);
            }
        });
        check1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(check1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label1)
                .addContainerGap(292, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(check1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9))
        );

        panel2.setBackground(new java.awt.Color(31, 33, 37));
        panel2.setForeground(new java.awt.Color(33, 37, 43));
        panel2.setRoundBottomLeft(12);
        panel2.setRoundBottomRight(12);
        panel2.setRoundTopLeft(12);
        panel2.setRoundTopRight(12);
        panel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel2MouseClicked(evt);
            }
        });

        label2.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setText("copia JPEG");

        check2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                check2ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(check2)
                .addGap(18, 18, 18)
                .addComponent(label2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(check2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9))
        );

        panel3.setBackground(new java.awt.Color(31, 33, 37));
        panel3.setForeground(new java.awt.Color(33, 37, 43));
        panel3.setRoundBottomLeft(12);
        panel3.setRoundBottomRight(12);
        panel3.setRoundTopLeft(12);
        panel3.setRoundTopRight(12);
        panel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel3MouseClicked(evt);
            }
        });

        label3.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 255, 255));
        label3.setText("Rojo Verde Azu Sepia");

        check3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                check3ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(check3)
                .addGap(18, 18, 18)
                .addComponent(label3)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(check3, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panel4.setBackground(new java.awt.Color(31, 33, 37));
        panel4.setForeground(new java.awt.Color(33, 37, 43));
        panel4.setRoundBottomLeft(12);
        panel4.setRoundBottomRight(12);
        panel4.setRoundTopLeft(12);
        panel4.setRoundTopRight(12);
        panel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel4MouseClicked(evt);
            }
        });

        label4.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        label4.setForeground(new java.awt.Color(255, 255, 255));
        label4.setText("Modificar Imagen");

        check4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                check4ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(check4)
                .addGap(18, 18, 18)
                .addComponent(label4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label4, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(check4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9))
        );

        panel5.setBackground(new java.awt.Color(31, 33, 37));
        panel5.setForeground(new java.awt.Color(33, 37, 43));
        panel5.setRoundBottomLeft(12);
        panel5.setRoundBottomRight(12);
        panel5.setRoundTopLeft(12);
        panel5.setRoundTopRight(12);
        panel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel5MouseClicked(evt);
            }
        });

        label5.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        label5.setForeground(new java.awt.Color(255, 255, 255));
        label5.setText("Blanco y Negro");

        check5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                check5ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(check5)
                .addGap(18, 18, 18)
                .addComponent(label5)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(check5, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel19.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Seleccione las Opciones");

        buttonRound2.setForeground(new java.awt.Color(255, 255, 255));
        buttonRound2.setText("Ejecutar");
        buttonRound2.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        buttonRound2.setRadius(20);
        buttonRound2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound2ActionPerformed(evt);
            }
        });

        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);

        panelRound3.setBackground(new java.awt.Color(80, 89, 103));
        panelRound3.setRoundBottomLeft(12);
        panelRound3.setRoundBottomRight(12);
        panelRound3.setRoundTopLeft(12);
        panelRound3.setRoundTopRight(12);

        lblImagenLogo.setBackground(new java.awt.Color(234, 189, 159));
        lblImagenLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagenLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagenLogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        lblNombreA.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        lblNombreA.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNombreA, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombreA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel2.setOpaque(false);

        btnSubir.setForeground(new java.awt.Color(255, 255, 255));
        btnSubir.setAlignmentX(0.5F);
        btnSubir.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        btnSubir.setRadius(15);
        btnSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSubir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSubir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Elija la Imagen");

        buttonRound3.setForeground(new java.awt.Color(184, 192, 230));
        buttonRound3.setText("Regresar");
        buttonRound3.setBorderColor(new java.awt.Color(20, 26, 31));
        buttonRound3.setColor(new java.awt.Color(20, 26, 31));
        buttonRound3.setColorClick(new java.awt.Color(37, 51, 63));
        buttonRound3.setColorOver(new java.awt.Color(26, 35, 43));
        buttonRound3.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        buttonRound3.setRadius(12);
        buttonRound3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(buttonRound2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonRound3, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(buttonRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRound3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound3ActionPerformed
        // TODO add your handling code here:
        Principal p = new Principal();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonRound3ActionPerformed

    private void check1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check1ActionPerformed

    private void btnSubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirActionPerformed
        // TODO add your handling code here:
        cargarImg();
    }//GEN-LAST:event_btnSubirActionPerformed

    private void buttonRound2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound2ActionPerformed
        try {
            // TODO add your handling code here:
            ejecutar();
        } catch (Exception ex) {
            Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonRound2ActionPerformed

    private void panel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1MouseClicked
        // TODO add your handling code here:
        activar(check1);
    }//GEN-LAST:event_panel1MouseClicked

    private void check1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_check1ItemStateChanged
        // TODO add your handling code here:
        seleccionar();
    }//GEN-LAST:event_check1ItemStateChanged

    private void panel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel2MouseClicked
        // TODO add your handling code here:
        activar(check2);
    }//GEN-LAST:event_panel2MouseClicked

    private void panel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel3MouseClicked
        // TODO add your handling code here:
        activar(check3);
    }//GEN-LAST:event_panel3MouseClicked

    private void panel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel4MouseClicked
        // TODO add your handling code here:
        activar(check4);
    }//GEN-LAST:event_panel4MouseClicked

    private void panel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel5MouseClicked
        // TODO add your handling code here:
        activar(check5);
    }//GEN-LAST:event_panel5MouseClicked

    private void check2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_check2ItemStateChanged
        // TODO add your handling code here:
        seleccionar();
    }//GEN-LAST:event_check2ItemStateChanged

    private void check3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_check3ItemStateChanged
        // TODO add your handling code here:
        seleccionar();
    }//GEN-LAST:event_check3ItemStateChanged

    private void check4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_check4ItemStateChanged
        // TODO add your handling code here:
        seleccionar();
    }//GEN-LAST:event_check4ItemStateChanged

    private void check5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_check5ItemStateChanged
        // TODO add your handling code here:
        seleccionar();
    }//GEN-LAST:event_check5ItemStateChanged

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
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Editor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Elementos.ButtonRound btnSubir;
    private Elementos.ButtonRound buttonRound2;
    private Elementos.ButtonRound buttonRound3;
    private javax.swing.JCheckBox check1;
    private javax.swing.JCheckBox check2;
    private javax.swing.JCheckBox check3;
    private javax.swing.JCheckBox check4;
    private javax.swing.JCheckBox check5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel lblImagenLogo;
    private javax.swing.JLabel lblNombreA;
    private Elementos.PanelRound panel1;
    private Elementos.PanelRound panel2;
    private Elementos.PanelRound panel3;
    private Elementos.PanelRound panel4;
    private Elementos.PanelRound panel5;
    private Elementos.PanelRound panelRound1;
    private Elementos.PanelRound panelRound2;
    private Elementos.PanelRound panelRound3;
    // End of variables declaration//GEN-END:variables
}
