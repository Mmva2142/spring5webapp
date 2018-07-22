package guru.spring5webapp.service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by shifengyuan.
 * Date: 2018/6/23
 * Time: 23:02
 */
@Service
public class JokeServiceImpl implements JokeService {

    @Autowired
    public ChuckNorrisQuotes chuckNorrisQuotes;

    @Override
    public String getJoke() {
        return chuckNorrisQuotes.getRandomQuote();
    }
}
