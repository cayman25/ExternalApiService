package pl.bookmaker.externalservice.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.bookmaker.externalservice.demo.apiServices.DateValidation;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import pl.bookmaker.externalservice.demo.ExternalApi.ApiFootballJsonCollection;
=======
import pl.bookmaker.externalservice.demo.testService.ApiFootballUrlToGetJsonCollection;
>>>>>>> 602866516a36c48a67921a27f401eeb264533225
=======
import pl.bookmaker.externalservice.demo.testService.ApiFootballJsonCollection;
>>>>>>> parent of ffaced8... test
=======
import pl.bookmaker.externalservice.demo.ExternalApi.ApiFootballJsonCollection;
>>>>>>> parent of 40c459c... test
=======
import pl.bookmaker.externalservice.demo.testService.ApiFootballJsonCollection;
>>>>>>> parent of ffaced8... test

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class ApiFootballJsonCollectionTest {

    private String currentDate = DateValidation.getTodayWithAddOrSubstract(0);
    private String nextDate = DateValidation.getTodayWithAddOrSubstract(14);

    @Test
    public void listShouldNotBeEmpty(){
        ApiFootballJsonCollection jsonCollection = new ApiFootballJsonCollection();
        List<String> list = jsonCollection.createUrl();

        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void listShouldHaveCorrectUrl(){

        final String  VALID_URL="http://api.football-data.org/v2/competitions/2021/matches?dateFrom="+ currentDate + "&dateTo=" + nextDate;

        ApiFootballJsonCollection jsonCollection = new ApiFootballJsonCollection();
        String url = jsonCollection.createUrl().get(0);
        Assert.assertEquals(url, VALID_URL);
    }
}
