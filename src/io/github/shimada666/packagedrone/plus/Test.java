package io.github.shimada666.packagedrone.plus;

import io.github.shimada666.packagedrone.plus.info.RpmInformation;
import io.github.shimada666.packagedrone.plus.info.RpmInformations;
import io.github.shimada666.packagedrone.plus.parse.RpmInputStream;

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
