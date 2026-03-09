package vod.repository.mem;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vod.repository.ArtPieceDao;
import vod.model.Exhibition;
import vod.model.Artist;
import vod.model.ArtPiece;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MemArtPieceDao implements ArtPieceDao {
    @Override
    public List<ArtPiece> findAll() {
        return SampleData.artPieces;
    }

    @Override
    public ArtPiece findById(int id) {
        return SampleData.artPieces.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<ArtPiece> findByArtist(Artist d) {
       return SampleData.artPieces.stream().filter(m -> m.getArtist() == d).collect(Collectors.toList());
    }

    @Override
    public List<ArtPiece> findByExhibition(Exhibition c) {
        return SampleData.artPieces.stream().filter(m -> m.getExhibitions().contains(c)).collect(Collectors.toList());
    }

    @Override
    public ArtPiece add(ArtPiece m) {
        int max = SampleData.artPieces.stream().max((m1, m2) -> m1.getId() - m2.getId()).get().getId();
        m.setId(++max);
        SampleData.artPieces.add(m);
        return m;
    }
}
