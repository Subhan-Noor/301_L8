package com.example.lab08;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomListTest {
    
    private CustomList mockCityList() {
        return new CustomList();
    }

    @Test
    public void testHasCityReturnsTrueWhenCityPresent() {
        CustomList list = mockCityList();
        City calgary = new City("Calgary", "AB");
        list.addCity(calgary);

        assertTrue(list.hasCity(calgary));
    }

    @Test
    public void testDeleteCityRemovesExistingCity() {
        CustomList list = mockCityList();
        City edmonton = new City("Edmonton", "AB");
        list.addCity(edmonton);

        list.deleteCity(edmonton);

        assertFalse(list.hasCity(edmonton));
    }

    @Test
    public void testDeleteCityNoCrashIfMissing() {
        CustomList list = mockCityList();
        City regina = new City("Regina", "SK");

        int before = list.getCount();
        list.deleteCity(regina); // should not throw or change size
        assertEquals(before, list.getCount());
    }

    @Test
    public void testCountCitiesReflectsAddsAndDeletes() {
        CustomList list = mockCityList();

        assertEquals(0, list.getCount());

        list.addCity(new City("Toronto", "ON"));
        list.addCity(new City("Vancouver", "BC"));
        assertEquals(2, list.getCount());

        list.deleteCity(new City("Toronto", "ON"));
        assertEquals(1, list.getCount());
    }
}
