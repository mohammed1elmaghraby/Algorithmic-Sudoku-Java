package Theme;

public class Colors {
    // Colors
    public static final String RESET         = "\033[0m";
    public static final String WHITE         = "\033[0;37m";
    public static final String BLACK         = "\033[0;30m";
    public static final String PURPLE        = "\033[0;35m";
    public static final String BRIGHT_PURPLE = "\033[1;35m";
    public static final String LIGHT_PURPLE  = "\033[0;95m";
    public static final String RED           = "\033[1;31m"; 
    public static final String REVERSE       = "\033[7m";
    public static final String BLUE          = "\033[34m";
    public static final String GREEN         = "\u001B[32m";
    public static final String YELLOW        = "\u001B[33m";
    public static final String CYAN          = "\u001B[36m";
    public static final String PURPLE_BRIGHT = "\033[0;95m";
    public static final String DARK_BLUE = "\u001B[36m";
    public static final String NAVY_BLUE = "\u001B[38;5;17m";
    // Fonts
    public static final String BOLD          = "\033[1m";
    public static final String DIM           = "\u001B[2m";        
    public static final String ITALIC        = "\u001B[3m";     
    public static final String UNDERLINE     = "\u001B[4m"; 
    // Font's background
    public static final String BG_RED        = "\u001B[41m";
    public static final String BG_BLUE       = "\u001B[44m";
    public static final String BG_CYAN       = "\u001B[46m";
    public static final String BG_WHITE      = "\u001B[47m";

    public static String mainTitle(String text) {
        return REVERSE + BOLD + text + RESET;
    }

    // Options method
    public static String option(String text) {
        return LIGHT_PURPLE + text + RESET;
    }

    //Success method
    public static String success(String text) {
        return GREEN + text + RESET;
    }

    // Fail method
    public static String error(String text) {
        return RED + text + RESET;
    }
}