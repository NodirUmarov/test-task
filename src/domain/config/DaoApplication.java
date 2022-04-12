package domain.config;

public class DaoApplication {

    public static void run() {
        registerDriver("org.postgresql.Driver");
        registerDriver("domain.config.ApplicationContext");
    }

    private static void registerDriver(String path) {
        try {
            System.out.println("Registering driver " + path);
            Class.forName(path);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
