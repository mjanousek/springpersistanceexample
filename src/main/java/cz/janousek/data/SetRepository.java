package cz.janousek.data;

import cz.janousek.web.SpecialSet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SetRepository extends JpaRepository<SpecialSet, Long> {
}
