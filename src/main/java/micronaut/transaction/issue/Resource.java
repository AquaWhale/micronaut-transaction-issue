package micronaut.transaction.issue;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import javax.inject.Inject;

@Controller("/test")
public class Resource {

    @Inject
    Service service;

    @Get
    public String index() {
        return service.test();
    }
}
