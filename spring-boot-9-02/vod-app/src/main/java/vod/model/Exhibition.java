package vod.model;

import java.util.ArrayList;
import java.util.List;

public class Exhibition {

    private int id;
    private String name;
    private String logo; //url logo w przypadku UI będzie zaciągany dynamicznie
    private List<ArtPiece> artPieces = new ArrayList<>();//struktura kolekcyjna związaną z granymi filmami, uproszczone
//relacja wiele do wiele
    public Exhibition(int id, String name, String logo) {//konsturktor
        this.id = id;
        this.name = name;
        this.logo = logo;
    }

    public Exhibition() {//bezparametrowy
    }
//settery, gettery i to String - później będziemy korzystać z wynalazku Lombok
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<ArtPiece> getArtPieces() {
        return artPieces;
    }

    public void setArtPieces(List<ArtPiece> artPieces) {
        this.artPieces = artPieces;
    }

    public void addArtPiece(ArtPiece m) {
        this.artPieces.add(m);
    }

    @Override
    public String toString() {
        return "Exhibition {" +
                "name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
