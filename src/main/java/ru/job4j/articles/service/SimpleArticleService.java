package ru.job4j.articles.service;

import ru.job4j.articles.model.Article;
import ru.job4j.articles.model.Word;
import ru.job4j.articles.service.generator.ArticleGenerator;
import ru.job4j.articles.store.Store;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleArticleService implements ArticleService {

    private final ArticleGenerator articleGenerator;

    private final Store<Word> wordStore;

    private final Store<Article> articleStore;

    public SimpleArticleService(ArticleGenerator articleGenerator,
                                Store<Word> wordStore,
                                Store<Article> articleStore) {
        this.articleGenerator = articleGenerator;
        this.wordStore = wordStore;
        this.articleStore = articleStore;
    }

    @Override
    public List<Article> generate(int count) {
        var words = wordStore.findAll();
        var articles = IntStream.iterate(0, i -> i < count, i -> i + 1)
            .mapToObj((x) -> articleGenerator.generate(words))
            .collect(Collectors.toList());
        articles.forEach(articleStore::save);
        return articles;
    }
}
