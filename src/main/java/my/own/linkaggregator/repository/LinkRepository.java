package my.own.linkaggregator.repository;

import my.own.linkaggregator.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {

    List<Link> findAllByTaskId(long id);
}
