package learn.xml.dataprovider;

import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import learn.xml.jaxb.model.Customer;

public class DataProvider {

	public static final String DATADIR = "./data/";
	public static final int SMALL = 10;
	public static final int MEDIUM = 1000;
	
	public static void main(String[] args) throws Exception {
		List<Customer> data = getData(SMALL);
		System.out.println("Returned: " + data.size());
		for (int i = 0; i < Math.min(data.size(), 10); i++) {
			System.out.println((Customer)data.get(i));
		}
	}

	public static List<Customer> getData(int limit) throws ParseException {
		String filename = null;
		if (limit > MEDIUM) {
			filename = DATADIR + "customersLarge.json";
		} else {
			filename = DATADIR + "customers.json";
		}
		
		JSONArray inputData = null;
		JSONParser parser = new JSONParser();
		try {
			JSONObject obj = (JSONObject)parser.parse(new FileReader(filename));
			inputData = (JSONArray)obj.get("result");
		} catch (IOException | ParseException e) {
			e.printStackTrace();
			return null;
		}
		
		List<Customer> outputData = new ArrayList<>();
		
		for (int i = 0; i < limit; i++) {
			JSONObject item = (JSONObject)inputData.get(i);
			Customer cust = new Customer();
			
			cust.setId((Long)item.get(Customer.ID));
			cust.setName((String)item.get(Customer.NAME));
			cust.setPhone((String)item.get(Customer.PHONE));
			cust.setAbout((String)item.get(Customer.ABOUT));
			cust.setAge((Long)item.get(Customer.AGE));
			cust.setBalance((String)item.get(Customer.BALANCE));
			cust.setActive((Boolean)item.get(Customer.ACTIVE));
			
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String joined = (String)item.get(Customer.JOINED);
			try {
				cust.setJoined(df.parse(joined));
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}

			outputData.add(cust);
		}
		
		return outputData;
	}
}
