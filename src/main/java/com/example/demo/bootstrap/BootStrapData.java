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
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        if (partRepository.count() == 0 && outsourcedPartRepository.count() == 0 && productRepository.count() == 0) {


            //NEW FIX: 5 Parts instantiated manually
            OutsourcedPart gbcIPSDisplay = new OutsourcedPart();
            gbcIPSDisplay.setCompanyName("Western Governors University");
            gbcIPSDisplay.setName("Game Boy Color IPS Display");
            gbcIPSDisplay.setInv(50);
            gbcIPSDisplay.setPrice(30.0);
            gbcIPSDisplay.setId(100L);
            gbcIPSDisplay.setMinValue(5);
            gbcIPSDisplay.setMaxValue(500);
            outsourcedPartRepository.save(gbcIPSDisplay);

            OutsourcedPart ledButtons = new OutsourcedPart();
            ledButtons.setCompanyName("Western Governors University");
            ledButtons.setName("LED Buttons");
            ledButtons.setInv(20);
            ledButtons.setPrice(500.0);
            ledButtons.setId(200L);
            ledButtons.setMinValue(5);
            ledButtons.setMaxValue(300);
            outsourcedPartRepository.save(ledButtons);

            InhousePart gbaShell = new InhousePart();
            gbaShell.setName("GBA Shell");
            gbaShell.setInv(50);
            gbaShell.setPrice(60.0);
            gbaShell.setId(300L);
            gbaShell.setMinValue(5);
            gbaShell.setMaxValue(500);
            partRepository.save(gbaShell);

            InhousePart gbcShell = new InhousePart();
            gbcShell.setName("GBC Shell");
            gbcShell.setInv(30);
            gbcShell.setPrice(45.0);
            gbcShell.setId(400L);
            gbcShell.setMinValue(3);
            gbcShell.setMaxValue(400);
            partRepository.save(gbcShell);

            InhousePart usbcCharger = new InhousePart();
            usbcCharger.setName("USB-C Charger");
            usbcCharger.setInv(20);
            usbcCharger.setPrice(20.0);
            usbcCharger.setId(500L);
            usbcCharger.setMinValue(5);
            usbcCharger.setMaxValue(300);
            partRepository.save(usbcCharger);

            List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                System.out.println(part.getName() + " " + part.getCompanyName());
            }


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
