package application;


import application.utilities.Tool;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author SwordLake
 */
public class Menu {

    public static void print(String str) {
        List<String> menuList = Arrays.asList(str.split("\\|"));
        for (String menuItem : menuList) {
            System.out.println(menuItem);
    }
    }

    public static int getUserChoice(int min, int max) {
        int number = Tool.getAnInteger("Enter choice","Invalid choice ! Enter again",min,max);
        return number;
    }

}
