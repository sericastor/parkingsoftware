package view;

import controller.ExitController;
import controller.LogoutController;
import controller.MainController;
import controller.ParkingController;
import edu.stanford.ejalbert.BrowserLauncher;
import edu.stanford.ejalbert.exception.BrowserLaunchingInitializingException;
import edu.stanford.ejalbert.exception.UnsupportedOperatingSystemException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author r4wd3r
 */
public class MainView extends javax.swing.JFrame {

    /** Creates new form MainFrame */
    
    public MainView() {
        ImageIcon img=new ImageIcon("src/images/parking1.gif"); 
         setIconImage(img.getImage()); 
        initComponents();
        this.setResizable(false);
        PlateTextField.requestFocus();        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        DataEntryPanel = new javax.swing.JPanel();
        PlateTextField = new javax.swing.JTextField();
        PlateLabel = new javax.swing.JLabel();
        SearchButton = new javax.swing.JButton();
        OptionsPanel = new javax.swing.JPanel();
        ExitButton = new javax.swing.JButton();
        LogoutButton = new javax.swing.JButton();
        ParkingPanel = new javax.swing.JPanel();
        CloseBoxButton = new javax.swing.JButton();
        AdministerButton = new javax.swing.JButton();
        ParkQuickLabel = new javax.swing.JLabel();
        AoQPanel = new javax.swing.JPanel();
        ClockPanel = new javax.swing.JPanel();
        ClockLabel = new javax.swing.JLabel();
        StateTabbed = new javax.swing.JTabbedPane();
        EntryPanel = new javax.swing.JPanel();
        ExitPanel = new javax.swing.JPanel();
        FacturePanel = new javax.swing.JPanel();
        FactureTurnPanel = new javax.swing.JPanel();
        VehicleTypePanel = new javax.swing.JPanel();
        MenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        AdministerMenu = new javax.swing.JMenuItem();
        GenerateReportsMenu = new javax.swing.JMenuItem();
        FileSeparator1 = new javax.swing.JPopupMenu.Separator();
        CloseBoxMenu = new javax.swing.JMenuItem();
        FileSeparator2 = new javax.swing.JPopupMenu.Separator();
        LogoutMenu = new javax.swing.JMenuItem();
        ExitMenu = new javax.swing.JMenuItem();
        EditMenu = new javax.swing.JMenu();
        UndoMenu = new javax.swing.JMenuItem();
        EditSeparator1 = new javax.swing.JPopupMenu.Separator();
        CutMenu = new javax.swing.JMenuItem();
        CopyMenu = new javax.swing.JMenuItem();
        PasteMenu = new javax.swing.JMenuItem();
        DeleteMenu = new javax.swing.JMenuItem();
        ViewMenu = new javax.swing.JMenu();
        HelpMenu = new javax.swing.JMenu();
        ViewHelpMenu = new javax.swing.JMenuItem();
        HelpSeparator1 = new javax.swing.JPopupMenu.Separator();
        AboutEParkingMenu = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ChiquiParking");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        DataEntryPanel.setBackground(new java.awt.Color(255, 255, 255));

        PlateTextField.setFont(new java.awt.Font("Book Antiqua", 0, 36)); // NOI18N
        PlateTextField.setToolTipText("Ingrese la placa del vehiculo");
        PlateTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PlateTextFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PlateTextFieldKeyReleased(evt);
            }
        });

        PlateLabel.setFont(new java.awt.Font("Tahoma", 0, 20));
        PlateLabel.setText("Placa:");

        SearchButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SearchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search.png"))); // NOI18N
        SearchButton.setToolTipText("Pulse aquí para buscar el vehículo.");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DataEntryPanelLayout = new javax.swing.GroupLayout(DataEntryPanel);
        DataEntryPanel.setLayout(DataEntryPanelLayout);
        DataEntryPanelLayout.setHorizontalGroup(
            DataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataEntryPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(PlateLabel)
                .addGap(18, 18, 18)
                .addComponent(PlateTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(SearchButton)
                .addContainerGap())
        );
        DataEntryPanelLayout.setVerticalGroup(
            DataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataEntryPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DataEntryPanelLayout.createSequentialGroup()
                        .addComponent(PlateLabel)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DataEntryPanelLayout.createSequentialGroup()
                        .addGroup(DataEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PlateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchButton))
                        .addGap(20, 20, 20))))
        );

        OptionsPanel.setBackground(new java.awt.Color(255, 255, 255));

        ExitButton.setFont(new java.awt.Font("Tahoma", 0, 14));
        ExitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Close.png"))); // NOI18N
        ExitButton.setText("  Salir");
        ExitButton.setToolTipText("Pulse aquí para salir.");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        LogoutButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LogoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Stop.png"))); // NOI18N
        LogoutButton.setText("Cerrar Sesión");
        LogoutButton.setToolTipText("Pulse aquí para cerrar sesión.");
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout OptionsPanelLayout = new javax.swing.GroupLayout(OptionsPanel);
        OptionsPanel.setLayout(OptionsPanelLayout);
        OptionsPanelLayout.setHorizontalGroup(
            OptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OptionsPanelLayout.createSequentialGroup()
                .addContainerGap(777, Short.MAX_VALUE)
                .addComponent(LogoutButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        OptionsPanelLayout.setVerticalGroup(
            OptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OptionsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(OptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LogoutButton))
                .addContainerGap())
        );

        ParkingPanel.setBackground(new java.awt.Color(254, 254, 254));
        ParkingPanel.setForeground(new java.awt.Color(1, 1, 1));

        CloseBoxButton.setFont(new java.awt.Font("Tahoma", 0, 14));
        CloseBoxButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Box.png"))); // NOI18N
        CloseBoxButton.setText("Cerrar Turno");
        CloseBoxButton.setToolTipText("Pulse aquí para cerrar su turno.");
        CloseBoxButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseBoxButtonActionPerformed(evt);
            }
        });

        AdministerButton.setFont(new java.awt.Font("Tahoma", 0, 14));
        AdministerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tools.png"))); // NOI18N
        AdministerButton.setText("Administración");
        AdministerButton.setToolTipText("Pulse aquí para configurar el sistema (Sólo administrador)");
        AdministerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdministerButtonActionPerformed(evt);
            }
        });

        ParkQuickLabel.setFont(new java.awt.Font("Tahoma", 0, 48));
        ParkQuickLabel.setForeground(new java.awt.Color(51, 102, 0));
        ParkQuickLabel.setText("ParkQuick");

        javax.swing.GroupLayout ParkingPanelLayout = new javax.swing.GroupLayout(ParkingPanel);
        ParkingPanel.setLayout(ParkingPanelLayout);
        ParkingPanelLayout.setHorizontalGroup(
            ParkingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ParkingPanelLayout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(ParkQuickLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 369, Short.MAX_VALUE)
                .addComponent(AdministerButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CloseBoxButton, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        ParkingPanelLayout.setVerticalGroup(
            ParkingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ParkingPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ParkingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CloseBoxButton)
                    .addComponent(AdministerButton)
                    .addComponent(ParkQuickLabel))
                .addContainerGap())
        );

        AoQPanel.setBackground(new java.awt.Color(254, 254, 254));

        javax.swing.GroupLayout AoQPanelLayout = new javax.swing.GroupLayout(AoQPanel);
        AoQPanel.setLayout(AoQPanelLayout);
        AoQPanelLayout.setHorizontalGroup(
            AoQPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
        );
        AoQPanelLayout.setVerticalGroup(
            AoQPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 305, Short.MAX_VALUE)
        );

        ClockPanel.setBackground(new java.awt.Color(254, 254, 254));

        ClockLabel.setFont(new java.awt.Font("Bell MT", 2, 36)); // NOI18N
        ClockLabel.setToolTipText("Hora actual.");

        javax.swing.GroupLayout ClockPanelLayout = new javax.swing.GroupLayout(ClockPanel);
        ClockPanel.setLayout(ClockPanelLayout);
        ClockPanelLayout.setHorizontalGroup(
            ClockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ClockPanelLayout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(ClockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        ClockPanelLayout.setVerticalGroup(
            ClockPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClockPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(ClockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        EntryPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout EntryPanelLayout = new javax.swing.GroupLayout(EntryPanel);
        EntryPanel.setLayout(EntryPanelLayout);
        EntryPanelLayout.setHorizontalGroup(
            EntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
        );
        EntryPanelLayout.setVerticalGroup(
            EntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );

        StateTabbed.addTab("Entradas", EntryPanel);

        ExitPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout ExitPanelLayout = new javax.swing.GroupLayout(ExitPanel);
        ExitPanel.setLayout(ExitPanelLayout);
        ExitPanelLayout.setHorizontalGroup(
            ExitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
        );
        ExitPanelLayout.setVerticalGroup(
            ExitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );

        StateTabbed.addTab("Salidas", ExitPanel);

        FacturePanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout FacturePanelLayout = new javax.swing.GroupLayout(FacturePanel);
        FacturePanel.setLayout(FacturePanelLayout);
        FacturePanelLayout.setHorizontalGroup(
            FacturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
        );
        FacturePanelLayout.setVerticalGroup(
            FacturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );

        StateTabbed.addTab("Facturas", FacturePanel);

        FactureTurnPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout FactureTurnPanelLayout = new javax.swing.GroupLayout(FactureTurnPanel);
        FactureTurnPanel.setLayout(FactureTurnPanelLayout);
        FactureTurnPanelLayout.setHorizontalGroup(
            FactureTurnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
        );
        FactureTurnPanelLayout.setVerticalGroup(
            FactureTurnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );

        StateTabbed.addTab("Facturas Turno", FactureTurnPanel);

        VehicleTypePanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout VehicleTypePanelLayout = new javax.swing.GroupLayout(VehicleTypePanel);
        VehicleTypePanel.setLayout(VehicleTypePanelLayout);
        VehicleTypePanelLayout.setHorizontalGroup(
            VehicleTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
        );
        VehicleTypePanelLayout.setVerticalGroup(
            VehicleTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );

        StateTabbed.addTab("Tipo de Vehículos", VehicleTypePanel);

        FileMenu.setText("Archivo");

        AdministerMenu.setText("Administar Sistema");
        AdministerMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdministerMenuActionPerformed(evt);
            }
        });
        FileMenu.add(AdministerMenu);

        GenerateReportsMenu.setText("Generar Reportes");
        GenerateReportsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateReportsMenuActionPerformed(evt);
            }
        });
        FileMenu.add(GenerateReportsMenu);
        FileMenu.add(FileSeparator1);

        CloseBoxMenu.setText("Cerrar Caja");
        CloseBoxMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseBoxMenuActionPerformed(evt);
            }
        });
        FileMenu.add(CloseBoxMenu);
        FileMenu.add(FileSeparator2);

        LogoutMenu.setText("Cerrar Sesión");
        LogoutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutMenuActionPerformed(evt);
            }
        });
        FileMenu.add(LogoutMenu);

        ExitMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        ExitMenu.setText("Salir");
        ExitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitMenuActionPerformed(evt);
            }
        });
        FileMenu.add(ExitMenu);

        MenuBar.add(FileMenu);

        EditMenu.setText("Editar");

        UndoMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        UndoMenu.setText("Deshacer");
        EditMenu.add(UndoMenu);
        EditMenu.add(EditSeparator1);

        CutMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        CutMenu.setText("Cortar");
        EditMenu.add(CutMenu);

        CopyMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        CopyMenu.setText("Copiar");
        EditMenu.add(CopyMenu);

        PasteMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        PasteMenu.setText("Pegar");
        EditMenu.add(PasteMenu);

        DeleteMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        DeleteMenu.setText("Eliminar");
        EditMenu.add(DeleteMenu);

        MenuBar.add(EditMenu);

        ViewMenu.setText("Ver");
        MenuBar.add(ViewMenu);

        HelpMenu.setText("Ayuda");

        ViewHelpMenu.setText("Ver Ayuda");
        ViewHelpMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewHelpMenuActionPerformed(evt);
            }
        });
        HelpMenu.add(ViewHelpMenu);
        HelpMenu.add(HelpSeparator1);

        AboutEParkingMenu.setText("Acerca de e-Parking");
        AboutEParkingMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutEParkingMenuActionPerformed(evt);
            }
        });
        HelpMenu.add(AboutEParkingMenu);

        MenuBar.add(HelpMenu);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ParkingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(OptionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ClockPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DataEntryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AoQPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(StateTabbed, javax.swing.GroupLayout.DEFAULT_SIZE, 1155, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ParkingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DataEntryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ClockPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(AoQPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StateTabbed, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OptionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        MainController.verifyCarInParkway(PlateTextField.getText().toString());
    }//GEN-LAST:event_SearchButtonActionPerformed
    public void setAddOrQuitPanel(JPanel panel){
        //panel.setBounds(AoQPanel.getBounds());
        //panel.setLocation(AoQPanel.getLocation());
        AoQPanel.removeAll();
        AoQPanel.setVisible(false);
        AoQPanel.add(panel);
        AoQPanel.setVisible(true);
        AoQPanel.repaint();
    }
    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        LogoutController.logout(JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea cerrar sesión?" , "Cerrar Sesión" , JOptionPane.YES_NO_OPTION));
        controller.MainController.system.Logout();
    }//GEN-LAST:event_LogoutButtonActionPerformed

private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
    this.askToExit();
}//GEN-LAST:event_ExitButtonActionPerformed

    private void AdministerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdministerButtonActionPerformed
        MainController.setVisibleAdminAccessView(true);
    }//GEN-LAST:event_AdministerButtonActionPerformed

    private void ExitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuActionPerformed
        this.ExitButtonActionPerformed(null);
    }//GEN-LAST:event_ExitMenuActionPerformed

    private void LogoutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutMenuActionPerformed
        this.LogoutButtonActionPerformed(null);
    }//GEN-LAST:event_LogoutMenuActionPerformed

    private void CloseBoxButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseBoxButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("Cerrar Caja");
    }//GEN-LAST:event_CloseBoxButtonActionPerformed

    private void CloseBoxMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseBoxMenuActionPerformed
        this.CloseBoxButtonActionPerformed(null);
    }//GEN-LAST:event_CloseBoxMenuActionPerformed

    private void AdministerMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdministerMenuActionPerformed
        this.AdministerButtonActionPerformed(evt);
    }//GEN-LAST:event_AdministerMenuActionPerformed

    private void GenerateReportsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateReportsMenuActionPerformed
        System.out.println("Generar Reportes");
    }//GEN-LAST:event_GenerateReportsMenuActionPerformed

    private void ViewHelpMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewHelpMenuActionPerformed
         try {
            //System.out.println("Help");

            BrowserLauncher launcher = new BrowserLauncher();
            launcher.openURLinBrowser("http://parkingsoftware.isgreat.org/");
        } catch (BrowserLaunchingInitializingException ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedOperatingSystemException ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ViewHelpMenuActionPerformed

    private void AboutEParkingMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutEParkingMenuActionPerformed
        MainController.setVisibleAboutParkQuickView(true);
    }//GEN-LAST:event_AboutEParkingMenuActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.askToExit();
    }//GEN-LAST:event_formWindowClosing

