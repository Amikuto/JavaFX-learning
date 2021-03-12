package sample.request;

import java.io.IOException;

public class ReqMain {

    public static void main(String[] args) throws IOException {
        Request request = new Request();
        Parser parser = new Parser();
//        System.out.println(parser.getAll(0));
//        System.out.println(parser.getName(0));
//        System.out.println(parser.getSurname(0));
//        System.out.println(parser.getStreet(0));
//        System.out.println(parser.getCity(0));
//        System.out.println(parser.getPostalCode(0));
//        System.out.println(parser.getBirthDay(0));

        String name = "TestName";
        String surname = "TestSurname";
        Integer postalCode = 82349;
        String city = "TestCity";
        String birthday = "2001-04-22";
        String street = "TestStreet";
        request.requestPOST(name, surname, postalCode, city, birthday, street);

//        String name = "Ololo";
//        JSONObject json = new JSONObject();
//        json.put(name, "Freddie the Fish");
//        json.put("surname", "TestSurname");
//        json.put("postalCode", 10394);
//        json.put("city", "Moscow");
//        json.put("birthday", "2020-01-01");
//        json.put("street", "STREET_TEST");
//
//        System.out.println(json);
    }
}
