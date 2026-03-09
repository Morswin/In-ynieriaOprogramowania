package vod.service;

import vod.model.Exhibition;
import vod.model.ArtPiece;

import java.util.List;

public interface ExhibitionService {
//api zwraca nam wszystkie kina
    Exhibition getExhibitionById(int id);

    List<Exhibition> getAllExhibitions();

    List<Exhibition> getExhibitionsByArtPiece(ArtPiece m);

    List<ArtPiece> getArtPiecesInExhibition(Exhibition c);

    Exhibition addExhibition(Exhibition e);
}
