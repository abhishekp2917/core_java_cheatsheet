package com.excercise.javaMultiThreading.Deadlocks.example2;

// Class representing a person in the hallway
class Person {
    private final String name;
    private boolean sideLeft = true; // Person starts by standing on the left side

    public Person(String name) {
        this.name = name;
    }

    public boolean isOnLeft() {
        return sideLeft;
    }

    // Move to right side of the hallway
    public void moveToRight() {
        System.out.println(name + " moves to right side.");
        sideLeft = false;
    }

    // Move to left side of the hallway
    public void moveToLeft() {
        System.out.println(name + " moves to left side.");
        sideLeft = true;
    }

    public String getName() {
        return name;
    }
}

// Class representing the narrow hallway scenario
class Hallway {
    private final Person p1;
    private final Person p2;

    public Hallway(Person p1, Person p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    // Logic where each person tries to pass the other without blocking
    public void tryToPass(Person me, Person other) {
        while (true) {
            // Livelock condition check: both are on the same side → potential collision
            if (me.isOnLeft() == other.isOnLeft()) {

                // Both threads detect conflict and attempt to resolve it by switching sides
                // But since both do it at the same time, they continue to end up on the same side again
                System.out.println(me.getName() + ": Oh no! " + other.getName() + " is on the same side. Switching sides.");

                // Switch side to "be polite" and avoid collision
                if (me.isOnLeft()) {
                    me.moveToRight();
                } else {
                    me.moveToLeft();
                }

                // Simulate polite wait → let the other person take a turn
                // But both threads do the same → leads to livelock
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            } else {
                // Finally on different sides → no collision
                // This may rarely happen if thread timing breaks the symmetry
                System.out.println(me.getName() + ": Successfully passed.");
                break;
            }
        }
    }
}

// Main class to run the livelock example
public class Test {
    public static void main(String[] args) {
        Person alice = new Person("Alice");
        Person bob = new Person("Bob");

        Hallway hallway = new Hallway(alice, bob);

        // Two threads, each trying to pass each other in the hallway
        Thread t1 = new Thread(() -> hallway.tryToPass(alice, bob));
        Thread t2 = new Thread(() -> hallway.tryToPass(bob, alice));

        t1.start();
        t2.start();
    }
}
