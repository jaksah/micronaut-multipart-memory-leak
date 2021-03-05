package micronaut.multipart.memory.leak;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.multipart.CompletedFileUpload;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.reactivex.Maybe;
import java.util.UUID;

@Controller
@Secured(SecurityRule.IS_AUTHENTICATED)
public class LeakController {
    @Post(value = "/image", consumes = MediaType.MULTIPART_FORM_DATA)
    public Maybe<Profile> addImage(
        CompletedFileUpload file
    ) {
        return Maybe.fromCallable(file::getBytes)
                   .map(ignore ->
                            Profile.builder()
                                .id(UUID.randomUUID())
                                .name("name")
                                .image("...")
                                .build()
                   );
    }
}
