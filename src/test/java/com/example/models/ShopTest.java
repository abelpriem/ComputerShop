package com.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.models.Computer;
import com.example.models.Shop;

public class ShopTest {
    Shop shop;
    Computer computer1;
    Computer computer2;
    Computer computer3;

    @BeforeEach
    public void setUp() {
        shop = new Shop("TiendaPCs", "Abel", 1234, new ArrayList<>());
        computer1 = new Computer("Dell", 8, "i5", "Windows 10", 599.99);
        computer2 = new Computer("HP", 16, "i7", "Windows 11", 879.99);
        computer3 = new Computer("Mackbook Air", 8, "M2", "Sequoia 15", 1299.99);
    }

    @Test
    public void testSetters() {
        Shop otherShop = new Shop(null, null, 0, null);

        otherShop.setShopName("Apple Store");
        otherShop.setOwnerName("Iker Fernández");
        otherShop.setTaxId(4321);

        assertEquals("Apple Store", otherShop.getShopName(), "Shop name should be Apple Store");
        assertEquals("Iker Fernández", otherShop.getOwnerName(), "Owner name should be Iker Fernández");
        assertEquals(4321, otherShop.getTaxId(), "Tax ID should be 4321");
    }

    @Test
    public void testGetters() {
        Shop otherShop = new Shop(null, null, 0, null);
        Computer newComputer = new Computer("Lenovo", 32, "i9", "Ubuntu 28", 759.99);

        otherShop.addComputer(newComputer);

        assertEquals(1, otherShop.getComputers().size());
        assertEquals("Lenovo", otherShop.getComputers().get(0).getBrand());
    }

    @Test
    public void addComputerTest() {
        shop.addComputer(computer3);
        assertEquals(1, shop.getComputers().size());
        assertEquals("Mackbook Air", computer3.getBrand());
        assertEquals(8, computer3.getMemory());
        assertEquals("M2", computer3.getProcessor());
        assertEquals("Sequoia 15", computer3.getOperatingSystem());
        assertEquals(1299.99, computer3.getPrice());
    }

    @Test
    public void deleteComputerTest() {
        shop.addComputer(computer1);
        shop.addComputer(computer2);

        assertEquals(2, shop.getComputers().size());

        shop.deleteComputer("Dell");
        assertEquals(1, shop.getComputers().size());
    }

    @Test
    public void getComputersTest() {
        shop.addComputer(computer1);
        shop.addComputer(computer3);

        assertEquals("M2", shop.getComputers().get(1).getProcessor());
        assertEquals(599.99, shop.getComputers().get(0).getPrice());
    }

    @Test
    public void searchComputerTest() {
        shop.addComputer(computer1);
        shop.addComputer(computer2);
        shop.addComputer(computer3);

        List<Computer> result = shop.searchComputer("Mackbook Air");
        assertEquals(1, result.size());
        assertEquals("Sequoia 15", result.get(0).getOperatingSystem());
    }

    @Test
    public void getEmptyComputersTest() {
        assertTrue(shop.getComputers().isEmpty());
    }
}
