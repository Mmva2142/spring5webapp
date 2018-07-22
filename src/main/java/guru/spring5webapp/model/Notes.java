package guru.spring5webapp.model;

import lombok.*;

import javax.persistence.*;

/**
 * Created by shifengyuan.
 * Date: 2018/6/28
 * Time: 21:09
 */

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe recipe;

    @Lob
    private String recipeNotes;

}
