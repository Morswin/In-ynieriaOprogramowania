package vod.repository.data;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.Artist;
import vod.repository.ArtistDao;

import java.util.List;

@Repository
@Primary
@RequiredArgsConstructor
public class DataArtistDao implements ArtistDao {
    ArtistRepository repository;

    @Override
    public List<Artist> findAll() {
        return repository.findAll();
    }

    @Override
    public Artist findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Artist add(Artist d) {
        return repository.save(d);
    }
}
