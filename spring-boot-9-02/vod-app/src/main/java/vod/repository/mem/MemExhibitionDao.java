package vod.repository.mem;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import vod.repository.ExhibitionDao;
import vod.model.Exhibition;
import vod.model.ArtPiece;

import java.util.List;
import java.util.stream.Collectors;

@Primary
@Component
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
}
