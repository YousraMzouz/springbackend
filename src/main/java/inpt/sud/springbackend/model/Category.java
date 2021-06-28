package inpt.sud.springbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
@Entity // ca represente une table dans la base de données
@Data //pour les getters et les setters
@NoArgsConstructor @AllArgsConstructor @ToString //outils lombuk facultative c permet de générer les construct automatiquement

public class Category implements Serializable { //pour serialiser les données

    @Id                                                 //il s'agit de l'id au niveau de la base de données
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generer l'id autom sans le taper manuelement

    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "category") //relation entre les tables : un produit a une seule categorie
    private Collection<Product> products ;
}
