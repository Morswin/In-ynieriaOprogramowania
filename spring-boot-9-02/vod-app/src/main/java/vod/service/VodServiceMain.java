package vod.service;

import vod.repository.ExhibitionDao;
import vod.repository.ArtPieceDao;
import vod.repository.mem.MemExhibitionDao;
import vod.repository.mem.MemArtPieceDao;
import vod.model.Exhibition;
import vod.service.impl.ExhibitionServiceBean;

import java.util.List;

public class VodServiceMain {

    public static void main(String[] args) {
        System.out.println("Let's find exhibitions!");

        // service preparation przygotowanie serwisu który używa repo jednego cinemaservice
        //chcemy wyswielic lisę kin, repo dają dostęp do nich, ale z punktu widzenia apliakcji
        //powiinismy komunikowac sie przez serwis
        //serwis jest taka fasadą ponad repozytoriami - architektura wielowarstwowa
        ExhibitionDao exhibitionDao = new MemExhibitionDao();
        ArtPieceDao artPieceDao = new MemArtPieceDao();
        //przygotowanie serwisu ma jedna impelemntacja, moze byc ich wiecej
        //ta impelemntacja potrzebuje w swoim konstruktorze dostarczyc obiekty dao
        //tu mamy znowu dwa intefejsy i trzeba sie zastanowic z których impelemntacji skorzystać
        ExhibitionService service = new ExhibitionServiceBean(exhibitionDao, artPieceDao);

        // service use
        //cinemaservice ma api zwraca wsyzstkie kina
      //  tylko że ten serwis trzeba przygotowac, trzeba pozyskać tą usługe.
        List<Exhibition> exhibitions = service.getAllExhibitions();
        System.out.println(exhibitions.size() + " exhibitions found:");
        exhibitions.forEach(System.out::println);
    }
}
