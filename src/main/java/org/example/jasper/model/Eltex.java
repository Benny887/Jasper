package org.example.jasper.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Eltex {
    private String eltexName;
    private int total;
    private int goal;
    private String metric;
}
