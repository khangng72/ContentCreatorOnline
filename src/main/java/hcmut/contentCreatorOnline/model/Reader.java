package hcmut.contentCreatorOnline.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Reader extends CCO_User{

//    @Column(name = "readerId", updatable = false, nullable = false)
//    private UUID readerId;

    @Column(name = "readingTime")
    private Date readingTime;

    @Column(name = "isShowInfo", length = 100)
    private String isShowInfo;

    @Column(name = "nickName", length = 100)
    private String nickName;
//
//    @OneToMany(mappedBy = "reader", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private Set<Order> orderSet;
//
//    @ManyToMany(mappedBy = "readers")
//    @JsonBackReference
//    private Set<Genre> genres;
}
