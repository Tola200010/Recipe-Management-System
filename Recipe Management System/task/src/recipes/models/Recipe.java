package recipes.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Fetch(value = FetchMode.SUBSELECT)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> ingredients;
    @Fetch(value = FetchMode.SUBSELECT)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> directions;
    private String category;
    @UpdateTimestamp
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;
}
