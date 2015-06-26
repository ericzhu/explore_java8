package learn.xml.jaxb.create;

import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import learn.xml.dataprovider.DataProvider;
import learn.xml.jaxb.model.Customer;
import learn.xml.jaxb.model.Customers;
import learn.xml.jaxb.model.GroupType;

public class CreateXMLWithJAXB {

	public static void main(String[] args) throws Exception {
		List<Customer> data = DataProvider.getData(DataProvider.SMALL);

		Customers customers = new Customers();
		customers.setCustomers(data);
		customers.setGroupType(GroupType.B2B);

		JAXBContext context = JAXBContext.newInstance(Customers.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		StringWriter sw = new StringWriter();
		marshaller.marshal(customers, sw);
		System.out.println(sw.toString());
		
		File f = new File("./output/customers.xml");
		marshaller.marshal(customers, new FileOutputStream(f, false));

	}
}
