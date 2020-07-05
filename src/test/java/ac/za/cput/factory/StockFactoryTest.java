package ac.za.cput.factory;

import ac.za.cput.entity.Stock;
import org.junit.Test;

import static org.junit.Assert.*;

/*
 *  @author: Sherwin Adams
 *  Desc: Tests for Stock Factory
 */

public class StockFactoryTest
{

    @Test
    public void createFurnitureStock()
    {
        Stock furniture = StockFactory.createFurnitureStock(20, "02-06-2020");
        System.out.println(furniture);
    }

    @Test
    public void createDeviceStock()
    {
        Stock device = StockFactory.createDeviceStock(10,"02-07-2020");
        System.out.println(device);

    }
}