package org.espina;

import org.espina.models.Proveedores;
import org.espina.utils.ConstantVars;
import org.espina.utils.Tasks;

import java.util.ArrayList;

public class Main {

    private static ConstantVars constantVars = new ConstantVars();
    public static void main(String[] args) {

        //Variables declaration
        ArrayList<Proveedores> arr = new ArrayList<>();
        int argument = 0;

        try{
            //Parse argument to integer
            argument = Integer.parseInt(args[0]);

            switch (args.length) {
                case 0:
                    System.out.println(constantVars.ERR_NO_ARG);
                    System.exit(-1);
                    break;
                case 1:
                    Tasks tasks = new Tasks();
                    arr = tasks.listing(argument);
                    tasks.createFile(arr);
                    break;
                default: //If number of arguments is greater than 1
                    System.out.println(constantVars.ERR_ONE_ARG);
            }

        }catch (NumberFormatException n){
            //If not a number, this throw the exception
            System.out.println(constantVars.ERR_ARG_WR);
        }

    }
}
