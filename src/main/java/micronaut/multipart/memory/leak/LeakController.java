package micronaut.multipart.memory.leak;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.multipart.CompletedFileUpload;
import io.reactivex.Maybe;
import java.util.UUID;

@Controller
public class LeakController {
    @Post(value = "/image", consumes = MediaType.MULTIPART_FORM_DATA)
    public Maybe<Profile> addImage(
        CompletedFileUpload file
    ) {
        return Maybe.just(Profile.builder()
                              .id(UUID.randomUUID())
                              .name("name")
                              .image("...")
                              .build());
    }
}
