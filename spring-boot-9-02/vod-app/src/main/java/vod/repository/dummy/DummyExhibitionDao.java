package vod.repository.dummy;

import org.springframework.stereotype.Component;
import vod.model.ArtPiece;
import vod.model.Exhibition;
import vod.repository.ExhibitionDao;

import java.util.List;

@Component
public class DummyExhibitionDao implements ExhibitionDao {
    @Override
    public List<Exhibition> findAll() {
        return List.of();
    }

    @Override
    public Exhibition findById(int id) {
        return null;
    }

    @Override
    public List<Exhibition> findByArtPiece(ArtPiece m) {
        return List.of();
    }
}
