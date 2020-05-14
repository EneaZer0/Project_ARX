package MAINGUI.CONSTANTS;

public class String_Constants {

    private String language;

    public String alternative_ratings;

    /////// Text Formating ///////

    public String tab = "     ";

    public String ntab = "\n" + tab;

    /////// Initial doc information displayed ////////

    public String path_str;

    public String fond_str;

    public String fond_typed_doc_str;

    /////// Errors exception messages /////////

    public String null_error;

    public String illegal_error;

    public String not_existing_file;

    public String illegal_error_bad_type;

    public String commandNotFound;

    /////// Path and format Console Outputs ///////////

    public String file_exists;

    public String not_path_input;

    public String correct_format;

    public String good_ending_format;

    public String input_file_format;

    public String expected_format;


    /////////// LOGO ////////////

    public String coolAR = "\n" +
            ntab + " ▄▄▄      ██▓ ▄▄▄█████▓█████ ██▀███  ███▄    █ ▄▄▄    ▄▄▄█████▓██▓██▒   █▓█████     ██▀███  ▄▄▄    ▄▄▄█████▓██▓███▄    █  ▄████  ██████ \n" +
            tab + "▒████▄   ▓██▒ ▓  ██▒ ▓▓█   ▀▓██ ▒ ██▒██ ▀█   █▒████▄  ▓  ██▒ ▓▓██▓██░   █▓█   ▀    ▓██ ▒ ██▒████▄  ▓  ██▒ ▓▓██▒██ ▀█   █ ██▒ ▀█▒██    ▒ \n" +
            tab + "▒██  ▀█▄ ▒██░ ▒ ▓██░ ▒▒███  ▓██ ░▄█ ▓██  ▀█ ██▒██  ▀█▄▒ ▓██░ ▒▒██▒▓██  █▒▒███      ▓██ ░▄█ ▒██  ▀█▄▒ ▓██░ ▒▒██▓██  ▀█ ██▒██░▄▄▄░ ▓██▄   \n" +
            tab + "░██▄▄▄▄██▒██░ ░ ▓██▓ ░▒▓█  ▄▒██▀▀█▄ ▓██▒  ▐▌██░██▄▄▄▄█░ ▓██▓ ░░██░ ▒██ █░▒▓█  ▄    ▒██▀▀█▄ ░██▄▄▄▄█░ ▓██▓ ░░██▓██▒  ▐▌██░▓█  ██▓ ▒   ██▒\n" +
            tab + " ▓█   ▓██░██████▒██▒ ░░▒████░██▓ ▒██▒██░   ▓██░▓█   ▓██▒▒██▒ ░░██░  ▒▀█░ ░▒████▒   ░██▓ ▒██▒▓█   ▓██▒▒██▒ ░░██▒██░   ▓██░▒▓███▀▒██████▒▒\n" +
            tab + " ▒▒   ▓▒█░ ▒░▓  ▒ ░░  ░░ ▒░ ░ ▒▓ ░▒▓░ ▒░   ▒ ▒ ▒▒   ▓▒█░▒ ░░  ░▓    ░ ▐░ ░░ ▒░ ░   ░ ▒▓ ░▒▓░▒▒   ▓▒█░▒ ░░  ░▓ ░ ▒░   ▒ ▒ ░▒   ▒▒ ▒▓▒ ▒ ░\n" +
            tab + "  ▒   ▒▒ ░ ░ ▒  ░ ░    ░ ░  ░ ░▒ ░ ▒░ ░░   ░ ▒░ ▒   ▒▒ ░  ░    ▒ ░  ░ ░░  ░ ░  ░     ░▒ ░ ▒░ ▒   ▒▒ ░  ░    ▒ ░ ░░   ░ ▒░ ░   ░░ ░▒  ░ ░\n" +
            tab + "  ░   ▒    ░ ░  ░        ░    ░░   ░   ░   ░ ░  ░   ▒   ░      ▒ ░    ░░    ░        ░░   ░  ░   ▒   ░      ▒ ░  ░   ░ ░░ ░   ░░  ░  ░  \n" +
            tab + "      ░  ░   ░  ░        ░  ░  ░             ░      ░  ░       ░       ░    ░  ░      ░          ░  ░       ░          ░      ░      ░  \n" +
            tab + "                                                                      ░                                                                 \n" +
            tab + "\n";