private void PlateTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PlateTextFieldKeyPressed
PlateTextField.setText(PlateTextField.getText().toUpperCase());
}//GEN-LAST:event_PlateTextFieldKeyPressed

private void PlateTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PlateTextFieldKeyReleased
PlateTextField.setText(PlateTextField.getText().toUpperCase());
}//GEN-LAST:event_PlateTextFieldKeyReleased

    public void start(){
        Thread thread = new Thread();
        thread.start();
    }
    
    public void run(){
    
        while(true){
            try{
            Thread.sleep(1000);
            MainController.updateClockInFrame();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        
    }
    public void updateFrame(String date){
        this.ClockLabel.setText(date);
        this.repaint();
    }
    
    public void askToExit(){
        int confirm=JOptionPane.showConfirmDialog(CopyMenu, "¿Esta seguro que desea salir?");
        if (confirm == 0){
            controller.MainController.system.Close();
            ExitController.exit(0);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AboutEParkingMenu;
    private javax.swing.JButton AdministerButton;
    private javax.swing.JMenuItem AdministerMenu;
    private javax.swing.JPanel AoQPanel;
    private javax.swing.JLabel ClockLabel;
    private javax.swing.JPanel ClockPanel;
    private javax.swing.JButton CloseBoxButton;
    private javax.swing.JMenuItem CloseBoxMenu;
    private javax.swing.JMenuItem CopyMenu;
    private javax.swing.JMenuItem CutMenu;
    private javax.swing.JPanel DataEntryPanel;
    private javax.swing.JMenuItem DeleteMenu;
    private javax.swing.JMenu EditMenu;
    private javax.swing.JPopupMenu.Separator EditSeparator1;
    private javax.swing.JPanel EntryPanel;
    private javax.swing.JButton ExitButton;
    private javax.swing.JMenuItem ExitMenu;
    private javax.swing.JPanel ExitPanel;
    private javax.swing.JPanel FacturePanel;
    private javax.swing.JPanel FactureTurnPanel;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JPopupMenu.Separator FileSeparator1;
    private javax.swing.JPopupMenu.Separator FileSeparator2;
    private javax.swing.JMenuItem GenerateReportsMenu;
    private javax.swing.JMenu HelpMenu;
    private javax.swing.JPopupMenu.Separator HelpSeparator1;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JMenuItem LogoutMenu;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JPanel OptionsPanel;
    private javax.swing.JLabel ParkQuickLabel;
    private javax.swing.JPanel ParkingPanel;
    private javax.swing.JMenuItem PasteMenu;
    private javax.swing.JLabel PlateLabel;
    private javax.swing.JTextField PlateTextField;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTabbedPane StateTabbed;
    private javax.swing.JMenuItem UndoMenu;
    private javax.swing.JPanel VehicleTypePanel;
    private javax.swing.JMenuItem ViewHelpMenu;
    private javax.swing.JMenu ViewMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
