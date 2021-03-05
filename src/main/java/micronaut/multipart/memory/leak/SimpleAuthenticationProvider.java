package micronaut.multipart.memory.leak;

import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.AuthenticationProvider;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.micronaut.security.authentication.UserDetails;
import io.reactivex.Maybe;
import java.util.ArrayList;
import javax.inject.Singleton;
import org.reactivestreams.Publisher;

@Singleton
public class SimpleAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Publisher<AuthenticationResponse> authenticate(
        final HttpRequest<?> httpRequest,
        final AuthenticationRequest<?, ?> authenticationRequest
    ) {
        return Maybe.<AuthenticationResponse>create(emitter -> {
                emitter.onSuccess(new UserDetails("user", new ArrayList<>()));
        }).toFlowable();
    }
}
