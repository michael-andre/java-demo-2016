package fr.ecp.sio.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michaël on 12/10/2016.
 */
public class Demo {

    public static void main(String[] args) {

        List<String> a = new ArrayList<>();
        a.add("toto");
        log(a);
        System.out.println(a);

    }


    public static void log(List<String> arg) {
        //arg = new ArrayList<>();
        arg.add("toto2");
        System.out.println(arg);
    }

}
