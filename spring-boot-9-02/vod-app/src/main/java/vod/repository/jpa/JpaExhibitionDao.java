package vod.repository.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import vod.model.ArtPiece;
import vod.model.Exhibition;
import vod.repository.ExhibitionDao;

import java.util.List;

@Repository
public class JpaExhibitionDao implements ExhibitionDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Exhibition> findAll() {
        return entityManager.createQuery("select c from Exhibition c").getResultList();
    }

    @Override
    public Exhibition findById(int id) {
        return entityManager.find(Exhibition.class, id);
    }

    @Override
    public List<Exhibition> findByArtPiece(ArtPiece m) {
        return entityManager
                .createQuery("select c from Exhibition c inner join c.artpiece where artpiece=:artpiece")
                .setParameter("artpiece", m)
                .getResultList();
    }

    @Override
    public Exhibition save(Exhibition exhibition) {
        entityManager.persist(exhibition);
        return exhibition;
    }
}
