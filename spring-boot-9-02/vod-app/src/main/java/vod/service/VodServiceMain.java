package vod.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vod.model.Exhibition;

import java.util.List;

public class VodServiceMain {

    public static void main(String[] args) {
        System.out.println("Let's find exhibitions!");

        ApplicationContext context = new AnnotationConfigApplicationContext("vod");
        ExhibitionService service = context.getBean(ExhibitionService.class);

        // service use
        // cinemaservice ma api zwraca wsyzstkie kina
        // tylko że ten serwis trzeba przygotowac, trzeba pozyskać tą usługe.
//        List<Exhibition> exhibitions = service.getAllExhibitions();
//        System.out.println(exhibitions.size() + " exhibitions found:");
//        exhibitions.forEach(System.out::println);

        String foo = context.getBean(String.class);
        System.out.println("foo string: " + foo);
    }
}
