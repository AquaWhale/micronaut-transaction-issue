package micronaut.transaction.issue;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
public class Service {

    @Inject
    Repository repository;

    @Transactional
    public String test() {
        boolean success = repository.test();
        if (!success) {
            throw new RuntimeException();
        }
        throw new RuntimeException();
    }
}
