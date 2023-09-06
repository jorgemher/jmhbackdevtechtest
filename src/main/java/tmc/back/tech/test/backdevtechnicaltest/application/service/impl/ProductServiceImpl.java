package tmc.back.tech.test.backdevtechnicaltest.application.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import tmc.back.tech.test.backdevtechnicaltest.application.exception.ProductIdNotFoundException;
import tmc.back.tech.test.backdevtechnicaltest.application.service.ExistingApisService;
import tmc.back.tech.test.backdevtechnicaltest.application.service.ProductService;
import tmc.back.tech.test.backdevtechnicaltest.infrastructure.dto.ProductDetail;
import tmc.back.tech.test.backdevtechnicaltest.infrastructure.dto.SimilarProducts;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    @NonNull
    private final ExistingApisService existingApisService;

    @Override
    public SimilarProducts getProductsSimilar(String id) throws ProductIdNotFoundException {
        SimilarProducts similarProducts = new SimilarProducts();
        Set<Integer> productSimilarIds = existingApisService.getProductSimilarIds(id);
        if (Objects.nonNull(productSimilarIds)) {
            Set<ProductDetail> productDetails = new HashSet<>();
            getProductDetails(productSimilarIds, productDetails);
            similarProducts.setProductDetailList(productDetails);
        } else {
            throw new ProductIdNotFoundException();
        }
        return similarProducts;
    }

    private void getProductDetails(Set<Integer> productSimilarIds, Set<ProductDetail> productDetails) {
        List<Flux<ProductDetail>> fluxList = new ArrayList<>();
        productSimilarIds.forEach(id -> fluxList.add(existingApisService.getProductFuture(id)));
        fluxList.forEach(flux -> flux.subscribe(productDetails::add));
    }
}
