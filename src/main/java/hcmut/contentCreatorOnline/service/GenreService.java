package hcmut.contentCreatorOnline.service;

import hcmut.contentCreatorOnline.dto.genre.GenreResult;
import hcmut.contentCreatorOnline.exception.ApplicationException;
import hcmut.contentCreatorOnline.exception.ErrorConst;
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

    public GenreResult getGenreById(Integer genreId) {
        Genre genre = genreRepository.findById(genreId)
                .orElseThrow(() -> new ApplicationException(
                        ErrorConst.RESOURCE_NOT_FOUND,
                        String.format("Genre with id %s not found", genreId)
                ));
        
        return new GenreResult(genre.getGenreId(), genre.getGenreName());
    }
}
