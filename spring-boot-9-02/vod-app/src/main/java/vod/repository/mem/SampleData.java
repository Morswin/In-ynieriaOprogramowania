package vod.repository.mem;

import vod.model.Exhibition;
import vod.model.Artist;
import vod.model.ArtPiece;

import java.util.ArrayList;
import java.util.List;

class SampleData {

    static List<Exhibition> exhibitions = new ArrayList<>();

    static List<Artist> artists = new ArrayList<>();

    static List<ArtPiece> artPieces = new ArrayList<>();

    static {
        Artist vanGogh = new Artist(1, "Vincent", "van Gogh");
        Artist daVinci = new Artist(2, "Leonardo", "da Vinci");
        Artist picasso = new Artist(3, "Pablo", "Picasso");
        Artist kahlo = new Artist(4, "Frida", "Kahlo");

        ArtPiece starryNight = new ArtPiece(1, "Starry Night", "https://upload.wikimedia.org/wikipedia/commons/e/ea/The_Starry_Night.jpg", vanGogh, (float)4.9);
        ArtPiece sunflowers = new ArtPiece(2, "Sunflowers", "https://upload.wikimedia.org/wikipedia/commons/4/40/Vincent_Willem_van_Gogh_127.jpg", vanGogh, (float)4.7);

        ArtPiece monaLisa = new ArtPiece(3, "Mona Lisa", "https://upload.wikimedia.org/wikipedia/commons/6/6a/Mona_Lisa.jpg", daVinci, (float)5.0);
        ArtPiece lastSupper = new ArtPiece(4, "The Last Supper", "https://upload.wikimedia.org/wikipedia/commons/4/4b/Leonardo_da_Vinci_-_Last_Supper.jpg", daVinci, (float)4.8);

        ArtPiece guernica = new ArtPiece(5, "Guernica", "https://upload.wikimedia.org/wikipedia/en/7/74/PicassoGuernica.jpg", picasso, (float)4.6);
        ArtPiece weepingWoman = new ArtPiece(6, "The Weeping Woman", "https://upload.wikimedia.org/wikipedia/en/7/74/Picasso_The_Weeping_Woman.jpg", picasso, (float)4.4);

        ArtPiece twoFridas = new ArtPiece(7, "The Two Fridas", "https://upload.wikimedia.org/wikipedia/commons/1/1e/The_Two_Fridas.jpg", kahlo, (float)4.5);

        bind(starryNight, vanGogh);
        bind(sunflowers, vanGogh);

        bind(monaLisa, daVinci);
        bind(lastSupper, daVinci);

        bind(guernica, picasso);
        bind(weepingWoman, picasso);

        bind(twoFridas, kahlo);

        Exhibition modernArt = new Exhibition(1, "Modern Art Exhibition", "https://upload.wikimedia.org/wikipedia/commons/0/0a/Museum_of_Modern_Art_logo.svg");
        Exhibition renaissance = new Exhibition(2, "Renaissance Masters", "https://upload.wikimedia.org/wikipedia/commons/5/5f/Louvre_Museum_Wikimedia_Commons.jpg");
        Exhibition cubism = new Exhibition(3, "Cubism and Beyond", "https://upload.wikimedia.org/wikipedia/commons/3/3a/Museo_Reina_Sofia_logo.png");
        Exhibition womenArt = new Exhibition(4, "Women in Art", "https://upload.wikimedia.org/wikipedia/commons/9/9b/Frida_Kahlo_Museum_logo.png");

        bind(modernArt, starryNight);
        bind(modernArt, sunflowers);

        bind(renaissance, monaLisa);
        bind(renaissance, lastSupper);

        bind(cubism, guernica);
        bind(cubism, weepingWoman);

        bind(womenArt, twoFridas);
        bind(modernArt, guernica);
        bind(cubism, starryNight);

        artPieces.add(starryNight);
        artPieces.add(sunflowers);
        artPieces.add(monaLisa);
        artPieces.add(lastSupper);
        artPieces.add(guernica);
        artPieces.add(weepingWoman);
        artPieces.add(twoFridas);

        artists.add(vanGogh);
        artists.add(daVinci);
        artists.add(picasso);
        artists.add(kahlo);

        exhibitions.add(modernArt);
        exhibitions.add(renaissance);
        exhibitions.add(cubism);
        exhibitions.add(womenArt);

//        Artist smarzowski = new Artist(1, "Wojciech", "Smarzowski");
//        Artist vega = new Artist(2, "Patryk", "Vega");
//        Artist wajda = new Artist(3, "Andrzej", "Wajda");
//        Artist skolimowski = new Artist(4, "Jerzy", "Skolimowski");
//
//        ArtPiece wolyn = new ArtPiece(1, "Wolyn", "https://ocdn.eu/pulscms-transforms/1/D0gk9kuTURBXy8zYzFhMDRhZS1jOGRiLTQxN2YtOTcwYy1iNjRjZDBkMjc4MDYuanBlZ5GTBc0DFM0BvIGhMAU", smarzowski, (float) 4.1);
//        ArtPiece wesele = new ArtPiece(2, "Wesele", "https://fwcdn.pl/fpo/40/98/124098/7521214.6.jpg", smarzowski, (float) 4.3);
//
//        ArtPiece polityka = new ArtPiece(3, "Polityka", "https://i.iplsc.com/-/00094J03E94SMPSS-C122.jpg", vega, (float) 3.9);
//        ArtPiece pitbul = new ArtPiece(4, "Pitbul", "https://bi.im-g.pl/im/5b/9b/12/z19510363V,-Pitbull--Nowe-porzadki---rez--Patryk-Vega--plakat.jpg", vega, (float) 3.1);
//
//        ArtPiece katyn = new ArtPiece(5, "Katyn", "http://www.gokmichalowo.pl/imprezy2007/katyn/plakat_maly.jpg", wajda, (float) 4.7);
//        ArtPiece tatarak = new ArtPiece(6, "Tatarak", "http://gapla.fn.org.pl/public/cache/P21829-483x700.jpg", wajda, (float) 4.4);
//
//        ArtPiece essential = new ArtPiece(7, "Essential killing", "https://m.media-amazon.com/images/M/MV5BNTE5NjAxMTEzNl5BMl5BanBnXkFtZTcwMjYzMDQ0Ng@@._V1_UX182_CR0,0,182,268_AL_.jpg", skolimowski, (float) 4.9);
//        ArtPiece ferdydurke = new ArtPiece(8, "Ferdydurke", "http://gapla.fn.org.pl/public/cache/P19423-483x700.jpg", skolimowski, (float) 4.3);
//
//        bind(wolyn, smarzowski);
//        bind(wesele, smarzowski);
//
//        bind(polityka, vega);
//        bind(pitbul, vega);
//
//        bind(katyn, wajda);
//        bind(tatarak, wajda);
//
//        bind(essential, skolimowski);
//        bind(ferdydurke, skolimowski);
//
//        Exhibition kinoteka = new Exhibition(1, "Kinoteka", "https://www.kinoteka.pl/img/logo.png");
//        Exhibition podBaranami = new Exhibition(2, "Kino pod Baranami", "http://www.festiwalfilmuniemego.pl/wp-content/uploads/2015/11/Kino-pod-Baranami.png");
//        Exhibition noweHoryzonty = new Exhibition(3, "Kino Nowe Horyzonty", "https://i2.wp.com/garretreza.pl/wp-content/uploads/2018/07/nh.jpg");
//        Exhibition zak = new Exhibition(4, "Kino Zak", "https://static2.s-trojmiasto.pl/zdj/c/n/19/2276/250x0/2276445.jpg");
//
//        bind(kinoteka, wesele);
//        bind(noweHoryzonty, wesele);
//        bind(noweHoryzonty, wolyn);
//        bind(noweHoryzonty, polityka);
//
//        bind(kinoteka, tatarak);
//        bind(zak, tatarak);
//        bind(zak, essential);
//        bind(podBaranami, essential);
//        bind(podBaranami, polityka);
//
//        artPieces.add(wolyn);
//        artPieces.add(wesele);
//        artPieces.add(polityka);
//        artPieces.add(pitbul);
//        artPieces.add(katyn);
//        artPieces.add(tatarak);
//        artPieces.add(essential);
//        artPieces.add(ferdydurke);
//
//        artists.add(smarzowski);
//        artists.add(vega);
//        artists.add(wajda);
//        artists.add(skolimowski);
//
//        exhibitions.add(kinoteka);
//        exhibitions.add(podBaranami);
//        exhibitions.add(noweHoryzonty);
//        exhibitions.add(zak);

    }

    private static void bind(Exhibition c, ArtPiece m) {
        c.addArtPiece(m);
        m.addExhibition(c);
    }

    private static void bind(ArtPiece m, Artist d) {
        d.addArtPiece(m);
        m.setArtist(d);
    }

}
