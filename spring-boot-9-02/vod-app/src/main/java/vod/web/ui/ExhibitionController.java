package vod.web.ui;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vod.model.ArtPiece;
import vod.model.Exhibition;
import vod.service.ArtPieceService;
import vod.service.ExhibitionService;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ExhibitionController {
    private final ExhibitionService exhibitionService;
    private final ArtPieceService artPieceService;

    @GetMapping("/exhibitions")
    String getExhibitions(Model model, @RequestParam(value = "artPieceId", required = false) Integer artPieceId ) {
        log.info("about to display exhibition list");
        if (artPieceId != null) {
            ArtPiece artPiece = artPieceService.getArtPieceById(artPieceId);
            List<Exhibition> exhibitions = exhibitionService.getExhibitionsByArtPiece(artPiece);
            model.addAttribute("exhibitions", exhibitions);
            model.addAttribute("title", "Exhibitions displaying: " + artPiece.getTitle());
        } else {
            List<Exhibition> exhibitions = exhibitionService.getAllExhibitions();
            model.addAttribute("exhibitions", exhibitions);
            model.addAttribute("title", "Exhibitions");
        }
        return "exhibitionsView";
    }
}
