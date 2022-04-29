package example.T1.services;

import example.T1.model.Game;
import example.T1.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * This class implement the logic for operation on game table from database
 */
@Service
public class GameServiceImpl implements GameService {

    GameRepository gameRepository;

    /**
     *
     * @param gameRepository interface
     */
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    /**
     *
     * @return List games
     */
    @Override
    public List<Game> getGames() {
        List<Game> games=new ArrayList<>();
        gameRepository.findAll().forEach(games::add);
        return games;
    }

    /**
     *
     * @param id integer
     * @return Game
     */
    @Override
    public Game getGameByID(Integer id) {
        return gameRepository.findById(id).get();
    }

    /**
     *
     * @param game object
     * @return Game
     */
    @Override
    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    /**
     *
     * @param id integer
     * @param game object
     */
    @Override
    public void updateGame(Integer id, Game game) {
        Game game1=gameRepository.findById(id).get();
        game1.setNume(game.getNume());
        game1.setAnAparitie(game.getAnAparitie());
        game1.setPublisher(game.getPublisher());
        game1.setPret(game.getPret());
        game1.setGen(game.getGen());
        game1.setDescriere(game.getDescriere());
        gameRepository.save(game1);
    }

    /**
     *
     * @param id integer
     */
    @Override
    public void deleteGameByID(Integer id) {
        gameRepository.deleteById(id);
    }

    /**
     * This method call is used to retrieve a list of games based on publisher
     * @param publisher String
     * @return game List
     */
    @Override
    public List<Game> getGamesByPublisher(String publisher){
        List<Game> games=new ArrayList<>();
        for(Game g: gameRepository.findAll()){
            if(g.getPublisher().equals(publisher)){
                games.add(g);
            }
        }
        return games;
    }

    /**
     * This method call is used to retrieve a list of games based on gen
     * @param gen String
     * @return game List
     */
    @Override
    public List<Game> getGamesByGen(String gen) {
        List<Game> games=new ArrayList<>();
        for(Game g: gameRepository.findAll()){
            if(g.getGen().equals(gen)){
                games.add(g);
            }
        }
        return games;
    }

    /**
     * This method call is used to retrieve a list of games based on year
     * @param anAparitie int
     * @return game List
     */
    @Override
    public List<Game> getGamesByAnAparitie(int anAparitie) {
        List<Game> games=new ArrayList<>();
        for(Game g: gameRepository.findAll()){
            if(g.getAnAparitie()==anAparitie){
                games.add(g);
            }
        }
        return games;
    }

}
