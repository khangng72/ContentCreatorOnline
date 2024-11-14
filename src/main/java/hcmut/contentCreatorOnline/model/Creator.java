package hcmut.contentCreatorOnline.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Creator extends CCO_User{
    @Column(name = "penName")
    private String penName;

    @Column(name = "numberOfContents")
    private BigInteger numberOfContents;

    @Column(name = "numberOfFollowers")
    private BigInteger numberOfFollowers;
//
//    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
//    @JsonBackReference
//    private Set<Creation> creationSet;
//
//    @OneToMany(mappedBy = "tierNumber", cascade = CascadeType.ALL)
//    @JsonBackReference
//    private Set<Join_Tier> joinTiers;
}
