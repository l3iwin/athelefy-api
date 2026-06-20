package com.athelefy.repository;

import com.athelefy.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<List<Player>> findByTeams_Id(Long teamId);

}
