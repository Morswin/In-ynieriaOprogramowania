package vod.repository.data;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import vod.model.ArtPiece;
import vod.model.Artist;
import vod.model.Exhibition;
import vod.repository.ArtPieceDao;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Primary
public class DataArtPieceDao implements ArtPieceDao {
    @Override
    public List<ArtPiece> findAll() {
        return repositiory.findAll();
    }

    @Override
    public ArtPiece findById(int id) {
        return repositiory.findById(id).orElse(null);
    }

    @Override
    public List<ArtPiece> findByArtist(Artist d) {
        return repositiory.findAllByArtist(d);
    }

    @Override
    public List<ArtPiece> findByExhibition(Exhibition c) {
        return repositiory.findAllByExhibitionsContaining(c);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public ArtPiece add(ArtPiece m) {
        return repositiory.save(m);
    }

    private final ArtPieceRepositiory repositiory;


}
