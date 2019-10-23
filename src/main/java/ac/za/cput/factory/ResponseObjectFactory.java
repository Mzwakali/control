package ac.za.cput.factory;

import ac.za.cput.domain.ResponseObject;

public class ResponseObjectFactory {

    public static ResponseObject buildResponseObject(String responseCode, String responseDesc){
        return new ResponseObject(responseCode, responseDesc);
    }
}
