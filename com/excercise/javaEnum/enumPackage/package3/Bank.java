package com.excercise.javaEnum.enumPackage.package3;

public enum Bank {
    SBI(false),
    ICICI(true){

        // overriding getMarketValue method for 'ICICI' constant
        public float getMarketValue(){
            return 200;
        }
    },
    RBI(false);

    boolean isPrivate;
    private float marketValue = 100f;

    Bank(boolean isPrivate){
        this.isPrivate = isPrivate;
    }

    public float getMarketValue(){
        return this.marketValue;
    }
}