    public String game =
            tab + tab + tab + tab +tab + tab +tab + tab +tab + tab +"▄▄▄█████▓██░ ██▓█████      ▄████ ▄▄▄      ███▄ ▄███▓█████ \n" +
                    tab + tab + tab + tab +tab + tab +tab + tab +tab + tab +"▓  ██▒ ▓▓██░ ██▓█   ▀     ██▒ ▀█▒████▄   ▓██▒▀█▀ ██▓█   ▀ \n" +
                    tab + tab + tab + tab +tab + tab +tab + tab +tab + tab +"▒ ▓██░ ▒▒██▀▀██▒███      ▒██░▄▄▄▒██  ▀█▄ ▓██    ▓██▒███   \n" +
                    tab + tab + tab + tab +tab + tab +tab + tab +tab + tab +"░ ▓██▓ ░░▓█ ░██▒▓█  ▄    ░▓█  ██░██▄▄▄▄██▒██    ▒██▒▓█  ▄ \n" +
                    tab + tab + tab + tab +tab + tab +tab + tab +tab + tab +"  ▒██▒ ░░▓█▒░██░▒████▒   ░▒▓███▀▒▓█   ▓██▒██▒   ░██░▒████▒\n" +
                    tab + tab + tab + tab +tab + tab +tab + tab +tab + tab +"  ▒ ░░   ▒ ░░▒░░░ ▒░ ░    ░▒   ▒ ▒▒   ▓▒█░ ▒░   ░  ░░ ▒░ ░\n" +
                    tab + tab + tab + tab +tab + tab +tab + tab +tab + tab +"    ░    ▒ ░▒░ ░░ ░  ░     ░   ░  ▒   ▒▒ ░  ░      ░░ ░  ░\n" +
                    tab + tab + tab + tab +tab + tab +tab + tab +tab + tab +"  ░      ░  ░░ ░  ░      ░ ░   ░  ░   ▒  ░      ░     ░   \n" +
                    tab + tab + tab + tab +tab + tab +tab + tab +tab + tab +"         ░  ░  ░  ░  ░         ░      ░  ░      ░     ░  ░\n" +
                    tab + tab + tab + tab +tab + tab +tab + tab +tab + tab +"                                                          \n" +
                    "\n";



    public String_Constants(String language) {
        this.language = language;

        setConstants();
    }

    private void setConstants() {

        switch (language){

            case Commands.ENGLISH:
                alternative_ratings = "Alternative Ratings";


                /////// Initial doc information displayed ////////

                path_str = "Path: ";

                fond_str = "Fond: ";

                fond_typed_doc_str = "Type of Document: ";

                /////// Errors exception messages /////////

                null_error = "NULL POINTER ERROR: ";

                illegal_error = "ILLEGAL ARGUMENT ERROR: ";

                not_existing_file = "The file does not exist";

                illegal_error_bad_type = "ERROR: The amount of numbers does not coincide with the supposed model. Revise the document. Probably a new model must be made.";

                commandNotFound = "No command found for value: ";

                /////// Path and format Console Outputs ///////////

                file_exists = "File Exists.";

                not_path_input = "No path input.";

                correct_format = "Input file has correct ending format.";

                good_ending_format = ".doc";

                input_file_format = "Input File Format is: .";

                expected_format = " A .doc file is expected.";

                break;

            case Commands.SPANISH:
                /////// Initial doc information displayed ////////

                path_str = "Directorio: ";

                fond_str = "Fondo ";

                fond_typed_doc_str = "Tipo de documento: ";

                /////// Errors exception messages /////////

                null_error = "ERROR DE REFERENCIA NULA: ";

                illegal_error = "ERROR DE ARGUMENTO ILEGA: ";

                illegal_error_bad_type = "ERROR: La cantidad de numeros leidos no coincide con su supuesto modelo. Revise el documento. Es probable que se tenga que crear un modelo nuevo.";

                not_existing_file = "El archivo no existe";

                commandNotFound = "No existe el comando: ";

                /////// Path and format Console Outputs ///////////

                file_exists = "El archivo existe.";

                not_path_input = "No se a metido directorio.";

                correct_format = "El archivo tiene el formato correcto.";

                good_ending_format = ".doc";

                input_file_format = "El archivo actual tiene formato de tipo: .";

                expected_format = " Se espera un archivo de tipo .doc";
        }
    }


}
