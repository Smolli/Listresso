package de.etecture.listresso;

import de.etecture.listresso.domain.Product;
import de.etecture.listresso.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SimpleCommandLinePropertySource;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Arrays;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Autowired
    private Environment environment;
    @Autowired
    private ProductRepository productRepository;

    /**
     * Initializes listresso.
     * <p/>
     * Spring profiles can be configured with a program arguments --spring.profiles.active=your-active-profile
     * <p/>
     */
    @PostConstruct
    void initApplication() throws IOException {
        if (this.environment.getActiveProfiles().length == 0) {
            Application.LOGGER.warn("No Spring profile configured, running with default configuration");
        } else {
            Application.LOGGER.info("Running with Spring profile(s) : {}", Arrays.toString(this.environment.getActiveProfiles()));
        }

        if (this.productRepository.findAll().isEmpty()) {
            this.productRepository.save(new Product("Espresso", 0.60));
            this.productRepository.save(new Product("Doppelter Espresso", 1.20));
            this.productRepository.save(new Product("Milchkaffee", 1.20));
            this.productRepository.save(new Product("Cappuchino", 1.45));
        }
    }

    /**
     * Main method, used to run the application.
     */
    public static void main(final String[] args) {
        final SpringApplication app = new SpringApplication(Application.class);
        app.setShowBanner(false);

        final SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);

        // Check if the selected profile has been set as argument.
        // if not the development profile will be added
        Application.addDefaultProfile(app, source);

        app.run(args);
    }

    /**
     * Set a default profile if it has not been set
     */
    private static void addDefaultProfile(final SpringApplication app, final SimpleCommandLinePropertySource source) {
        if (!source.containsProperty("spring.profiles.active")) {
            app.setAdditionalProfiles("dev");
        }
    }
}
