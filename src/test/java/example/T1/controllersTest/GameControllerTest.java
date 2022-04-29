package example.T1.controllersTest;
import example.T1.controllers.BillController;
import example.T1.controllers.GameController;
import example.T1.model.*;
import example.T1.services.BillService;
import example.T1.services.GameService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;


@SpringBootTest
public class GameControllerTest {

    @InjectMocks
    GameController gameController;

    @Mock
    GameService gameService;

    /**
     * Test to get all objects
     */
    @Test
    public void testFindAll() {
        Game game1 = new Game("nume",2000,  "publisher",20,"gen", "descriere");
        Game game2 = new Game("nume2",20002,  "publisher2",202,"gen2", "descriere2");
        List<Game> games = new ArrayList<>();
        games.add(game1);
        games.add(game2);

        when(gameService.getGames()).thenReturn(games);

        ResponseEntity<List<Game>> result = gameController.getAllGames();

        assertThat(result.getBody().size()).isEqualTo(2);
        assertThat(result.getBody().get(0).getNume()).isEqualTo(game1.getNume());
        assertThat(result.getBody().get(1).getNume()).isEqualTo(game2.getNume());
    }

    /**
     * Test for get a single object by id of item
     */
    @Test
    public void getGamebyIdTest(){
        Game game = new Game("nume",2000,  "publisher",20,"gen", "descriere");

        when(gameService.getGameByID(1)).thenReturn(game);

        ResponseEntity<Game> result = gameController.getGameByID(1);

        assertThat(result.getBody().getNume()).isEqualTo(game.getNume());
    }

    /**
     * Test of creating an object
     */
    @Test
    public void createGameTest(){
        Game game = new Game("nume",2000,  "publisher",20,"gen", "descriere");
        game.setIdGame(1);
        when(gameService.createGame(game)).thenReturn(game);

        ResponseEntity<Game> result = gameController.createGame(game);

        assertThat(result.getBody().getNume()).isEqualTo(game.getNume());
    }

    /**
     * Testing for delete an object by id of object
     */
    @Test
    public void deleteGameIdTest(){
        Game game = new Game("nume",2000,  "publisher",20,"gen", "descriere");
        gameService.deleteGameByID(1);

        ResponseEntity<Game> result = gameController.deleteGameByID(1);

        assertThat(result.getStatusCode().toString()).isEqualTo("204 NO_CONTENT");
    }

    /**
     * Test for update an object properties
     */
    @Test
    public void updateGameTest(){
        Game game = new Game("nume",2000,  "publisher",20,"gen", "descriere");
        gameService.updateGame(1,game);

        ResponseEntity<Game> result = gameController.updateGame(1,game);

        assertThat(result.getStatusCode().toString()).isEqualTo("200 OK");
    }

    /**
     * Test to get all objects with a specific property
     */
    @Test
    public void FindByStudioTest() {
        Game game1 = new Game("nume",2000,  "publisher",20,"gen", "descriere");
        Game game2 = new Game("nume2",20002,  "publisher2",202,"gen2", "descriere2");
        List<Game> games = new ArrayList<>();
        games.add(game1);
        games.add(game2);

        when(gameService.getGamesByPublisher("publisher")).thenReturn(games);

        ResponseEntity<List<Game>> result = gameController.getGamesByPublisher("publisher");

        assertThat(result.getBody().size()).isEqualTo(2);
        assertThat(result.getBody().get(0).getPublisher()).isEqualTo(game1.getPublisher());
        assertThat(result.getBody().get(1).getPublisher()).isEqualTo(game2.getPublisher());
    }

    /**
     * Test to get all objects with a specific property
     */
    @Test
    public void FindByGenTest() {
        Game game1 = new Game("nume",2000,  "publisher",20,"gen", "descriere");
        Game game2 = new Game("nume2",20002,  "publisher2",202,"gen2", "descriere2");
        List<Game> games = new ArrayList<>();
        games.add(game1);
        games.add(game2);

        when(gameService.getGamesByGen("gen")).thenReturn(games);

        ResponseEntity<List<Game>> result = gameController.getGamesByGen("gen");

        assertThat(result.getBody().size()).isEqualTo(2);
        assertThat(result.getBody().get(0).getGen()).isEqualTo(game1.getGen());
        assertThat(result.getBody().get(1).getGen()).isEqualTo(game2.getGen());
    }

    /**
     * Test to get all objects with a specific property
     */
    @Test
    public void FindByYearTest() {
        Game game1 = new Game("nume",2000,  "publisher",20,"gen", "descriere");
        Game game2 = new Game("nume2",20002,  "publisher2",202,"gen2", "descriere2");
        List<Game> games = new ArrayList<>();
        games.add(game1);
        games.add(game2);

        when(gameService.getGamesByAnAparitie(2000)).thenReturn(games);

        ResponseEntity<List<Game>> result = gameController.getGamesByAnAparitie(2000);

        assertThat(result.getBody().size()).isEqualTo(2);
        assertThat(result.getBody().get(0).getAnAparitie()).isEqualTo(game1.getAnAparitie());
        assertThat(result.getBody().get(1).getAnAparitie()).isEqualTo(game2.getAnAparitie());
    }

}
