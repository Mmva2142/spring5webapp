package guru.spring5webapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by shifengyuan.
 * Date: 2018/6/29
 * Time: 20:38
 */

@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

}
