package com.CrackingTheCodingInterview.Ch8_ObjectOrientedDesign.Ch8_4_ParkingLot;

import java.util.*;

public class ParkingLot
{
    public static void main(String[] args)
    {
        // Create a test parking lot with 100 spots.
        ParkingLot pl = new ParkingLot(100);
    }

    // Store all parking spots in an ArrayList, whether occupied or not.
    ArrayList<ParkingSpot> parking_spot = new ArrayList<ParkingSpot>();

    // Additionally, store available spots in a Queue.
    // This has the advantage of improving on the book's O(n) time to find a new parking spot.
    // From the Queue it's O(1) time to find a new spot.
    Queue<ParkingSpot> parking_spot_available = new ArrayDeque<ParkingSpot>();

    public ParkingLot(int parking_lot_size)
    {
        // Add 10 parking spots.
        for (int i = 0; i < parking_lot_size; i++)
        {
            ParkingSpot spot = new ParkingSpot(i);
            this.parking_spot.add(spot);
            this.parking_spot_available.add(spot);
        }
    }

    public abstract class Vehicle
    {
        protected VehicleType type;
        ParkingSpot parking_spot = null;

        public boolean park()
        {
            if (parking_spot_available.peek() != null)
            {
                ParkingSpot spot = parking_spot_available.remove(); // Dequeue available spot if asking for one
                spot.park(this);
                this.parking_spot = spot;

                return true;
            }
            else
            {
                return false;
            }
        }

        public boolean unpark()
        {
            if (this.parking_spot != null)
            {
                parking_spot_available.add(this.parking_spot); // Return to the Queue when it's available for parking once more
                this.parking_spot.current_occupant = null;
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    class Car extends Vehicle
    {
        public Car()
        {
            this.type = VehicleType.Car;
        }
    }

    class ParkingSpot
    {
        int id;
        VehicleType type;
        Vehicle current_occupant = null;

        public ParkingSpot(int id)
        {
            this.id = id;
        }

        public void park(Vehicle v)
        {
            this.current_occupant = v;
        }

        public boolean is_available()
        {
            if (current_occupant == null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    public enum VehicleType
    {
        Car, Motorcycle, Bike;
    }
}
