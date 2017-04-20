package view;

import model.Salaries;
import service.SalariesService;

import java.util.*;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    //todo: 1. 1900년대 평균연봉을 구하세요(1985~1999)
    //todo: 2. 전체 레코드의 평균연봉을 구하세요
    //todo: 3. 최고 연봉자와 최소 연봉자를 구하세요
    //todo: 4. NL의 최고 연봉자를 구하세요
    //todo: 5. NYY 구단의 평균연봉을 구하세요

    /*
    //todo: 코딩순서
    1. Salaries의 모델 객체를 만든다(멤버변수5개)
    yearID,teamID,lgID,playerID,salary
        ->salary는 int 타입으로
    2. stream을 사용하여 결과를 구하세요
    */

    public static void main(String[] args) {
        List<Salaries> list = SalariesService.makeListFromCSV("src\\data\\Salaries.csv");
        Stream<Salaries> stream = list.stream();

        for (Salaries e : list) {
            System.out.println(e.getYearID());
        }
        System.out.println("*********************리스트출력테스트*********************");

        //todo: 1. 1900년대 평균연봉을 구하세요(1985~1999)
        //Year을 숫자로 뽑아서 2000이하의 평균을 출력

        Collection<Salaries> sal = list;
        OptionalDouble avgSal =
                sal.stream()
                        .filter(s -> s.getYearID().getYear() < 2000)
                        .mapToInt(s -> s.getSalary())
                        .average();

        double avgQ1 = avgSal.getAsDouble();

        System.out.println("문제1 1900년대 평균연봉: " + avgQ1);

        //todo: 2. 전체 레코드의 평균연봉을 구하세요

        OptionalDouble avgOpt =
                sal.stream()
                        .mapToInt(x -> x.getSalary())
                        .average();

        double avg = avgOpt.getAsDouble();
        System.out.println("문제2 평균: " + avg);


        //todo: 3. 최고 연봉자와 최소 연봉자를 구하세요
        Collection<Salaries> sal2 = list;

        // sort사용하여서 최고, 최소를 뽑으면 됨.
        Stream<List> st = Stream.of(list);
        Stream<List> sortedStream = st.sorted();


        /*Collection<Salaries> salMax = list;
        OptionalInt max =
                salMax.stream()

                        .mapToInt(x -> x.getSalary())
                        .max();

        String maxPerson = max.toString();
        System.out.println("문제3 최고연봉자: " + maxPerson);

        Collection<Salaries> salMin = list;
        OptionalInt min =
                salMin.stream()
                        .mapToInt(x -> x.getSalary())
                        .min();

        String minPerson = min.toString();
        System.out.println("문제3 최소연봉자: " + minPerson.toString());*/

        //todo: 4. NL의 최고 연봉자를 구하세요
        Collection<Salaries> salNL = list;
        OptionalInt maxNL =
                salNL.stream()
                        .filter(x -> x.getLgID() == "NL")
                        .mapToInt(x -> x.getSalary())
                        .max();

        double maxNLResult = maxNL.getAsInt();
        System.out.println("문제4 NL의 최고 연봉자: " + maxNLResult);


        //todo: 5. NYY 구단의 평균연봉을 구하세요
        Collection<Salaries> salNYY = list;
        OptionalDouble avgNYY =
                salNYY.stream()
                        .filter(x -> x.getTeamID() == "NYY")
                        .mapToInt(x -> x.getSalary())
                        .average();

        double avgNYYResult = avgNYY.getAsDouble();
        System.out.println("문제5 NYY 구단의 평균연봉: " + avgNYYResult);


        //todo: 6. 최상위 연봉자 10명을 구하시오.


    }
}
