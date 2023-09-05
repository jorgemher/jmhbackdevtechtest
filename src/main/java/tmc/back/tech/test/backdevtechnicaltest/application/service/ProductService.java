package tmc.back.tech.test.backdevtechnicaltest.application.service;

import tmc.back.tech.test.backdevtechnicaltest.application.exception.ProductIdNotFoundException;
import tmc.back.tech.test.backdevtechnicaltest.infrastructure.dto.SimilarProducts;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public interface ProductService {
    SimilarProducts getProductsSimilar (String id) throws ProductIdNotFoundException, ExecutionException, InterruptedException, TimeoutException;
}
