package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository = outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for (OutsourcedPart part : outsourcedParts) {
            System.out.println(part.getName() + " " + part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        if (partRepository.count() == 0 && outsourcedPartRepository.count() == 0 && productRepository.count() == 0) {

            //5 Parts instantiated using newly added constructors.
            OutsourcedPart gbcIPSDisplay = new OutsourcedPart("Game Boy Color IPS Display", 50, 30);
            OutsourcedPart ledButtons = new OutsourcedPart("LED Buttons", 20, 500);
            InhousePart gbaShell = new InhousePart("Game Boy Advance Premium Shell", 30, 45);
            InhousePart gbcShell = new InhousePart("Game Boy Color Premium Shell", 30, 60);
            InhousePart usbcCharger = new InhousePart("USB-C Charger Upgrade", 20, 15);
            partRepository.save(gbcIPSDisplay);
            partRepository.save(ledButtons);
            partRepository.save(gbaShell);
            partRepository.save(gbcShell);
            partRepository.save(usbcCharger);


            //5 Products instantiated using constructors
            Product gameBoyColor = new Product("Game Boy Color", 80.0, 15);
            Product gameBoyAdvance = new Product("Game Boy Advance", 120.0, 20);
            Product gameBoyMicro = new Product("Game Boy Micro", 200.0, 30);
            Product gbaModded = new Product("Modded Game Boy Advance", 300.0, 20);
            Product gbcModded = new Product("Modded Game Boy Color", 280.0, 15);
            productRepository.save(gameBoyColor);
            productRepository.save(gameBoyAdvance);
            productRepository.save(gameBoyMicro);
            productRepository.save(gbaModded);
            productRepository.save(gbcModded);

        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products" + productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts" + partRepository.count());
        System.out.println(partRepository.findAll());
    }
}
