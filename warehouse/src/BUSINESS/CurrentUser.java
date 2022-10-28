package BUSINESS;

public class CurrentUser {
    private static CurrentUser instance = new CurrentUser();
    private int userId;
    private int roleId;
    private boolean loggedIn = false;

    //Singleton because only we can only have one user at the same time
    public static CurrentUser getInstance()
    {
        return instance;
    }

    //Setting logged-in user data
    //userId and roleId are enough
    public void login(int userId, int roleId)
    {
        this.userId = userId;
        this.roleId = roleId;
        this.loggedIn = true;
    }

    //This method may never be used
    //If a user logs out he will be redirected to the login menu
    //The user won't be able to access any other menu until he enters
    //valid authentication data, so there is no need for logout
    //But just in case it is needed... :)
    public void logout() {
         this.loggedIn = false;
    }
}
