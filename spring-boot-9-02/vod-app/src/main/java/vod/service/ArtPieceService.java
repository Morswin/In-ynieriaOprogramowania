package vod.service;

import vod.model.Artist;
import vod.model.ArtPiece;

import java.util.List;

public interface ArtPieceService {


    List<ArtPiece> getAllArtPieces();

    List<ArtPiece> getArtPiecesByArtist(Artist d);

    ArtPiece getArtPieceById(int id);

    ArtPiece addArtPiece(ArtPiece m);


    List<Artist> getAllArtists();

    Artist getArtistById(int id);

    Artist addArtist(Artist d);
}
