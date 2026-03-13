package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vod.model.ArtPiece;
import vod.model.Exhibition;
import vod.service.ArtPieceService;
import vod.service.ExhibitionService;
import vod.web.rest.dto.ArtPieceDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class ArtPieceRest {
    private final ExhibitionService exhibitionService;
    private final ArtPieceService artPieceService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;

    @GetMapping("/artpieces")
    List<ArtPiece> getArtPieces() {
        log.info("about to retrieve art piece list");
        List<ArtPiece> artPieces = artPieceService.getAllArtPieces();
        log.info("{} art pieces found", artPieces.size());
        return artPieces;
    }

    @GetMapping("/artpieces/{id}")
    ResponseEntity<ArtPiece> getArtPiece(@PathVariable("id") int id) {
        log.info("about to retrieve art piece {}", id);
        ArtPiece artPiece = artPieceService.getArtPieceById(id);
        log.info("art piece found {}", artPiece);
        if (artPiece != null) {
            return ResponseEntity.ok(artPiece);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/exhibitions/{exhibitionId}/artpieces")
    ResponseEntity<List<ArtPiece>> getArtPiecesDisplayedAtExhibition(@PathVariable("exhibitionId") int exhibitionId) {
        log.info("about to retrieve art pieces displayed at exhibition {}", exhibitionId);
        Exhibition exhibition = exhibitionService.getExhibitionById(exhibitionId);
        if (exhibition == null) {
            return ResponseEntity.notFound().build();
        } else {
            List<ArtPiece> artPieces = exhibitionService.getArtPiecesInExhibition(exhibition);
            log.info("there are {} art pieces at exhibition {}", artPieces.size(), exhibitionId);
            return ResponseEntity.ok(artPieces);
        }
    }

    @PostMapping("/artpieces")
    ResponseEntity<?> addArtPiece(@RequestBody ArtPieceDTO artPieceDTO) {
        log.info("about to add an art piece");
        ArtPiece artPiece = new ArtPiece();
        artPiece.setTitle(artPieceDTO.getTitle());
        artPiece.setPoster(artPieceDTO.getPoster());
        artPiece.setRating(artPieceDTO.getRating());
        artPiece.setArtist(artPieceService.getArtistById(artPieceDTO.getArtistId()));
        artPiece = artPieceService.addArtPiece(artPiece);
        log.info("new art piece added {}", artPiece);
        return ResponseEntity
                .created(
                        ServletUriComponentsBuilder
                                .fromCurrentRequestUri()
                                .path("/" + artPiece.getId())
                                .build()
                                .toUri()
                )
                .body(artPiece);
    }
}


