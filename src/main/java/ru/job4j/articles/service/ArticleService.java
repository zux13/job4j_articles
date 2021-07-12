package ru.job4j.articles.service;

import ru.job4j.articles.model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> generate(int count);
}
