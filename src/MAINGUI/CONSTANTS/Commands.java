package MAINGUI.CONSTANTS;

public class Commands {

    private static String_Constants strings_eng = new String_Constants(Commands.ENGLISH);

    public static final String HELP = "help";

    public static final String HELP_OUTPUT = "To read a new document:" +
            strings_eng.ntab + "1 -> Enter the path information if the Path input." +
            strings_eng.ntab + "2 -> Select the Fond you are working with. " +
            strings_eng.ntab + "3 -> Select the Type of Document that you have input. " +
            strings_eng.ntab + "4 -> Press the Start Extraction Button";

    public static final String CLEAR = "clear";

    public static final String HELP_CLEAR = "The command clear it is used to erase all the information from the terminal.";

    public static final String AR_GAME = "ar_game";

    public static final String LANGUAGE = "language";

    public static final String ENGLISH = "english";

    public static final String SPANISH = "spanish";
}
