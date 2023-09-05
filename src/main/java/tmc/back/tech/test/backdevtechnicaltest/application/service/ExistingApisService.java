package tmc.back.tech.test.backdevtechnicaltest.application.service;

import tmc.back.tech.test.backdevtechnicaltest.infrastructure.dto.ProductDetail;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public interface ExistingApisService {
    Set<Integer> getProductSimilarIds(String productId);
    CompletableFuture<ProductDetail> getProductFuture(Integer productId);
    ProductDetail getProduct(Integer productId);
}
