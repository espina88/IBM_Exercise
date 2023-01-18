package org.espina.utils;

import org.espina.models.Proveedores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Tasks {

    private static ConstantVars constantVars = new ConstantVars();
    /**
     * This method is used to return providers data from
     * database
     *
     * @param argumento This is the first paramter to listing method
     * @return Arraylist with Proveedores objects with all the information
     */
    public static ArrayList<Proveedores> listing(int argumento ){

        //Variables declaration
        ArrayList<Proveedores> arrayList = new ArrayList<>();
        Connection dbConnection = DatabaseConnection.connection();

        try {
            PreparedStatement stm = dbConnection.prepareStatement("SELECT * FROM proveedores where id_cliente=?");
            stm.setInt(1,argumento);
            ResultSet rs = stm.executeQuery();

            //If Select returns empty
            if (!rs.isBeforeFirst() ) {
                System.out.println(constantVars.ERR_NO_PRV);
            }else {

                while (rs.next()) {
                    //Adding to array the data from database
                    arrayList.add(new Proveedores(rs.getInt("id_proveedor"),rs.getString("nombre"),rs.getDate("fecha_alta"), rs.getInt("id_cliente")));
                }
                //Closing resources
                stm.close();
                DatabaseConnection.closeConnection(dbConnection);
                return arrayList;
            }

        } catch (SQLException e) {
            System.out.println( constantVars.ERR_QRY_DB + e.getMessage().toString());
            throw new RuntimeException(e);
        }
        return null;
    }
    /**
     * The method createFile is used to create a new txt file
     * with a configured path and name the information
     * is provided by an arraylist
     * @param arr This is the first parameter
     * @return void
     */
    public void createFile( ArrayList<Proveedores>  arr ){
        //Declaring variables
        boolean result;
        String filePath = "./file/proveedores.txt";
        FileOutputStream fos = null;

        //Setting a path for file
        File file = new File(filePath);

        try {
            //Creating the new file
            result = file.createNewFile();

            try {
                fos = new FileOutputStream(filePath);
                //If client code does not exist we rewrite the file with empty
                if( arr==null ){
                    fos.write("".getBytes());
                }
                //If client has providers, we will write into file txt
                else{
                    fos.write(("Proveedores: \n").getBytes());
                    for( Proveedores list: arr ){
                        fos.write((list.getId_proveedor()+","+list.getNombre()+","+list.getFecha_alta()+","+list.getId_cliente()+"\n").getBytes());
                    }
                    fos.flush();
                    fos.close();
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        } catch (IOException e) {
            System.out.println( constantVars.ERR_GEN_TXT + e.getMessage().toString());
            e.printStackTrace();    //prints exception if any
        }
    }
}

