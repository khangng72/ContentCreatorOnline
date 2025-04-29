package hcmut.contentCreatorOnline.controller.genre;


import hcmut.contentCreatorOnline.dto.genre.GenreResult;
import hcmut.contentCreatorOnline.dto.genre.GetAllGenresResponse;
import hcmut.contentCreatorOnline.service.GenreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/genre")
public class GenreController {


    GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/all")
    public ResponseEntity<GetAllGenresResponse> getAllGenres() {
        List<GenreResult> result = genreService.getAllGenres();
        GetAllGenresResponse response = new GetAllGenresResponse(HttpStatus.OK.value(), result);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{genreId}")
    public ResponseEntity<GenreResult> getGenreById(@PathVariable Integer genreId) {
        GenreResult result = genreService.getGenreById(genreId);
        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
