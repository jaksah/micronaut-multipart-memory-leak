package micronaut.multipart.memory.leak;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Profile {
    UUID id;
    String name;
    String image;
}
