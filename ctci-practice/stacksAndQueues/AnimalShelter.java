package org.practice.courses.courseapi;

import java.util.LinkedList;

/* Implement enqueue(), dequeueAny(), dequeueDog(), dequeueCat()
 * operations customer can choose animal type but not specific animal
 * in order or get any dog or cat
*/

public class AnimalShelter {

    static class Animal{
        String name;
        String type;
        int order;

        Animal(String name, String type){
            this.name = name;
            this.type = type;
        }

        int getOrder(){
            return this.order;
        }

        void setOrder(int order){
            this.order = order;
        }

        boolean isOlder(Animal a){
            if(this.order < a.order){
                return false;
            }

            return true;
        }
    }

    static class Dog extends Animal{
        Dog(String name){
            super(name, "dog");
        }
    }

    static class Cat extends Animal{
        Cat(String name){
            super(name, "cat");
        }
    }

    static class AnimalQueue {
        LinkedList<Dog> dogs = new LinkedList<>();
        LinkedList<Cat> cats = new LinkedList<>();
        int order = 0;

        void enqueue(Animal a){
            a.setOrder(order);
            order++;
            if(a.type == "dog"){
                dogs.addLast((Dog)a);
            } else if(a.type == "cat"){
                cats.addLast((Cat)a);
            }
        }

        Dog dequeueDog(){
            return dogs.poll();
        }

        Cat dequeueCat(){
            return cats.poll();
        }

        Animal dequeueAny(){
            if(dogs.size() == 0){
                return dequeueCat();
            } else if(cats.size() == 0){
                return dequeueDog();
            }

            if(dogs.peek().getOrder() < cats.peek().getOrder()){
                return dequeueDog();
            } else {
               return dequeueCat();
            }
        }
    }

    public static void main(String args[]){
        Dog d1 = new Dog("dog1");
        Dog d2 = new Dog("dog2");
        Dog d3 = new Dog("dog3");
        Dog d4 = new Dog("dog4");

        Cat c1 = new Cat("cat1");
        Cat c2 = new Cat("cat2");
        Cat c3 = new Cat("cat3");
        Cat c4 = new Cat("cat4");

        AnimalQueue animalQueue = new AnimalQueue();
        animalQueue.enqueue(d1);
        animalQueue.enqueue(c1);
        animalQueue.enqueue(c2);
        animalQueue.enqueue(c3);
        animalQueue.enqueue(d2);
        animalQueue.enqueue(d3);
        animalQueue.enqueue(c4);
        animalQueue.enqueue(d4);

        System.out.println("Dequeue any: " + animalQueue.dequeueAny().name);
        System.out.println("Dequeue cat: " + animalQueue.dequeueCat().name);
        System.out.println("Dequeue dog: " + animalQueue.dequeueDog().name);
    }
}
