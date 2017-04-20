package service;

import com.opencsv.CSVReader;
import model.Salaries;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class SalariesService {

    public static List<Salaries> makeListFromCSV(String filename) {
        List<Salaries> list = null;
        try {
            CSVReader reader = new CSVReader(new FileReader(filename));

            list = new ArrayList<>();
            reader.readNext(); // skip the first line
            String[] spl = null;

            while ((spl = reader.readNext()) != null) {
                LocalDate localdate = LocalDate.of(Integer.parseInt(spl[0]), 1, 1);
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
//                LocalDate formattedString = LocalDate.parse(localdate.format(formatter));
                list.add(new Salaries(localdate, spl[1], spl[2], spl[3], Integer.parseInt(spl[4])));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            list = new ArrayList<>();
        }

        return list;
    }


    //todo: 1. 1900년대 평균연봉을 구하세요(1985~1999)


    //todo: 2. 전체 레코드의 평균연봉을 구하세요


    //todo: 3. 최고 연봉자와 최소 연봉자를 구하세요


    //todo: 4. NL의 최고 연봉자를 구하세요


    //todo: 5. NYY 구단의 평균연봉을 구하세요




}
