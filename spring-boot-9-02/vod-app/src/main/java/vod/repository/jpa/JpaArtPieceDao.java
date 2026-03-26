package vod.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.ArtPiece;
import vod.model.Artist;
import vod.model.Exhibition;
import vod.repository.ArtPieceDao;

import java.util.List;

@Repository
@Primary
public class JpaArtPieceDao implements ArtPieceDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ArtPiece> findAll() {
        return entityManager.createQuery("select a from ArtPiece a").getResultList();
    }

    @Override
    public ArtPiece findById(int id) {
        return entityManager.find(ArtPiece.class, id);
    }

    @Override
    public List<ArtPiece> findByArtist(Artist d) {
        return entityManager.createQuery("select ap from ArtPiece ap inner join ap.artist where artist=:artist")
                .setParameter("artist", d)
                .getResultList();
    }

    @Override
    public List<ArtPiece> findByExhibition(Exhibition c) {
        return entityManager.createQuery("select ap from ArtPiece ap inner join ap.exhibitions where exhibition=:exhibition")
                .setParameter("exhibition", c)
                .getResultList();
    }

    @Override
    public ArtPiece add(ArtPiece m) {
        return null;
    }
}
