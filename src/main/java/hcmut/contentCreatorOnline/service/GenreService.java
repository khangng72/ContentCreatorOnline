package hcmut.contentCreatorOnline.service;

import hcmut.contentCreatorOnline.dto.genre.GenreResult;
import hcmut.contentCreatorOnline.model.Genre;
import hcmut.contentCreatorOnline.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }


    public List<GenreResult> getAllGenres() {
        List<Genre> genreList = genreRepository.findAll();
        List<GenreResult> genreResultList = new ArrayList<>();

        for (Genre genre : genreList) {
            GenreResult genreResult = new GenreResult(genre.getGenreId(), genre.getGenreName());
            genreResultList.add(genreResult);
        }
        return genreResultList;
    }
}
