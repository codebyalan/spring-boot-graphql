package com.ambro.spring.graphql.dto;

import java.util.Set;

public record BookRec(String title, Set<Long> authorIds,int publishedYear, String isbn, Long publicationId) {}
