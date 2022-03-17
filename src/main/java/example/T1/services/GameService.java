package example.T1.services;

import example.T1.model.Game;

import java.util.List;
/**
 * Is an interface for declaration of methods which will applied for game table
 */
public interface GameService {
    /**
     *
     * @return List games
     */
    List<Game> getGames();
    /**
     *
     * @param  id integer
     * @return Game
     */
    Game getGameByID(Integer id);
    /**
     *
     * @param game object
     * @return Game
     */
    Game createGame(Game game);
    /**
     *
     * @param id integer
     * @param game object
     */
    void updateGame(Integer id, Game game);
    /**
     *
     * @param id integer
     */
    void deleteGameByID(Integer id);
}
