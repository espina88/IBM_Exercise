package org.espina.utils;

/**
 * This class is used to define constants used
 * in the app
 *
 */
public class ConstantVars {

    // DATABASE
    public final String DRIVER="com.mysql.cj.jdbc.Driver";
    public final String BBDD="jdbc:mysql://localhost/ibm";
    public final String USER ="root";
    public final String PASS="root";

    //Errors DB
    public final String ERR_CONN_DB = "Error de conexión en base de datos";
    public final String ERR_CLOSE_CONN = "Error al cerrar conexión con la base de datos: ";
    public final String ERR_QRY_DB = "Error al realizar la consulta a base de datos: ";

    //Errors
    public final String ERR_NO_PRV = "El cliente no tiene proveedores asignados";
    public final String ERR_GEN_TXT = "Error al crear el archivo txt: ";

    //ARGUMENT ERRORS
    public final String ERR_NO_ARG = "Por favor, inserte algún código de cliente. ";
    public final String ERR_ONE_ARG = "Por favor, inserte un solo código de cliente. ";
    public final String ERR_ARG_WR = "El argumento introducido no es válido ";
}
