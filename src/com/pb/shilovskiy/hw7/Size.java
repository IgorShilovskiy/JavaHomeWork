package com.pb.shilovskiy.hw7;

public enum Size {
    XXS,
    XS,
    S,
    M,
    L;
    private String description;
    private int euroSize;

    public String getDescription(){
        String st="Взрослый размер";
        if (this.equals(XXS)){
            st = "Детский размер";
        }
        return st;
    }

    public int getEuroSize(){
        int i=0;
        switch (this) {
            case XXS:
                i=32;
                break;
            case XS:
                i=34;
                break;
            case S:
                i=36;
                break;
            case M:
                i=38;
                break;
            case L:
                i=40;
                break;
        }
        return i;
        }
//    private Size(String description, int euroSize) {
//        this.description = description;
//        this.euroSize = euroSize;
//    }

}



