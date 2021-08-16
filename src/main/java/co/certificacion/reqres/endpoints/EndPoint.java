package co.certificacion.reqres.endpoints;

public class EndPoint {

    private static final String GET = "get";
    private static final String POST = "post";

    public static String getEndPoint(String endpoint) {
        switch (endpoint) {
            case "get":
                return EndPoint.GET;
            case "post":
                return EndPoint.POST;
            default:
                break;
        }
        return "";
    }
}
