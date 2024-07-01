package Lessons.Lesson_03.app.config;

import Lessons.Lesson_03.app.repository.ProductRepository;
import Lessons.Lesson_03.app.repository.ProductRepositoryListImpl;
import Lessons.Lesson_03.app.repository.ProductRepositoryMapImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:aplication.properties")
public class AppConfiguration {

    private final String repositoryType;

    public AppConfiguration(@Value("${repository.type}") String repositoryType) {
        this.repositoryType = repositoryType;
    }

    @Bean
    public ProductRepository getProductRepository() {
if (repositoryType.equals("list")){
    return new ProductRepositoryListImpl();
}
return new ProductRepositoryMapImpl();
    }


}
