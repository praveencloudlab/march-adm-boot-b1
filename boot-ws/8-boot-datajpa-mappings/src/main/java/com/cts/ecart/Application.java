package  com.cts.ecart;

import com.cts.ecart.entity.*;
import com.cts.ecart.repository.BrandRepository;
import com.cts.ecart.repository.CategoryRepository;
import com.cts.ecart.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext context= SpringApplication.run(Application.class, args);
         ProductRepository prodRepo= context.getBean(ProductRepository.class);
        CategoryRepository catRepo=context.getBean(CategoryRepository.class);
        BrandRepository brandRepo=context.getBean(BrandRepository.class);


        List<Product> productList = new ArrayList<>();

        // Product 1
        Price price1 = new Price(1000);
        Stock stock1 = new Stock(54);
        Product product1 = new Product("iPhone 13", "iphone-13.jpg", "Apple iPhone 13, A15 Bionic chip, iOS 15", 4.5, price1, stock1);
        productList.add(product1);

        // Product 2
        Price price2 = new Price(1500.00);
        Stock stock2 = new Stock(50);
        Product product2 = new Product("Samsung Galaxy Z Fold 3", "galaxy-z-fold-3.jpg", "Samsung Galaxy Z Fold 3, foldable AMOLED display", 4.0, price2, stock2);
        productList.add(product2);

        // Product 3
        Price price3 = new Price(999.99);
        Stock stock3 = new Stock(200);
        Product product3 = new Product("MacBook Pro", "macbook-pro.jpg", "Apple MacBook Pro, M1 chip, macOS Monterey", 4.8, price3, stock3);
        productList.add(product3);

        // Product 4
        Price price4 = new Price(500.00);
        Stock stock4 = new Stock(150);
        Product product4 = new Product("Xbox Series X", "xbox-series-x.jpg", "Microsoft Xbox Series X, 4K gaming, 120fps", 4.3, price4, stock4);
        productList.add(product4);

        // Product 5
        Price price5 = new Price(699.00);
        Stock stock5 = new Stock(100);
        Product product5 = new Product("Sony Alpha a6600", "sony-alpha-a6600.jpg", "Sony Alpha a6600, 24.2MP, 4K video", 4.7, price5, stock5);
        productList.add(product5);

        // Product 6
        Price price6 = new Price(129.99);
        Stock stock6 = new Stock(500);
        Product product6 = new Product("AirPods Pro", "airpods-pro.jpg", "Apple AirPods Pro, active noise cancellation, spatial audio", 4.5, price6, stock6);
        productList.add(product6);

        // Product 7
        Price price7 = new Price(599.00);
        Stock stock7 = new Stock(300);
        Product product7 = new Product("Canon EOS R6", "canon-eos-r6.jpg", "Canon EOS R6, 20.1MP, 4K video", 4.6, price7, stock7);
        productList.add(product7);

        // Product 8
        Price price8 = new Price(799.00);
        Stock stock8 = new Stock(50);
        Product product8 = new Product("DJI Mavic Air 2S", "dji-mavic-air-2s.jpg", "DJI Mavic Air 2S, 4K/60fps video, 1/2-inch CMOS sensor", 4.8, price8, stock8);
        productList.add(product8);

        // Product 9
        Price price9 = new Price(1299.00);
        Stock stock9 = new Stock(20);
        Product product9 = new Product("LG C1 Series OLED TV", "lg-c1-oled-tv.jpg", "LG C1 Series OLED TV, 4K Ultra HD, HDR10, Dolby Vision", 4.9, price9, stock9);
        productList.add(product9);

        // Product 10
        Price price10 = new Price(899.00);
        Stock stock10 = new Stock(100);
        Product product10 = new Product("PlayStation 5", "playstation-5.jpg", "Sony PlayStation 5, 4K gaming, 120fps", 4.4, price10, stock10);
        productList.add(product10);


       // prodRepo.saveAll(productList);

        List<Brand> brandList = new ArrayList<>();

        // Brand 1
        Brand brand1 = new Brand("Nike");
        brandList.add(brand1);

        // Brand 2
        Brand brand2 = new Brand("Adidas");
        brandList.add(brand2);

        // Brand 3
        Brand brand3 = new Brand("Apple");
        brandList.add(brand3);

        // Brand 4
        Brand brand4 = new Brand("Samsung");
        brandList.add(brand4);

        // Brand 5
        Brand brand5 = new Brand("Sony");
        brandList.add(brand5);

        // Brand 6
        Brand brand6 = new Brand("Canon");
        brandList.add(brand6);

        // Brand 7
        Brand brand7 = new Brand("Dell");
        brandList.add(brand7);

        // Brand 8
        Brand brand8 = new Brand("HP");
        brandList.add(brand8);

        // Brand 9
        Brand brand9 = new Brand("LG");
        brandList.add(brand9);

        // Brand 10
        Brand brand10 = new Brand("Microsoft");
        brandList.add(brand10);

        List<String> categoryNames = Arrays.asList(
                "Electronics",
                "Clothing",
                "Beauty",
                "Books",
                "Home & Kitchen",
                "Toys & Games",
                "Sports & Outdoors",
                "Health",
                "Automotive",
                "Pet Supplies"
        );

        List<Category> categoryList = IntStream.range(0, categoryNames.size())
                .mapToObj(i -> new Category(categoryNames.get(i)))
                .collect(Collectors.toList());

         brandRepo.saveAll(brandList);
         catRepo.saveAll(categoryList);







    }

}
