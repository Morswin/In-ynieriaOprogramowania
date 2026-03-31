package vod.service.impl;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vod.model.Exhibition;
import vod.model.ArtPiece;
import vod.repository.ExhibitionDao;
import vod.repository.ArtPieceDao;
import vod.service.ExhibitionService;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ExhibitionServiceBean implements ExhibitionService {

    private static final Logger log = Logger.getLogger(ExhibitionService.class.getName());

    private ExhibitionDao exhibitionDao;
    private ArtPieceDao artPieceDao;

    public ExhibitionServiceBean(ExhibitionDao exhibitionDao, ArtPieceDao artPieceDao) {
        log.info("creating exhibition service bean");
        this.exhibitionDao = exhibitionDao;
        this.artPieceDao = artPieceDao;
    }

    @Override
    public Exhibition getExhibitionById(int id) {
        log.info("searching exhibition by id " + id);
        return exhibitionDao.findById(id);
    }

    @Override
    public List<ArtPiece> getArtPiecesInExhibition(Exhibition c) {
        log.info("searching art pieces displayed in exhibition " + c.getId());
        return artPieceDao.findByExhibition(c);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public Exhibition addExhibition(Exhibition e) {
        log.info("adding new exhibition" + e);
        return exhibitionDao.save(e);
    }

    @Override
    public List<Exhibition> getAllExhibitions() {
        log.info("searching all exhibitions");
        return exhibitionDao.findAll();
    }

    @Override
    public List<Exhibition> getExhibitionsByArtPiece(ArtPiece m) {
        log.info("searching exhibitions by art piece " + m.getId());
        return exhibitionDao.findByArtPiece(m);
    }

}
