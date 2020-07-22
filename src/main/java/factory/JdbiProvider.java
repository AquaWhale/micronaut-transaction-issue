package factory;

import io.micronaut.context.annotation.Factory;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.argument.Arguments;
import org.jdbi.v3.core.argument.NullArgument;
import org.jdbi.v3.core.statement.SqlStatements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.sql.DataSource;
import java.sql.Types;

@Factory
public class JdbiProvider {

    private static final Logger LOG = LoggerFactory.getLogger(JdbiProvider.class);

    @Inject
    private DataSource dataSource;


    @Singleton
    public Jdbi initWrapper() {
        Jdbi jdbi = Jdbi.create(dataSource);
        jdbi.getConfig(SqlStatements.class).setUnusedBindingAllowed(true);
        jdbi.getConfig(Arguments.class).setUntypedNullArgument(new NullArgument(Types.NULL));
        LOG.info("JDBI wrapper initialized ({})!", jdbi);
        return jdbi;
    }
}
