package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import vod.model.ArtPiece;
import vod.model.Artist;
import vod.model.Exhibition;

import java.util.List;

public interface ArtPieceRepository extends JpaRepository<ArtPiece, Integer> {
    List<ArtPiece> findAllByArtist(Artist d);

    List<ArtPiece> findAllByExhibitionsContaining(Exhibition d);
}
