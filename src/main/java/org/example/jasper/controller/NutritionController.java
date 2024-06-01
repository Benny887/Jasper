package org.example.jasper.controller;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.example.jasper.processor.NutritionReportProcessor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;

@RestController
@RequiredArgsConstructor
public class NutritionController {
    private final NutritionReportProcessor processor;

    @GetMapping("/report")
    public ResponseEntity<byte[]> getNutritionReport() throws JRException {
        ByteArrayOutputStream reportStream = processor.generateReport();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);

        return new ResponseEntity<>(reportStream.toByteArray(), headers, HttpStatus.OK);
    }

}
