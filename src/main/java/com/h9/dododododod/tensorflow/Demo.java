package com.h9.dododododod.tensorflow;



public class Demo {

    public static void main(String[] args) {
        if (args.length != 2) {

            System.exit(1);
        }
        String modelDir = args[0];
        String imageFile = args[1];

        System.out.println(modelDir);
        System.out.println(imageFile);
    }
}
