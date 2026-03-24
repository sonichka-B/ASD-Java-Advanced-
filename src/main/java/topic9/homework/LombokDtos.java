package topic9.homework;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

public class LombokDtos {
    @Data //@Getter + @Setter + @RequiredArgsConstructor + @ToString + @EqualsAndHashCode (клас мутабельний)
    public static class AttendeeDto{
        private String name;
        private int id;
    }

    @Value //@Getter + @AllArgsConstructor + @ToString + @EqualsAndHashCode + final-поля (клас іммутабельний)
    public static class Pass{
        String name;
        int id;
    }
    @Builder
    public static class NotificationRequest{
        private String name;
       private int id;
    }
    NotificationRequest notificationRequest = NotificationRequest.builder()
            .id(43)
            .name("Aba")
            .build();
}
