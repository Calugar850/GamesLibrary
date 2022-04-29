package example.T1.servicesImplTest;


import example.T1.model.Game;
import example.T1.repositories.GameRepository;
import example.T1.services.GameServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GameServiceImplTest {

    @InjectMocks
    GameServiceImpl gameService;

    @Mock
    private GameRepository gameRepository;

    /**
     * Testing to retrieve an object with a specific id
     */
    @Test
    public void getGameIdTest(){
        Game game = new Game("nume",2000,  "publisher",20,"gen", "descriere");
        game.setIdGame(1);

        when(gameRepository.findById(1)).thenReturn(java.util.Optional.of(game));

        Game result = gameService.getGameByID(1);

        assertThat(result.getNume()).isEqualTo(game.getNume());
    }

    /**
     * Testing to retrieve all objects of this type
     */
    @Test
    public void getAllGamesTest(){
        Game game = new Game("nume",2000,  "publisher",20,"gen", "descriere");
        Game game2 = new Game("nume2",20002,  "publisher2",202,"gen2", "descriere2");
        List<Game> games = new ArrayList<>();
        games.add(game);
        games.add(game2);

        when(gameRepository.findAll()).thenReturn(games);

        List<Game> result = gameService.getGames();

        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getNume()).isEqualTo(game.getNume());
        assertThat(result.get(1).getNume()).isEqualTo(game2.getNume());
    }

    /**
     * Testing for creating an object
     */
    @Test
    public void createGameTest(){
        Game game = new Game("nume",2000,  "publisher",20,"gen", "descriere");
        game.setIdGame(1);

        when(gameRepository.save(any())).thenReturn(game);

        Game result = gameService.createGame(game);

        assertThat(result.getNume()).isEqualTo(game.getNume());
    }

    /**
     * Test for delete an object with a specific Id
     */
    @Test
    public void deleteGameIdTest(){
        Game game = new Game("nume",2000,  "publisher",20,"gen", "descriere");
        game.setIdGame(1);
        gameService.deleteGameByID(1);

        assertThat(game.getNume()).isEqualTo("nume");
    }

    /**
     * Testing for updating an objects properties
     */
    @Test
    public void updateGameTest(){
        Game game = new Game("nume",2000,  "publisher",20,"gen", "descriere");
        game.setIdGame(1);
        gameRepository.save(game);
        game.setNume("Nume2");

        assertThat(game.getNume()).isEqualTo("Nume2");
    }

    /**
     * Testing to retrieve a list of objects with a specific property value
     */
    @Test
    public void FindByStudioTest() {
        Game game1 = new Game("nume",2000,  "publisher",20,"gen", "descriere");
        Game game2 = new Game("nume2",20002,  "publisher2",202,"gen2", "descriere2");
        List<Game> games = new ArrayList<>();
        games.add(game1);
        games.add(game2);

        when(gameRepository.findAll()).thenReturn(games);

        List<Game> result = gameService.getGamesByPublisher("publisher");

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getPublisher()).isEqualTo(game1.getPublisher());
    }

    /**
     * Testing to retrieve a list of objects with a specific property value
     */
    @Test
    public void FindByGenTest() {
        Game game1 = new Game("nume",2000,  "publisher",20,"gen", "descriere");
        Game game2 = new Game("nume2",20002,  "publisher2",202,"gen2", "descriere2");
        List<Game> games = new ArrayList<>();
        games.add(game1);
        games.add(game2);

        when(gameRepository.findAll()).thenReturn(games);

        List<Game> result = gameService.getGamesByGen("gen");

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getGen()).isEqualTo(game1.getGen());

    }

    /**
     * Testing to retrieve a list of objects with a specific property value
     */
    @Test
    public void FindByYearTest() {
        Game game1 = new Game("nume",2000,  "publisher",20,"gen", "descriere");
        Game game2 = new Game("nume2",20002,  "publisher2",202,"gen2", "descriere2");
        List<Game> games = new ArrayList<>();
        games.add(game1);
        games.add(game2);

        when(gameRepository.findAll()).thenReturn(games);

        List<Game> result = gameService.getGamesByAnAparitie(2000);

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getAnAparitie()).isEqualTo(game1.getAnAparitie());
    }
}
