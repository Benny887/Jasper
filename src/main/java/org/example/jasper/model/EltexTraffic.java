package org.example.jasper.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class EltexTraffic {
    private String date;
    private long data;
    private String input;
}
