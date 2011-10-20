/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Diego
 */
public class FormatDate extends MaskFormatter{
    
    private SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy kk:mm:ss");
    
    public FormatDate() throws ParseException{
        //Formato "dd/mm/aaaa hh:mm:ss"
        super("##/##/#### ##:##:##");
    }
    
    //Convertir un String al formato fecha
    @Override
    public Object stringToValue(String date) throws ParseException{
        return format.parseObject(date);
    }
    
    //Convertir una fecha a String
    @Override
    public String valueToString(Object value) throws ParseException{
        if(value instanceof Date){
            return format.format((Date) value);
        }
        return format.format(new Date());
    } 
}
