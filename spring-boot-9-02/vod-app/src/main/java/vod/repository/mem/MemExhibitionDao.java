package vod.repository.mem;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import vod.repository.ExhibitionDao;
import vod.model.Exhibition;
import vod.model.ArtPiece;

import java.util.List;
import java.util.stream.Collectors;

@Primary
@Repository
public class MemExhibitionDao implements ExhibitionDao {

    @Override
    public List<Exhibition> findAll() {
        return SampleData.exhibitions;
    }

    @Override
    public Exhibition findById(int id) {
        return SampleData.exhibitions.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Exhibition> findByArtPiece(ArtPiece m) {
        return SampleData.exhibitions.stream().filter(c -> c.getArtPieces().contains(m)).collect(Collectors.toList());
    }

    @Override
    public Exhibition save(Exhibition exhibition) {
        int maxId = SampleData.exhibitions.stream()
                .sorted((c1, c2) -> c2.getId()-c1.getId())
                .findFirst()
                .map(c->c.getId())
                .orElse(0);
        exhibition.setId(maxId);
        SampleData.exhibitions.add(exhibition);
        return exhibition;
    }
}
