package org.corgi.packagedrone.plus;

import org.corgi.packagedrone.plus.info.RpmInformation;
import org.corgi.packagedrone.plus.info.RpmInformations;
import org.corgi.packagedrone.plus.parse.RpmInputStream;

import java.io.FileInputStream;

public class Test {
    public static void main(String[] args) {
        try (RpmInputStream in = new RpmInputStream(new FileInputStream("nginx.rpm"))) {
            RpmInformation rpmInformation = RpmInformations.makeInformation(in);
            System.out.println(rpmInformation);
        } catch (Exception e) {

        }
    }
}
