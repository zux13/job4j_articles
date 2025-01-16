package ru.job4j.articles.service.generator;

import ru.job4j.articles.model.Article;
import ru.job4j.articles.model.Word;

import java.util.Collections;
import java.util.List;

public class RandomArticleGenerator implements ArticleGenerator {
    @Override
    public Article generate(List<Word> words) {
        Collections.shuffle(words);
        StringBuilder contentBuilder = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            if (i > 0) {
                contentBuilder.append(" ");
            }
            contentBuilder.append(words.get(i).getValue());
        }
        return new Article(contentBuilder.toString());
    }
}
