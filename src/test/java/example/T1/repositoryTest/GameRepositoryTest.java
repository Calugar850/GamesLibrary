package example.T1.repositoryTest;

import example.T1.model.Game;
import example.T1.repositories.GameRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GameRepositoryTest {

    @Mock
    GameRepository gameRepository;

    /**
     * Testing repository for find an object
     */
    @Test
    public void findByIdGameTest(){
        Game game = new Game("nume",2000,  "publisher",20,"gen", "descriere");
        game.setIdGame(1);
        when(gameRepository.findById(1)).thenReturn(Optional.of(game));

        Game result = gameRepository.findById(1).get();

        assertThat(result.getNume()).isEqualTo(game.getNume());
    }

    /**
     * Testing for getting all object from the table
     */
    @Test
    public void findAllGamesTest(){
        Game game1 = new Game("nume",2000,  "publisher",20,"gen", "descriere");
        Game game2 = new Game("nume2",20002,  "publisher2",202,"gen2", "descriere2");
        List<Game> games = new ArrayList<>();
        games.add(game1);
        games.add(game2);

        when(gameRepository.findAll()).thenReturn(games);

        List<Game> result = (List<Game>)gameRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getNume()).isEqualTo(game1.getNume());
        assertThat(result.get(1).getNume()).isEqualTo(game2.getNume());
    }

    /**
     * Testing repository for delete an object
     */
    @Test
    public void deleteByIdPremiumUserTest(){
        Game game = new Game("nume",2000,  "publisher",20,"gen", "descriere");
        game.setIdGame(1);
        gameRepository.deleteById(1);

        Optional<Game> result = gameRepository.findById(1);

        assertThat(result.isEmpty()).isEqualTo(true);
    }

    /**
     * Testing for saving an object in the table
     */
    @Test
    public void saveBaseUserTest(){
        Game game = new Game("nume",2000,  "publisher",20,"gen", "descriere");
        game.setIdGame(1);
        when(gameRepository.save(any())).thenReturn(game);

        Game result = gameRepository.save(game);

        assertThat(result.getNume()).isEqualTo(game.getNume());
    }
}
