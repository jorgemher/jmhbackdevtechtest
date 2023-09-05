package tmc.back.tech.test.backdevtechnicaltest.application.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tmc.back.tech.test.backdevtechnicaltest.application.service.ExistingApisService;
import tmc.back.tech.test.backdevtechnicaltest.infrastructure.dto.ProductDetail;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class ExistingApisServiceImpl implements ExistingApisService {
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String getProductsSimilarIdsUrl = "http://host.docker.internal:3001/product/{productId}/similarids";
    private static final String getProduct = "http://host.docker.internal:3001/product/{productId}";

    public Set<Integer> getProductSimilarIds(String productId) {
        Map<String, Integer> params = getProductIdParamMap(Integer.parseInt(productId));
        return restTemplate.getForObject(getProductsSimilarIdsUrl, Set.class, params);
    }

    @Async
    @Override
    public CompletableFuture<ProductDetail> getProductFuture(Integer productId) {
        Map<String, Integer> params = getProductIdParamMap(productId);
        return CompletableFuture.completedFuture(restTemplate.getForObject(getProduct, ProductDetail.class, params));
    }

    @Override
    public ProductDetail getProduct(Integer productId) {
        Map<String, Integer> params = getProductIdParamMap(productId);
        return restTemplate.getForObject(getProduct, ProductDetail.class, params);
    }

    private static Map<String, Integer> getProductIdParamMap(Integer productId) {
        Map<String, Integer > params = new HashMap<>();
        params.put("productId", productId);
        return params;
    }
}
