package org.example.jasper;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.example.jasper.model.EltexTraffic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class JasperApplication {

    public static void main(String[] args) throws JRException {
        SpringApplication.run(JasperApplication.class, args);
//        String filePathTable = "/home/viktor/IdeaProjects/Jasper/src/main/resources/jasper_table.jrxml"; //- таблицы
//
//        Nutrition protein = new Nutrition("Protein", 62, 83, "g");
//        Nutrition carbohydrates = new Nutrition("Carbohydrates", 22, 33, "g");
//        Nutrition fibres = new Nutrition("Fibres", 12, 34, "g");
//        Nutrition sugars = new Nutrition("Sugars", 53, 3, "g");
//        Nutrition fat = new Nutrition("Fat", 87, 34, "g");
//        Nutrition cholesterol = new Nutrition("Cholesterol", 23, 67, "g");
//        Nutrition sodium = new Nutrition("Sodium", 43, 76, "g");
//        Nutrition potassium = new Nutrition("Potassium", 43, 43, "g");
//        Nutrition calcium = new Nutrition("Calcium", 42, 84, "g");
//        Nutrition iron = new Nutrition("Iron", 19, 47, "g");
//
//        List<Nutrition> nutritionList = new ArrayList<>();
//        nutritionList.add(protein);
//        nutritionList.add(carbohydrates);
//        nutritionList.add(fibres);
//        nutritionList.add(sugars);
//        nutritionList.add(fat);
//        nutritionList.add(cholesteroL);
//        nutritionList.add(sodium);
//        nutritionList.add(potassium);
//        nutritionList.add(calcium);
//        nutritionList.add(iron);
//
//        JRBeanCollectionDataSource nutrientDataSource = new JRBeanCollectionDataSource(nutritionList);
//
//        //-------------------------------------------------------------------------------------------------------//
//
//        String filePathChart = "/home/viktor/IdeaProjects/Jasper/src/main/resources/jasper_chart.jrxml"; // графики
//
//        MacroNutrient carbMacroNutrition = new MacroNutrient("Carbohydrates", 48);
//        MacroNutrient fatMacroNutrition = new MacroNutrient("Fat", 32);
//        MacroNutrient ProteinMacroNutrition = new MacroNutrient("Protein", 20);
//
//
//        List<MacroNutrient> macroNutrientList = new ArrayList<>();
//        macroNutrientList.add(carbMacroNutrition);
//        macroNutrientList.add(fatMacroNutrition);
//        macroNutrientList.add(ProteinMacroNutrition);
//
//
//        JRBeanCollectionDataSource macroNutrientDatasource = new JRBeanCollectionDataSource(macroNutrientList);

        //-------------------------------------------------------------------------------------------------------//
        
//        String filePathChartSubrepo = "/home/viktor/IdeaProjects/Jasper/src/main/resources/jasper_chart_and_subreport.jrxml"; // табл граф подотчеты

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        EltexTraffic traffic = new EltexTraffic(format.format(new Date(1714496400000L)), 0, "Input");
        EltexTraffic traffic1 = new EltexTraffic(format.format(new Date(1714410000000L)), 0, "Input");
        EltexTraffic traffic2 = new EltexTraffic(format.format(new Date(1714669200000L)), 0, "Input");
        EltexTraffic traffic3 = new EltexTraffic(format.format(new Date(1714755600000L)), 0, "Input");
        EltexTraffic traffic4 = new EltexTraffic(format.format(new Date(1714842000000L)), 0, "Input");
        EltexTraffic traffic5 = new EltexTraffic(format.format(new Date(1714928400000L)), 0, "Input");
        EltexTraffic traffic6 = new EltexTraffic(format.format(new Date(1715014800000L)), 0, "Input");
        EltexTraffic traffic7 = new EltexTraffic(format.format(new Date(1715101200000L)), 0, "Input");
        EltexTraffic traffic8 = new EltexTraffic(format.format(new Date(1715187600000L)), 0, "Input");
        EltexTraffic traffic9 = new EltexTraffic(format.format(new Date(1715274000000L)), 0, "Input");
        EltexTraffic traffic10 = new EltexTraffic(format.format(new Date(1715360400000L)), 0, "Input");
        EltexTraffic traffic11 = new EltexTraffic(format.format(new Date(1715446800000L)), 0, "Input");
        EltexTraffic traffic12 = new EltexTraffic(format.format(new Date(1715533200000L)), 0, "Input");
        EltexTraffic traffic13 = new EltexTraffic(format.format(new Date(1715619600000L)), 0, "Input");
        EltexTraffic traffic14 = new EltexTraffic(format.format(new Date(1715706000000L)), 0, "Input");
        EltexTraffic traffic15 = new EltexTraffic(format.format(new Date(1715792400000L)), 0, "Input");
        EltexTraffic traffic16 = new EltexTraffic(format.format(new Date(1715878800000L)), 0, "Input");
        EltexTraffic traffic17 = new EltexTraffic(format.format(new Date(1715965200000L)), 0, "Input");
        EltexTraffic traffic18 = new EltexTraffic(format.format(new Date(1716051600000L)), 0, "Input");
        EltexTraffic traffic19 = new EltexTraffic(format.format(new Date(1716138000000L)), 10053, "Input");
        EltexTraffic traffic20 = new EltexTraffic(format.format(new Date(1716138000000L)), 4333, "Output");
        EltexTraffic traffic21 = new EltexTraffic(format.format(new Date(1716310800000L)), 0, "Input");
        EltexTraffic traffic22 = new EltexTraffic(format.format(new Date(1716397200000L)), 0, "Input");
        EltexTraffic traffic23 = new EltexTraffic(format.format(new Date(1716483600000L)), 0, "Input");
        EltexTraffic traffic24 = new EltexTraffic(format.format(new Date(1716570000000L)), 0, "Input");
        EltexTraffic traffic25 = new EltexTraffic(format.format(new Date(1716656400000L)), 0, "Input");
        EltexTraffic traffic26 = new EltexTraffic(format.format(new Date(1716742800000L)), 0, "Input");
        EltexTraffic traffic27 = new EltexTraffic(format.format(new Date(1716829200000L)), 0, "Input");
        EltexTraffic traffic28 = new EltexTraffic(format.format(new Date(1716915600000L)), 0, "Input");
        EltexTraffic traffic29 = new EltexTraffic(format.format(new Date(1717002000000L)), 0, "Input");
        EltexTraffic traffic30 = new EltexTraffic(format.format(new Date(1717088400000L)), 0, "Input");

        List<EltexTraffic> eltexTraffic = new ArrayList<>();
        eltexTraffic.add(traffic);
        eltexTraffic.add(traffic1);
        eltexTraffic.add(traffic2);
        eltexTraffic.add(traffic3);
        eltexTraffic.add(traffic4);
        eltexTraffic.add(traffic5);
        eltexTraffic.add(traffic6);
        eltexTraffic.add(traffic7);
        eltexTraffic.add(traffic8);
        eltexTraffic.add(traffic9);
        eltexTraffic.add(traffic10);
        eltexTraffic.add(traffic11);
        eltexTraffic.add(traffic12);
        eltexTraffic.add(traffic13);
        eltexTraffic.add(traffic14);
        eltexTraffic.add(traffic15);
        eltexTraffic.add(traffic16);
        eltexTraffic.add(traffic17);
        eltexTraffic.add(traffic18);
        eltexTraffic.add(traffic19);
        eltexTraffic.add(traffic20);
        eltexTraffic.add(traffic21);
        eltexTraffic.add(traffic22);
        eltexTraffic.add(traffic23);
        eltexTraffic.add(traffic24);
        eltexTraffic.add(traffic25);
        eltexTraffic.add(traffic26);
        eltexTraffic.add(traffic27);
        eltexTraffic.add(traffic28);
        eltexTraffic.add(traffic29);
        eltexTraffic.add(traffic30);

        JRBeanCollectionDataSource eltexDatasource = new JRBeanCollectionDataSource(eltexTraffic);

        String fileEltexTraffic = "/home/viktor/IdeaProjects/Jasper/src/main/resources/jasper_eltex_traffic.jrxml";

        Map<String, Object> params = new HashMap<>();// входные параметры на лицевике
//        params.put("firstName", "John");
//        params.put("lastName", "Smith");
//        params.put("dob", "15/09/1988");
//        params.put("age", 50);

//        params.put("nutritionDataSet", nutrientDataSource);
//        params.put("macroNutrientDataSet", macroNutrientDatasource);


//        params.put("foodReport", getFoodReport());
//        params.put("foodParameter", getFoodParameter());

          params.put("eltexTrafficDataSet", eltexDatasource);


        JasperReport report = JasperCompileManager.compileReport(fileEltexTraffic);
        JasperPrint print = JasperFillManager.fillReport(report, params, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(print, "/home/viktor/IdeaProjects/Jasper/report.pdf");
        System.out.println("Report has been exported successfully");
    }

    //-------------------------------------------------------------------------------------------------------// для подотчета

//    private static JRBeanCollectionDataSource getFoodDataSource() {
//        List<Food> foodList = new ArrayList<>();
//        Food banana = new Food("banana", "breakfast", 0,28,1);
//        Food avocado = new Food("avocado", "breakfast", 22,13,3);
//        Food milk = new Food("milk", "breakfast", 8,12,8);
//        Food chiken = new Food("chiken", "lunch", 2,0,26);
//        Food rice = new Food("rice", "lunch", 0,45,26);
//        Food egg = new Food("egg", "lunch", 5,0,6);
//        Food potato = new Food("potato", "lunch", 5,37,4);
//        Food oats = new Food("oat", "dinner", 5,51,13);
//
//        foodList.add(banana);
//        foodList.add(avocado);
//        foodList.add(milk);
//        foodList.add(chiken);
//        foodList.add(rice);
//        foodList.add(egg);
//        foodList.add(potato);
//        foodList.add(oats);
//        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(foodList);
//        return dataSource;
//    }
//
//    private static Map getFoodParameter() {
//        Map<String, Object> foodParameter = new HashMap<>();
//        foodParameter.put("foodDataset", getFoodDataSource());
//        return foodParameter;
//    }
//
//    private static JasperReport getFoodReport() {
//        String filePath = "/home/viktor/IdeaProjects/Jasper/src/main/resources/food_nutrition.jrxml";
//        JasperReport report = null;
//        try {
//            report = JasperCompileManager.compileReport(filePath);
//        } catch (JRException e) {
//            throw new RuntimeException(e);
//        }
//        return report;
//    }

}
