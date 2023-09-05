package tmc.back.tech.test.backdevtechnicaltest.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetail {
    @NonNull
    private String id;
    @NonNull
    private String name;
    @NonNull
    private Float number;
    @NonNull
    private Boolean availability;
}
