package vod.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import vod.repository.ExhibitionDao;
import vod.repository.ArtistDao;
import vod.repository.ArtPieceDao;
import vod.model.Exhibition;
import vod.model.Artist;
import vod.model.ArtPiece;
import vod.service.ArtPieceService;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ArtPieceServiceBean implements ArtPieceService {

    private static final Logger log = Logger.getLogger(ArtPieceService.class.getName());

    private ArtistDao artistDao;
    private ExhibitionDao exhibitionDao;
    private ArtPieceDao artPieceDao;

    public ArtPieceServiceBean(ArtistDao artistDao, ExhibitionDao exhibitionDao, ArtPieceDao artPieceDao) {
        this.artistDao = artistDao;
        this.exhibitionDao = exhibitionDao;
        this.artPieceDao = artPieceDao;
    }

    public List<ArtPiece> getAllArtPieces() {
        log.info("searching all art pieces...");
        return artPieceDao.findAll();
    }

    public List<ArtPiece> getArtPiecesByArtist(Artist d) {
        log.info("searching art pieces by artist " + d.getId());
        return artPieceDao.findByArtist(d);
    }

    public List<ArtPiece> getArtPiecesInExhibition(Exhibition c) {
        log.info("searching art pieces displayed in exhibition " + c.getId());
        return artPieceDao.findByExhibition(c);
    }

    public ArtPiece getArtPieceById(int id) {
        log.info("searching art piece by id " + id);
        return artPieceDao.findById(id);
    }

    public List<Exhibition> getAllExhibitions() {
        log.info("searching all exhibitions");
        return exhibitionDao.findAll();
    }

    public List<Exhibition> getExhibitionsByArtPiece(ArtPiece m) {
        log.info("searching exhibitions by art piece " + m.getId());
        return exhibitionDao.findByArtPiece(m);
    }

    public Exhibition getExhibitionById(int id) {
        log.info("searching exhibitions by id " + id);
        return exhibitionDao.findById(id);
    }

    public List<Artist> getAllArtists() {
        log.info("searching all artists");
        return artistDao.findAll();
    }

    public Artist getArtistById(int id) {
        log.info("searching artist by id " + id);
        return artistDao.findById(id);
    }

    @Override
    public ArtPiece addArtPiece(ArtPiece m) {
        log.info("about to add art piece " + m);
        return artPieceDao.add(m);
    }

    @Override
    public Artist addArtist(Artist d) {
        log.info("about to add artist " + d);
        return artistDao.add(d);
    }

}
