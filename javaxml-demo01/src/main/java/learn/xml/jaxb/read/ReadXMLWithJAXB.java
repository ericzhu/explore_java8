package learn.xml.jaxb.read;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import learn.xml.jaxb.model.Customers;

public class ReadXMLWithJAXB {
	public static void main(String[] args) throws Exception {
		JAXBContext context = JAXBContext.newInstance(Customers.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		File f = new File("./data/customers.xml");
		Customers customers = (Customers)unmarshaller.unmarshal(f);
		System.out.println(customers.getGroupType());
	}
}
