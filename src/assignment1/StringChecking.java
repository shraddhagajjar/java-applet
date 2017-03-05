/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

/**
 *
 * @author shraddha
 */
public class StringChecking {

    public static void main(String[] args) {
        int count = 0;
        String s = "HelloHowRUou12345";
        if (s.length() >= 10) {
            if ( s.contains("[a-zA-Z]+") == true) {
                for (int i = 0; i < s.length(); i++) {

                    if (Character.isDigit(s.charAt(i))) {
                     count++;
                        System.out.println(count);
                    }
                }
            }

        }
    }

}
