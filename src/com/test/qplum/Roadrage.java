package com.test.qplum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
class Car{
    int speed, position;
    Car(int p, int s){
        speed = s;
        position = p;
    }
}
public class Roadrage {

    static int Merge(int arr[], int aux[], int low, int mid, int high)
    {
        int k = low, i = low, j = mid + 1;
        int inversionCount = 0;

        while (i <= mid && j <= high)
        {
            if (arr[i] <= arr[j]) {
                aux[k++] = arr[i++];
            }
            else {
                aux[k++] = arr[j++];
                inversionCount += (mid - i + 1);	// NOTE
            }
        }

        while (i <= mid)
            aux[k++] = arr[i++];

        for (i = low; i <= high; i++)
            arr[i] = aux[i];

        return inversionCount;
    }

    static int MergeSort(int[] arr, int[] aux, int low, int high)
    {
//        System.out.println(low+" "+high);
        if (high <= low)	// if run size == 1
            return 0;

        int mid = (low + ((high - low) >> 1));
        int inversionCount = 0;

        inversionCount += MergeSort(arr, aux, low, mid);

        inversionCount += MergeSort(arr, aux, mid + 1, high);

        inversionCount += Merge(arr, aux, low, mid, high);

        return inversionCount;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        ArrayList<Car> cars;
        int[] arr;
        int[] aux;
        while(T-- >0){
            cars = new ArrayList<>();
            int n = Integer.parseInt(bufferedReader.readLine());
            arr = new int[n];
            aux = new int[n];
//            System.out.println(n);
            int num = n;
            while(num-- > 0){
                String[] values = bufferedReader.readLine().split(" ");
                int p = Integer.parseInt(values[0]);
                int s = Integer.parseInt(values[1]);
                Car c = new Car(p, s);
                cars.add(c);
            }
//            for(Car c: cars){
//                System.out.println(c.position +" "+c.speed);
//            }

            Collections.sort(cars, new Comparator<Car>() {
                @Override
                public int compare(Car o1, Car o2) {
                    return o1.position - o2.position;
                }
            });

//            for(Car c: cars){
//                System.out.println(c.position +" "+c.speed);
//            }
            int i  = 0;
            for(Car c: cars){
               arr[i] = c.speed;
               aux[i] = c.speed;
               i++;
            }

            System.out.println(MergeSort(arr, aux, 0, n- 1));

        }
    }
}
