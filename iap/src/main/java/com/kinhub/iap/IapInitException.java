package com.kinhub.iap;

public class IapInitException extends Exception{

    public IapInitException(){
        super("Invalid public address - check IapManager constructor");
    }

}
