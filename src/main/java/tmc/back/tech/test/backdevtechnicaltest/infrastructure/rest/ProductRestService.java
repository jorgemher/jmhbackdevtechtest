package tmc.back.tech.test.backdevtechnicaltest.infrastructure.rest;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tmc.back.tech.test.backdevtechnicaltest.application.exception.ProductIdNotFoundException;
import tmc.back.tech.test.backdevtechnicaltest.application.service.ProductService;
import tmc.back.tech.test.backdevtechnicaltest.infrastructure.dto.SimilarProducts;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductRestService {
    @NonNull
    private final ProductService productService;

    @RequestMapping (method = RequestMethod.GET, path = "/product/{productId}/similar")
    public ResponseEntity<SimilarProducts> getProductsSimilar (@PathVariable("productId") String productId)
            throws ProductIdNotFoundException {
        return ResponseEntity.ok(productService.getProductsSimilar(productId));
    }
}
