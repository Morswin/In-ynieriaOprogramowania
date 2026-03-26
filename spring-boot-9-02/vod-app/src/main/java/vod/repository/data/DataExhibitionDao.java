package vod.repository.data;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.ArtPiece;
import vod.model.Exhibition;
import vod.repository.ExhibitionDao;

import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class DataExhibitionDao implements ExhibitionDao {
    private final ExhibitionRepository repository;

    @Override
    public List<Exhibition> findAll() {
        return repository.findAll();
    }

    @Override
    public Exhibition findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Exhibition> findByArtPiece(ArtPiece m) {
        return repository.findAllByArtPieces(m);
    }

    @Override
    public Exhibition save(Exhibition exhibition) {
        return repository.save(exhibition);
    }
}
