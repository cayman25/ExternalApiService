package pl.bookmaker.externalservice.demo.externalApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.bookmaker.externalservice.demo.models.entity.Game;

import java.util.List;

class ApiFootballFacade {

    private final ApiFootballGameCollection apiFootballGameCollection;
    private final ApiFootballConsumer apiFootballConsumer;
    private final ApiFootballUrls apiFootballUrls;
    private final ApiFootballFilterGame apiFootballFilterGame;

    ApiFootballFacade(ApiFootballGameCollection apiFootballGameCollection, ApiFootballConsumer apiFootballConsumer, ApiFootballUrls apiFootballUrls, ApiFootballFilterGame apiFootballFilterGame) {
        this.apiFootballGameCollection=apiFootballGameCollection;
        this.apiFootballConsumer = apiFootballConsumer;
        this.apiFootballUrls = apiFootballUrls;
        this.apiFootballFilterGame = apiFootballFilterGame;
    }

    void updateGameCollection(){
        List<Game> games = apiFootballConsumer.getGameEntityCollection(apiFootballUrls.createListUrl());
        apiFootballGameCollection.setFinishedGames(apiFootballFilterGame.getFinishedGames(games));
        apiFootballGameCollection.setAllGames(apiFootballFilterGame.getAllNotFinishedGames(games));
    }

}
