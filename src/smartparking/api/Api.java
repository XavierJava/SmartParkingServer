package smartparking.api;

public interface Api {
    boolean register(String name, String password) throws Exception;

    boolean login(String name, String password) throws Exception;
}
