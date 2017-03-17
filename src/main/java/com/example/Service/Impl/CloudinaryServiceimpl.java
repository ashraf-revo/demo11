package com.example.Service.Impl;

import com.example.Service.CloudinaryService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Ashraf Atef
 */
@Service

public class CloudinaryServiceimpl implements CloudinaryService {
    @Autowired
    Cloudinary cloudinary;

    @Override
    public String upload(String file) {
        Map map = null;
        try {

            map = cloudinary.uploader().uploadLarge(Base64.decodeBase64(file), ObjectUtils.emptyMap());
        } catch (IOException ex) {
            Logger.getLogger(CloudinaryServiceimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (String) map.get("secure_url");

    }
}
