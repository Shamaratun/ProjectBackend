package org.isdb.ProjectBackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Wishlist")
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer wishlistID;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    // @OneToMany(mappedBy = "wishlist")
    // private List<WishlistItem> items;


}