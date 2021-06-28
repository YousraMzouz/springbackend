package inpt.sud.springbackend;
import inpt.sud.springbackend.dao.CategoryRepository;
import inpt.sud.springbackend.dao.ProductRepository;
import inpt.sud.springbackend.model.Category;
import inpt.sud.springbackend.model.Product;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class SpringbackendApplication implements CommandLineRunner {
   // private RepositoryRestConfiguration repositoryRestConfiguration;
    @Autowired
    ProductRepository productRepository; //déclarons l'objet sans le creer grace à @Autowired qui permet d'injecter cette objet
                                         //cad l'objet ne va pas etre instantier par le developeur mais par le framework
    @Autowired
    CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbackendApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

       // repositoryRestConfiguration.exposeIdsFor(Product.class , Category.class);

        categoryRepository.save(new Category(null,"Computers", null, null));
        categoryRepository.save(new Category(null,"Printers", null, null));
        categoryRepository.save(new Category(null,"Smartphones", null, null));

        Random rnd = new Random();

        categoryRepository.findAll().forEach( category -> {
            for(int i =1 ; i <=10 ; i++ ){
                Product p = new Product();
                p.setName(RandomString.make(10));
                p.setCurrentPrice(100+ rnd.nextInt(10000) );
                p.setAvailable(rnd.nextBoolean());
                p.setSelected(rnd.nextBoolean());
                p.setPromotion(rnd.nextBoolean());
                p.setCategory(category);
                p.setPhotoName("unknown.png");

                productRepository.save(p);

            }
        });

       /*   List<String> names = Arrays.asList("Computers", "Printers", "Smartphones");

      for (int i = 0; i < 3; i++){
            Category c = new Category();
            c.setId(null);
            c.setName(names.get(i));
            c.setDescription(null);
            c.setProducts(null);
            categoryRepository.save(c);

        }
       */
            //ici j'appelle n'importe quel méthode sans se soucier de creer les clases, les extends...
            //productRepository.findAll();
          // repositoryRestConfiguration.exposeIdsFor(Product.class, Category.class);
        }
}
