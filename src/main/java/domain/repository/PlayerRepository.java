package domain.repository;

import domain.user.Player;

import java.util.List;

public interface PlayerRepository {
    List<Player> getPlayers();
    void addPlayer(Player player);
}
