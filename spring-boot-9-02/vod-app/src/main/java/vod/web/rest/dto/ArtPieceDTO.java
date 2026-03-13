package vod.web.rest.dto;

import lombok.Data;

@Data
public class ArtPieceDTO {
    private String title;
    private String poster;
    private int artistId;
    private float rating;
}
