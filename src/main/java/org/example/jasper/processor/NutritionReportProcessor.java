package org.example.jasper.processor;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import org.example.jasper.model.Food;
import org.example.jasper.model.MacroNutrient;
import org.example.jasper.model.Nutrition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class NutritionReportProcessor {

    @Autowired
    private final MessageSource messageSource;

    public ByteArrayOutputStream generateReport(Locale locale) throws JRException {
        String filePathChartSubrepo = "/home/viktor/IdeaProjects/Jasper/src/main/resources/jasper_chart_and_subreport_http.jrxml"; // табл граф подотчеты

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

        //-------------------------------------------------------------------------------------------------------//

        MacroNutrient carbMacroNutrition = new MacroNutrient("Carbohydrates", 48);
        MacroNutrient fatMacroNutrition = new MacroNutrient("Fat", 32);
        MacroNutrient ProteinMacroNutrition = new MacroNutrient("Protein", 20);


        List<MacroNutrient> macroNutrientList = new ArrayList<>();
        macroNutrientList.add(carbMacroNutrition);
        macroNutrientList.add(fatMacroNutrition);
        macroNutrientList.add(ProteinMacroNutrition);


        JRBeanCollectionDataSource macroNutrientDatasource = new JRBeanCollectionDataSource(macroNutrientList);

        //-------------------------------------------------------------------------------------------------------//

        Map<String, Object> params = new HashMap<>();// входные параметры на лицевике
        params.put("firstName", "John");
        params.put("lastName", "Smith");
        params.put("dob", "15/09/1988");
        params.put("age", 50);

        params.put("nutritionDataSet", nutrientDataSource);
        params.put("macroNutrientDataSet", macroNutrientDatasource);

        params.put("foodReport", getFoodReport());
        params.put("foodParameter", getFoodParameter());

        setLocalizedParameters(params, locale);

        JasperReport report = JasperCompileManager.compileReport(filePathChartSubrepo);
        JasperPrint print = JasperFillManager.fillReport(report, params, new JREmptyDataSource());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        JRPdfExporter exporter = new JRPdfExporter();
        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        configuration.setCompressed(true);
        exporter.setConfiguration(configuration);
        exporter.setExporterInput(new SimpleExporterInput(print));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
        exporter.exportReport();
        return outputStream;
    }

    //-------------------------------------------------------------------------------------------------------// для подотчета

    private void setLocalizedParameters(Map<String, Object> parameters, Locale locale) {
        MessageSourceResourceBundle resourceBundle = new MessageSourceResourceBundle(messageSource, locale);
        parameters.put(JRParameter.REPORT_RESOURCE_BUNDLE, resourceBundle);
        parameters.put(JRParameter.REPORT_LOCALE, locale);
    }


    private JRBeanCollectionDataSource getFoodDataSource() {
        List<Food> foodList = new ArrayList<>();
        Food banana = new Food("banana", "breakfast", 0,28,1);
        Food avocado = new Food("avocado", "breakfast", 22,13,3);
        Food milk = new Food("milk", "breakfast", 8,12,8);
        Food chiken = new Food("chiken", "lunch", 2,0,26);
        Food rice = new Food("rice", "lunch", 0,45,26);
        Food egg = new Food("egg", "lunch", 5,0,6);
        Food potato = new Food("potato", "lunch", 5,37,4);
        Food oats = new Food("oat", "dinner", 5,51,13);

        foodList.add(banana);
        foodList.add(avocado);
        foodList.add(milk);
        foodList.add(chiken);
        foodList.add(rice);
        foodList.add(egg);
        foodList.add(potato);
        foodList.add(oats);
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(foodList);
        return dataSource;
    }

    private Map getFoodParameter() {
        Map<String, Object> foodParameter = new HashMap<>();
        foodParameter.put("foodDataset", getFoodDataSource());
        return foodParameter;
    }

    private JasperReport getFoodReport() {
        String filePath = "/home/viktor/IdeaProjects/Jasper/src/main/resources/food_nutrition.jrxml";
        JasperReport report = null;
        try {
            report = JasperCompileManager.compileReport(filePath);
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
        return report;
    }

}
