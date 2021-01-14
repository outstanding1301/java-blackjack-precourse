package domain.repository;

import domain.user.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerRepositoryImplTest {
    PlayerRepository repository;
    @BeforeEach
    void PlayerRepositoryTest() {
        repository = new PlayerRepositoryImpl();
        repository.addPlayer(new Player("Ingeol", 100));
        repository.addPlayer(new Player("Cat", 10000));
        repository.addPlayer(new Player("Dog", 100));
        repository.addPlayer(new Player("Pizza", 50));
    }

    @Test
    void getPlayers() {
        System.out.println(repository.getPlayers());
    }
}