package tmc.back.tech.test.backdevtechnicaltest.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimilarProducts {
    @NonNull
    private Set<ProductDetail> productDetailList;
}
