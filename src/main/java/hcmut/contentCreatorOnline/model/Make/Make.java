package hcmut.contentCreatorOnline.model.Make;

import java.util.UUID;

import hcmut.contentCreatorOnline.model.Reader.Reader;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Make {
    @Id
    @GeneratedValue
    @Column(name = "orderId")
    private UUID orderId;

    // Quan hệ nhiều-một với READER
    @ManyToOne
    @JoinColumn(name = "readerId", referencedColumnName = "readerId")
    private Reader reader;

}
