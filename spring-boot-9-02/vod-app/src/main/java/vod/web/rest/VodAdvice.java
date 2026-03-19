package vod.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice(basePackages = "vod.web.rest")
@RequiredArgsConstructor
@Slf4j
public class VodAdvice {
    private final ExhibitionValidator exhibitionValidator;
    private final ArtPieceValidator artPieceValidator;

    @InitBinder("exhibition")
    public void initBinderForExhibition(WebDataBinder binder) {binder.addValidators(exhibitionValidator);}

    @InitBinder("artPieceDTO")
    public void initBinderForArtPiece(WebDataBinder binder) {binder.addValidators(artPieceValidator);}

    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        log.info("illegal argument provided {}", e);
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<String> handleException(Exception e) {
        log.info("generic exception {}", e);
        return ResponseEntity.status(HttpStatus.LOOP_DETECTED).body(e.getMessage());
    }
}
