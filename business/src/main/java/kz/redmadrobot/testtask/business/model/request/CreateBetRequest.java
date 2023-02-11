package kz.redmadrobot.testtask.business.model.request;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class CreateBetRequest {

    private Long adId;
    private Long userId;
    private BigDecimal offeredPrice;

}
