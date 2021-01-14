package domain.repository;

import domain.user.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerRepositoryImpl implements PlayerRepository {
    private List<Player> players;

    public PlayerRepositoryImpl() {
        players = new ArrayList<>();
    }

    @Override
    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public void addPlayer(Player player) {
        players.add(player);
    }
}
