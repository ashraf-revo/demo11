/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Service.Impl;

import com.example.Service.Methods;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 *
 * @author Ashraf Atef
 */
@Service
public class MethodsImpl implements Methods {

    public String MakeTooken(int bits_number) {
        SecureRandom random = new SecureRandom();
        return new BigInteger(bits_number, random).toString(32);
    }

//    public static void main(String[] args) {
//       MethodsImpl mi=new MethodsImpl();
//        System.out.println(mi.MakeTooken(35));
//        System.out.println(mi.MakeTooken(35));
//        System.out.println(mi.MakeTooken(35));
//
//
//    }

}
