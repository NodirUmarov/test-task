package kz.redmadrobot.testtask.business.model.request;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class CreateAdRequest {

    private String title;
    private String description;
    private BigDecimal minimalPrice;
    private Long categoryId;
    private Long userId;
    private byte[] imageData;

}