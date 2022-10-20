package integration;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.utility.DockerImageName;

public class ContainerizedDbIntegrationTest {

    private static final int PORT = 3306;
    private static final String PASSWORD = "password";

    public static MySQLContainer mysql;

    protected String getDbPassword() {
        return PASSWORD;
    }

    protected String getDbUrl(){
        return "jdbc:mysql://127.0.0.1:3306/";
    }

    protected String getDb() {
        return "testA3";
    }

    protected String getConnectionString() {
        return getDbUrl() + getDb();
    }

    protected void runMigration(double level) {
        String url = getDbUrl();
        String db = getDb();
        Flyway flyway = new Flyway(
                new FluentConfiguration()
                        .schemas(db)
                        .defaultSchema(db)
                        .createSchemas(true)
                        .target(Double.toString(level))
                        .dataSource(url, "root", PASSWORD)
        );
        flyway.repair();
        flyway.migrate();
    }

}
