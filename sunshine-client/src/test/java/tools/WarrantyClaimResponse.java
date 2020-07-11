package tools;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class WarrantyClaimResponse implements Serializable {

    private static final long serialVersionUID = -5052819479816333681L;

    public WarrantyClaimResponse() {
    }

    @JsonProperty("id")
    private long lineItemId;
    private Long parentId;
    private Long contributionId;
    private Boolean claimable;
    private String productCode;
    private String businessCode;
    private Double totalAmount;
    private Double claimAmount;
    private Double customerShareAmount;
    private Double handlingFee;
    private Double claimUnitPrice;
    private boolean valid;
    private String errorCode;
    private List<WarrantyClaimResponse> children;

    public boolean isInvalid() {
        return claimable && !valid;
    }
}
