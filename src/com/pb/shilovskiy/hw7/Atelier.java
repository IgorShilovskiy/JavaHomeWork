package com.pb.shilovskiy.hw7;

public class Atelier {
    public static void dressMan(Clothes[] clothes){
        System.out.println("Для мужчин предлагается следующая одежда: ");
        for (int i=0; i<clothes.length; i++) {
            if (clothes[i] instanceof Tshirt)
                ((Tshirt) clothes[i]).dressMan();
            if (clothes[i] instanceof Pants)
                ((Pants) clothes[i]).dressMan();
            if (clothes[i] instanceof Tie)
                ((Tie) clothes[i]).dressMan();
        }
    }

    public static void dressWomen(Clothes[] clothes){
        System.out.println("Для женщин предлагается следующая одежда: ");
        for (int i=0; i<clothes.length; i++) {
            if (clothes[i] instanceof Tshirt)
                ((Tshirt) clothes[i]).dressWomen();
            if (clothes[i] instanceof Pants)
                ((Pants) clothes[i]).dressWomen();
            if (clothes[i] instanceof Skirt)
                ((Skirt) clothes[i]).dressWomen();
        }
    }


    public static void main(String[] args) {
        Tshirt t1 = new Tshirt(Size.S,1500,"красный");
        Tshirt t2 = new Tshirt(Size.XXS,1500,"зеленый");
        Pants p1 = new Pants (Size.XS,1700,"синий");
        Pants p2 = new Pants (Size.XXS,1800,"черный");
        Skirt s1 = new Skirt(Size.L,800,"сиреневый");
        Skirt s2 = new Skirt(Size.XXS,850,"черный");
        Tie ti1 = new Tie(Size.M,200,"черный в белую полоску");
        Tie ti2 = new Tie(Size.M,200,"серый в черную полоску");

        Clothes[] clothes = new Clothes[]{t1, t2, p1, p2, s1, s2, ti1, ti2};
        dressMan(clothes);
        dressWomen(clothes);

    }

}
