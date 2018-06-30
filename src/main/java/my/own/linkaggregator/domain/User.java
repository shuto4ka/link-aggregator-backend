package my.own.linkaggregator.domain;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "\"user\"",
        uniqueConstraints = {@UniqueConstraint(columnNames = "username", name = "user_unique_username_idx")})
@Access(AccessType.FIELD)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "tasks")
public class User {

    @Id
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @Access(value = AccessType.PROPERTY)
    private Long id;

    @Column(name = "username", nullable = false)
    @NotBlank
    private String username;

    @Column(name = "password", nullable = false)
    @NotBlank
    private String password;

    @Singular
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.REMOVE)
    @OrderBy("id")
    private List<Task> tasks;


    //Removing password from graph
    @GraphQLQuery(name = "password")
    public String getPasswordForGraphQL() {
        return null;
    }
}
