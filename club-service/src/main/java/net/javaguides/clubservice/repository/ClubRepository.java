package net.javaguides.clubservice.repository;

import net.javaguides.clubservice.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {
    Club findByClubCode(String clubCode);
}
