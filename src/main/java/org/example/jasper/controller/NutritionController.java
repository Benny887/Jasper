package org.example.jasper.controller;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.example.jasper.processor.NutritionReportProcessor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
public class NutritionController {
    private final NutritionReportProcessor processor;

    @GetMapping("/report") //(http://localhost:8080/report?lang=fr_FR)
    public ResponseEntity<byte[]> getNutritionReport(@RequestParam("lang") String language) throws JRException {
        Locale locale = StringUtils.parseLocaleString(language);
        ByteArrayOutputStream reportStream = processor.generateReport(locale);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);

        return new ResponseEntity<>(reportStream.toByteArray(), headers, HttpStatus.OK);
    }

}
