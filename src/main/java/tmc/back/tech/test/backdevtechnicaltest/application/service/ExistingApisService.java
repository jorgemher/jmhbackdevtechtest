package tmc.back.tech.test.backdevtechnicaltest.application.service;

import reactor.core.publisher.Flux;
import tmc.back.tech.test.backdevtechnicaltest.infrastructure.dto.ProductDetail;

import java.util.Set;

public interface ExistingApisService {
    Set<Integer> getProductSimilarIds(String productId);
    Flux<ProductDetail> getProductFuture(Integer productId);
}
