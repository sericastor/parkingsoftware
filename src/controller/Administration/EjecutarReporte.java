
package controller.Administration;

import controller.MainController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class EjecutarReporte {

        public static final String DRIVER="com.mysql.jdbc.Driver";
        public static final String RUTA="jdbc:mysql://localhost:3306/eparkdb";
        public static final String USER="root";
        public static final String PASSWORD="";
    public static Connection CONEXION;
    //public static JasperReport report;

    public void startReport(int id){

        try{
            Class.forName(DRIVER);
            CONEXION = DriverManager.getConnection(RUTA,USER,PASSWORD);
            javax.swing.JOptionPane.showMessageDialog(null,"Conexion establecida");
            System.out.println(CONEXION);
            //report = JasperCompileManager.compileReport("D:\report2.jrxml");
            //JasperPrint print = JasperFillManager.fillReport(report, null, CONEXION);
            //Exporta el informe a PDF
            //String destFileNamePdf="C:\reporte1.pdf";
            //Creación del PDF
            //JasperExportManager.exportReportToPdfFile(print, destFileNamePdf);
            Map parameters = new HashMap();
            parameters.put("dFunciona","Esto si funciona");
            JasperReport report = JasperCompileManager.compileReport("C:\\report2.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Informe.pdf");

        }catch(Exception e){
            javax.swing.JOptionPane.showMessageDialog(null, e);

        }
    }
} 
