package org.example.jasper;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.example.jasper.model.Eltex;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class JasperApplication {

    public static void main(String[] args) throws JRException {
        SpringApplication.run(JasperApplication.class, args);
        String filePath = "/home/viktor/IdeaProjects/Jasper/src/main/resources/jasper.jrxml";

        Eltex eltex = new Eltex("Eltex", 1500, 2000, "g");
        Eltex eltex1 = new Eltex("Eltex", 1500, 2000, "g");
        Eltex eltex2 = new Eltex("Eltex", 1500, 2000, "g");
        Eltex eltex3 = new Eltex("Eltex", 1500, 2000, "g");
        Eltex eltex4 = new Eltex("Eltex", 1500, 2000, "g");
        Eltex eltex5 = new Eltex("Eltex", 1500, 2000, "g");
        Eltex eltex6 = new Eltex("Eltex", 1500, 2000, "g");
        Eltex eltex7 = new Eltex("Eltex", 1500, 2000, "g");
        Eltex eltex8 = new Eltex("Eltex", 1500, 2000, "g");
        Eltex eltex9 = new Eltex("Eltex", 1500, 2000, "g");

        List<Eltex> eltexList = new ArrayList<>();
        eltexList.add(eltex);
        eltexList.add(eltex1);
        eltexList.add(eltex2);
        eltexList.add(eltex3);
        eltexList.add(eltex4);
        eltexList.add(eltex5);
        eltexList.add(eltex6);
        eltexList.add(eltex7);
        eltexList.add(eltex8);
        eltexList.add(eltex9);

        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(eltexList);

        Map<String, Object> params = new HashMap<>();
        params.put("firstName", "John");
        params.put("lastName", "Smith");
        params.put("dob", "07/09/1977");
        params.put("age", 50);

        params.put("eltexDataSet", beanCollectionDataSource);

        JasperReport report = JasperCompileManager.compileReport(filePath);
        JasperPrint print = JasperFillManager.fillReport(report, params, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(print, "/home/viktor/IdeaProjects/Jasper/report.pdf");
        System.out.println("Report has been exported successfully");
    }

}
