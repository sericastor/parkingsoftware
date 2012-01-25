/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LoginView.java
 *
 * Created on 3/09/2011, 05:32:25 PM
 */
package view;


import controller.ExitController;
import controller.LoginController;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



/**
 *
 * @author Martin Kanayet
 */
public class LoginView extends javax.swing.JFrame {

    public LoginView() {
        ImageIcon img=new ImageIcon("src/images/parking1.gif"); 
        setIconImage(img.getImage()); 
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        UserTextField.requestFocus();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IntroPanel = new javax.swing.JPanel();
        HelpPanel = new javax.swing.JPanel();
        NeedHelpLabel = new javax.swing.JLabel();
        ManualButton = new javax.swing.JButton();
        LoginPanel = new javax.swing.JPanel();
        UserTextField = new javax.swing.JTextField();
        NameLabel = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        PasswordLabel = new javax.swing.JLabel();
        LoginButton = new javax.swing.JButton();
        IconLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ParkQuick ~ Iniciar Sesión");
        setBackground(new java.awt.Color(0, 0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        IntroPanel.setBackground(new java.awt.Color(255, 255, 255));

        HelpPanel.setBackground(new java.awt.Color(255, 255, 255));
        HelpPanel.setForeground(new java.awt.Color(153, 153, 255));

        NeedHelpLabel.setFont(new java.awt.Font("Tahoma", 0, 20));
        NeedHelpLabel.setText("¿Necesita ayuda con el Sistema? ");

        ManualButton.setFont(new java.awt.Font("Tahoma", 0, 14));
        ManualButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Info.png"))); // NOI18N
        ManualButton.setText("Manual de Usuario");
        ManualButton.setToolTipText("Pulse aquí para obtener ayuda.");
        ManualButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManualButtonActionPerformed(evt);
            }
        });

        LoginPanel.setBackground(new java.awt.Color(255, 255, 255));

        UserTextField.setToolTipText("Ingrese su nombre.");

        NameLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
        NameLabel.setText("Nombre de Usuario:");

        PasswordField.setToolTipText("Ingrese su contraseña.");
        PasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PasswordFieldKeyPressed(evt);
            }
        });

        PasswordLabel.setFont(new java.awt.Font("Tahoma", 1, 14));
        PasswordLabel.setText("Contraseña:");

        LoginButton.setFont(new java.awt.Font("Tahoma", 0, 14));
        LoginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Lock.png"))); // NOI18N
        LoginButton.setText("Iniciar Sesión");
        LoginButton.setToolTipText("Pulse aquí para comprobar sus datos.");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel);
        LoginPanel.setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PasswordLabel)
                    .addComponent(NameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(UserTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PasswordField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(275, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                .addContainerGap(188, Short.MAX_VALUE)
                .addComponent(LoginButton)
                .addGap(213, 213, 213))
        );
        LoginPanelLayout.setVerticalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PasswordLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LoginButton)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout HelpPanelLayout = new javax.swing.GroupLayout(HelpPanel);
        HelpPanel.setLayout(HelpPanelLayout);
        HelpPanelLayout.setHorizontalGroup(
            HelpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HelpPanelLayout.createSequentialGroup()
                .addGroup(HelpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HelpPanelLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(ManualButton))
                    .addGroup(HelpPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(NeedHelpLabel)))
                .addGap(10, 10, 10)
                .addComponent(LoginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HelpPanelLayout.setVerticalGroup(
            HelpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HelpPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(NeedHelpLabel)
                .addGap(28, 28, 28)
                .addComponent(ManualButton)
                .addContainerGap(93, Short.MAX_VALUE))
            .addComponent(LoginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        IconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Sin título-2.png"))); // NOI18N

        javax.swing.GroupLayout IntroPanelLayout = new javax.swing.GroupLayout(IntroPanel);
        IntroPanel.setLayout(IntroPanelLayout);
        IntroPanelLayout.setHorizontalGroup(
            IntroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HelpPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(IntroPanelLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(IconLabel)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        IntroPanelLayout.setVerticalGroup(
            IntroPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IntroPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(IconLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(HelpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(IntroPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(IntroPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
       LoginController.startLogin();
    }//GEN-LAST:event_LoginButtonActionPerformed

    private void ManualButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManualButtonActionPerformed
        
            /*try {
                //System.out.println("Help");

                BrowserLauncher launcher = new BrowserLauncher();
                launcher.openURLinBrowser("http://parkingsoftware.isgreat.org");
            } catch (BrowserLaunchingInitializingException ex) {
                Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedOperatingSystemException ex) {
                Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            
         Desktop desktop; /* Declaro un objeto Desktop que es una nueva API en JAVA
        Para mas detalle sobre ésta API ver la siguiente Página web > 
        http://java.sun.com/developer/technicalArticles/J2SE/Desktop/javase6/desktop_api/
         */
        File file = new File("documentation/web_site/default.html");//declaro un Objeto File que apunte a mi archivo html
        if (Desktop.isDesktopSupported()) {// si éste pc soporta esta API 
            desktop = Desktop.getDesktop();//objtengo una instancia del Desktop(Escritorio)de mi pc 
            try {
                desktop.open(file);//abro el archivo con el programa predeterminado
            } catch (IOException ex) {
                System.out.println("Se genro un error abriendo el archivo html del manual" + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Lo lamento,no se puede abrir el archivo; ésta Maquina no soporta la API Desktop");
        }
    }//GEN-LAST:event_ManualButtonActionPerformed

    private void PasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            LoginButtonActionPerformed(null);
        }
    }//GEN-LAST:event_PasswordFieldKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int confirm=JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea salir?");
        if (confirm == JOptionPane.OK_OPTION){
            ExitController.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    public String getUserName() {
        return UserTextField.getText().toLowerCase();
    }

    public String getUserPassword() {
       return String.valueOf(PasswordField.getPassword());
    }
    
    public javax.swing.JTextField getUserTextField(){
        return UserTextField;
    }
    
    public javax.swing.JPasswordField getPasswordField(){
        return PasswordField;
    }

    public void showMessage(String title, String message, int messageType) {
        JOptionPane.showMessageDialog(this, message, title, messageType);
        UserTextField.requestFocus();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HelpPanel;
    private javax.swing.JLabel IconLabel;
    private javax.swing.JPanel IntroPanel;
    private javax.swing.JButton LoginButton;
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JButton ManualButton;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JLabel NeedHelpLabel;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JTextField UserTextField;
    // End of variables declaration//GEN-END:variables
}
