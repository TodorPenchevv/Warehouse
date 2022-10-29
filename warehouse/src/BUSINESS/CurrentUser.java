package BUSINESS;

public class CurrentUser {
    private static CurrentUser instance = new CurrentUser();
    private static int userId;
    private static int roleId;
    private static boolean loggedIn = false;

    //Singleton because we can only have one user at the same time
    public static CurrentUser getInstance()
    {
        return instance;
    }

    //Setting logged-in user data
    //userId and roleId are enough
    public static void login(int userId, int roleId)
    {
        userId = userId;
        roleId = roleId;
        loggedIn = true;
    }

    //This method may never be used
    //If a user logs out he will be redirected to the login menu
    //The user won't be able to access any other menu until he/she enters
    //valid authentication data, so there is no need for logout
    //But just in case... :)
    public static void logout() {
         loggedIn = false;
    }

    public static int getUserId() {
        return userId;
    }

    public static int getRoleId() {
        return roleId;
    }
}
