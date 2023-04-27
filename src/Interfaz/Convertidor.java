package Interfaz;

import Modificadores.MisClases.DatosCategoria;
import Modificadores.MisClases.ListaSimple;
import Modificadores.MisClases.Usuario;
import Modificadores.MisClases.ctrlUsuario;
import Modificadores.MisClases.ejecutarP;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.function.Function;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author mesoi
 */
public class Convertidor extends javax.swing.JFrame {

    private FlatSVGIcon.ColorFilter fl;
    public static DefaultListModel<String> model = new DefaultListModel<>();
    public static DefaultListModel<String> modelA = new DefaultListModel<>();
    public static DefaultListModel<String> nombres = new DefaultListModel<>();
    public static ListaSimple<String> listaP = new ListaSimple<>();
    public static ListaSimple<Integer> op = new ListaSimple<>();
    public static ArrayList<Integer> cantidad = new ArrayList<>();
    public static int total;

    /**
     * Creates new form Convertidor
     */
    public Convertidor() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Convertidor");
        consola.putClientProperty("JComponent.roundRect", true);
        progreso.setStringPainted(true);
        FlatSVGIcon add = new FlatSVGIcon("img/add.svg", 12, 12);
        fl = new FlatSVGIcon.ColorFilter(new Function<Color, Color>() {
            @Override
            public Color apply(Color t) {
                return new Color(25, 33, 40);
            }

        });
        add.setColorFilter(fl);
        btnagregar.setIcon(add);
        cargarUsuarios();
        procesamiento.setFocusable(false);
        procesamiento.disable();
        consola.setFocusable(false);
        //cargarCategoriasU();
    }

    public void cargarUsuarios() {
        comboUsuarios.removeAllItems();
        for (int i = 0; i < ctrlUsuario.usuarios.getSize(); i++) {
            Usuario temp = (Usuario) ctrlUsuario.usuarios.get(i);
            comboUsuarios.addItem(temp.getNombre());
        }
    }

    public void cargarCategoriasU() {
        comboCategorias.removeAllItems();
        int seleccion = comboUsuarios.getSelectedIndex();
        Usuario temp = (Usuario) ctrlUsuario.usuarios.get(seleccion);
        if (temp != null) {
            for (int i = 0; i < temp.getCategoria().size(); i++) {
                DatosCategoria dTemp = temp.getCategoria().get(i);
                comboCategorias.addItem(dTemp.getNombreCategoria());
            }
        }
    }

    public void agregarCola() {

        int usuarioS = comboUsuarios.getSelectedIndex();
        int categoriaS = comboCategorias.getSelectedIndex();

        Usuario temp = (Usuario) ctrlUsuario.usuarios.get(usuarioS);
        DatosCategoria dTemp = temp.getCategoria().get(categoriaS);
        
        for (int i = 0; i < nombres.size(); i++) {
            String[] datos = nombres.getElementAt(i).split(",");
           
            if (datos[0].equals(temp.getNombre()) && datos[1].equals(dTemp.getNombreCategoria())) {
                JOptionPane.showMessageDialog(null, "Este Usuario y Categoría ya se han agregado");
                return;
            }
        }

        
        nombres.addElement(temp.getNombre() + "," + dTemp.getNombreCategoria());
        if (dTemp.getImgCategoria().getSize() == 0) {
            JOptionPane.showMessageDialog(null, "No hay imagenes para procesar");
            return;
        }
        for (int i = 0; i < dTemp.getImgCategoria().getSize(); i++) {

            File fTemp = new File(dTemp.getImgCategoria().get(i) + "");
            model.addElement(fTemp.getName() + "");
            modelA.addElement(fTemp.getPath() + "");
            cantidad.add(0);
        }
        total = model.size();
        procesamiento.setModel(model);
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

    public void ejecutarFiltros() {
        progreso.setValue(0);
        JCheckBox[] opciones = {check1, check2, check3, check4, check5};

        for (int i = 0; i < opciones.length; i++) {
            if (opciones[i].isSelected()) {
                switch (i) {
                    case 0:
                        for (int j = 0; j < modelA.size(); j++) {
                            listaP.add(modelA.get(j));
                            op.add(i + 1);

                        }
                        break;
                    case 1:
                        for (int j = 0; j < modelA.size(); j++) {
                            listaP.add(modelA.get(j));
                            op.add(i + 1);
                        }
                        break;
                    case 2:
                        for (int j = 0; j < modelA.size(); j++) {
                            listaP.add(modelA.get(j));
                            op.add(i + 1);
                        }
                        break;
                    case 3:
                        for (int j = 0; j < modelA.size(); j++) {
                            listaP.add(modelA.get(j));
                            op.add(i + 1);
                        }
                        break;
                    case 4:
                        for (int j = 0; j < modelA.size(); j++) {
                            listaP.add(modelA.get(j));
                            op.add(i + 1);
                        }
                        break;
                    default:
                        throw new AssertionError();
                }
            }
        }

        for (int i = 0; i < listaP.getSize(); i++) {
            new ejecutarP((int) op.get(i), (String) listaP.get(i), listaP.getSize()).start();
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
        panelRound1 = new Elementos.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        comboUsuarios = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        comboCategorias = new javax.swing.JComboBox<>();
        btnagregar = new Elementos.ButtonRound();
        panelRound2 = new Elementos.PanelRound();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        procesamiento = new javax.swing.JList<>();
        buttonRound1 = new Elementos.ButtonRound();
        panelRound3 = new Elementos.PanelRound();
        panel1 = new Elementos.PanelRound();
        label1 = new javax.swing.JLabel();
        check1 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        panel3 = new Elementos.PanelRound();
        label3 = new javax.swing.JLabel();
        check3 = new javax.swing.JCheckBox();
        panel2 = new Elementos.PanelRound();
        label2 = new javax.swing.JLabel();
        check2 = new javax.swing.JCheckBox();
        panel5 = new Elementos.PanelRound();
        label5 = new javax.swing.JLabel();
        check5 = new javax.swing.JCheckBox();
        panel4 = new Elementos.PanelRound();
        label4 = new javax.swing.JLabel();
        check4 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        buttonRound2 = new Elementos.ButtonRound();
        progreso = new javax.swing.JProgressBar();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        consola = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(31, 33, 37));

        panelRound1.setBackground(new java.awt.Color(39, 44, 51));
        panelRound1.setForeground(new java.awt.Color(39, 44, 51));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario:");

        comboUsuarios.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        comboUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        comboUsuarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboUsuarios.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboUsuariosItemStateChanged(evt);
            }
        });
        comboUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboUsuariosActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Categoría:");

        comboCategorias.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        comboCategorias.setForeground(new java.awt.Color(255, 255, 255));
        comboCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnagregar.setForeground(new java.awt.Color(25, 33, 40));
        btnagregar.setText(" Agregar");
        btnagregar.setBorderColor(new java.awt.Color(53, 223, 145));
        btnagregar.setColor(new java.awt.Color(53, 223, 145));
        btnagregar.setColorClick(new java.awt.Color(62, 182, 127));
        btnagregar.setColorOver(new java.awt.Color(61, 203, 138));
        btnagregar.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        btnagregar.setRadius(12);
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(comboCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(comboUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(comboCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panelRound2.setBackground(new java.awt.Color(39, 44, 51));
        panelRound2.setForeground(new java.awt.Color(39, 44, 51));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cola de Procesamiento");

        procesamiento.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        procesamiento.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(procesamiento);

        buttonRound1.setForeground(new java.awt.Color(184, 192, 230));
        buttonRound1.setText("Regresar");
        buttonRound1.setBorderColor(new java.awt.Color(20, 26, 31));
        buttonRound1.setColor(new java.awt.Color(20, 26, 31));
        buttonRound1.setColorClick(new java.awt.Color(37, 51, 63));
        buttonRound1.setColorOver(new java.awt.Color(26, 35, 43));
        buttonRound1.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        buttonRound1.setRadius(12);
        buttonRound1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 42, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        panelRound3.setBackground(new java.awt.Color(39, 44, 51));
        panelRound3.setForeground(new java.awt.Color(39, 44, 51));
        panelRound3.setRoundBottomLeft(20);
        panelRound3.setRoundBottomRight(20);
        panelRound3.setRoundTopLeft(20);
        panelRound3.setRoundTopRight(20);

        panel1.setBackground(new java.awt.Color(31, 33, 37));
        panel1.setForeground(new java.awt.Color(33, 37, 43));
        panel1.setRoundBottomLeft(20);
        panel1.setRoundBottomRight(20);
        panel1.setRoundTopLeft(20);
        panel1.setRoundTopRight(20);
        panel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel1MouseClicked(evt);
            }
        });

        label1.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("JPEG a BMP y Viceversa");

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
                .addGap(14, 14, 14)
                .addComponent(check1)
                .addGap(18, 18, 18)
                .addComponent(label1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(check1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(9, 9, 9))
        );

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Seleccione las Opciones");

        panel3.setBackground(new java.awt.Color(31, 33, 37));
        panel3.setForeground(new java.awt.Color(33, 37, 43));
        panel3.setRoundBottomLeft(20);
        panel3.setRoundBottomRight(20);
        panel3.setRoundTopLeft(20);
        panel3.setRoundTopRight(20);
        panel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel3MouseClicked(evt);
            }
        });

        label3.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 255, 255));
        label3.setText("Rojo Verde Azul Sepia");

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
                .addGap(14, 14, 14)
                .addComponent(check3)
                .addGap(18, 18, 18)
                .addComponent(label3)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(check3, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(9, 9, 9))
        );

        panel2.setBackground(new java.awt.Color(31, 33, 37));
        panel2.setForeground(new java.awt.Color(33, 37, 43));
        panel2.setRoundBottomLeft(20);
        panel2.setRoundBottomRight(20);
        panel2.setRoundTopLeft(20);
        panel2.setRoundTopRight(20);
        panel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel2MouseClicked(evt);
            }
        });

        label2.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setText("Copia JPEG                  ");

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
                .addGap(14, 14, 14)
                .addComponent(check2)
                .addGap(18, 18, 18)
                .addComponent(label2)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(check2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panel5.setBackground(new java.awt.Color(31, 33, 37));
        panel5.setForeground(new java.awt.Color(33, 37, 43));
        panel5.setRoundBottomLeft(20);
        panel5.setRoundBottomRight(20);
        panel5.setRoundTopLeft(20);
        panel5.setRoundTopRight(20);
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
                .addGap(14, 14, 14)
                .addComponent(check5)
                .addGap(18, 18, 18)
                .addComponent(label5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(check5, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(label5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9))
        );

        panel4.setBackground(new java.awt.Color(31, 33, 37));
        panel4.setForeground(new java.awt.Color(33, 37, 43));
        panel4.setRoundBottomLeft(20);
        panel4.setRoundBottomRight(20);
        panel4.setRoundTopLeft(20);
        panel4.setRoundTopRight(20);
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
                .addGap(14, 14, 14)
                .addComponent(check4)
                .addGap(18, 18, 18)
                .addComponent(label4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(check4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel10.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Seleccione el tipo de Ejecución");

        buttonRound2.setForeground(new java.awt.Color(255, 255, 255));
        buttonRound2.setText("Ejecutar en Paralelo");
        buttonRound2.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        buttonRound2.setRadius(20);
        buttonRound2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRound2ActionPerformed(evt);
            }
        });

        progreso.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        progreso.setBorder(null);

        jLabel12.setFont(new java.awt.Font("Montserrat", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Consola de Ejecución");

        consola.setEditable(false);
        consola.setColumns(20);
        consola.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        consola.setRows(5);
        jScrollPane2.setViewportView(consola);

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                    .addComponent(progreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel12)
                        .addComponent(jLabel10)
                        .addGroup(panelRound3Layout.createSequentialGroup()
                            .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(panel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonRound2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(progreso, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboUsuariosActionPerformed

    private void check1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check1ActionPerformed

    private void comboUsuariosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboUsuariosItemStateChanged
        // TODO add your handling code here:
        cargarCategoriasU();
    }//GEN-LAST:event_comboUsuariosItemStateChanged

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        // TODO add your handling code here:
        agregarCola();
    }//GEN-LAST:event_btnagregarActionPerformed

    private void buttonRound2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound2ActionPerformed
        // TODO add your handling code here:
        ejecutarFiltros();
    }//GEN-LAST:event_buttonRound2ActionPerformed

    private void buttonRound1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRound1ActionPerformed
        // TODO add your handling code here:
        Principal p = new Principal();
        p.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_buttonRound1ActionPerformed

    private void panel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1MouseClicked
        // TODO add your handling code here:
        activar(check1);
    }//GEN-LAST:event_panel1MouseClicked

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

    private void check1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_check1ItemStateChanged
        // TODO add your handling code here:
        seleccionar();
    }//GEN-LAST:event_check1ItemStateChanged

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
            java.util.logging.Logger.getLogger(Convertidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Convertidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Convertidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Convertidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Convertidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Elementos.ButtonRound btnagregar;
    private Elementos.ButtonRound buttonRound1;
    private Elementos.ButtonRound buttonRound2;
    private javax.swing.JCheckBox check1;
    private javax.swing.JCheckBox check2;
    private javax.swing.JCheckBox check3;
    private javax.swing.JCheckBox check4;
    private javax.swing.JCheckBox check5;
    private javax.swing.JComboBox<String> comboCategorias;
    private javax.swing.JComboBox<String> comboUsuarios;
    public static javax.swing.JTextArea consola;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private Elementos.PanelRound panel1;
    private Elementos.PanelRound panel2;
    private Elementos.PanelRound panel3;
    private Elementos.PanelRound panel4;
    private Elementos.PanelRound panel5;
    private Elementos.PanelRound panelRound1;
    private Elementos.PanelRound panelRound2;
    private Elementos.PanelRound panelRound3;
    private javax.swing.JList<String> procesamiento;
    public static javax.swing.JProgressBar progreso;
    // End of variables declaration//GEN-END:variables
}
