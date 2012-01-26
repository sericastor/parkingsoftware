
package controller.Administration;

import controller.MainController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JProgressBar;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ExecuteReport {

        public static final String DRIVER="com.mysql.jdbc.Driver";
        public static final String RUTA="jdbc:mysql://localhost:3306/eparkdb";
        public static final String USER="root";
        public static final String PASSWORD="6262541";
    public static Connection CONEXION;
    public static JasperReport report;

    public void startReport(long Date1, long Date2){

        try{
            Timestamp date1 = new Timestamp(Date1);  
            Timestamp date2 = new Timestamp(Date2);
            if(Date2==0){
            Long yesterday=Date1-86400000;
            date2 = new Timestamp(yesterday);
            }
            Map Parameters = new HashMap();
            Parameters.put("Date1",date1);
            Parameters.put("Date2",date2);
            Class.forName(DRIVER);
            CONEXION = DriverManager.getConnection(RUTA,USER,PASSWORD);
            report = JasperCompileManager.compileReport("src\\jasperTemplates\\report1.jrxml");
            JasperPrint print = JasperFillManager.fillReport(report, Parameters, CONEXION);
            //Exporta el informe a PDF
            String destFileNamePdf="src\\Reports\\reporte diario de ingresos "+
                    MainController.getSystemTime().getDate()+
                    "."+(MainController.getSystemTime().getMonth()+1)+
                    "."+(MainController.getSystemTime().getYear()+1900)
                    +".pdf";
            //Creación del PDF
            JasperExportManager.exportReportToPdfFile(print, destFileNamePdf);
            JasperViewer jviewer=new JasperViewer(print,false);
            jviewer.setTitle(destFileNamePdf);
            jviewer.setVisible(true);
        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null, e);

        }
    }
} 
