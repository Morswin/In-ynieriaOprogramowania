package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vod.model.ArtPiece;
import vod.model.Exhibition;
import vod.service.ArtPieceService;
import vod.service.ExhibitionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class ExhibitionRest {
    private final ExhibitionService exhibitionService;
    private final ArtPieceService artPieceService;

    @GetMapping("/exhibitions")
    List<Exhibition> getExhibitions(
            @PathVariable(value = "phrase", required = false) String phrase,
            @RequestHeader(value = "custom-header", required = false) String customHeader,
            @CookieValue(value = "some-cookie", required = false) String someCookie) {
        log.info("about to retrieve exhibitions list");
        log.info("phrase param: {}", phrase);
        log.info("custom header param: {}", customHeader);
        log.info("some cookie: {}", someCookie);
        List<Exhibition> exhibitions = exhibitionService.getAllExhibitions();
        log.info("{} exhibitions found", exhibitions.size());
        return  exhibitions;
    }

    @GetMapping("/exhibitions/{id}")
    ResponseEntity<Exhibition> getExhibition(@PathVariable("id") int id) {
        log.info("about to retrieve exhibition {}", id);
        Exhibition exhibition = exhibitionService.getExhibitionById(id);
        log.info("exhibition found: {}", exhibition);
        if (exhibition != null) {
            return ResponseEntity.status(200).body(exhibition);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/artpieces/{id}/exhibitions")
    ResponseEntity<List<Exhibition>> getExhibitionsDisplayingArtPiece(@PathVariable("id") int id) {
        log.info("about to retrieve exhibition displaying art piece: {}", id);
        ArtPiece artPiece = artPieceService.getArtPieceById(id);
        if (artPiece == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            List<Exhibition> exhibitions = exhibitionService.getExhibitionsByArtPiece(artPiece);
            log.info("found {} exhibitions displaying art piece {}", exhibitions.size(), artPiece);
            return ResponseEntity.status(200).body(exhibitions);
        }
    }

    @PostMapping("/exhibitions")
    ResponseEntity<Exhibition> addExhibition(@RequestBody Exhibition exhibition) {
        log.info("about to add new exhibition {} ", exhibition);
        exhibition = exhibitionService.addExhibition(exhibition);
        log.info("new exhibition added {}", exhibition);
        return ResponseEntity.status(HttpStatus.CREATED).body(exhibition);
    }
}
