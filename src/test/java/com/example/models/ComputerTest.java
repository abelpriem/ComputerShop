package com.example.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    void testGetters() {
        Computer computer = new Computer("Dell", 8, "i5", "Windows 10", 599.99);

        assertEquals("Dell", computer.getBrand(), "Brand should be Dell");
        assertEquals(8, computer.getMemory(), "Memory should be 8");
        assertEquals("i5", computer.getProcessor(), "Processor should be i5");
        assertEquals("Windows 10", computer.getOperatingSystem(), "OS should be W10");
        assertEquals(599.99, computer.getPrice(), "Price should be 599,99");
    }

    @Test
    void testSetters() {
        Computer computer = new Computer();

        computer.setBrand("HP");
        computer.setMemory(16);
        computer.setProcessor("i7");
        computer.setOperatingSystem("Windows 11");
        computer.setPrice(879.99);

        assertEquals("HP", computer.getBrand(), "Brand should be HP");
        assertEquals(16, computer.getMemory(), "Memory should be 16");
        assertEquals("i7", computer.getProcessor(), "Processor should be i7");
        assertEquals("Windows 11", computer.getOperatingSystem(), "OS should be Windows 11");
        assertEquals(879.99, computer.getPrice(), "Price should be 879,99");
    }
}
