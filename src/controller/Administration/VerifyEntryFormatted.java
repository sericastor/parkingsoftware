/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Administration;

import java.text.ParseException;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;

/**
 *
 * @author DiegoAl
 */
public class VerifyEntryFormatted extends InputVerifier{

    @Override
    public boolean verify(JComponent input) {
        
        JFormattedTextField jf = (JFormattedTextField) input;
       

        try {
            jf.commitEdit();
            double d = Double.valueOf(jf.getValue().toString());
            if (d >= 0.0) {
                jf.setValue(d);
                return true;
            } else {
                jf.setValue(0.0);
                return false;
            }
        } catch (NumberFormatException nfe) {
            jf.setValue(0.0);
            return false;
        } catch (ParseException pe) {
            jf.setValue(0.0);
            return false;
        }
    }
    
}
