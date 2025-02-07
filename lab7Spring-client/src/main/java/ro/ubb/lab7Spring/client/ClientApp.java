package ro.ubb.lab7Spring.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.RestTemplate;
import ro.ubb.lab7Spring.web.dto.BooksDto;
import ro.ubb.lab7Spring.web.dto.CustomersDto;
import ro.ubb.lab7Spring.web.dto.RentalsBookDto;

public class ClientApp {
    public static void main(String[] args) {
        System.out.println("Hello, Java Spring!");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("ro.ubb.lab7Spring.client.config");

        RestTemplate restTemplate = context.getBean(RestTemplate.class);

        String booksUrl = "http://localhost:8080/api/books";
        BooksDto booksDto = restTemplate.getForObject(booksUrl, BooksDto.class);
        System.out.println(booksDto);

        String customersUrl = "http://localhost:8080/api/customers";
        CustomersDto customersDto = restTemplate.getForObject(customersUrl, CustomersDto.class);
        System.out.println(customersDto);

        String rentalsBookUrl = "http://localhost:8080/api/rentalsbook";
        RentalsBookDto rentalsBookDto = restTemplate.getForObject(rentalsBookUrl, RentalsBookDto.class);
        System.out.println(rentalsBookDto);
    }
}