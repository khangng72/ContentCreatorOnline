package hcmut.contentCreatorOnline.model.Contains;

import jakarta.persistence.Column;

import java.util.UUID;

public class Contains {

    @Column(name = "readListId", nullable = false)
    private UUID readListId;


    @Column(name = "creationId", nullable = false)
    private UUID creationId;
}
