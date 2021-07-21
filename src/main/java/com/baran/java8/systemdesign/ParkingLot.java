//package com.baran.java8.systemdesign;
//
//import java.sql.Timestamp;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.OptionalInt;
//import java.util.concurrent.TimeUnit;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class ParkingLot {
//    private List<ParkingFloor> parkingFloorList;
//    private List<Vehicle> vehicleList;
//    private List<DetailBoard> detailBoardList;
//
//    private ParkingLot() {
//    }
//
//    private ParkingLot parkingLot = new ParkingLot();
//
//    public ParkingLot getInstance() {
//        return this.parkingLot;
//    }
//
//    private void addFloor(ParkingFloor parkingFloor) {
//        parkingFloorList.add(parkingFloor);
//    }
//
//    private void deleteFloor(ParkingFloor parkingFloor) {
//        parkingFloorList.remove(parkingFloor);
//    }
//
//    public Optional<Ticket> checkInVehicle(Vehicle vehicle) {
//        ReentrantLock checkInLock = new ReentrantLock(true);
//        Ticket ticket = null;
//        try {
//            checkInLock.tryLock(5, TimeUnit.MINUTES);
//            //Logic to check and assign slot
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            checkInLock.unlock();
//        }
//        return Optional.ofNullable(ticket);
//    }
//
//    public OptionalInt checkOutVehicle(Ticket ticket) {
//        int cost = 0;
//        ReentrantLock checkoutLock = new ReentrantLock(true);
//        try {
//            checkoutLock.tryLock(5, TimeUnit.MINUTES);
//            //Logic to check and assign slot
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            checkoutLock.unlock();
//        }
//        return OptionalInt.of(cost);
//    }
//
//    //Dependency objects--------------------------
//    private class ParkingFloor {
//        private DetailBoard detailBoard;
//        private List<ParkingSlot> parkingSlotsList;
//
//
//    }
//
//    private class Ticket {
//        private Gate entryGate;
//        private Gate exitGate;
//
//
//    }
//
//    abstract class Gate {
//        protected Timestamp arrivalTime;
//        protected String name;
//    }
//
//    enum ParkingSlotType {
//
//        TwoWheeler {
//            public double getPrice(long duration) {
//                return duration * 0.75;
//            }
//        }, Compact {
//            public double getPrice(long duration) {
//                return duration * 0.75;
//            }
//        }, Medium {
//            public double getPrice(long duration) {
//                return duration * 0.75;
//            }
//        }, Large {
//            public double getPrice(long duration) {
//                return duration * 0.75;
//            }
//        };
//
//        public abstract double getPrice(long duration);
//
//    }
//
//    enum VehicleType {CAR, BIKE, SCOOTER, BUS, TRUCK}
//
//    enum PaymentType {CARD, CASH, UPI}
//
//    abstract class Vehicle {
//        protected String vehicleNumber;
//        protected String color;
//        protected VehicleType vehicleType;
//    }
//
//    private class DetailBoard {
//        private Map<ParkingFloor, Integer> parkingFloorAvailableSlotsMap;
//
//        public void incrementAvailableSlotForBoard(ParkingFloor parkingFloor) {
//
//        }
//
//        public void decrementAvailableSlotForBoard(ParkingFloor parkingFloor) {
//
//        }
//        public void displayDetailsForFloor(ParkingFloor parkingFloor){
//            parkingFloorAvailableSlotsMap.entrySet()
//                    .stream()
//                    .filter(entry-> entry.getKey().equals(parkingFloor))
//            .
//            ;
//
//
//        }
//    }
//
//    private class Payment {
//        private PaymentType paymentType;
//        private int charges;
//
//    }
//
//    private class ParkingSlot {
//        private ParkingSlotType parkingSlotType;
//
//    }
//}
