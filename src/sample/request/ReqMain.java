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

        request.requestPOST();
    }
}
