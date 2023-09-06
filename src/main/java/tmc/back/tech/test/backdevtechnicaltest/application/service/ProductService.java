package tmc.back.tech.test.backdevtechnicaltest.application.service;

import tmc.back.tech.test.backdevtechnicaltest.application.exception.ProductIdNotFoundException;
import tmc.back.tech.test.backdevtechnicaltest.infrastructure.dto.SimilarProducts;

public interface ProductService {
    SimilarProducts getProductsSimilar (String id)
            throws ProductIdNotFoundException;
}
