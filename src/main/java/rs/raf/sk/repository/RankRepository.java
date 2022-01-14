package rs.raf.sk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import rs.raf.sk.models.Rank;

@Repository
public interface RankRepository extends JpaRepository<Rank, Integer>, JpaSpecificationExecutor<Rank> {
}