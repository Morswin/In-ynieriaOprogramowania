package vod.repository.data;

import org.springframework.data.jpa.repository.JpaRepository;
import vod.model.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
}
