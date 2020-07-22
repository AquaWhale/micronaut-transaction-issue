package micronaut.transaction.issue;

import org.jdbi.v3.core.Jdbi;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Repository {

    @Inject
    private Jdbi jdbi;

    public boolean test () {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO test (name) VALUES ('haha')");

        int success = jdbi.withHandle(handle -> handle
                .createUpdate(sql.toString())
                .execute());

        return success == 1;
    }
}
