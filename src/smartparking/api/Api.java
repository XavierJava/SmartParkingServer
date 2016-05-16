package smartparking.api;

public interface Api {
    void register(String name, String password);

    boolean login(String name, String password);
}
