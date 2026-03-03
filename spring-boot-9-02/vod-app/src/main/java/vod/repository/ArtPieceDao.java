package vod.repository;

import vod.model.Exhibition;
import vod.model.Artist;
import vod.model.ArtPiece;

import java.util.List;

public interface ArtPieceDao {

    List<ArtPiece> findAll();

    ArtPiece findById(int id);

    List<ArtPiece> findByArtist(Artist d);

    List<ArtPiece> findByExhibition(Exhibition c);

    ArtPiece add(ArtPiece m);

}
