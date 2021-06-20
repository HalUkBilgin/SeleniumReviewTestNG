package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {

    @Test
    public void test() throws IOException {

        String dosyaAdresi = "src/test/resources/ULKELER.xlsx";
        // JAVA'da herhangi bir dosyanın açılabilmesi için, FileInputStream
        // class'ından bir tane nesne oluşturulur. Ve parametre olarak,
        // açılmak istenen dosyanın adresi eklenir.
        FileInputStream fileInputStream = new FileInputStream(dosyaAdresi);
        // Excel dosyasını okumak için Workbook kullanıyoruz.
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        // Dosyaya yeni bir bilgi ekleyebilmek için (dosya yazmak için)
        FileOutputStream fileOutputStream = new FileOutputStream(dosyaAdresi);

        // 0. indexteki satırda, 3. indexte hücre oluşturduk ve içerisine NÜFUS yazdık
        workbook.getSheetAt(0).getRow(0).createCell(3).setCellValue("NÜFUS");

        // 1. indexteki satırda, 3. indexte hücre oluşturduk ve içerisine 83.000.000 yazdık
        workbook.getSheetAt(0).getRow(1).createCell(3).setCellValue("83.000.000");

        // İstediğimiz satırı tamamiyle silmek için bu kodu kullanıyoruz.
        Row onuncuSatir = workbook.getSheetAt(0).getRow(10);
        workbook.getSheetAt(0).removeRow(onuncuSatir);

        // İstediğimiz hücreyi silmek için bu kodu kullanıyoruz.
        Cell almanyaNufus = workbook.getSheetAt(0).getRow(1).getCell(3); // 83 milyon
        workbook.getSheetAt(0).getRow(1).removeCell(almanyaNufus);


        // Yaptığımız değişikleri excel dosyasına uygular ve kaydeder.
        workbook.write(fileOutputStream);

        fileOutputStream.close();
        workbook.close();
        fileInputStream.close();
    }

}
