package my.own.linkaggregator.domain;

import lombok.*;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "\"user\"",
        uniqueConstraints = {@UniqueConstraint(columnNames = "username", name = "user_unique_username_idx")})
@Access(AccessType.FIELD)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User /*implements UserDetails */{

    @Id
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @Access(value = AccessType.PROPERTY)
    private Long id;

    private String username;
    private String password;

    @Singular
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @OrderBy("id")
    @BatchSize(size = 100)
    private List<Task> tasks;

//    @Column(name = "authorities", columnDefinition = "text[]")
//    @Convert(converter = AuthoritiesToArrayConverter.class)
//    private List<Authority> authorities;

    private boolean enabled;


//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
}
