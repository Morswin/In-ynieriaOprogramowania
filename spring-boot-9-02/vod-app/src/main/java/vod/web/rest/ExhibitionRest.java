package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vod.model.Exhibition;
import vod.service.ExhibitionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ExhibitionRest {
    private final ExhibitionService exhibitionService;

    @GetMapping("/exhibitions")
    List<Exhibition> getExhibitions() {
        log.info("about to retrieve exhibitions list");
        List<Exhibition> exhibitions = exhibitionService.getAllExhibitions();
        log.info("{} exhibitions found", exhibitions.size());
        return  exhibitions;
    }
}
