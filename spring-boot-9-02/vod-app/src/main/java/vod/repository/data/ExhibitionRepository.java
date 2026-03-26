package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vod.model.Exhibition;
import vod.model.ArtPiece;

import java.util.List;

public interface ExhibitionRepository extends JpaRepository<Exhibition, Integer> {
    List<Exhibition> findAllByNameContaining(String name);

    @Query("select e from Exhibition e inner join e.artPieces artpieces where artpieces=:artpieces")
    List<Exhibition> findAllByArtPieces(@Param("artpieces") ArtPiece artPiece);
}
