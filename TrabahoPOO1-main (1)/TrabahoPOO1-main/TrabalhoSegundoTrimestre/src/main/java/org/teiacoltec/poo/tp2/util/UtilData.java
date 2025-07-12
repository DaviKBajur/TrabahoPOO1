package org.teiacoltec.poo.tp2.util;

import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UtilData {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public static Date lerData(Scanner sc) {
        String[] formatos = {"dd-MM-yyyy", "dd/MM/yyyy", "dd.MM.yyyy"};
        
        while (true) {
            String dataStr = sc.nextLine().trim();
            
            for (String formato : formatos) {
                try {
                    SimpleDateFormat sdfLocal = new SimpleDateFormat(formato);
                    sdfLocal.setLenient(false);
                    Date data = sdfLocal.parse(dataStr);
                    System.out.println("Data registrada: " + sdf.format(data));
                    return data;
                } catch (ParseException e) {
                }
            }
            
            System.out.print("Data inválida! Digite novamente (ex: 12-05-2024, 12/05/2024 ou 12.05.2024): ");
        }
    }

} 