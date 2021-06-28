package inpt.sud.springbackend.dao;

import org.springframework.web.bind.annotation.CrossOrigin;


import inpt.sud.springbackend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository; //une classe qui sert à effectuer des opérations CRUD sans ecrire aucune ligne de code
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@CrossOrigin("*")
@RepositoryRestResource
//on va beneficier non seulement de la coucge dao mais aussi de la couche controller sans écrire aucune ligne de code grace à la dependance REST Repositories
public interface CategoryRepository extends JpaRepository<Category, Long> {
        //on specifie la classe surlaquele on veut effectuer les ope CRUS et le type de son id


        }

