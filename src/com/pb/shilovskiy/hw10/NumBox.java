package com.pb.shilovskiy.hw10;

import java.util.Arrays;

public class NumBox <T extends Number> {
    public T[] numbers;

    public NumBox(int size) {
        numbers = (T[]) new Number[size];
    }

    public T get(int index) {
        return numbers[index];
    }

    public void set(int index, T number) {
        this.numbers[index] = number;
    }

    void add(T num) throws Exception{
        int index = this.length();
        this.numbers[index] = num;
    }


    int length() {
        int index = 0;
        for (int i=0; i<numbers.length;i++)
            if (numbers[i]!=null) {
                index++;
            }
            return index;
        }

    double average(){
    return this.sum()/this.length();
    }

    double sum(){
    double s=0;
    int len = this.length();
        for (int i=0;i<len;i++)
            s=s+numbers[i].doubleValue();
    return s;
    }

    T max() {
        int indexMax=0;
        int len = this.length();
        for (int i=1;i<len;i++){
            if (numbers[i].doubleValue()>numbers[i-1].doubleValue())
                indexMax=i;
        }
        return numbers[indexMax];
    }


    @Override
    public String toString() {
        String strOut="[";
        int len = this.length();
        for (int i=0;i<len-1;i++)
            strOut=strOut.concat(numbers[i]+ ", ");
        strOut=strOut.concat(numbers[len-1]+ "]");
        return strOut;
    }
}
