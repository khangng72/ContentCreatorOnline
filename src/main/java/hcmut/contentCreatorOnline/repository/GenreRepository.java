package hcmut.contentCreatorOnline.repository;

import hcmut.contentCreatorOnline.model.Genre;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    @NotNull
    Optional<Genre> findById(@NotNull Integer genreId);

}
