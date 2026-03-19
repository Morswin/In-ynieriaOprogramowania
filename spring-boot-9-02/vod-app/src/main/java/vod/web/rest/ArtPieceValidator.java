package vod.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vod.model.Artist;
import vod.service.ArtPieceService;
import vod.web.rest.dto.ArtPieceDTO;

@Component
@RequiredArgsConstructor
public class ArtPieceValidator implements Validator {
    private final ArtPieceService artPieceService;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(ArtPieceDTO.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ArtPieceDTO artPieceDTO = (ArtPieceDTO) target;
        Artist artist = artPieceService.getArtistById(artPieceDTO.getArtistId());
        if (artist == null) {
            errors.rejectValue("artistId", "artpiece.artist.missing");
        }
    }
}
