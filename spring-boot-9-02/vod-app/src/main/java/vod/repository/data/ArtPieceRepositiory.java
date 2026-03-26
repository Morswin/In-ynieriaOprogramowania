package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import vod.model.ArtPiece;

public interface ArtPieceRepositiory extends JpaRepository<ArtPiece, Integer> {
}
