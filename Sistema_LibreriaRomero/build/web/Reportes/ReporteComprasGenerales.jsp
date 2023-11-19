<%-- 
    Document   : ReporteComprasGenerales
    Created on : Nov 16, 2021, 5:01:55 PM
    Author     : Usuario
--%>
<%@page import="java.util.*"%>
<%@page import="java.io.File"%>
<%@page import="net.sf.jasperreports.engine.*"%>
<%@page import="net.sf.jasperreports.*" %>
<%@page import="net.sf.jasperreports.view.JasperViewer" %>
<%@page import="Modelo.ConexionSql"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REPORTE COMPRAS GENERALES</title>
    </head>
    <body>
        <%
        Connection cn;
        ConexionSql cnx = new ConexionSql();
        cn = cnx.getConexionSql();

        File reportFile = new File(application.getRealPath("/Reportes/ComprasGenerales.jasper"));

      Map<String, Object> parameter = new HashMap<String, Object>();
        
        
        byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(),parameter,cn);
        
        response.setContentType("application/pdf");
        response.setContentLength(bytes.length);
        
ServletOutputStream outputstram = response.getOutputStream();
outputstram.write(bytes,0,bytes.length);
outputstram.flush();
outputstram.close();




        

        %>
    </body>
</html>
