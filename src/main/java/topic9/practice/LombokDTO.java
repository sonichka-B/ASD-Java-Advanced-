package topic9.practice;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

public class LombokDTO {
    @Data
    public static class UserDTO{
        private String name;
        private String id;
    }
    @Value
    public static class Price{
         String name;
         String id;
    }
    @Builder
    public static class CheckoutRequest{
        private String name;
        private String id;
    }
    CheckoutRequest check = CheckoutRequest.builder()
            .name("sdf")
            .id("12")
            .build();

}
