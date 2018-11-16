package pl.bookmaker.externalservice.demo.externalApi;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bookmaker.externalservice.demo.models.entity.Game;
import pl.bookmaker.externalservice.demo.repository.GameRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class InMemoryGameRepository  {

    private HashMap<Integer, Game> map = new HashMap<>();

    Game save(Game game) {
        map.put(game.getMatchID(), game);
        return game;
    }

    Game findOne(int id) {
        return map.get(id);
    }

    void delete(int id) {
        map.remove(id);
    }

    List<Game> saveAll(List<Game> games){
        games.stream().map(game ->
                map.put(game.getMatchID(),game));
        return null;
    }
/*  Page<Game> findAll(Pageable pageable){
    List<Game> games =new ArrayList<>(map.values());
    return new PageImpl<>(games,pageable,games.size());
  }*/


}
