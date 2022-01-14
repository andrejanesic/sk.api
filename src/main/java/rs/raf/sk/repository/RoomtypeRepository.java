package rs.raf.sk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import rs.raf.sk.models.Roomtype;

@Repository
public interface RoomtypeRepository extends JpaRepository<Roomtype, Integer>, JpaSpecificationExecutor<Roomtype> {
}