package shop.test.mvc;

import net.shangtech.eshop.sales.entity.Freight;
import net.shangtech.eshop.shop.controller.command.FreightCommand;

import org.junit.Assert;
import org.junit.Test;

public class FreightTest {

	@Test
	public void test(){
		Freight freight = new Freight();
		//起重1斤20块,续重每斤4块
		freight.setFirstPrice(20.0);
		freight.setFirstWeight(500.0);
		freight.setAdditionalPrice(4.0);
		freight.setAdditionalUnit(500.0);
		
		//500g以内 20块
		Assert.assertEquals(20.0, FreightCommand.calc(freight, 0.0), 0);
		Assert.assertEquals(20.0, FreightCommand.calc(freight, 300.0), 0);
		Assert.assertEquals(20.0, FreightCommand.calc(freight, 500.0), 0);
		
		//501g-1000g,24块
		Assert.assertEquals(24.0, FreightCommand.calc(freight, 500.1), 0);
		Assert.assertEquals(24.0, FreightCommand.calc(freight, 600.1), 0);
		Assert.assertEquals(24.0, FreightCommand.calc(freight, 700.1), 0);
		Assert.assertEquals(24.0, FreightCommand.calc(freight, 800.1), 0);
		Assert.assertEquals(24.0, FreightCommand.calc(freight, 900.1), 0);
		Assert.assertEquals(24.0, FreightCommand.calc(freight, 1000.0), 0);
		
		//1000g-1500g,28块
		Assert.assertEquals(28.0, FreightCommand.calc(freight, 1000.1), 0);
		Assert.assertEquals(28.0, FreightCommand.calc(freight, 1100.1), 0);
		Assert.assertEquals(28.0, FreightCommand.calc(freight, 1200.1), 0);
		Assert.assertEquals(28.0, FreightCommand.calc(freight, 1300.1), 0);
		Assert.assertEquals(28.0, FreightCommand.calc(freight, 1400.1), 0);
		Assert.assertEquals(28.0, FreightCommand.calc(freight, 1500.0), 0);
	}
	
}
