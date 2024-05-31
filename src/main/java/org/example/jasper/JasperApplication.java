package org.example.jasper;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.example.jasper.model.Nutrition;
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
        String filePath = "/home/viktor/IdeaProjects/Jasper/src/main/resources/jasper.jrxml"; //- таблицы

        Nutrition protein = new Nutrition("Protein", 62, 83, "g");
        Nutrition carbohydrates = new Nutrition("Carbohydrates", 22, 33, "g");
        Nutrition fibres = new Nutrition("Fibres", 12, 34, "g");
        Nutrition sugars = new Nutrition("Sugars", 53, 3, "g");
        Nutrition fat = new Nutrition("Fat", 87, 34, "g");
        Nutrition cholesterol = new Nutrition("Cholesterol", 23, 67, "g");
        Nutrition sodium = new Nutrition("Sodium", 43, 76, "g");
        Nutrition potassium = new Nutrition("Potassium", 43, 43, "g");
        Nutrition calcium = new Nutrition("Calcium", 42, 84, "g");
        Nutrition iron = new Nutrition("Iron", 19, 47, "g");

        List<Nutrition> nutritionList = new ArrayList<>();
        nutritionList.add(protein);
        nutritionList.add(carbohydrates);
        nutritionList.add(fibres);
        nutritionList.add(sugars);
        nutritionList.add(fat);
        nutritionList.add(cholesterol);
        nutritionList.add(sodium);
        nutritionList.add(potassium);
        nutritionList.add(calcium);
        nutritionList.add(iron);

        JRBeanCollectionDataSource nutrientDataSource = new JRBeanCollectionDataSource(nutritionList);

//        String filePath = "/home/viktor/IdeaProjects/Jasper/src/main/resources/jasper_1.jrxml";  графики

//        EltexChart eltexChart1 = new EltexChart("eltex1", 20);
//        EltexChart eltexChart2 = new EltexChart("eltex2", 40);
//        EltexChart eltexChart3 = new EltexChart("eltex3", 60);

//        List<EltexChart> eltexChartList = new ArrayList<>();
//        eltexChartList.add(eltexChart1);
//        eltexChartList.add(eltexChart2);
//        eltexChartList.add(eltexChart3);


//        JRBeanCollectionDataSource chartDataSource = new JRBeanCollectionDataSource(eltexChartList);




        Map<String, Object> params = new HashMap<>();// входные параметры на лицевике
        params.put("firstName", "John");
        params.put("lastName", "Smith");
        params.put("dob", "15/09/1988");
        params.put("age", 50);

        params.put("nutritionDataSet", nutrientDataSource);
//        params.put("JasperChartDS", chartDataSource);

        JasperReport report = JasperCompileManager.compileReport(filePath);
        JasperPrint print = JasperFillManager.fillReport(report, params, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(print, "/home/viktor/IdeaProjects/Jasper/report.pdf");
        System.out.println("Report has been exported successfully");
    }

}
