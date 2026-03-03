package vod.repository;

import vod.model.Exhibition;
import vod.model.ArtPiece;

import java.util.List;

public interface ExhibitionDao {

    List<Exhibition> findAll();

    Exhibition findById(int id);

    List<Exhibition> findByArtPiece(ArtPiece m);

}
