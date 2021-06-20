package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {

    @Test
    public void test() throws IOException {
        String dosyaAdresi = "src/test/resources/ULKELER.xlsx";
        // JAVA'da herhangi bir dosyanın açılabilmesi için, FileInputStream
        // class'ından bir tane nesne oluşturulur. Ve parametre olarak,
        // açılmak istenen dosyanın adresi eklenir.
        FileInputStream fileInputStream = new FileInputStream(dosyaAdresi);
        // Excel dosyasını okumak için Workbook kullanıyoruz.
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //Excel   == Workbook
        //Sayfa   == Sheet
        //Satır   == Row
        //Hücre   == Cell

        //SAYFA (sheet) SEÇİMİ ( index 0'dan başlıyor )
        Sheet sayfa1 = workbook.getSheetAt(0);

        //SATIR (row) SEÇİMİ (index 0'dan başlıyor )
        Row satir1 = workbook.getSheetAt(0).getRow(0); //Row satir1 = sayfa1.getRow(0);

        //HÜCRE (cell) SEÇİMİ (index 0'dan başlıyor )
        Cell satir1hucre1 = workbook.getSheetAt(0).getRow(0).getCell(0); // satir1.getCell(0);
        System.out.println(satir1hucre1);
        System.out.println(workbook.getSheetAt(0).getRow(2).getCell(1));

        //Tablodaki son satirin indexini veriyor. // 10
        int sonSatirinIndexi = workbook.getSheetAt(0).getLastRowNum();

        // TÜM ÜLKELER SÜTUNU EKRANA YAZDIRDIK
        for(int i = 0 ; i <= sonSatirinIndexi ; i++){
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(0));
        }

        // TÜM BAŞKENTLER SÜTUNUNU EKRANA YAZDIRDIK
        for(int j = 0 ; j <= sonSatirinIndexi ; j++){
            System.out.println(workbook.getSheetAt(0).getRow(j).getCell(1));
        }


        int sonSutunIndex = workbook.getSheetAt(0).getRow(0).getLastCellNum();
        System.out.println("sonSutunIndex : "+sonSutunIndex);

        // BELİRLİ BİR SATIRDAKİ TÜM HÜCRELERİ YAZDIRMA
        for(int k = 0 ; k < sonSutunIndex ; k++){
            System.out.println(workbook.getSheetAt(0).getRow(3).getCell(k));
        }

        // Excel dosyasını kapatmak için bu kodları kullanabiliriz.
        workbook.close();
        fileInputStream.close();
    }


}
