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
public class ArtPieceController {
    private final ArtPieceService artPieceService;
    private final ExhibitionService exhibitionService;

    @GetMapping("/artPieces")
    String getExhibitions(Model model, @RequestParam(value = "exhibitionId", required = false) Integer exhibitionId ) {
        log.info("about to display exhibition list");
        if (exhibitionId != null) {
            Exhibition exhibition = exhibitionService.getExhibitionById(exhibitionId);
            List<ArtPiece> artPieces = exhibitionService.getArtPiecesInExhibition(exhibition);
            model.addAttribute("artPieces", artPieces);
            model.addAttribute("title", "Art pieces displayed in: " + exhibition.getName());
        } else {
            List<ArtPiece> artPieces = artPieceService.getAllArtPieces();
            model.addAttribute("artPieces", artPieces);
            model.addAttribute("title", "Artpieces");
        }
        return "artPiecesView";
    }
}
