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

    /**
     * This method call is used to retrieve a list of games based on publisher
     * @param publisher String
     * @return game List
     */
    List<Game> getGamesByPublisher(String publisher);

    /**
     * This method call is used to retrieve a list of games based on gen
     * @param gen String
     * @return game List
     */
    List<Game> getGamesByGen(String gen);

    /**
     * This method call is used to retrieve a list of games based on year
     * @param anAparitie int
     * @return game List
     */
    List<Game> getGamesByAnAparitie(int anAparitie);

}
